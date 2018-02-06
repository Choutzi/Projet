/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author efgde
 */
public class Conge {

    private Date dateDeb;
    private int duree;

    public Conge(Date dateDeb, int duree) {
        this.dateDeb = dateDeb;
        this.duree = duree;
    }

    public Date getDateDeb() {
        return dateDeb;
    }

    public int getDuree() {
        return duree;
    }
    
    public Date getFin(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.dateDeb);
        cal.add(Calendar.DATE, this.duree);
        return cal.getTime();
    }
}
