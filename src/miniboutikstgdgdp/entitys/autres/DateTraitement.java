/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniboutikstgdgdp.entitys.autres;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author HP ELITEBOOK
 */
public class DateTraitement {
    public static String dateToStringDdMmYyyy(Date  dt) {
        String dateString = "0000-00-00";
        //
        DateFormat dfm = new  SimpleDateFormat("yyyy-MM-dd");
        dateString = dfm.format(dt);
        //
        return  dateString;
        
    }
}
