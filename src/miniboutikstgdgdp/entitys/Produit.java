/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniboutikstgdgdp.entitys;

import java.util.List;
import javax.swing.JOptionPane;
import miniboutikstgdgdp.entitys.connexionBD.MaConnexionBD;
import miniboutikstgdgdp.entitys.modeleOperationBD.ModeleOperationBD;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author HP ELITEBOOK
 */
public class Produit extends ModeleOperationBD<Produit> {

    //Declaration de variables 
    private long idProduit;
    private String nomProduit;
    private String codeProduit;
    private double prixProdduit;
    private int qteStockProduit;
    private String fabricantProduit;
    private String descriptionProduit;
    private Categorie idCategorieProduit;
    //
    private List<LigneChoix> ligneChoixProdList;

    public Produit() {
    }
    
    public Produit(long idProduit, String nomProduit, String codeProduit, double prixProdduit, int qteStockProduit, String fabricantProduit, String descriptionProduit, Categorie idCategorieProduit) {
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.codeProduit = codeProduit;
        this.prixProdduit = prixProdduit;
        this.qteStockProduit = qteStockProduit;
        this.fabricantProduit = fabricantProduit;
        this.descriptionProduit = descriptionProduit;
        this.idCategorieProduit = idCategorieProduit;
    }
    //

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
    
    public String getDescriptionProduit() {
        return descriptionProduit;
    }
    
    public void setDescriptionProduit(String descriptionProduit) {
        this.descriptionProduit = descriptionProduit;
    }
    
    public Categorie getIdCategorieProduit() {
        return idCategorieProduit;
    }
    
    public void setIdCategorieProduit(Categorie idCategorieProduit) {
        this.idCategorieProduit = idCategorieProduit;
    }
    
    public List<LigneChoix> getLigneChoixProdList() {
        return ligneChoixProdList;
    }
    
    public void setLigneChoixProdList(List<LigneChoix> ligneChoixProdList) {
        this.ligneChoixProdList = ligneChoixProdList;
    }
    
    @Override
    public Produit insererUneLigne(Produit ObjIns) {
        Produit prodO = new Produit();
        try {
            String requete = "INSERT INTO produit (idProduit, nomProduit, codeProduit, prixProdduit, qteStockProduit, fabricantProduit, descriptionProduit,idCategorieProduit) "
                    + "VALUES ('" + ObjIns.idProduit + "', '" + ObjIns.nomProduit + "','" + ObjIns.codeProduit + "','" + ObjIns.prixProdduit + "','" + ObjIns.qteStockProduit + "','" + ObjIns.fabricantProduit + "',"
                    + "'" + ObjIns.descriptionProduit + "','" + ObjIns.idCategorieProduit + "')";
            MaConnexionBD konx = new MaConnexionBD();
            konx.ouvrirConnexion();
            int resultReq = konx.ExecuteurdeRequeteUpdate(requete);
            konx.fermetureConnexion();
            if (resultReq > 0) {
                prodO.trouverUn(ObjIns.idProduit);
                
            } else {
                prodO = null;
            }
            konx.fermetureConnexion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur dans Produit : insererUneLigne\n" + e.getMessage());
        }
        return prodO;
    }
    
    @Override
    public List<Produit> insererPlusieursLignes(List<Produit> ObjIns) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public Produit modifierUneLigne(Produit ObjIns, Object cleO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public Produit supprimerUneLigne(Object cleO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public List<Produit> supprimerPlusieursLignes(List<Object> ObjList) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public Produit trouverUn(Object cleO) {
        Produit prodO = new Produit();
        try {
            String requete = "SELECT idProduit, nomProduit, codeProduit, prixProdduit, qteStockProduit, fabricantProduit, descriptionProduit "
                    + "FROM produit WHERE idProduit = " + cleO;
            MaConnexionBD konex = new MaConnexionBD();
            konex.ouvrirConnexion();
            ResultSet rs = konex.ExecuteurdeRequeteSelect(requete);
            //
            while (rs.next()) {
                prodO.setIdProduit(rs.getLong("idProduit"));
                prodO.setNomProduit(rs.getString("nomProduit"));
                prodO.setCodeProduit(rs.getString("codeProduit"));
                prodO.setPrixProdduit(rs.getDouble("prixProdduit"));
                prodO.setQteStockProduit(rs.getInt("qteStockProduit"));
                prodO.setFabricantProduit(rs.getString("fabricantProduit"));
                prodO.setDescriptionProduit(rs.getString("descriptionProduit"));
                //
                int idCat = rs.getInt("idCategorieProduit");
                //
                prodO.setIdCategorieProduit(new Categorie().trouverUn(idCat));
                
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Erreur dans Produit : trouverUn\n" + e.getMessage());
        }
        return prodO;
    }
    
    @Override
    public List<Produit> trouverTout() {
        List<Produit> prodList = new ArrayList<>();
        //
        try {
            String requete = "SELECT idProduit, nomProduit, codeProduit, prixProdduit, qteStockProduit, fabricantProduit, descriptionProduit, idCategorieProduit  "
                    + "FROM produit";
            //
            MaConnexionBD konx = new MaConnexionBD();
            konx.ouvrirConnexion();
            ResultSet rs = konx.ExecuteurdeRequeteSelect(requete);
            //
            while (rs.next()) {
                Produit prodO = new Produit();
                //
                prodO.setIdProduit(rs.getLong("idProduit"));
                prodO.setNomProduit(rs.getString("nomProduit"));
                prodO.setCodeProduit(rs.getString("codeProduit"));
                prodO.setPrixProdduit(rs.getDouble("prixProdduit"));
                prodO.setQteStockProduit(rs.getInt("qteStockProduit"));
                prodO.setFabricantProduit(rs.getString("fabricantProduit"));
                prodO.setDescriptionProduit(rs.getString("descriptionProduit"));
                int idCat = rs.getInt("idCategorieProduit");
                prodO.setIdCategorieProduit(new Categorie().trouverUn(idCat));
                prodList.add(prodO);
            }
            rs.close();
            konx.fermetureConnexion();
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Erreur dans Produit :trouverTout\n" + e.getMessage());
        }
        return prodList;
    }
    
    @Override
    public List<Produit> trouverPlusieus(Object ObjTrv) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public String toString() {
        return nomProduit;
    }
    
}
