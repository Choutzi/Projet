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
import projet.exceptions.poserCongeException;

/**
 *
 * @author Choutzi
 */
public class Personnel {

    private String nom;
    private String prenom;
    private Date entree;
    private int identifiant;
    private ArrayList<Competence> competences = new ArrayList<Competence>();
    private ArrayList<Conge> conges = new ArrayList<Conge>();
    private ArrayList<Mission> missions = new ArrayList<Mission>();
    
    public ArrayList<Conge> getConges() {
        return conges;
    }
    
    public Personnel(String[] personnel) throws ParseException {
        this.nom = personnel[0];
        this.prenom = personnel[1];
        this.entree = new SimpleDateFormat("dd/MM/yyyy").parse(personnel[2]);
        this.identifiant = Integer.parseInt(personnel[3]);
    }

    public void addCompetence(ArrayList<String[]> comp, Entreprise e) {
        for (String[] id : comp) {
            if (this.identifiant == Integer.parseInt(id[0])) {
                for (String cp : id) {
                    if (e.existCompetence(cp) != null) {
                        this.competences.add(e.existCompetence(cp));
                    }
                }
            }
        }
    }

    public boolean existPersonnel(String s) {
        return this.identifiant == Integer.parseInt(s);
    }

    @Override
    public String toString() {
        return this.nom + ";" + this.prenom + ";" + (new SimpleDateFormat("dd/MM/yyyy").format(this.entree)) + ";" + this.identifiant + ";" + this.competences;
    }

    public void poserConge (Conge unConge) throws poserCongeException {
        for(Conge co : this.conges){
            //date début congé
            Date ddc = co.getDateDeb();
            //date fin congé
            Date dfc = co.getFin();
            //date début congé posé
            Date dduc = unConge.getDateDeb();
            //date fin congé posé
            Date dfuc = unConge.getFin();

            //si la date de début et de fin de chaque congé sont inférieurs à la date de début du congé posé OU si la date de début de chaque congé et la date de fin de chaque congé sont supérieurs à la date de fin du congé posé
            if ((ddc.before(dduc) && dfc.before(dfuc)) || (ddc.after(dduc) && dfc.after(dfuc))) {
                this.conges.add(unConge);
            }else{
                throw new poserCongeException();
            }
        }
        
    }
    
    public void ajouterMission(Mission uneMission){
        this.missions.add(uneMission);
    }
}
