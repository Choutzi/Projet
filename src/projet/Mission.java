/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
    private int taille;
    
    public Mission(String[] mission) throws ParseException{
        this.nom=mission[0];
        this.descriptif=mission[1];
        this.dateDeb=new SimpleDateFormat("dd/MM/yyyy").parse(mission[2]);
        this.duree=Integer.parseInt(mission[3]);
        this.stat=mission[4];
        this.taille=Integer.parseInt(mission[5]);
    }
    
    public int getTaille(){return this.taille;}
    
    public void addPersonnel(ArrayList<String[]> liste, Entreprise ent){
        if(this.taille>this.equipe.size()){
            for (String[] Misseq : liste){
                if(this.nom.equals(Misseq[0])){
                    for(int i=1; i<Misseq.length;i++){
                        if(ent.existPersonnel(Misseq[i])!=null)
                            this.equipe.add(ent.existPersonnel(Misseq[i]));
                    }
                }
            }
        }else
            System.out.println("Equipe au complet");
    }
    
    @Override
    public String toString(){
        return this.nom+";"+this.descriptif+";"+(new SimpleDateFormat("dd/MM/yyyy").format(this.dateDeb))+";"+this.duree+";"+this.stat+";"+this.equipe;
    }
}
