/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniboutikstgdgdp.entitys.modeleOperationBD;

import java.util.List;

/**
 *
 * @author HP ELITEBOOK
 */
public abstract class ModeleOperationBD<T> {
    //INSERER UNE LIGNE
    public abstract T insererUneLigne(T ObjIns);
    //MODIFIER 
    public abstract T modifierUneLigne(T ObjMod,Object cleO);
    //SUPPRESSION
    public abstract T  supprimerUneLigne(Object cleO);
    //RECHERCHER
    public abstract  T trouverUn(Object cleO);
    //Trouver Tout sans Cle
    public  abstract List<T> trouverTout();
    
}
