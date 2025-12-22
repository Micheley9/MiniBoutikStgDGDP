/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniboutikstgdgdp.gui.ControleurGui;
//

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import miniboutikstgdgdp.entitys.Approvisionnement;
import miniboutikstgdgdp.entitys.Categorie;
import miniboutikstgdgdp.entitys.Produit;
import miniboutikstgdgdp.entitys.Produits;
import miniboutikstgdgdp.entitys.connexionBD.MaConnexionBD;

/**
 *
 * @author HP ELITEBOOK
 */
public class NouveauProduitPanelControleurMonoTbl {

    public static Produits creationProduit(JTextField nomProdTextField, JTextField codeProdTextField, JTextField prixProdTextField,
            JTextField qteProdTextField, JTextField fabicantProTextField, JTextField fournisseurProTextField, JComboBox categorieJComboBox) {
        //
        double prixProd = Double.parseDouble(prixProdTextField.getText());
        int qteProd = Integer.parseInt(qteProdTextField.getText());

        //
        Produits prodO = new Produits();
        //
        long idProd = new Date().getTime();
        prodO.setIdProduit(idProd);
        prodO.setNomProduit(nomProdTextField.getText());
        prodO.setCodeProduit(codeProdTextField.getText());
        prodO.setCategorieProduitss(categorieJComboBox.getSelectedItem().toString());
        prodO.setPrixProdduit(prixProd);
        prodO.setQteStockProduit(qteProd);
        prodO.setDerniereQteVendueProd(0);
        prodO.setDataVenteProduit(null);
        prodO.setFabricantProduit(fabicantProTextField.getText());
        prodO.setFournisseurProduit(fournisseurProTextField.getText());

        //
        Produits prodOIns = new Produits();
        //
        prodO = prodOIns.insererUneLigne(prodO);

        //
        if (prodO == null) {
            JOptionPane.showMessageDialog(null, "Erreur");
        } else {
            JOptionPane.showMessageDialog(null, "insertion reusi");
        }

        //
        return prodO;
    }

