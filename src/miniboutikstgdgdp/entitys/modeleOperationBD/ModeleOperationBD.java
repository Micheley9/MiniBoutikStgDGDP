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

    //
    public abstract T insererUneLigne(T ObjIns);
    //
    public abstract List<T> insererPlusieursLignes(List<T> ObjIns);
    //
    public abstract T modifierUneLigne(T ObjIns, Object cleO);
    //
    public abstract T supprimerUneLigne(Object cleO);
    //
    public abstract List<T> supprimerPlusieursLignes(List<Object> ObjList);
    //
    public abstract T trouverUn(Object cleO);
    //
    public abstract List<T> trouverTout();
    //
    public abstract List<T> trouverPlusieus(Object ObjTrv);
}
