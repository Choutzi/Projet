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
import java.util.Iterator;
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
    
    public int getId() {
        return this.identifiant;
    }

    /**
     * Constructeur Personnel avec des donnée de type String
     * @param personnel
     * @throws ParseException 
     */
    public Personnel(String[] personnel) throws ParseException {
        this.nom = personnel[0];
        this.prenom = personnel[1];
        this.entree = new SimpleDateFormat("dd/MM/yyyy").parse(personnel[2]);
        this.identifiant = Integer.parseInt(personnel[3]);
    }

    /**
     * Ajout des compétences associer à la personne suivant l'id
     * @param comp
     * @param e 
     */
    public void addCompetence(ArrayList<String[]> comp, Entreprise e) {
        //on parcours la liste des compétences de chaque personne provenant du Fichier base de données pour chaque personne
        for (String[] id : comp) {
            //si l'indentifiant de la personne à l'identifiant de la ligne
            if (this.identifiant == Integer.parseInt(id[0])) {
                //pour chaque compétences compétence dans cette ligne
                for (String cp : id) {
                    //si la compétence existe dans la liste des compétences de l'entreprise
                    if (e.existCompetence(cp) != null) {
                        //on récupère l'objet compétence grace à l'ID contenu dans la ligne
                        this.competences.add(e.existCompetence(cp));
                    }
                }
            }
        }
    }

    /**
     * Méthode permettant d'obtenir un personnel existant avec son ID
     * @param s
     * @return personnel
     */
    public boolean existPersonnel(String s) {
        return this.identifiant == Integer.parseInt(s);
    }
    
    @Override
    public String toString() {
        return this.nom + ";" + this.prenom + ";" + (new SimpleDateFormat("dd/MM/yyyy").format(this.entree)) + ";" + this.identifiant;
    }

    /**
     * Méthode permettant de savoir si une personne a la compétence passée en paramètre
     * @param c
     * @return boolean
     */
    public boolean avoirComp(Competence c) {
        for (Competence comp : this.competences) {
            if (comp.getIdentifiant().equals(c.getIdentifiant())) {
                return true;
            }
        }
        return false;
    }
    
    /*
    Permet d'affecter un Congé à une personne, renvoie une exception si le congé empiète sur un autre
    */

    /**
     * A faire !!
     * @param unConge
     * @throws poserCongeException 
     */
    public void poserConge(Conge unConge) throws poserCongeException {
        if (this.conges.size() > 0) {
            System.out.println(this.conges.size());
            for (Conge co : this.conges) {
                //date début congé
                Date ddc = co.getDateDeb();
                //date fin congé
                Date dfc = co.getFin();
                //date début congé posé
                Date dduc = unConge.getDateDeb();
                //date fin congé posé
                Date dfuc = unConge.getFin();
                
                System.out.println(co.toString());
                //si la date de début et de fin de chaque congé sont inférieurs à la date de début du congé posé OU si la date de début de chaque congé et la date de fin de chaque congé sont supérieurs à la date de fin du congé posé
                if (dduc.after(ddc) && dduc.before(dfc)) {
                    throw new poserCongeException("Le congé est posé pendant un congé existant !");
                }
                if (dfuc.after(ddc) && dfuc.before(dfc)) {
                    throw new poserCongeException("Le congé est posé pendant un congé existant !");
                }
                if(dduc.before(ddc) && dfuc.after(dfc)) {
                    throw new poserCongeException("Le congé est posé pendant un congé existant !");
                }
                
            }
            this.conges.add(unConge);
        } else {
            this.conges.add(unConge);
        }
        
    }

    /**
     * A faire
     * @param c
     * @throws ParseException 
     */
    public void initConge(ArrayList<String[]> c) throws ParseException {
        if (!c.isEmpty()) {
            for (String[] ligne : c) {
                if (this.identifiant == Integer.parseInt(ligne[0])) {
                    for (int i = 1; i < ligne.length; i = i + 2) {
                        this.conges.add(new Conge(new SimpleDateFormat("dd/MM/yyyy").parse(ligne[i]), Integer.parseInt(ligne[i + 1])));
                    }
                }
            }
        }
    }
    
    public ArrayList<Competence> getCompetence() {
        return this.competences;
    }
    
    public void ajouterMission(Mission uneMission) {
        this.missions.add(uneMission);
    }
}
