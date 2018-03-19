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
import projet.exceptions.affecterPersException;
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

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEntree(Date entree) {
        this.entree = entree;
    }

    public void setCompetences(ArrayList<Competence> competences) {
        this.competences = competences;
    }

    public void setConges(ArrayList<Conge> conges) {
        this.conges = conges;
    }

    public void setMissions(ArrayList<Mission> missions) {
        this.missions = missions;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getEntree() {
        return entree;
    }

    public int getIdentifiant() {
        return identifiant;
    }

    public ArrayList<Competence> getCompetences() {
        return competences;
    }

    public ArrayList<Mission> getMissions() {
        return missions;
    }
    private ArrayList<Competence> competences = new ArrayList<Competence>();
    private ArrayList<Conge> conges = new ArrayList<Conge>();
    private ArrayList<Mission> missions = new ArrayList<Mission>();

    public ArrayList<Conge> getConges() {
        return conges;
    }

    /**
     * permet de retrouver un congé à partir d'une chaine
     *
     * @param mission
     * @return
     */
    public Conge getConge(Object conge) {
        Conge leC;
        for (Conge c : this.conges) {
            if (c.toString().equals(conge)) {
                leC = c;
                return leC;
            }
        }
        return null;

    }

    /**
     * permet de retrouver une mission à partir d'une chaine
     *
     * @param mission
     * @return
     */
    public Mission getMission(Object mission) {
        Mission laM;
        for (Mission m : this.missions) {
            if (m.toString().equals(mission)) {
                laM = m;
                return laM;
            }
        }
        return null;

    }

    public void removeConge(Conge unConge) {
        this.conges.remove(unConge);
    }

    public void removeMission(Mission uneMission) {
        this.missions.remove(uneMission);
    }

    public int getId() {
        return this.identifiant;
    }

    /**
     * Constructeur Personnel avec des donnée de type String
     *
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
     *
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
     * ajouter une compétence à la liste de compétences de la personne
     *
     * @param uneCompetence
     */
    public void addComp(Competence uneCompetence) {
        this.competences.add(uneCompetence);
    }

    /**
     * On enlève la compétence de la liste des compétences
     * @param comp
     */
    public void removeComp(Competence comp, Entreprise e) {
        this.competences.remove(comp);
        
        for (Mission m : this.missions) {
            for (Competence c : this.competences) {
                if(m.getCompetences().contains(comp)){
                    m.removePersonnel(this);
                    Mission me = e.getMission(m);
                    me.removePersonnel(this);
                    if(!m.getPersonnels().contains(this))
                        this.missions.remove(m);
                    
                }
            }
        }
    }

    /**
     * Méthode permettant d'obtenir un personnel existant avec son ID
     *
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
     * Méthode permettant de savoir si une personne a la compétence passée en
     * paramètre
     *
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

    /**
     * Ajoute un congé à une personne
     *
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
                if (dduc.before(ddc) && dfuc.after(dfc)) {
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
     *
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
    
    
    public boolean etreOccupe(Date datedeb, Date datefin){
        boolean occupe = false;
        for (Conge unConge : this.conges) {
            //date début congé
            Date ddc = unConge.getDateDeb();
            //date fin congé
            Date dfc = unConge.getFin();

            if (datedeb.after(ddc) && datefin.before(dfc)) {
                occupe = true;
            }
            if (datefin.after(ddc) && datefin.before(dfc)) {
                occupe = true;
            }
            if (datedeb.before(ddc) && datefin.after(dfc)) {
                occupe = true;
            }
        }
        return occupe;
    }

    /**
     * ajoute une mission à cette personne
     * @param uneMission
     * @throws affecterPersException 
     */
    public void ajouterMission(Mission uneMission) throws affecterPersException {

        for (Conge unConge : this.conges) {
            
            //date début congé
            Date ddc = unConge.getDateDeb();
            //date fin congé
            Date dfc = unConge.getFin();
            //date début mission
            Date ddm = uneMission.getDatedeb();
            //date fin mission
            Date dfm = uneMission.getFin();

            if (ddm.after(ddc) && dfm.before(dfc)) {
                throw new affecterPersException("Le congé est posé pendant un congé existant !");
            }
            if (dfm.after(ddc) && dfm.before(dfc)) {
                throw new affecterPersException("Le congé est posé pendant un congé existant !");
            }
            if (ddm.before(ddc) && dfm.after(dfc)) {
                throw new affecterPersException("Le congé est posé pendant un congé existant !");
            }
        }
        if (this.missions.size() > 0) {
            for (Mission m : this.missions) {

                Date ddc = m.getDatedeb();

                Date dfc = m.getFin();

                Date dduc = uneMission.getDatedeb();

                Date dfuc = uneMission.getFin();

                if (dduc.after(ddc) && dduc.before(dfc)) {
                    throw new affecterPersException("La mission est posé pendant une mission existant !");
                }
                if (dfuc.after(ddc) && dfuc.before(dfc)) {
                    throw new affecterPersException("La mission est posé pendant une mission existant !");
                }
                if (dduc.before(ddc) && dfuc.after(dfc)) {
                    throw new affecterPersException("La mission est posé pendant une mission existant !");
                }

            }
            this.missions.add(uneMission);
        } else {
            this.missions.add(uneMission);
        }

    }
    
    
}