    public static void afficageSurTable(JTable produitsTable) {
        List<Produit> prodList = new Produit().trouverTout();
        //
        Object[][] dataProd = new Object[prodList.size()][8];
        //
        int i = 0;
        //
        for (Produit prodO : prodList) {
            dataProd[i][0] = (i + 1);
            dataProd[i][1] = prodO.getNomProduit();
            dataProd[i][2] = prodO.getCodeProduit();
            dataProd[i][3] = prodO.getIdCategorieProduit().getNomCategorie();
            dataProd[i][4] = prodO.getPrixProdduit();
            dataProd[i][5] = prodO.getQteStockProduit();
            dataProd[i][6] = prodO.getFabricantProduit();
            dataProd[i][7] = prodO.getIdProduit();
            i++;
        }

        produitsTable.setModel(new javax.swing.table.DefaultTableModel(
                dataProd,
                new String[]{
                    "N°", "NOM", "CODE", "CATEGORIE", "PRIX", "QUANTITE", "FRABRICANT", "Identifiant"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

    }

    public static void affrichageReccuperationId(JComboBox<Categorie> listeCategirueBox, Categorie cleo) {

        Categorie selectionCombo = (Categorie) listeCategirueBox.getSelectedItem();
        cleo.setIdCategorie(selectionCombo.getIdCategorie());

    }

    public static Produit insertionProduit(JTextField nomProdTextField, JTextField codeProdTextField, JTextField prixProdTextField,
            JTextField qteProdTextField, JTextField fabicantProTextField, JTextArea descrpritionTextArea, JComboBox<Categorie> idCategorieComboBox) {
        double prixProd = Double.parseDouble(prixProdTextField.getText());
        int qteProd = Integer.parseInt(qteProdTextField.getText());
        //

        Categorie idCategoriProd = (Categorie) idCategorieComboBox.getSelectedItem();
        //
        Produit prodO = new Produit();
        //
        long idProd = new Date().getTime();
        prodO.setIdProduit(idProd);
        prodO.setNomProduit(nomProdTextField.getText());
        prodO.setCodeProduit(codeProdTextField.getText());
        prodO.setIdCategorieProduit(idCategoriProd);
        prodO.setPrixProdduit(prixProd);
        prodO.setQteStockProduit(qteProd);
        prodO.setFabricantProduit(fabicantProTextField.getText());
        prodO.setDescriptionProduit(descrpritionTextArea.getText());
        //
        Produit prodOIns = new Produit();
        //
        prodO = prodOIns.insererUneLigne(prodO);

        //
        if (prodO == null) {
            JOptionPane.showMessageDialog(null, "Erreur lors de l'insertion !");
        } else {
            JOptionPane.showMessageDialog(null, "Insertion reussie !");
        }

        return prodO;

    }

//    public static void recupeurIdCategorie(JComboBox<Categorie> prodComboBox, JLabel idCategorie) {
//        Categorie selectedProduit = (Categorie) prodComboBox.getSelectedItem();
//       
//        //
//        idCategorie.setText(""+selectedProduit.getIdCategorie());
//       
//    }
    public static void rechercheJTextField(JTable listeUtilisateurJTable, JTextField rechercheTextField) {
        DefaultTableModel mod = (DefaultTableModel) listeUtilisateurJTable.getModel();
        TableRowSorter<DefaultTableModel> tabMod = new TableRowSorter<>(mod);
        listeUtilisateurJTable.setRowSorter(tabMod);
        tabMod.setRowFilter(RowFilter.regexFilter(rechercheTextField.getText()));
    }

    public static void rechecherProduit(JTextField nomProdTextField, JTextField rechercheTextField, JTextField codeProdTextField, JTextField prixProdTextField,
            JTextField qteProdTextField, JTextField fabicantProTextField, JTextArea descrpritionTextArea, int idCategorieSelectionnee, JLabel IdentifiantProd) {
        Categorie categoriePourInsertion = new Categorie();
        categoriePourInsertion.setIdCategorie(idCategorieSelectionnee);
        //
        try {
            String requete = "SELECT idProduit, nomProduit, codeProduit, prixProdduit, qteStockProduit, fabricantProduit, descriptionProduit,idCategorieProduit "
                    + "FROM produit WHERE nomProduit = '" + rechercheTextField.getText() + "'";
            MaConnexionBD konex = new MaConnexionBD();
            konex.ouvrirConnexion();
            ResultSet rs = konex.ExecuteurdeRequeteSelect(requete);
            //
            while (rs.next()) {

                nomProdTextField.setText(rs.getString("nomProduit"));
                codeProdTextField.setText(rs.getString("codeProduit"));
                prixProdTextField.setText(rs.getString("prixProdduit"));
                qteProdTextField.setText(rs.getString("qteStockProduit"));
                fabicantProTextField.setText(rs.getString("fabricantProduit"));
                descrpritionTextArea.setText(rs.getString("descriptionProduit"));
                idCategorieSelectionnee = rs.getInt("idCategorieProduit");
                IdentifiantProd.setText(rs.getString("idProduit"));

                //
            }
            konex.fermetureConnexion();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur dans Produit, trouverUn : \n" + e.getMessage());
        }

    }

    public static void suppressionProduit(JLabel identifiant) {
        try {
            String requeteSql = "DELETE FROM produit WHERE  idProduit= " + identifiant.getText();
            MaConnexionBD konxi = new MaConnexionBD();
            konxi.ouvrirConnexion();
            int execReq = konxi.ExecuteurdeRequeteUpdate(requeteSql);
            if (execReq > 0) {
                JOptionPane.showMessageDialog(null, "suppression reussie !!");
            } else {
                JOptionPane.showMessageDialog(null, "Erreur lors de la suppression !!");
            }
            konxi.fermetureConnexion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur dans Produit, trouverUn : \n" + e.getMessage());
        }

    }

    public static void tableClicked(JTextField nomProdTextField, JTextField codeProdTextField, JTextField prixProdTextField,
            JTextField qteProdTextField, JTextField fabicantProTextField, JTextArea descrpritionTextArea, JComboBox<Categorie> idCategorieComboBox, JTable listeProduitTable) {
        int row = listeProduitTable.getSelectedRow();
        int column = listeProduitTable.getSelectedColumn();

        // On vérifie si l'utilisateur a cliqué sur la colonne "Select" (index 7)
        if (row != -1 && column == 7) {
            /*Récupérer l'ID stocké dans la cellule sélectionnée
            Note: Comme on a défini la classe Boolean, on récupère l'ID via la liste ou un ID caché
             Si vous avez remplacé l'ID par le Boolean, récupérons l'ID de l'objet */

            List<Produit> laListe = new Produit().trouverTout();
            Long idSelectionne = laListe.get(row).getIdProduit();
            // Retrouver l'objet complet
            Produit prodO = new Produit().trouverUn(idSelectionne);
            // Remplir les champs du formulaire 
            idCategorieComboBox.setSelectedItem(prodO.getIdCategorieProduit().getIdCategorie());
            nomProdTextField.setText(prodO.getNomProduit());
            codeProdTextField.setText(prodO.getCodeProduit());
            descrpritionTextArea.setText(prodO.getDescriptionProduit());
            fabicantProTextField.setText(prodO.getFabricantProduit());
            prixProdTextField.setText(String.valueOf(prodO.getPrixProdduit()));
            qteProdTextField.setText(String.valueOf(prodO.getQteStockProduit()));
            
            

        }

    }
}
