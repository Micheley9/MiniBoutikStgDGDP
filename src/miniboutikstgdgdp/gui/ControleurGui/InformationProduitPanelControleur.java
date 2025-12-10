/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniboutikstgdgdp.gui.ControleurGui;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import miniboutikstgdgdp.entitys.connexionBD.MaConnexionBD;

/**
 *
 * @author HP ELITEBOOK
 */
public class InformationProduitPanelControleur {

    public static void infoVenteProduit(JTable historiqueVenteTable) {
        try {
            String requete = "SELECT p.nomProduit AS Nom, p.codeProduit AS Code, c.nomCategorie AS Categorie, p.qteStockProduit AS QteStock, "
                    + "COALESCE(SUM(lc.qteLgChx), 0) AS QteVendue, p.fabricantProduit AS Fabricant FROM produit p "
                    + "INNER JOIN categorie c ON p.idCategorieProduit = c.idCategorie LEFT JOIN lignechoix lc ON p.idProduit = lc.idProduitLgChx "
                    + "GROUP BY p.idProduit, p.nomProduit, p.codeProduit, c.nomCategorie, p.qteStockProduit, p.fabricantProduit ORDER BY p.nomProduit";
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
                listing[i][0] = (i + 1);
                listing[i][1] = resultatReq.getString("Nom");
                listing[i][2] = resultatReq.getString("Code");
                listing[i][3] = resultatReq.getString("Categorie");
                listing[i][4] = resultatReq.getString("QteStock");
                listing[i][5] = resultatReq.getString("QteVendue");
                listing[i][6] = resultatReq.getString("Fabricant");
                i++;
            }
            kon.fermetureConnexion();
            //jTable1 = new javax.swing.JTable();

            historiqueVenteTable.setModel(new javax.swing.table.DefaultTableModel(
                    listing,
                    new String[]{
                        "N°", "NOM", "CODE", "TYPE", "Qte STOCK", "Qte VENDUE", "FRABICANT"
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
