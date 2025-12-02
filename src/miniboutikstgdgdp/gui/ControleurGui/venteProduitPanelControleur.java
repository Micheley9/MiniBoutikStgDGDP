/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniboutikstgdgdp.gui.ControleurGui;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import miniboutikstgdgdp.entitys.Categorie;
import miniboutikstgdgdp.entitys.LigneChoix;
import miniboutikstgdgdp.entitys.Produit;
import miniboutikstgdgdp.entitys.Produits;
import miniboutikstgdgdp.entitys.VenteProduit;

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

    /*
    public static void affichqgeInfoProd(JComboBox<Produits> prodComboBox, JLabel categoriLabel, JLabel quantiteLabel, JLabel prixProdLabel) {
        //*
        Produits selectProduits = (Produits) prodComboBox.getSelectedItem();       
       //
       categoriLabel.setText(selectProduits.getCategorieProduitss());
       quantiteLabel.setText(""+selectProduits.getQteStockProduit());
       prixProdLabel.setText(""+selectProduits.getPrixProdduit());
    }*/
    public static void affichageComboBoxOOP(JComboBox<Categorie> categorieComboBox) {
        List<Categorie> listCategories = new Categorie().trouverTout();
        for (Categorie catO : listCategories) {
            categorieComboBox.addItem(catO);
        }

    }

    public static void affichageComboBox2(JComboBox<Produit> prodComboBox) {
        List<Produit> prodList = new Produit().trouverTout();
        for (Produit prodO : prodList) {
            prodComboBox.addItem(prodO);
        }
    }

    public static void affichageSelected(JComboBox<Produit> prodComboBox, JLabel categoriLabel, JLabel quantiteLabel, JLabel prixProdLabel) {
        Produit selectedProduit = (Produit) prodComboBox.getSelectedItem();
        //
        categoriLabel.setText(selectedProduit.getIdCategorieProduit().getNomCategorie());
        quantiteLabel.setText("" + selectedProduit.getQteStockProduit());
        prixProdLabel.setText("" + selectedProduit.getPrixProdduit());

    }

    public static void dateHeure(JLabel datelLabel) {
        Date dDate = new Date();
        DateFormat sdf = new SimpleDateFormat("dd / MM / yyyy");
        String dateSys = sdf.format(dDate);
        datelLabel.setText(dateSys);

    }

    public static VenteProduit chargerLePanier(JComboBox<Produit> prodComboBox, JLabel categoriLabel,
            JLabel quantiteLabel, JLabel prixProdLabel, JSpinner qteSpinner, JTable listeChoixProdTable, JLabel dateDuJourLabel, VenteProduit ventProd, JLabel montantTLabel, JLabel prixpatielLabel) {
        double prixprod = Double.parseDouble("" + prixProdLabel.getText());
        int qteStk = Integer.parseInt("" + quantiteLabel.getText());
        if (ventProd == null) {
            Long idVent = new Date().getTime();
            ventProd = new VenteProduit();
            ventProd.setIdVenteProd(idVent);
            ventProd.setMontantVenteProd(0);
        }
        //
        Produit prodO = new Produit();
        //
        List<LigneChoix> ligneVenteList = ventProd.getLigneChoixVenteList();
        if (ligneVenteList == null) {
            ligneVenteList = new ArrayList<>();
        }
        LigneChoix lc = new LigneChoix();
        //
        lc.setIdVenteProduitLgChx(ventProd);
        long ic = new Date().getTime() + 1;
        lc.setIdLgChx(ic);
        lc.setIdProduitLgChx((Produit) prodComboBox.getSelectedItem());
        lc.setQteLgChx(Integer.parseInt("" + qteSpinner.getValue()));
        lc.setMontantpartielLgChx((prixprod * lc.getQteLgChx()));
        //
        ligneVenteList.add(lc);
        ventProd.setLigneChoixVenteList(ligneVenteList);
        //
        ventProd.setMontantVenteProd((ventProd.getMontantVenteProd() + lc.getMontantpartielLgChx()));
        prodO.setQteStockProduit(qteStk - lc.getQteLgChx());

        //
        //dateDuJourLabel.setText(DateTraitement.dateToStringDdMmYyyy(ventProd.getDateVenteProd()));
        montantTLabel.setText("" + ventProd.getMontantVenteProd());
        quantiteLabel.setText("" + prodO.getQteStockProduit());
        prixpatielLabel.setText("" + lc.getMontantpartielLgChx());
        //
        //
        List<LigneChoix> ligneChoixList = ventProd.getLigneChoixVenteList();
        //
        int nL = ligneChoixList.size();
        int nC = 6;
        Object dataVnt[][] = new Object[nL][nC];
        //
        //
        int cpt = 0;
        for (LigneChoix lChx : ligneChoixList) {
            //
            dataVnt[cpt][0] = (cpt + 1);
            dataVnt[cpt][1] = lChx.getIdProduitLgChx();
            dataVnt[cpt][2] = lChx.getIdProduitLgChx().getPrixProdduit();
            dataVnt[cpt][3] = lChx.getQteLgChx();
            dataVnt[cpt][4] = lChx.getMontantpartielLgChx();
            dataVnt[cpt][5] = false;
            cpt++;
        }
        //
        listeChoixProdTable.setModel(new javax.swing.table.DefaultTableModel(
                dataVnt,
                new String[]{
                    "N°", "Nom", "Prix", "Qte", "Montant ", "Select"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });

        return ventProd;

    }

    public static VenteProduit chargerLePanier(JTable listeChoixProdTable, VenteProduit ventProd) {

        List<Integer> listIndexSuppr = new ArrayList<>();
        //
        int nlt = listeChoixProdTable.getRowCount();
        //
        for (int i = 0; i < nlt; i++) {
            if (((boolean) listeChoixProdTable.getValueAt(i, 5)) == true) {
                listIndexSuppr.add(i);
            }
        }
        List<LigneChoix> ligneChoixList = ventProd.getLigneChoixVenteList();
        //
        if(listIndexSuppr.isEmpty()){
            JOptionPane.showMessageDialog(null, "Aucune ligne selectonnée!!");
        }else{
            JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer cette(ces) "+listIndexSuppr.size()+" ligne(s)" );
        }
        List<LigneChoix> ligneChoixList1 = ventProd.getLigneChoixVenteList();
        //
        int nL = ligneChoixList.size();
        int nC = 6;
        Object dataVnt[][] = new Object[nL][nC];
        //
        //
        int cpt = 0;
        for (LigneChoix lChx : ligneChoixList) {
            //
            dataVnt[cpt][0] = (cpt + 1);
            dataVnt[cpt][1] = lChx.getIdProduitLgChx();
            dataVnt[cpt][2] = lChx.getIdProduitLgChx().getPrixProdduit();
            dataVnt[cpt][3] = lChx.getQteLgChx();
            dataVnt[cpt][4] = lChx.getMontantpartielLgChx();
            dataVnt[cpt][5] = false;
            cpt++;
        }
        //
        listeChoixProdTable.setModel(new javax.swing.table.DefaultTableModel(
                dataVnt,
                new String[]{
                    "N°", "Nom", "Prix", "Qte", "Montant ", "Select"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });

        return ventProd;
    }
}
