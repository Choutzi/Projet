/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author Choutzi
 */
public class Entreprise {
    
    private static ArrayList<Personnel> ListePersonnel=new ArrayList<Personnel>();
    private static ArrayList<Mission> ListeMission=new ArrayList<Mission>();
    private static ArrayList<Competence> ListeCompetence=new ArrayList<Competence>();
    
   public void addCompetence(ArrayList<String[]> comp){
       for(int i=0; i<comp.size();i++){
           Entreprise.ListeCompetence.add(new Competence(comp.get(i)));
       }
    }
   
   public void addMission(ArrayList<String[]> mission) throws ParseException{
       for(int i=0; i<(mission.size());i++){
           Entreprise.ListeMission.add(new Mission(mission.get(i)));
       }
    }
   
   public void addPersonnel(ArrayList<String[]> personnel) throws ParseException{
       for(int i=0; i<personnel.size();i++){
           Entreprise.ListePersonnel.add(new Personnel(personnel.get(i)));
       }
    }
   
   public Competence existCompetence(String s){
       for(Competence comp : Entreprise.ListeCompetence){
           if(comp.getIdentifiant().equals(s))
               return comp;
       }
       return null;
   }
   
   public Personnel existPersonnel(String s){
       for(Personnel per : Entreprise.ListePersonnel){
           if(per.existPersonnel(s))
               return per;
       }
       return null;
   }
   
   public ArrayList<Personnel> getPersonnel(){
       return Entreprise.ListePersonnel;
   }
   
   public ArrayList<Mission> getMission(){
       return Entreprise.ListeMission;
   }
   
   public ArrayList<Competence> getCompetence(){
       return Entreprise.ListeCompetence;
   }
   
   public void initEntrprise() throws ParseException{
       CSVmanager cs=new CSVmanager();
       ArrayList<String[]> listeComp=cs.lecture((System.getProperty("user.dir") + "\\listes\\liste_competences.csv"));
       ArrayList<String[]> listeMission=cs.lecture((System.getProperty("user.dir") + "\\listes\\liste_missions.csv"));
       ArrayList<String[]> listePersonnel=cs.lecture((System.getProperty("user.dir") + "\\listes\\liste_personnel.csv"));
       ArrayList<String[]> listeCompPer=cs.lecture((System.getProperty("user.dir") + "\\listes\\competences_personnel.csv"));
       ArrayList<String[]> listePerMiss=cs.lecture((System.getProperty("user.dir") + "\\listes\\personnel_mission.csv"));
       addPersonnel(listePersonnel);
       addMission(listeMission);
       addCompetence(listeComp);
       for (Personnel per : Entreprise.ListePersonnel){
            per.addCompetence(listeCompPer, this);
        }
       for (Mission mis : Entreprise.ListeMission){
            mis.addPersonnel(listePerMiss, this);
        }
   }
              
    @Override
    public String toString(){
        String ec="";
        /*for(int i=0; i<this.ListeCompetence.size();i++){
            ec=ec+this.ListeCompetence.get(i).toString()+"\n";
        }
        return ec;*/
        for(int i=0; i<Entreprise.ListeMission.size();i++){
            ec=ec+Entreprise.ListeMission.get(i).toString()+"\n";
        }
        return ec;
    }    
}
