/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import projet.exceptions.affecterPersException;

/**
 *
 * @author Choutzi
 */
public class Mission {

    private String nom;
    private String descriptif;
    private Date dateDeb;
    private int duree;
    private ArrayList<Personnel> equipe = new ArrayList<>();
    private ArrayList<Competence> competences = new ArrayList<>();

    private enum statut {
        Preparation, Planifiee, EnCours, Terminee
    };
    private String stat;

    /**
     * Création d'une mission ainsi que l'ajout de compétence requise
     * @param nom
     * @param descriptif
     * @param dateDeb
     * @param duree
     * @param c
     * @param e 
     */
    public Mission(String nom, String descriptif, Date dateDeb, int duree, ArrayList<String[]> c, Entreprise e) {
        this.nom = nom;
        this.descriptif = descriptif;
        this.dateDeb = dateDeb;
        this.duree = duree;
        for (String[] ligne : c) {
            if (e.existCompetence(ligne[0].substring(1)) != null) {
                this.competences.add(e.existCompetence(ligne[0].substring(1)));
            }
        }
        this.stat = "Preparation";
    }

    /**
     * Création d'une mission avec des données de type String
     * @param mission
     * @throws ParseException 
     */
    public Mission(String[] mission) throws ParseException {
        this.nom = mission[0];
        this.descriptif = mission[1];
        this.dateDeb = new SimpleDateFormat("dd/MM/yyyy").parse(mission[2]);
        this.duree = Integer.parseInt(mission[3]);
        this.stat = mission[4];
    }

    /**
     * Permet d'obtenir le nombre de compétence requise pour la mission
     * @return int
     */
    public int getTaille() {
        return this.competences.size();
    }

    public String getNom() {
        return this.nom;
    }

    public ArrayList<Competence> getCompetences() {
        return this.competences;
    }

    public ArrayList<Personnel> getPersonnels() {
        return this.equipe;
    }

    /**
     * 
     * Initialisation des missions et de leur personnel à partir du fichier csv mission_personnel(idMission : idPers)
    */
    public void addPersonnel(ArrayList<String[]> liste, Entreprise ent) {
        if (this.getTaille() > this.equipe.size()) {
            for (String[] Misseq : liste) {
                if (this.nom.equals(Misseq[0])) {
                    for (int i = 1; i < Misseq.length; i++) {
                        if (ent.existPersonnel(Misseq[i]) != null) {
                            this.equipe.add(ent.existPersonnel(Misseq[i]));
                        }
                    }
                }
            }
        } else {
            System.out.println("Equipe au complet");
        }
    }

    /**
     * Si la mission n'a pas encore la compétence dans ça liste de compétence alors l'ajoute
     * @param c 
     */
    public void ajoutCompetence(Competence c) {
        if (!this.competences.contains(c)) {
            this.competences.add(c);
        }
    }
    
    public Date getDatedeb(){return this.dateDeb;}

    /**
     * Méthode permettant à partir d'un ID d'ajouter une compétence existant dans la liste des compétences de l'entriprise dans une mission
     * @param c
     * @param e 
     */
    public void ajoutCompetence(ArrayList<String[]> c, Entreprise e) {
        for (String[] ligne : c) {
            if (this.nom.equals(ligne[0])) {
                for (int i = 1; i < ligne.length; i++) {
                    if (!this.competences.contains(e.existCompetence(ligne[i]))) {
                        this.competences.add(e.existCompetence(ligne[i]));
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return this.nom + ";" + this.descriptif + ";" + (new SimpleDateFormat("dd/MM/yyyy").format(this.dateDeb)) + ";" + this.duree + ";" + this.stat;
    }

    
    /**
     * Méthode permettant d'obtenir la date de fin d'une mission
     * @return Date
     */
    public Date getFin() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.dateDeb);
        cal.add(Calendar.DATE, this.duree);
        return cal.getTime();
    }

    /**
     * Affecter une personne à une mission
     *
     * @param unePersonne Personne à affecter
     * @throws affecterPersException Si la mission affectée déborde sur les
     * congés du Personnel
     */
    public void affecterPers(Personnel unePersonne) throws affecterPersException {
            //si pour chaque congé de la personne
           /* for (Conge unConge : unePersonne.getConges()) {
                //date début congé
                Date ddc = unConge.getDateDeb();
                //date fin congé
                Date dfc = unConge.getFin();
                //date début mission
                Date ddm = this.dateDeb;
                //date fin mission
                Date dfm = this.getFin();

                //si la date de début et de fin du congé sont inférieurs à la date de début mission OU si la date de début congé et la date de fin congé sont supérieurs à la date de fin mission
                if ((ddc.before(ddm) && dfc.before(ddm)) || (ddc.after(dfm) && dfc.after(dfm))) {
                    this.equipe.add(unePersonne);
                    unePersonne.ajouterMission(this);
                } else {
                    throw new affecterPersException();
                }
            }*/

            this.equipe.add(unePersonne);
    }
    
    public void setStat(String stat){
        this.stat=stat;
    }
}
