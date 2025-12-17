/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniboutikstgdgdp.entitys;

import java.util.Date;
import javax.swing.*;
import miniboutikstgdgdp.entitys.connexionBD.MaConnexionBD;
import miniboutikstgdgdp.entitys.modeleOperationBD.ModeleOperationBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import miniboutikstgdgdp.entitys.autres.DateTraitement;

/**
 *
 * @author HP ELITEBOOK
 */
public class Approvisionnement extends ModeleOperationBD<Approvisionnement> {

    private long idApprov;
    private Date dateAppov;
    private int qteApprov;
    private double prixAchatApprov;
    private Produit idProdApprov;
    //

    public Approvisionnement() {
    }

    public Approvisionnement(long idApprov, Date dateAppov, int qteApprov, double prixAchatApprov, Produit idProdApprov) {
        this.idApprov = idApprov;
        this.dateAppov = dateAppov;
        this.qteApprov = qteApprov;
        this.prixAchatApprov = prixAchatApprov;
        this.idProdApprov = idProdApprov;
    }
    //

    public long getIdApprov() {
        return idApprov;
    }

    public void setIdApprov(long idApprov) {
        this.idApprov = idApprov;
    }

    public Date getDateAppov() {
        return dateAppov;
    }

    public void setDateAppov(Date dateAppov) {
        this.dateAppov = dateAppov;
    }

    public int getQteApprov() {
        return qteApprov;
    }

    public void setQteApprov(int qteApprov) {
        this.qteApprov = qteApprov;
    }

    public double getPrixAchatApprov() {
        return prixAchatApprov;
    }

    public void setPrixAchatApprov(double prixAchatApprov) {
        this.prixAchatApprov = prixAchatApprov;
    }

    public Produit getIdProdApprov() {
        return idProdApprov;
    }

    public void setIdProdApprov(Produit idProdApprov) {
        this.idProdApprov = idProdApprov;
    }
    //

    @Override
    public Approvisionnement insererUneLigne(Approvisionnement ObjIns) {
        Approvisionnement ApprovO = new Approvisionnement();
        try {
            long idProd = ObjIns.getIdProdApprov().getIdProduit();
            String dateString = DateTraitement.dateToStringDdMmYyyy(ObjIns.getDateAppov());
            
            String requete = "INSERT INTO approvionnement (idApprov, dateAppov, qteApprov, prixAchatApprov,idProdApprov) "
                    + "VALUES ('" + ObjIns.idApprov + "','" + dateString + "','" + ObjIns.getQteApprov() + "','" + ObjIns.getPrixAchatApprov() + "','" + idProd + "')";
            MaConnexionBD konx = new MaConnexionBD();
            konx.ouvrirConnexion();
            int rs = konx.ExecuteurdeRequeteUpdate(requete);
            if (rs > 0) {
                ApprovO = ApprovO.trouverUn(ObjIns.idApprov);
            } else {
                ApprovO = null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur dans Approvisionnement, insererUneLigne : \n" + e.getMessage());
        }
        return ApprovO;
    }

    @Override
    public List<Approvisionnement> insererPlusieursLignes(List<Approvisionnement> ObjIns) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Approvisionnement modifierUneLigne(Approvisionnement ObjIns, Object cleO) {

        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Approvisionnement supprimerUneLigne(Object cleO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Approvisionnement> supprimerPlusieursLignes(List<Object> ObjList) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Approvisionnement trouverUn(Object cleO) {
        Approvisionnement ApprovO = new Approvisionnement();
        try {
            String requete = "SELECT idApprov,dateAppov, qteApprov, prixAchatApprov, idProdApprov FROM  approvionnement WHERE  idApprov = " + cleO;
            MaConnexionBD konx = new MaConnexionBD();
            konx.ouvrirConnexion();
            ResultSet rs = konx.ExecuteurdeRequeteSelect(requete);
            while (rs.next()) {
                ApprovO.setIdApprov(rs.getLong("idApprov"));
                ApprovO.setDateAppov(rs.getDate("dateAppov"));
                ApprovO.setQteApprov(rs.getInt("qteApprov"));
                ApprovO.setPrixAchatApprov(rs.getDouble("prixAchatApprov"));

                long idProd = rs.getLong("idProdApprov");

                ApprovO.setIdProdApprov(new Produit().trouverUn(idProd));

            }
            konx.fermetureConnexion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur dans Approvisionnement, trouverUn : \n" + e.getMessage());
        }
        return ApprovO;
    }

    @Override
    public List<Approvisionnement> trouverTout() {
        List<Approvisionnement> approvList = new ArrayList<>();
        try {
           
                String requete = "SELECT idApprov,dateAppov, qteApprov, prixAchatApprov, idProdApprov FROM  approvionnement";
                MaConnexionBD konx = new MaConnexionBD();
                konx.ouvrirConnexion();
                ResultSet rs = konx.ExecuteurdeRequeteSelect(requete);
                while (rs.next()) {
                    Approvisionnement ApprovO = new Approvisionnement();

                    ApprovO.setIdApprov(rs.getLong("idApprov"));
                    ApprovO.setDateAppov(rs.getDate("dateAppov"));
                    ApprovO.setQteApprov(rs.getInt("qteApprov"));
                    ApprovO.setPrixAchatApprov(rs.getDouble("prixAchatApprov"));
                    long idProd = rs.getLong("idProdApprov");
                    ApprovO.setIdProdApprov(new Produit().trouverUn(idProd));
                    
                    approvList.add(ApprovO);

                }
                konx.fermetureConnexion();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erreur dans Approvisionnement, trouverTout : \n" + e.getMessage());
            }
            return approvList;
        }

        @Override
        public List<Approvisionnement> trouverPlusieus
        (Object ObjTrv
        
            ) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

    }
