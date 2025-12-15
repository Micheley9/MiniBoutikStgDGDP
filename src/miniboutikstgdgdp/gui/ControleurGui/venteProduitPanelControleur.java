/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniboutikstgdgdp.gui.ControleurGui;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import miniboutikstgdgdp.entitys.autres.DateTraitement;

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
//----------------------------------------------------------Charger Le Panier------------------------------------------------------------------------

    public static VenteProduit chargerLePanier(JComboBox<Produit> prodComboBox, JLabel categoriLabel,
            JLabel quantiteLabel, JLabel prixProdLabel, JSpinner qteSpinner, JTable listeChoixProdTable, JLabel dateDuJourLabel, VenteProduit ventProd, JLabel montantTLabel, JLabel prixpatielLabel) {
        //
        double prixprod = Double.parseDouble("" + prixProdLabel.getText());
        int qteStockProd = Integer.parseInt("" + quantiteLabel.getText());
        int qtePayer = Integer.parseInt("" + qteSpinner.getValue());
        //
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
        if (qtePayer <= 0) {
            //
            JOptionPane.showMessageDialog(null, "Quantité commander negative ! ");
        } else if (qtePayer > qteStockProd || qteStockProd <= 0) {
            //
            JOptionPane.showMessageDialog(null, "Stock de produit inferiere : \n " + qteStockProd);
        } else {
            //
            lc.setIdVenteProduitLgChx(ventProd);
            long idVente = new Date().getTime() + 1;
            lc.setIdLgChx(idVente);
            lc.setIdProduitLgChx((Produit) prodComboBox.getSelectedItem());
            lc.setQteLgChx(qtePayer);
            lc.setMontantpartielLgChx((prixprod * lc.getQteLgChx()));
            //
            ligneVenteList.add(lc);
            ventProd.setLigneChoixVenteList(ligneVenteList);
            //
            ventProd.setMontantVenteProd((ventProd.getMontantVenteProd() + lc.getMontantpartielLgChx()));
            prodO.setQteStockProduit(qteStockProd - lc.getQteLgChx());
            //
            montantTLabel.setText("" + ventProd.getMontantVenteProd());
            quantiteLabel.setText("" + prodO.getQteStockProduit());
            prixpatielLabel.setText("" + lc.getMontantpartielLgChx());
            //
            List<LigneChoix> ligneChoixList = ventProd.getLigneChoixVenteList();
            //
            int nL = ligneChoixList.size();
            int nC = 7;
            Object dataVnt[][] = new Object[nL][nC];
            //
            //
            int cpt = 0;
            for (LigneChoix lChx : ligneChoixList) {
                //
                dataVnt[cpt][0] = (cpt + 1);
                dataVnt[cpt][1] = lChx.getIdProduitLgChx().getIdProduit();
                dataVnt[cpt][2] = lChx.getIdProduitLgChx();
                dataVnt[cpt][3] = lChx.getIdProduitLgChx().getPrixProdduit();
                dataVnt[cpt][4] = lChx.getQteLgChx();
                dataVnt[cpt][5] = lChx.getMontantpartielLgChx();
                dataVnt[cpt][6] = false;
                cpt++;
            }
            //
            listeChoixProdTable.setModel(new javax.swing.table.DefaultTableModel(
                    dataVnt,
                    new String[]{
                        "N°", "ID", "Nom", "Prix", "Qte", "Montant  Partiel", "Select"
                    }
            ) {
                Class[] types = new Class[]{
                    java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
                };
                boolean[] canEdit = new boolean[]{
                    false, true, true, true, true, true, true
                };

                public Class getColumnClass(int columnIndex) {
                    return types[columnIndex];
                }

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });
        }
        //

        return ventProd;
    }
