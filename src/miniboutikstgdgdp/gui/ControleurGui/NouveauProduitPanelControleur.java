/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniboutikstgdgdp.gui.ControleurGui;

import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import miniboutikstgdgdp.entitys.Categorie;
import miniboutikstgdgdp.entitys.Produit;
import miniboutikstgdgdp.entitys.connexionBD.MaConnexionBD;

/**
 *
 * @author HP ELITEBOOK
 */
public class NouveauProduitPanelControleur {

    public static Produit creationProduit(JTextField nomProdTextField, JTextField codeProdTextField, JTextField prixProdTextField,
            JTextField qteProdTextField, JTextField fabicantProTextField, JTextField fournisseurProTextField, JComboBox categorieTextField) {
        //
        double prixProd = Double.parseDouble(prixProdTextField.getText());
        int qteProd = Integer.parseInt(qteProdTextField.getText());
        Categorie idCatProd = null;
        //
        Produit prodO = new Produit();
        //
        long idProd = new Date().getTime();
        prodO.setIdProduit(idProd);
        prodO.setNomProduit(nomProdTextField.getText());
        prodO.setCodeProduit(codeProdTextField.getText());
        prodO.setPrixProdduit(prixProd);
        prodO.setQteStockProduit(qteProd);
        prodO.setFabricantProduit(fabicantProTextField.getText());
        prodO.setFournisseurProduit(fournisseurProTextField.getText());
        prodO.setIdCategorieProd(new Categorie().trouverUn(idCatProd));

        //
        Produit insertProd = new Produit();
        prodO = insertProd.insererUneLigne(prodO);
        if (prodO == null) {
            JOptionPane.showMessageDialog(null, "Ereur Contreue Nouveau produit");
        } else {
            JOptionPane.showMessageDialog(null, "insertion reusi");
        }
        //
        return prodO;
    }

    public static void affichage(JComboBox comboBox) {

        String requete = "SELECT idCategorie,nomCategorie,descriptionCategorie FROM categorie ";
        MaConnexionBD kon = new MaConnexionBD();
        kon.ouvrirConnexion();
        ResultSet resultatReq = kon.ExecuteurdeRequeteSelect(requete);
        try {
            while (resultatReq.next()) {
                comboBox.addItem(resultatReq.getString("nomCategorie"));

            }
            // affichage
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erreur" + ex.getMessage());
        }

    }

    public static void affichageSelect(JLabel selecJLabel, JComboBox comboBox) {
        String Selec = comboBox.getSelectedItem().toString();
        String requete = "SELECT idCategorie,nomCategorie,descriptionCategorie FROM categorie WHERE nomCategorie ='" + Selec + "'";
        MaConnexionBD kon = new MaConnexionBD();
        kon.ouvrirConnexion();
        ResultSet resultatReq = kon.ExecuteurdeRequeteSelect(requete);
        try {
            while (resultatReq.next()) {
                selecJLabel.setText(resultatReq.getString("idCategorie"));

            }
            // affichage
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erreur" + ex.getMessage());
        }

    }

    public static void creationProduit2(JTextField nomProdTextField, JTextField codeProdTextField, JTextField prixProdTextField,
            JTextField qteProdTextField, JTextField fabicantProTextField, JTextField fournisseurProTextField, JLabel categorieLabel) {
        long idProd = new Date().getTime();
        String requete = "INSERT INTO Produit (idProduit,nomProduit,codeProduit,prixProdduit,qteStockProduit,fabricantProduit,"
                + "fournisseurProduit,idCategorieProd) VALUES ('" + idProd + "','" + nomProdTextField.getText() + "','" + codeProdTextField.getText() + "','" + prixProdTextField.getText() + "',"
                + "'" + qteProdTextField.getText() + "','" + fabicantProTextField.getText() + "','" + fournisseurProTextField.getText() + "','" + categorieLabel.getText() + "')";
        MaConnexionBD konex = new MaConnexionBD();
        konex.ouvrirConnexion();
        int testIns = konex.ExecuteurdeRequeteUpdate(requete);
        konex.fermetureConnexion();
        //
        if (testIns > 0) {
            JOptionPane.showMessageDialog(null, "Reussie");
        } else {
            JOptionPane.showMessageDialog(null, "echouer");
        }
    }

    public static void chargerInfosPersonne(JTable listeJTable) {
        //
        try {
            String requete = "SELECT p.idProduit,p.nomProduit,p.codeProduit,p.prixProdduit,p.qteStockProduit,p.fabricantProduit,c.nomCategorie "
                    + "FROM produit p JOIN categorie c ON p.idCategorieProd = c.idCategorie ";
            MaConnexionBD kon = new MaConnexionBD();
            kon.ouvrirConnexion();
            ResultSet resultatReq = kon.ExecuteurdeRequeteSelect(requete);
            // affichage
            int nLigne = 0;
            int nCol = 7;
            while (resultatReq.next()) {
                nLigne++;
            }
            Object[][] listing = new Object[nLigne][nCol];
            resultatReq = kon.ExecuteurdeRequeteSelect(requete);
            int i = 0;
            while (resultatReq.next()) {
                listing[i][0] = (resultatReq.getString("p.idProduit"));
                listing[i][1] = resultatReq.getString("p.nomProduit");
                listing[i][2] = resultatReq.getString("p.codeProduit");
                listing[i][3] = resultatReq.getString("c.nomCategorie");
                listing[i][4] = resultatReq.getString("p.prixProdduit");
                listing[i][5] = resultatReq.getString("p.qteStockProduit");
                listing[i][6] = resultatReq.getString("p.fabricantProduit");
                i++;
            }
            kon.fermetureConnexion();
            //jTable1 = new javax.swing.JTable();

            listeJTable.setModel(new javax.swing.table.DefaultTableModel(
                   listing,
                    new String[]{
                        "N°", "NOM", "CODE", "CATEGORIE", "PRIX", "QUANTITE", "FRABRICANT"
                    }
            ) {
                boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "L'affichage Echouée!!!!" + e.getMessage());
        }
    }

}
