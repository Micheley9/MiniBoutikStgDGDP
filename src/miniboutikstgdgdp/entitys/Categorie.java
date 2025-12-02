/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniboutikstgdgdp.entitys;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import miniboutikstgdgdp.entitys.connexionBD.MaConnexionBD;
import miniboutikstgdgdp.entitys.modeleOperationBD.ModeleOperationBD;

/**
 *
 * @author HP ELITEBOOK
 */
public class Categorie extends ModeleOperationBD<Categorie> {

    //
    private int idCategorie;
    private String nomCategorie;
    private String descriptionCategorie;
    //
    private List<Produit> produiList;

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

    public List<Produit> getProduiList() {
        return produiList;
    }

    public void setProduiList(List<Produit> produiList) {
        this.produiList = produiList;
    }

    @Override
    public Categorie insererUneLigne(Categorie ObjIns) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Categorie> insererPlusieursLignes(List<Categorie> ObjIns) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Categorie modifierUneLigne(Categorie ObjIns, Object cleO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Categorie supprimerUneLigne(Object cleO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Categorie> supprimerPlusieursLignes(List<Object> ObjList) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Categorie trouverUn(Object cleO) {
        Categorie catObj = new Categorie();
        try {
            String requete = "SELECT idCategorie, nomCategorie,descriptionCategorie FROM categorie WHERE idCategorie = " + cleO;
            MaConnexionBD konex = new MaConnexionBD();
            konex.ouvrirConnexion();
            ResultSet rs = konex.ExecuteurdeRequeteSelect(requete);
            boolean testReq = false;
            while (rs.next()) {
                testReq = true;
                catObj.setIdCategorie(rs.getInt("idCategorie"));
                catObj.setNomCategorie(rs.getString("nomCategorie"));
                catObj.setDescriptionCategorie(rs.getString("descriptionCategorie"));
            }
            rs.close();
            konex.fermetureConnexion();
            if (testReq == false) {
                catObj = null;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur dans Categorie : trouverUn \n" + e.getMessage());
        }
        return catObj;
    }

    @Override
    public List<Categorie> trouverTout() {
        List<Categorie> catList = new ArrayList<>();
        try {
            String requete = "SELECT idCategorie, nomCategorie,descriptionCategorie FROM categorie";
            MaConnexionBD konex = new MaConnexionBD();
            konex.ouvrirConnexion();
            ResultSet rs = konex.ExecuteurdeRequeteSelect(requete);

            while (rs.next()) {
                Categorie catObj = new Categorie();
                //
                catObj.setIdCategorie(rs.getInt("idCategorie"));
                catObj.setNomCategorie(rs.getString("nomCategorie"));
                catObj.setDescriptionCategorie(rs.getString("descriptionCategorie"));
                //
                catList.add(catObj);
            }
            rs.close();
            konex.fermetureConnexion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur dans Categorie :  trouvertTout\n" + e.getMessage());
        }
        return catList;
    }

    @Override
    public List<Categorie> trouverPlusieus(Object ObjTrv) {
        List<Categorie> catList = new ArrayList<>();
        try {
            String requete = "SELECT idCategorie, nomCategorie,descriptionCategorie FROM categorie WHERE idCategorie = " + ObjTrv;
            MaConnexionBD konex = new MaConnexionBD();
            konex.ouvrirConnexion();
            ResultSet rs = konex.ExecuteurdeRequeteSelect(requete);

            while (rs.next()) {
                Categorie catObj = new Categorie();
                //
                catObj.setIdCategorie(rs.getInt("idCategorie"));
                catObj.setNomCategorie(rs.getString("nomCategorie"));
                catObj.setDescriptionCategorie(rs.getString("descriptionCategorie"));
                //
                catList.add(catObj);
            }
            rs.close();
            konex.fermetureConnexion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur dans Categorie :  trouverPlusieusAvecCle\n" + e.getMessage());
        }
        return catList;
    }
    //

    @Override
    public String toString() {
        return nomCategorie;
    }

}
