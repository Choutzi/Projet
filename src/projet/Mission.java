/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Choutzi
 */
public class Mission {
    
    private String nom;
    private String descriptif;
    private Date dateDeb;
    private int duree;
    private ArrayList<Personnel> equipe=new ArrayList<Personnel>();
    private enum statut{Preparation, Planifiee, EnCours};
    private String stat;
    
    public Mission(String[] mission) throws ParseException{
        this.nom=mission[0];
        this.descriptif=mission[1];
        this.dateDeb=new SimpleDateFormat("dd/MM/yyyy").parse(mission[2]);
        this.duree=Integer.parseInt(mission[3]);
        this.stat=mission[4];
    }
    
    public void addPersonnel(Personnel p){
        if(!this.equipe.contains(p))
            this.equipe.add(p);
    }
    
    @Override
    public String toString(){
        return this.nom+";"+this.descriptif+";"+(new SimpleDateFormat("dd/MM/yyyy").format(this.dateDeb))+";"+this.duree+";"+this.stat;
    }
}
