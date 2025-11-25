/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniboutikstgdgdp.entitys;

import com.mysql.cj.protocol.Resultset;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import javax.swing.JOptionPane;
import miniboutikstgdgdp.entitys.connexionBD.MaConnexionBD;
import miniboutikstgdgdp.entitys.modeleOperationBD.ModeleOperationBD;

/**
 *
 * @author HP ELITEBOOK
 */
public class Produits extends ModeleOperationBD<Produits> {

    //
    private long idProduit;
    private String nomProduit;
    private String codeProduit;
    private String categorieProduitss;
    private double prixProdduit;
    private int qteStockProduit;
    private int derniereQteVendueProd;
    private Date dataVenteProduit;
    private String fabricantProduit;
    private String fournisseurProduit;
    //

    public Produits() {
    }
    //

    public Produits(long idProduit, String nomProduit, String codeProduit, String categorieProduitss, double prixProdduit, int qteStockProduit, int derniereQteVendueProd, Date dataVenteProduit, String fabricantProduit, String fournisseurProduit) {
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.codeProduit = codeProduit;
        this.categorieProduitss = categorieProduitss;
        this.prixProdduit = prixProdduit;
        this.qteStockProduit = qteStockProduit;
        this.derniereQteVendueProd = derniereQteVendueProd;
        this.dataVenteProduit = dataVenteProduit;
        this.fabricantProduit = fabricantProduit;
        this.fournisseurProduit = fournisseurProduit;
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

    public int getDerniereQteVendueProd() {
        return derniereQteVendueProd;
    }

    public void setDerniereQteVendueProd(int derniereQteVendueProd) {
        this.derniereQteVendueProd = derniereQteVendueProd;
    }

    public Date getDataVenteProduit() {
        return dataVenteProduit;
    }

    public void setDataVenteProduit(Date dataVenteProduit) {
        this.dataVenteProduit = dataVenteProduit;
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

    //
    @Override
    public String toString() {
        return getNomProduit(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public Produits insererUneLigne(Produits ObjIns) {
        Produits prodO = null;
        try {
            prodO = new Produits();
            String requete = "INSERT INTO produit (idProduit,nomProduit,codeProduit,categorieProduits,prixProdduit,qteStockProduit,fabricantProduit,fournisseurProduit) VALUES "
                    + "('" + ObjIns.idProduit + "','" + ObjIns.nomProduit + "','" + ObjIns.codeProduit + "','" + ObjIns.categorieProduitss + "','" + ObjIns.prixProdduit + "','" + ObjIns.qteStockProduit + "','" + ObjIns.fabricantProduit + "','" + ObjIns.fournisseurProduit + "')";
            MaConnexionBD con = new MaConnexionBD();
            con.ouvrirConnexion();
            int testReq = con.ExecuteurdeRequeteUpdate(requete);
            con.fermetureConnexion();
            if (testReq > 0) {
                prodO.trouverUn(ObjIns.idProduit);
            } else {
                prodO = null;
            }
            con.fermetureConnexion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur dans Produit:::insererUneLigne" + e.getMessage());
        }
        return prodO;
    }

    @Override
    public Produits modifierUneLigne(Produits ObjMod, Object cleO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Produits supprimerUneLigne(Object cleO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Produits trouverUn(Object cleO) {
        Produits prodO = new Produits();
        try {
            String requete = "SELECT idProduit,nomProduit, codeProduit, categorieProduits, prixProdduit, qteStockProduit, derniereQteVendueProd, dataVenteProduit,  "
                    + "fabricantProduit, fournisseurProduit FROM produit WHERE idProduit = " + cleO;
            MaConnexionBD kon = new MaConnexionBD();
            kon.ouvrirConnexion();
            ResultSet resultSet = kon.ExecuteurdeRequeteSelect(requete);
            boolean testSelect = false;
            while (resultSet.next()) {
                testSelect = true;
                prodO.setIdProduit(resultSet.getLong("idProduit"));
                prodO.setNomProduit(resultSet.getString("nomProduit"));
                prodO.setCodeProduit(resultSet.getString("codeProduit"));
                prodO.setCategorieProduitss(resultSet.getString("categorieProduits"));
                prodO.setPrixProdduit(resultSet.getDouble("prixProdduit"));
                prodO.setQteStockProduit(resultSet.getInt("qteStockProduit"));
                prodO.setDerniereQteVendueProd(resultSet.getInt("derniereQteVendueProd"));
                prodO.setDataVenteProduit(resultSet.getDate("dataVenteProduit"));
                prodO.setFabricantProduit(resultSet.getString("fabricantProduit"));
                prodO.setFournisseurProduit(resultSet.getString("fournisseurProduit"));
            }
            resultSet.close();
            kon.fermetureConnexion();
            if (testSelect == false) {
                prodO = null;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur dans Produit::trouverUn" + e.getMessage());
        }
        return prodO;
    }

    @Override
    public List<Produits> trouverTout() {
        List<Produits> prodList = new ArrayList<>();
        try {
            String requete = "SELECT idProduit, nomProduit, codeProduit, categorieProduits, prixProdduit, qteStockProduit,fabricantProduit  FROM produit";
            MaConnexionBD kon = new MaConnexionBD();
            kon.ouvrirConnexion();
            ResultSet rs = kon.ExecuteurdeRequeteSelect(requete);
            //
            while (rs.next()) {
                Produits prodO = new Produits();
                //
                prodO.setIdProduit(rs.getLong("idProduit"));
                prodO.setNomProduit(rs.getString("nomProduit"));
                prodO.setCodeProduit(rs.getString("codeProduit"));
                prodO.setCategorieProduitss(rs.getString("categorieProduits"));
                prodO.setPrixProdduit(rs.getDouble("prixProdduit"));
                prodO.setQteStockProduit(rs.getInt("qteStockProduit"));
                prodO.setFabricantProduit(rs.getString("fabricantProduit"));

                //
                prodList.add(prodO);
                //

            }
            rs.close();
            kon.fermetureConnexion();
        } catch (Exception e) {
            System.out.println("Erreur dans:::trouverTout  \n\n  " + e.getMessage());
        }
        return prodList;
    }

    public String getCategorieProduitss() {
        return categorieProduitss;
    }

    public void setCategorieProduitss(String categorieProduitss) {
        this.categorieProduitss = categorieProduitss;
    }

}
