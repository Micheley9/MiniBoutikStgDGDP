/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniboutikstgdgdp.gui.ControleurGui;

import com.toedter.calendar.JDateChooser;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import miniboutikstgdgdp.entitys.Approvisionnement;
import miniboutikstgdgdp.entitys.Produit;

/**
 *
 * @author HP ELITEBOOK
 */
public class ApprovisionnementProduitPanelControleur {

    public static void afficheApprovisionnement(JTable listeApprovisionnementTable) {
        List<Approvisionnement> approvList = new Approvisionnement().trouverTout();
        //
        Object[][] dataApprov = new Object[approvList.size()][6];
        //
        int i = 0;
        for (Approvisionnement approvO : approvList) {
            dataApprov[i][0] = (i + 1);
            dataApprov[i][1] = approvO.getDateAppov();
            dataApprov[i][2] = approvO.getQteApprov();
            dataApprov[i][3] = approvO.getPrixAchatApprov();
            dataApprov[i][4] = approvO.getIdProdApprov().getNomProduit();
            dataApprov[i][5] = approvO.getIdApprov();
            //
            i++;
        }
        listeApprovisionnementTable.setModel(new javax.swing.table.DefaultTableModel(
                dataApprov,
                new String[]{
                    "N°", "Date", "Quantité ", "Prix d'Achat", "Produit", "ID"
                }
        ));

    }

    public static Approvisionnement insertUn(JComboBox<Produit> idProdJComboBox, JDateChooser dateApprovDateChooser, JTextField qteApprovTextField,
            JTextField prixApprovTextField) {
        Approvisionnement approvO = new Approvisionnement();
        int qteApprov = Integer.parseInt(qteApprovTextField.getText());
        double montantAppriv = Double.parseDouble(prixApprovTextField.getText());

        Produit produitSelectionne = (Produit) idProdJComboBox.getSelectedItem();

        long idApprov = new Date().getTime();
        approvO.setIdApprov(idApprov);
        approvO.setDateAppov(dateApprovDateChooser.getDate());
        approvO.setQteApprov(qteApprov);
        approvO.setPrixAchatApprov(montantAppriv);
        approvO.setIdProdApprov(produitSelectionne);

        Approvisionnement approvIns = new Approvisionnement();
        approvO = approvIns.insererUneLigne(approvO);

        Produit prodO = new Produit().trouverUn(produitSelectionne.getIdProduit());
        int stockActuel = prodO.getQteStockProduit();
        int nouveauStock = stockActuel + qteApprov;
        //
        prodO.setQteStockProduit(nouveauStock);

        // Mettre à jour dans la base
        Produit produitModifie = prodO.modifierUneLigne(prodO, prodO.getIdProduit());

        JOptionPane.showMessageDialog(null, "Nouvelle Quatité du produit " + prodO.getNomProduit() + " Est " + nouveauStock);
        if (produitModifie == null) {
            JOptionPane.showMessageDialog(null,
                    "Erreur lors de la mise à jour du stock pour : " + prodO.getNomProduit());
        }
        if (approvO == null) {
            JOptionPane.showMessageDialog(null, "Echec .........");
        } else {
            JOptionPane.showMessageDialog(null, "L'approvisionnnement est effectuer avec succès");
        }

        return approvO;
    }

    public static void tableClick(JComboBox<Produit> idProdJComboBox, JDateChooser dateApprovDateChooser, JTextField qteApprovTextField,
            JTextField prixApprovTextField, JTable listeApprovisionnementTable) {
        int row = listeApprovisionnementTable.getSelectedRow();
        int column = listeApprovisionnementTable.getSelectedColumn();

        Produit produitSelectionne = (Produit) idProdJComboBox.getSelectedItem();

        // On vérifie si l'utilisateur a cliqué sur la colonne "Select" (index 5)
        if (row != -1 && column == 5) {
            /*Récupérer l'ID stocké dans la cellule sélectionnée
            Note: Comme on a défini la classe Boolean, on récupère l'ID via la liste ou un ID caché
             Si vous avez remplacé l'ID par le Boolean, récupérons l'ID de l'objet */

            List<Approvisionnement> laListe = new Approvisionnement().trouverTout();
            Long idSelectionne = laListe.get(row).getIdApprov();
            // Retrouver l'objet complet
            Approvisionnement approv = new Approvisionnement().trouverUn(idSelectionne);
            // Remplir les champs du formulaire 
            idProdJComboBox.setSelectedItem(produitSelectionne);
            qteApprovTextField.setText(String.valueOf(approv.getQteApprov()));
            prixApprovTextField.setText(String.valueOf(approv.getPrixAchatApprov()));
            dateApprovDateChooser.setDate(approv.getDateAppov()); // Si vous utilisez un JDateChooser
        }

    }

    //
    public static Approvisionnement modifierUneLigne(JComboBox<Produit> idProdJComboBox, JDateChooser dateApprovDateChooser, JTextField qteApprovTextField,
            JTextField prixApprovTextField, JTable listeApprovisionnementTable) {
        Approvisionnement approvO = new Approvisionnement();

        int row = listeApprovisionnementTable.getSelectedRow();
        int column = listeApprovisionnementTable.getSelectedColumn();

        Produit produitSelectionne = (Produit) idProdJComboBox.getSelectedItem();
        //

        // On vérifie si l'utilisateur a cliqué sur la colonne "Select" (index 5)
        if (row != -1 && column == 5) {

            List<Approvisionnement> laListe = new Approvisionnement().trouverTout();
            Long idSelectionne = laListe.get(row).getIdApprov();
            //
            Approvisionnement appov = new Approvisionnement().trouverUn(idSelectionne);
            Produit prodOO = new Produit().trouverUn(produitSelectionne.getIdProduit());
            int stockProd = prodOO.getQteStockProduit();
            int qteStock = appov.getQteApprov();
            //
            int nouveauStockProd = stockProd - qteStock;
            
            JOptionPane.showMessageDialog(null, stockProd +" - " +qteStock +" = "+nouveauStockProd);
            
            approvO.setDateAppov(dateApprovDateChooser.getDate());
            approvO.setQteApprov(Integer.parseInt(qteApprovTextField.getText()));
            approvO.setPrixAchatApprov(Double.parseDouble(prixApprovTextField.getText()));
            approvO.setIdProdApprov(produitSelectionne);

            Approvisionnement approvMod = new Approvisionnement();
            approvO = approvMod.modifierUneLigne(approvO, idSelectionne);
            //
           
            int nouveauStock =nouveauStockProd  + Integer.parseInt(qteApprovTextField.getText());
            //
            prodOO.setQteStockProduit(nouveauStock);

            // Mettre à jour dans la base
            Produit produitModifie = prodOO.modifierUneLigne(prodOO, prodOO.getIdProduit());
            if (produitModifie == null) {
                JOptionPane.showMessageDialog(null,
                        "Erreur lors de la mise à jour du stock pour : " + prodOO.getNomProduit());
            }

        }
        if (approvO == null) {
            JOptionPane.showMessageDialog(null, "Echec .........");
        } else {
            JOptionPane.showMessageDialog(null, "L'approvisionnnement est modifier avec succès");
        }

        return approvO;
    }
}
