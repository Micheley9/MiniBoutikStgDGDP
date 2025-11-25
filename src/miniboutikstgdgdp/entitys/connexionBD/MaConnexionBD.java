/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniboutikstgdgdp.entitys.connexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author HP ELITEBOOK
 */
public class MaConnexionBD {
     private final String url = "jdbc:mysql://localhost:3306/monotableminiboutik";
    private final String user = "root";
    private final String pwd = "";
    //
    private Connection konexi = null;

    //
    public MaConnexionBD() {
    }

    //
    public void ouvrirConnexion() {
        try {
            this.konexi = DriverManager.getConnection(this.url, this.user, this.pwd);
            System.out.println("connexion reussie !!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erreur lors de la connexion " + e.getMessage());
        }
    }

    public ResultSet ExecuteurdeRequeteSelect(String requete) {
        ResultSet rs = null;
        try {
            if (requete.toLowerCase().startsWith("select")) {
                Statement executReq = this.konexi.createStatement();
                rs = executReq.executeQuery(requete);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erreur" + e.getMessage());
        }
        return rs;
    }

    public int ExecuteurdeRequeteUpdate(String requete) {
        int rs = 0;
        try {
            if (!requete.toLowerCase().startsWith("select")) {
                Statement executReq = this.konexi.createStatement();
                rs = executReq.executeUpdate(requete);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erreur" + e.getMessage());
        }
        return rs;
    }
      public void fermetureConnexion() {
        try {
           this.konexi.close();
            System.out.println("connexion fermée !!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erreur lors de la fermeture " + e.getMessage());
        }
    }

    
}
