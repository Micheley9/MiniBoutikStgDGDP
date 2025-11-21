/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template=>idVenteqteVentemontantVenteDateVenteidProduitVente
 */
package miniboutikstgdgdp.entitys;
import java.util.*;

import miniboutikstgdgdp.entitys.modeleOperationBD.ModeleOperationBD;

/**
 *
 * @author HP ELITEBOOK
 */
public class Vente extends ModeleOperationBD<Vente>{
    //
    private long  idVente;
    private  int qteVente;
    private  double montantVente;
    private  Date DateVente;
    private  Produit idProduitVente;
    //

    public Vente() {
    }
    //
    public Vente(long idVente, int qteVente, double montantVente, Date DateVente, Produit idProduitVente) {
        this.idVente = idVente;
        this.qteVente = qteVente;
        this.montantVente = montantVente;
        this.DateVente = DateVente;
        this.idProduitVente = idProduitVente;
    }
    //

    public long getIdVente() {
        return idVente;
    }

    public void setIdVente(long idVente) {
        this.idVente = idVente;
    }

    public int getQteVente() {
        return qteVente;
    }

    public void setQteVente(int qteVente) {
        this.qteVente = qteVente;
    }

    public double getMontantVente() {
        return montantVente;
    }

    public void setMontantVente(double montantVente) {
        this.montantVente = montantVente;
    }

    public Date getDateVente() {
        return DateVente;
    }

    public void setDateVente(Date DateVente) {
        this.DateVente = DateVente;
    }

    public Produit getIdProduitVente() {
        return idProduitVente;
    }

    public void setIdProduitVente(Produit idProduitVente) {
        this.idProduitVente = idProduitVente;
    }
    //

    @Override
    public Vente insererUneLigne(Vente ObjIns) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Vente modifierUneLigne(Vente ObjMod, Object cleO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Vente supprimerUneLigne(Object cleO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Vente trouverUn(Object cleO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Vente> trouverTout() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
