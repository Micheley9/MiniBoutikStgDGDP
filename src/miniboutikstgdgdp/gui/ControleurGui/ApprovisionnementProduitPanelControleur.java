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

        Produit produitPourMaj = new Produit().trouverUn(produitSelectionne.getIdProduit());
        int stockActuel = produitPourMaj.getQteStockProduit();
        int nouveauStock = stockActuel + qteApprov;
        //
        produitPourMaj.setQteStockProduit(nouveauStock);

        // Mettre à jour dans la base
        Produit produitModifie = produitPourMaj.modifierUneLigne(produitPourMaj, produitPourMaj.getIdProduit());
        
        JOptionPane.showMessageDialog(null, "Nouvelle Quatité du produit "+produitPourMaj.getNomProduit()+ " Est "+nouveauStock);
        if (produitModifie == null) {
            JOptionPane.showMessageDialog(null,
                    "Erreur lors de la mise à jour du stock pour : " + produitPourMaj.getNomProduit());
        }
        if (approvO == null) {
            JOptionPane.showMessageDialog(null, "Echec .........");
        } else {
            JOptionPane.showMessageDialog(null, "L'approvisionnnement est effectuer avec succès");
        }

        return approvO;
    }
}
