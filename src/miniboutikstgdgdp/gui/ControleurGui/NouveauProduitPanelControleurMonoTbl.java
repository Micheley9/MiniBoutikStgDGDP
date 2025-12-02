/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniboutikstgdgdp.gui.ControleurGui;
//

import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import miniboutikstgdgdp.entitys.Categorie;
import miniboutikstgdgdp.entitys.Produit;
import miniboutikstgdgdp.entitys.Produits;

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
        Object[][] dataProd = new Object[prodList.size()][7];
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
            i++;
        }

        produitsTable.setModel(new javax.swing.table.DefaultTableModel(
                dataProd,
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

    }

    public static void affrichageReccuperationId(JComboBox<Categorie> listeCategirueBox,Categorie cleo) {
        
       
        Categorie selectionCombo = (Categorie) listeCategirueBox.getSelectedItem();
      cleo. setIdCategorie(selectionCombo.getIdCategorie());
         
        
    }
       
    

    public static Produit insertionProduit(JTextField nomProdTextField, JTextField codeProdTextField, JTextField prixProdTextField,
            JTextField qteProdTextField, JTextField fabicantProTextField, JTextArea descrpritionTextArea, JComboBox<Categorie> idCatSelectedBox) {
        double prixProd = Double.parseDouble(prixProdTextField.getText());
        int qteProd = Integer.parseInt(qteProdTextField.getText());
        

        //
        Produit prodO = new Produit();
        //
        long idProd = new Date().getTime();
        prodO.setIdProduit(idProd);
        prodO.setNomProduit(nomProdTextField.getText());
        prodO.setCodeProduit(codeProdTextField.getText());
        prodO.setIdCategorieProduit((Categorie) idCatSelectedBox.getSelectedItem());
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
            JOptionPane.showMessageDialog(null, "Erreur");
        } else {
            JOptionPane.showMessageDialog(null, "insertion reusi");
        }
        
        return  prodO;

    }
}
