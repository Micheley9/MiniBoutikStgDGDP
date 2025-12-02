/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniboutikstgdgdp.entitys;

import java.util.Date;
import java.util.List;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
