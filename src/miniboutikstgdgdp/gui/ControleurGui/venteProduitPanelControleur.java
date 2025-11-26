/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniboutikstgdgdp.gui.ControleurGui;

import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import miniboutikstgdgdp.entitys.Produits;

/**
 *
 * @author HP ELITEBOOK
 */
public class venteProduitPanelControleur {

    public static void chargerCombo(JComboBox<Produits> prodListComboBox) {
        List<Produits> prodList = new Produits().trouverTout();
        //
        for (Produits prod : prodList) {
            prodListComboBox.addItem(prod);

        }
    }
    public static void affichqgeInfoProd(JComboBox<Produits> prodComboBox, JLabel categoriLabel, JLabel quantiteLabel, JLabel prixProdLabel) {
        //*
        Produits selectProduits = (Produits) prodComboBox.getSelectedItem();       
       //
       categoriLabel.setText(selectProduits.getCategorieProduitss());
       quantiteLabel.setText(""+selectProduits.getQteStockProduit());
       prixProdLabel.setText(""+selectProduits.getPrixProdduit());
    }
}
