/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.util.ArrayList;

/**
 *
 * @author Choutzi
 */
public class Entreprise {
    
    private ArrayList<Personnel> ListePersonnel=new ArrayList<Personnel>();
    private ArrayList<Mission> ListeMission=new ArrayList<Mission>();
    private ArrayList<Competence> ListeCompetence=new ArrayList<Competence>();
    
   public void addCompetence(ArrayList<String[]> comp){
       for(int i=0; i<comp.size();i++){
           this.ListeCompetence.add(new Competence(comp.get(i)));
       }
    }
   
   public void addMission(ArrayList<String[]> mission){
       for(int i=0; i<mission.size();i++){
           this.ListeMission.add(new Mission(mission.get(i)));
       }
    }
   
   public void addPersonnel(ArrayList<String[]> personnel){
       for(int i=0; i<personnel.size();i++){
           this.ListePersonnel.add(new Personnel(personnel.get(i)));
       }
    }
    
    @Override
    public String toString(){
        String ec="";
        for(int i=0; i<this.ListeCompetence.size();i++){
            ec=ec+this.ListeCompetence.get(i).toString()+"\n";
        }
        return ec;
    }    
}
