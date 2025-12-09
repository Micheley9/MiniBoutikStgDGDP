/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniboutikstgdgdp.entitys;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import miniboutikstgdgdp.entitys.connexionBD.MaConnexionBD;
import miniboutikstgdgdp.entitys.modeleOperationBD.ModeleOperationBD;

/**
 *
 * @author HP ELITEBOOK
 */
public class LigneChoix extends ModeleOperationBD<LigneChoix> {

    //
    private long idLgChx;
    private int qteLgChx;
    private double montantpartielLgChx;
    private Produit idProduitLgChx;
    private VenteProduit idVenteProduitLgChx;
    //

    public LigneChoix() {
    }

    public LigneChoix(long idLgChx, int qteLgChx, double montantpartielLgChx, Produit idProduitLgChx, VenteProduit idVenteProduitLgChx) {
        this.idLgChx = idLgChx;
        this.qteLgChx = qteLgChx;
        this.montantpartielLgChx = montantpartielLgChx;
        this.idProduitLgChx = idProduitLgChx;
        this.idVenteProduitLgChx = idVenteProduitLgChx;
    }
    //

    public long getIdLgChx() {
        return idLgChx;
    }

    public void setIdLgChx(long idLgChx) {
        this.idLgChx = idLgChx;
    }

    public int getQteLgChx() {
        return qteLgChx;
    }

    public void setQteLgChx(int qteLgChx) {
        this.qteLgChx = qteLgChx;
    }

    public double getMontantpartielLgChx() {
        return montantpartielLgChx;
    }

    public void setMontantpartielLgChx(double montantpartielLgChx) {
        this.montantpartielLgChx = montantpartielLgChx;
    }

    public Produit getIdProduitLgChx() {
        return idProduitLgChx;
    }

    public void setIdProduitLgChx(Produit idProduitLgChx) {
        this.idProduitLgChx = idProduitLgChx;
    }

    public VenteProduit getIdVenteProduitLgChx() {
        return idVenteProduitLgChx;
    }

    public void setIdVenteProduitLgChx(VenteProduit idVenteProduitLgChx) {
        this.idVenteProduitLgChx = idVenteProduitLgChx;
    }

    @Override
    public LigneChoix insererUneLigne(LigneChoix ObjIns) {
        long idProduit = ObjIns.getIdProduitLgChx().getIdProduit();
        long idVenteProd = ObjIns.getIdVenteProduitLgChx().getIdVenteProd();
        try {
            String requete = "INSERT INTO ligneChoix (qteLgChx, montantpartielLgChx, idProduitLgChx, idVenteProduitLgChx)"
                    + " VALUES ('"+ObjIns.getIdLgChx()+"','"+ObjIns.getMontantpartielLgChx()+"','"+idProduit+"','"+idVenteProd+"')";

            MaConnexionBD konx = new MaConnexionBD();
            konx.ouvrirConnexion();
            int resultReq = konx.ExecuteurdeRequeteUpdate(requete);
            konx.fermetureConnexion();

            if (resultReq > 0) {
                return ObjIns;
            } else {
                return null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur dans LigneChoix : insererUneLigne \n\n" + e.getMessage());
            return null;
        }

    }

    @Override
    public List<LigneChoix> insererPlusieursLignes(List<LigneChoix> ObjIns) {
       List<LigneChoix> listLigeneV = new ArrayList<>();
        try {
            String requete = "INSERT INTO lignechoix (qteLgChx,montantpartielLgChx,idProduitLgChx,idVenteProduitLgChx)";
                    
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur dans LigneChoix : insererPlusieursLignes \n\n" + e.getMessage());
        }
       return listLigeneV;
    }

    @Override
    public LigneChoix modifierUneLigne(LigneChoix ObjIns, Object cleO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public LigneChoix supprimerUneLigne(Object cleO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<LigneChoix> supprimerPlusieursLignes(List<Object> ObjList) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public LigneChoix trouverUn(Object cleO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<LigneChoix> trouverTout() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<LigneChoix> trouverPlusieus(Object ObjTrv) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
