/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template_idCategorie;nomCategorie,descriptionCategorie
 */
package miniboutikstgdgdp.entitys;
import java.sql.ResultSet;
import java.util.*;
import miniboutikstgdgdp.entitys.connexionBD.MaConnexionBD;

import miniboutikstgdgdp.entitys.modeleOperationBD.ModeleOperationBD;

/**
 *
 * @author HP ELITEBOOK
 */
public class Categorie extends  ModeleOperationBD<Categorie>{
    //
    private int idCategorie;
    private  String nomCategorie;
    private String descriptionCategorie;
    //
    private  List<Produit> produitListCat;
    //
    //

    public Categorie() {
    }
    //

    public Categorie(int idCategorie, String nomCategorie, String descriptionCategorie) {
        this.idCategorie = idCategorie;
        this.nomCategorie = nomCategorie;
        this.descriptionCategorie = descriptionCategorie;
    }
    //

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public String getDescriptionCategorie() {
        return descriptionCategorie;
    }

    public void setDescriptionCategorie(String descriptionCategorie) {
        this.descriptionCategorie = descriptionCategorie;
    }

    public List<Produit> getProduitListCat() {
        return produitListCat;
    }

    public void setProduitListCat(List<Produit> produitListCat) {
        this.produitListCat = produitListCat;
    }
    //

    @Override
    public Categorie insererUneLigne(Categorie ObjIns) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Categorie modifierUneLigne(Categorie ObjMod, Object cleO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Categorie supprimerUneLigne(Object cleO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Categorie trouverUn(Object cleO) {
       Categorie catO = new Categorie();
        try {
            String requete = "SELECT idCategorie,nomCategorie,descriptionCategorie  FROM categorie WHERE idCategorie ="+cleO;
            //
            MaConnexionBD konex = new MaConnexionBD();
            konex.ouvrirConnexion();
            ResultSet rs = konex.ExecuteurdeRequeteSelect(requete);
            //
            while (rs.next()) {
               //
               catO.setIdCategorie(rs.getInt("idCategorie"));
               catO.setNomCategorie(rs.getString("nomCategorie"));
               catO.setDescriptionCategorie(rs.getString("descriptionCategorie")); 
            }
            rs.close();
            konex.fermetureConnexion();
            
        } catch (Exception e) {
        }
       return catO;
    }

    @Override
    public List<Categorie> trouverTout() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
