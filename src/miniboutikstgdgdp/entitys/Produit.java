/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template/*
                                                                                                                                            fabricantProduitfournisseurProduitidCategorieProd

 */
package miniboutikstgdgdp.entitys;

import java.util.*;
import java.sql.ResultSet;
import miniboutikstgdgdp.entitys.connexionBD.*;
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
        Produit prodO = new Produit();
        try {
            String requete = "INSERT INTO Produit (idProduit,nomProduit,codeProduit,prixProdduit,qteStockProduit,fabricantProduit,"
                    + "fournisseurProduit,idCategorieProd) VALUES ('" + ObjIns.idProduit + "','" + ObjIns.nomProduit + "','" + ObjIns.codeProduit + "','" + ObjIns.prixProdduit + "',"
                    + "'" + ObjIns.qteStockProduit + "','" + ObjIns.fabricantProduit + "','" + ObjIns.fournisseurProduit + "','" + ObjIns.idCategorieProd + "')";
            MaConnexionBD konex = new MaConnexionBD();
            konex.ouvrirConnexion();
            int testIns = konex.ExecuteurdeRequeteUpdate(requete);
            konex.fermetureConnexion();
            //
            if (testIns>0) {
                prodO = trouverUn(ObjIns.idProduit);
            }

        } catch (Exception e) {
        }
        return prodO;
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
        Produit prodO = new Produit();
        try {
            String requete = "SELECT idProduit,nomProduit,codeProduit,prixProdduit,qteStockProduit,fabricantProduit,fournisseurProduit,idCategorieProd "
                    + "FROM Produit WHERE idProduit = " + cleO;
            MaConnexionBD konex = new MaConnexionBD();
            konex.ouvrirConnexion();
            ResultSet rs = konex.ExecuteurdeRequeteSelect(requete);
            //
            boolean  testSelect = false;
            //
            while (rs.next()) {   
                testSelect = true;
                prodO.setIdProduit(rs.getLong("idProduit"));
                prodO.setNomProduit(rs.getString("idProduit"));
                prodO.setCodeProduit(rs.getString("idProduit"));
                prodO.setPrixProdduit(rs.getDouble("idProduit"));
                prodO.setQteStockProduit(rs.getInt("idProduit"));
                prodO.setFabricantProduit(rs.getString("idProduit"));
                prodO.setFournisseurProduit(rs.getString("idProduit"));
                int idCat = rs.getInt("idCategorieProd");
                prodO.setIdCategorieProd(new Categorie().trouverUn(idCat));
               
                
            }
            if (testSelect = false) {
                prodO = null;
            }
            rs.close();
            konex.fermetureConnexion();
        } catch (Exception e) {
        }
        return prodO;
    }

    @Override
    public List<Produit> trouverTout() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