//
//----------------------------------------------------------------Supprimer dans le panier--------------------------------------------------------------------------------------------

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
                int nC = 7;
                Object dataVnt[][] = new Object[nL][nC];
                //
                //
                int cpt = 0;
                for (LigneChoix lChx : ligneChoixList1) {
                    //
                    dataVnt[cpt][0] = (cpt + 1);
                    dataVnt[cpt][1] = lChx.getIdProduitLgChx().getIdProduit();
                    dataVnt[cpt][2] = lChx.getIdProduitLgChx();
                    dataVnt[cpt][3] = lChx.getIdProduitLgChx().getPrixProdduit();
                    dataVnt[cpt][4] = lChx.getQteLgChx();
                    dataVnt[cpt][5] = lChx.getMontantpartielLgChx();
                    dataVnt[cpt][6] = false;
                    cpt++;
                }
                //
                listeChoixProdTable.setModel(new javax.swing.table.DefaultTableModel(
                        dataVnt,
                        new String[]{
                            "N°", "ID", "Nom", "Prix", "Qte", "Montant  Partiel", "Select"
                        }
                ) {
                    Class[] types = new Class[]{
                        java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
                    };
                    boolean[] canEdit = new boolean[]{
                        false, true, true, true, true, true, true
                    };

                    public Class getColumnClass(int columnIndex) {
                        return types[columnIndex];
                    }

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                });
            }
        }
        return ventProd;
    }

    //---------------------------------------------------------------Supprimer dans le panier 2--------------------------------------------------------------------------------------------
    public static VenteProduit supprimerDansLePanier2(JTable listeChoixProdTable,
            VenteProduit ventProd,
            JLabel montantTotalLabel) {

        List<Integer> listIndexSuppr = new ArrayList<>();
        
        //
        int nlt = listeChoixProdTable.getRowCount();
        //
        for (int i = 0; i < nlt; i++) {
            if (((boolean) listeChoixProdTable.getValueAt(i, 6)) == true) {
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
                int nC = 7;
                Object dataVnt[][] = new Object[nL][nC];
                //
                //
                int cpt = 0;
                for (LigneChoix lChx : ligneChoixList1) {
                    //
                    dataVnt[cpt][0] = (cpt + 1);
                    dataVnt[cpt][1] = lChx.getIdProduitLgChx().getIdProduit();
                    dataVnt[cpt][2] = lChx.getIdProduitLgChx();
                    dataVnt[cpt][3] = lChx.getIdProduitLgChx().getPrixProdduit();
                    dataVnt[cpt][4] = lChx.getQteLgChx();
                    dataVnt[cpt][5] = lChx.getMontantpartielLgChx();
                    dataVnt[cpt][6] = false;
                    cpt++;
                }
                //
                listeChoixProdTable.setModel(new javax.swing.table.DefaultTableModel(
                        dataVnt,
                        new String[]{
                            "N°", "ID", "Nom", "Prix", "Qte", "Montant  Partiel", "Select"
                        }
                ) {
                    Class[] types = new Class[]{
                        java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
                    };
                    boolean[] canEdit = new boolean[]{
                        false, true, true, true, true, true, true
                    };

                    public Class getColumnClass(int columnIndex) {
                        return types[columnIndex];
                    }

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                });
            }
        }
        return ventProd;
    }

    //
    // ----------------------------------------------------- Insère directement depuis le JTable-----------------------------------------------
    //
    public static VenteProduit validerVenteDirecte(JTable listeChoixProdTable, VenteProduit ventProd) {

        // Créer et insérer la vente
        if (ventProd == null) {
            Long idVente = new Date().getTime();
            ventProd = new VenteProduit();
            ventProd.setIdVenteProd(idVente);
            ventProd.setDateVenteProd(new Date());
            ventProd.setMontantVenteProd(0);
        }
        // Calculer le montant total à partir du tableau
        double montantTotal = 0;
        DefaultTableModel model = (DefaultTableModel) listeChoixProdTable.getModel();

        for (int i = 0; i < model.getRowCount(); i++) {
            double montantPartiel = Double.parseDouble(model.getValueAt(i, 5).toString());
            montantTotal += montantPartiel;
        }
        ventProd.setMontantVenteProd(montantTotal);

        // Insérer la vente
        VenteProduit venteInseree = ventProd.insererUneLigne(ventProd);

        if (venteInseree == null) {
            JOptionPane.showMessageDialog(null, "Erreur lors de l'insertion de la vente");
            return ventProd;
        }

        //  Parcourir le tableau et insérer les lignes
        for (int i = 0; i < model.getRowCount(); i++) {
            try {
                long nomProduit = Long.parseLong(model.getValueAt(i, 1).toString());
                double prix = Double.parseDouble(model.getValueAt(i, 3).toString());
                int quantite = Integer.parseInt(model.getValueAt(i, 4).toString());
                double montantPartiel = Double.parseDouble(model.getValueAt(i, 5).toString());
                // Trouver le produit par son nom
                Produit produit = new Produit();
                produit.setIdProduit(nomProduit);

                if (produit != null) {
                    // Créer et insérer la ligne
                    LigneChoix ligne = new LigneChoix();
                    ligne.setQteLgChx(quantite);
                    ligne.setMontantpartielLgChx(montantPartiel);
                    ligne.setIdProduitLgChx(produit);
                    ligne.setIdVenteProduitLgChx(ventProd);

                    LigneChoix ligneInseree = ligne.insererUneLigne(ligne);

                    if (ligneInseree != null) {
                        // CORRECTION : Mettre à jour le stock correctement
                        Produit produitPourMaj = new Produit().trouverUn(produit.getIdProduit());
                        if (produitPourMaj != null) {
                            int stockActuel = produitPourMaj.getQteStockProduit();
                            int nouveauStock = stockActuel - quantite;

                            // Vérifier que le stock ne devient pas négatif
                            if (nouveauStock < 0) {
                                JOptionPane.showMessageDialog(null,
                                        "Stock insuffisant pour " + produitPourMaj.getNomProduit() + " après vérification");
                            } else {
                                produitPourMaj.setQteStockProduit(nouveauStock);

                                // Mettre à jour dans la base
                                Produit produitModifie = produitPourMaj.modifierUneLigne(produitPourMaj, produitPourMaj.getIdProduit());

                                if (produitModifie == null) {
                                    JOptionPane.showMessageDialog(null,
                                            "Erreur lors de la mise à jour du stock pour : " + produitPourMaj.getNomProduit());
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erreur ligne " + (i + 1) + ": " + e.getMessage());
            }
        }

        // Vider le tableau
        model.setRowCount(0);

        JOptionPane.showMessageDialog(null, "Vente validée avec succès !\nID: " + ventProd.getIdVenteProd());

        return ventProd;
    }
    //#############################################################################################################

    public static VenteProduit validerVenteDirecte(JTable listeChoixProdTable,
            VenteProduit ventProd,
            JLabel montantTotalLabel) {

        try {
            // Vérifier si le tableau a des données 
            if (listeChoixProdTable.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Le panier est vide !");
                return ventProd; // Retourner l'objet inchangé 
            }

            //  Demander confirmation 
            int rep = JOptionPane.showConfirmDialog(null, "Voulez-vous valider cette vente ? \n Nombre d'articles : " + listeChoixProdTable.getRowCount(),
                    "Confirmation de vente", JOptionPane.YES_NO_OPTION);

            if (rep != JOptionPane.YES_OPTION) {
                return ventProd; // Retourner l'objet inchangé 
            }

            // Créer et insérer la vente 
            if (ventProd == null) {
                Long idVent = new Date().getTime();
                ventProd = new VenteProduit();
                ventProd.setIdVenteProd(idVent);
                ventProd.setDateVenteProd(new Date());
                ventProd.setMontantVenteProd(0);
            }

            // Calculer le montant total à partir du tableau 
            double montantTotal = 0;
            DefaultTableModel model = (DefaultTableModel) listeChoixProdTable.getModel();

            for (int i = 0; i < model.getRowCount(); i++) {
                try {
                    double montant = Double.parseDouble(model.getValueAt(i, 5).toString());
                    montantTotal += montant;
                } catch (Exception e) {
                    // Ignorer les erreurs de conversion 
                }
            }

            ventProd.setMontantVenteProd(montantTotal);

            // Insérer la vente 
            VenteProduit venteInseree = ventProd.insererUneLigne(ventProd);

            if (venteInseree == null) {
                JOptionPane.showMessageDialog(null, "Erreur lors de l'insertion de la vente");
                return ventProd; // Retourner l'objet inchangé 
            }

            // Parcourir le tableau et insérer les lignes 
            boolean toutesLignesInserees = true;
            for (int i = 0; i < model.getRowCount(); i++) {
                try {
                    long idProduit = Long.parseLong(model.getValueAt(i, 1).toString());
                    double prix = Double.parseDouble(model.getValueAt(i, 3).toString());
                    int quantite = Integer.parseInt(model.getValueAt(i, 4).toString());
                    double montantPartiel = Double.parseDouble(model.getValueAt(i, 5).toString());

                    Produit produit = new Produit().trouverUn(idProduit);
                    if (produit == null) {
                        toutesLignesInserees = false;
                        continue;
                    }

                    // Récupérer les autres données 
                    LigneChoix ligne = new LigneChoix();
                    ligne.setIdLgChx(new Date().getTime() + i); // ID unique 
                    ligne.setQteLgChx(quantite);
                    ligne.setMontantpartielLgChx(montantPartiel);
                    ligne.setIdProduitLgChx(produit);
                    ligne.setIdVenteProduitLgChx(ventProd);

                    LigneChoix ligneInseree = ligne.insererUneLigne(ligne);

                    // Mettre à jour dans la base 
                    if (ligneInseree != null) {
                        // CORRECTION : Mettre à jour le stock correctement
                        Produit produitPourMaj = new Produit().trouverUn(produit.getIdProduit());
                        if (produitPourMaj != null) {
                            int stockActuel = produitPourMaj.getQteStockProduit();
                            int nouveauStock = stockActuel - quantite;

                            // Vérifier que le stock ne devient pas négatif
                            if (nouveauStock < 0) {
                                JOptionPane.showMessageDialog(null,
                                        "Stock insuffisant pour " + produitPourMaj.getNomProduit() + " après vérification");
                            } else {
                                produitPourMaj.setQteStockProduit(nouveauStock);

                                // Mettre à jour dans la base
                                Produit produitModifie = produitPourMaj.modifierUneLigne(produitPourMaj, produitPourMaj.getIdProduit());

                                if (produitModifie == null) {
                                    JOptionPane.showMessageDialog(null,
                                            "Erreur lors de la mise à jour du stock pour : " + produitPourMaj.getNomProduit());
                                }
                            }

                        }
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erreur ligne " + (i + 1) + ": " + e.getMessage());
                }
            }

            if (toutesLignesInserees) {
                // Vider le tableau 
                model.setRowCount(0);

                //  Mettre à jour le JLabel montantTotalLabel 
                if (montantTotalLabel != null) {
                    montantTotalLabel.setText("0.0");
                }
                // Afficher un message de succès 
                String DateJour = DateTraitement.dateToStringDdMmYyyy(new Date());
                JOptionPane.showMessageDialog(null,
                        "Vente validée avec succès !\n"
                        + "ID Vente : " + ventProd.getIdVenteProd() + "\n"
                        + "Date : " + DateJour + "\n"
                        + "Montant total : " + ventProd.getMontantVenteProd() + "\n"
                        + "Nombre d'articles : "+ model.getRowCount());
                // Vider le tableau 
                model.setRowCount(0);

                //  Mettre à jour le JLabel montantTotalLabel 
                if (montantTotalLabel != null) {
                    montantTotalLabel.setText("0.0");
                }

                // RÉINITIALISER LA VENTE POUR UNE NOUVELLE VENTE 
                // Retourner null pour indiquer qu'on peut créer une nouvelle vente 
                return null;

            } else {
                JOptionPane.showMessageDialog(null, "Des erreurs sont survenues lors de la validation Certains produits n'ont pas été enregistrés.");
                return ventProd; // Retourner l'objet inchangé 
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erreur lors de la validation de la vente : " + e.getMessage());
            e.printStackTrace();
            return ventProd; // Retourner l'objet inchangé 
        }
    }
}
