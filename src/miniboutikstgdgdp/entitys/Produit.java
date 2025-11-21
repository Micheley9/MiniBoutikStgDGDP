/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template/*
                                                                                                                                            fabricantProduitfournisseurProduitidCategorieProd

 */
package miniboutikstgdgdp.entitys;

import java.util.*;
import miniboutikstgdgdp.entitys.modeleOperationBD.ModeleOperationBD;

/**
 *
 * @author HP ELITEBOOK
 */
public class Produit extends ModeleOperationBD<Produit> {
// Declaration de variables

    private long idProduit;
    private String nomProduit;
    private String codeProduit;
    private double prixProdduit;
    private int qteStockProduit;
    private String fabricantProduit;
    private String fournisseurProduit;
    private Categorie idCategorieProd;
//
    private List<Vente> venteListProd;

    // Constructions
    /*
        ctrl+espace
     */
    public Produit() {
    }
    //

    public Produit(long idProduit, String nomProduit, String codeProduit, double prixProdduit, int qteStockProduit, String fabricantProduit, String fournisseurProduit, Categorie idCategorieProd) {
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.codeProduit = codeProduit;
        this.prixProdduit = prixProdduit;
        this.qteStockProduit = qteStockProduit;
        this.fabricantProduit = fabricantProduit;
        this.fournisseurProduit = fournisseurProduit;
        this.idCategorieProd = idCategorieProd;
    }

    // Getter & Setter
    /*
    click droit >insert code> Getter and Setter
     */
    public long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(long idProduit) {
        this.idProduit = idProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public String getCodeProduit() {
        return codeProduit;
    }

    public void setCodeProduit(String codeProduit) {
        this.codeProduit = codeProduit;
    }

    public double getPrixProdduit() {
        return prixProdduit;
    }

    public void setPrixProdduit(double prixProdduit) {
        this.prixProdduit = prixProdduit;
    }

    public int getQteStockProduit() {
        return qteStockProduit;
    }

    public void setQteStockProduit(int qteStockProduit) {
        this.qteStockProduit = qteStockProduit;
    }

    public String getFabricantProduit() {
        return fabricantProduit;
    }

    public void setFabricantProduit(String fabricantProduit) {
        this.fabricantProduit = fabricantProduit;
    }

    public String getFournisseurProduit() {
        return fournisseurProduit;
    }

    public void setFournisseurProduit(String fournisseurProduit) {
        this.fournisseurProduit = fournisseurProduit;
    }

    public Categorie getIdCategorieProd() {
        return idCategorieProd;
    }

    public void setIdCategorieProd(Categorie idCategorieProd) {
        this.idCategorieProd = idCategorieProd;
    }

    public List<Vente> getVenteListProd() {
        return venteListProd;
    }

    public void setVenteListProd(List<Vente> venteListProd) {
        this.venteListProd = venteListProd;
    }

    //
    //
    @Override
    public Produit insererUneLigne(Produit ObjIns) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Produit modifierUneLigne(Produit ObjMod, Object cleO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Produit supprimerUneLigne(Object cleO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Produit trouverUn(Object cleO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Produit> trouverTout() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
