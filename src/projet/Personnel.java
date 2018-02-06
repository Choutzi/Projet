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

    public void poserConge(Conge unConge) {
        this.conges.add(unConge);
    }
    
    public void ajouterMission(Mission uneMission){
        this.missions.add(uneMission);
    }
}
