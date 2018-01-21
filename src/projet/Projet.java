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
public class Projet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        
        int j=0;
        CSVmanager cs=new CSVmanager();
        /*
        ArrayList<String[]> listeParametres=cs.lecture((System.getProperty("user.dir") + "\\listes\\liste_competences.csv"));
        for(int i=0; i<listeParametres.size();i++){
            while(j<listeParametres.get(i).length){
                System.out.print(listeParametres.get(i)[j]+" ");
                j++;
            }
            j=0;
            System.out.println();
        }
        cs.sauvegarde(listeParametres);
        System.out.println("Hello word");
        
        frmStart frm = new frmStart();
        frm.setVisible(true); 
        ArrayList<String[]> listeComp=cs.lecture((System.getProperty("user.dir") + "\\listes\\liste_competences.csv"));
        Entreprise ent=new Entreprise();
        ent.addCompetence(listeComp);
        System.out.println(ent.toString());
        
        ArrayList<String[]> listeMission=cs.lecture((System.getProperty("user.dir") + "\\listes\\liste_missions.csv"));
        ent.addMission(listeMission);
        System.out.println(ent.toString());
        
        ArrayList<String[]> listePersonnel=cs.lecture((System.getProperty("user.dir") + "\\listes\\liste_personnel.csv"));
        ent.addPersonnel(listePersonnel);
        
        ArrayList<String[]> listeCompPer=cs.lecture((System.getProperty("user.dir") + "\\listes\\competences_personnel.csv"));
        // ajouter les compétences a chaque personnel !!
        for (Personnel per : ent.getPersonnel()){
            per.addCompetence(listeCompPer, ent);
            System.out.println(per.toString());
        }
        
        ArrayList<String[]> listePerMiss=cs.lecture((System.getProperty("user.dir") + "\\listes\\personnel_mission.csv"));
        for (Mission mis : ent.getMission()){
            mis.addPersonnel(listePerMiss, ent);
            System.out.println(mis.toString());
        }*/
        Entreprise e=new Entreprise();
        e.initEntrprise();
        System.out.println(e.toString());
        
        
    }
    
}
