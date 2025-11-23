/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniboutikstgdgdp.gui.ControleurGui;

import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import miniboutikstgdgdp.entitys.Categorie;
import miniboutikstgdgdp.entitys.Produit;

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
    
}
