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
import java.util.HashMap;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
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
            ventProd.setDateVenteProd(new Date());
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
        long idVente = new Date().getTime() + 1;
        lc.setIdLgChx(idVente);
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
            dataVnt[cpt][0] = (cpt +1);
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
                    "N°", "Nom", "Prix", "Qte", "Montant  Partiel ", "Select"
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
//

    public static VenteProduit supprimerDansLePanier(JTable listeChoixProdTable, VenteProduit ventProd) {

        List<Integer> listIndexSuppr = new ArrayList<>();
        //
        int nlt = listeChoixProdTable.getRowCount();
        //
        for (int i = 0; i < nlt; i++) {
            if (((boolean) listeChoixProdTable.getValueAt(i, 5)) == true) {
                listIndexSuppr.add(i);
            }
        }
        //
        if (listIndexSuppr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Aucune ligne selectonnée!!");
        } else {
            int rep = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer cette(ces) " + listIndexSuppr.size() + " ligne(s)", "Attention ", JOptionPane.YES_NO_OPTION);
            //
            if (rep == JOptionPane.YES_OPTION) {
                List<LigneChoix> ligneChoixList = ventProd.getLigneChoixVenteList();
                //
                HashMap<Integer, LigneChoix> hmListLChx = new HashMap<>();
                //
                int icpt = 0;
                for (LigneChoix lCh : ligneChoixList) {
                    hmListLChx.put(icpt, lCh);
                    icpt++;
                }
                //
                for (int idx : listIndexSuppr) {
                    hmListLChx.remove(idx);
                }
                //
                ligneChoixList = new ArrayList<>();
                if (!hmListLChx.isEmpty()) {
                    for (LigneChoix lc : hmListLChx.values()) {
                        ligneChoixList.add(lc);
                    }
                } else {
                }
                //
                ventProd.setLigneChoixVenteList(ligneChoixList);
                //
                List<LigneChoix> ligneChoixList1 = ventProd.getLigneChoixVenteList();
                //
                int nL = ligneChoixList1.size();
                int nC = 6;
                Object dataVnt[][] = new Object[nL][nC];
                //
                //
                int cpt = 0;
                for (LigneChoix lChx : ligneChoixList1) {
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
                            "N°", "Nom", "Prix", "Qte", "Montant  Partiel ", "Select"
                        }
                ) {
                    Class[] types = new Class[]{
                        java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
                    };

                    public Class getColumnClass(int columnIndex) {
                        return types[columnIndex];
                    }
                });
            }
        }
        return ventProd;
    }

    //------------------------
    public static VenteProduit supprimerDansLePanier2(JTable listeChoixProdTable,
            VenteProduit ventProd,
            JLabel montantTotalLabel) {

        List<Integer> listIndexSuppr = new ArrayList<>();
        //
        int nlt = listeChoixProdTable.getRowCount();
        //
        for (int i = 0; i < nlt; i++) {
            if (((boolean) listeChoixProdTable.getValueAt(i, 5)) == true) {
                listIndexSuppr.add(i);
            }
        }
        //
        if (listIndexSuppr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Aucune ligne selectonnée!!");
        } else {
            // Calculer le montant total des lignes sélectionnées
            double montantASoustraire = 0;
            List<LigneChoix> ligneChoixListTemp = ventProd.getLigneChoixVenteList();
            for (int idx : listIndexSuppr) {
                if (idx < ligneChoixListTemp.size()) {
                    montantASoustraire += ligneChoixListTemp.get(idx).getMontantpartielLgChx();
                }
            }

            int rep = JOptionPane.showConfirmDialog(null,
                    "Voulez-vous supprimer cette(ces) " + listIndexSuppr.size() + " ligne(s)\n"
                    + "Montant total à supprimer : " + montantASoustraire,
                    "Attention ",
                    JOptionPane.YES_NO_OPTION);
            //
            if (rep == JOptionPane.YES_OPTION) {
                List<LigneChoix> ligneChoixList = ventProd.getLigneChoixVenteList();
                //
                HashMap<Integer, LigneChoix> hmListLChx = new HashMap<>();
                //
                int icpt = 0;
                for (LigneChoix lCh : ligneChoixList) {
                    hmListLChx.put(icpt, lCh);
                    icpt++;
                }
                //
                for (int idx : listIndexSuppr) {
                    hmListLChx.remove(idx);
                }
                //
                ligneChoixList = new ArrayList<>();
                if (!hmListLChx.isEmpty()) {
                    for (LigneChoix lc : hmListLChx.values()) {
                        ligneChoixList.add(lc);
                    }
                } else {
                }
                //
                ventProd.setLigneChoixVenteList(ligneChoixList);

                // Mettre à jour le montant total de la vente
                double nouveauMontantTotal = ventProd.getMontantVenteProd() - montantASoustraire;
                ventProd.setMontantVenteProd(nouveauMontantTotal);

                // Mettre à jour le JLabel montantTotalLabel
                if (montantTotalLabel != null) {
                    montantTotalLabel.setText("" + nouveauMontantTotal);
                }

                //
                List<LigneChoix> ligneChoixList1 = ventProd.getLigneChoixVenteList();
                //
                int nL = ligneChoixList1.size();
                int nC = 6;
                Object dataVnt[][] = new Object[nL][nC];
                //
                //
                int cpt = 0;
                for (LigneChoix lChx : ligneChoixList1) {
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
                            "N°", "Nom", "Prix", "Qte", "Montant  Partiel ", "Select"
                        }
                ) {
                    Class[] types = new Class[]{
                        java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
                    };

                    public Class getColumnClass(int columnIndex) {
                        return types[columnIndex];
                    }
                });
            }
        }
        return ventProd;
    }

    //
    public static void validerLaVente(JTable listeChoixProdTable, VenteProduit ventePro) {
        int nlt = listeChoixProdTable.getRowCount();
    }
}
