/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniboutikstgdgdp.entitys;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import miniboutikstgdgdp.entitys.autres.DateTraitement;
import miniboutikstgdgdp.entitys.connexionBD.MaConnexionBD;
import miniboutikstgdgdp.entitys.modeleOperationBD.ModeleOperationBD;

/**
 *
 * @author HP ELITEBOOK
 */
public class VenteProduit extends ModeleOperationBD<VenteProduit> {

    //
    private long idVenteProd;
    private Date dateVenteProd;
    private double montantVenteProd;
    //
    private List<LigneChoix> ligneChoixVenteList;
//

    public VenteProduit() {
    }

    public VenteProduit(long idVenteProd, Date dateVenteProd, double montantVenteProd) {
        this.idVenteProd = idVenteProd;
        this.dateVenteProd = dateVenteProd;
        this.montantVenteProd = montantVenteProd;
    }
//

    public long getIdVenteProd() {
        return idVenteProd;
    }

    public void setIdVenteProd(long idVenteProd) {
        this.idVenteProd = idVenteProd;
    }

    public Date getDateVenteProd() {
        return dateVenteProd;
    }

    public void setDateVenteProd(Date dateVenteProd) {
        this.dateVenteProd = dateVenteProd;
    }

    public double getMontantVenteProd() {
        return montantVenteProd;
    }

    public void setMontantVenteProd(double montantVenteProd) {
        this.montantVenteProd = montantVenteProd;
    }

    public List<LigneChoix> getLigneChoixVenteList() {
        return ligneChoixVenteList;
    }

    public void setLigneChoixVenteList(List<LigneChoix> ligneChoixVenteList) {
        this.ligneChoixVenteList = ligneChoixVenteList;
    }

    @Override
    public VenteProduit insererUneLigne(VenteProduit ObjIns) {
        VenteProduit venteProd = new VenteProduit();
        try {

            String dateStr = DateTraitement.dateToStringDdMmYyyy(ObjIns.dateVenteProd);

            String requete = "INSERT INTO vente (idVente, dateVente, montantVente) VALUES ("
                    + ObjIns.getIdVenteProd() + ", '" + dateStr + "', "
                    + ObjIns.getMontantVenteProd() + ")"; // idProduitVente peut être NULL car on a les lignes

            MaConnexionBD konx = new MaConnexionBD();
            konx.ouvrirConnexion();
            int resultReq = konx.ExecuteurdeRequeteUpdate(requete);
            konx.fermetureConnexion();

            if (resultReq > 0) {
                venteProd.trouverUn(ObjIns.idVenteProd);
            } else {
                return null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur dans VenteProduit : insererUneLigne\n" + e.getMessage());
        }
        return venteProd;
    }

    @Override
    public List<VenteProduit> insererPlusieursLignes(List<VenteProduit> ObjIns) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public VenteProduit modifierUneLigne(VenteProduit ObjIns, Object cleO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public VenteProduit supprimerUneLigne(Object cleO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<VenteProduit> supprimerPlusieursLignes(List<Object> ObjList) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public VenteProduit trouverUn(Object cleO) {
        VenteProduit venteProd = new VenteProduit();
        try {
            String requete = "SELECT idVenteProd,dateVenteProd,montantVenteProd FROM venteproduit WHERE idVenteProd =" + cleO;
            MaConnexionBD konex = new MaConnexionBD();
            konex.ouvrirConnexion();
            ResultSet rs = konex.ExecuteurdeRequeteSelect(requete);
            while (rs.next()) {
                venteProd.setIdVenteProd(rs.getLong("idVenteProd"));
                venteProd.setDateVenteProd(rs.getDate("dateVenteProd"));
                venteProd.setMontantVenteProd(rs.getDouble("montantVenteProd"));
            }
            konex.fermetureConnexion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur dans VenteProduit : trouverUn\n" + e.getMessage());
        }
        return venteProd;
    }

    @Override
    public List<VenteProduit> trouverTout() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<VenteProduit> trouverPlusieus(Object ObjTrv) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
