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

    private static ArrayList<Personnel> ListePersonnel = new ArrayList<Personnel>();
    private static ArrayList<Mission> ListeMission = new ArrayList<Mission>();
    private static ArrayList<Competence> ListeCompetence = new ArrayList<Competence>();

    /**
     * Méthode pour ajouter une compétence à la liste de compétence de l'entreprise
     * @param comp 
     */
    public void addCompetence(ArrayList<String[]> comp) {
        for (int i = 0; i < comp.size(); i++) {
            Entreprise.ListeCompetence.add(new Competence(comp.get(i)));
        }
    }

    /**
     * Méthode pour ajouter des missions à partir d'une arraylist à la liste de mission de l'entreprise 
     * @param mission
     * @throws ParseException 
     */
    public void addMission(ArrayList<String[]> mission) throws ParseException {
        for (int i = 0; i < (mission.size()); i++) {
            Entreprise.ListeMission.add(new Mission(mission.get(i)));
        }
    }

    /**
     * Méthode pour ajouter le personnel à la liste de personnel de l'entreprise
     * @param personnel
     * @throws ParseException 
     */
    public void addPersonnel(ArrayList<String[]> personnel) throws ParseException {
        for (int i = 0; i < personnel.size(); i++) {
            Entreprise.ListePersonnel.add(new Personnel(personnel.get(i)));
        }
    }

    /**
     * Méthode permettant de vérifier si une copétence (son Id) existe bien dans la liste de l'entreprise et de la renvoyer
     * @param s
     * @return compétence
     */
    public Competence existCompetence(String s) {
        for (Competence comp : Entreprise.ListeCompetence) {
            if (comp.getIdentifiant().equals(s)) {
                return comp;
            }
        }
        return null;
    }

    /**
     * Permet de vérifier suivant un identifiant donné si la personne ayant cet identifant existe dans la liste de l'entreprise et la renvoie.
     * @param s
     * @return personnel 
     */
    public Personnel existPersonnel(String s) {
        for (Personnel per : Entreprise.ListePersonnel) {
            if (per.existPersonnel(s)) {
                return per;
            }
        }
        return null;
    }

    public ArrayList<Personnel> getPersonnel() {
        return Entreprise.ListePersonnel;
    }

    public ArrayList<Mission> getMission() {
        return Entreprise.ListeMission;
    }


    public ArrayList<Competence> getCompetence() {
        return Entreprise.ListeCompetence;
    }
   

   /**
    * Méthode permettant d'initialiser l'entreprise en remplissant toutes les listes en appelant les méthode du manager de fichier.
    * @throws ParseException 
    */
   public void initEntrprise() throws ParseException{
       Manager cs=new CSVmanager();
       //liste des compétences connues dans l'entreprise
       ArrayList<String[]> listeComp=cs.lecture((System.getProperty("user.dir")+"\\listes\\liste_competences.csv"));
       //liste des missions connues dans l'entreprise
       ArrayList<String[]> listeMission=cs.lecture((System.getProperty("user.dir") + "\\listes\\liste_missions.csv"));
       //liste des personnes connues dans l'entreprise
       ArrayList<String[]> listePersonnel=cs.lecture((System.getProperty("user.dir") + "\\listes\\liste_personnel.csv"));
       //liste des ID compétence par ID personne
       ArrayList<String[]> listeCompPer=cs.lecture((System.getProperty("user.dir") + "\\listes\\competences_personnel.csv"));
       //liste des ID personne par ID Mission
       ArrayList<String[]> listePerMiss=cs.lecture((System.getProperty("user.dir") + "\\listes\\personnel_mission.csv"));
       //liste des ID compétences par ID Mission
       ArrayList<String[]> listeCompMiss=cs.lecture((System.getProperty("user.dir") + "\\listes\\competences_mission.csv"));
       //liste des congés par ID Personnel
       ArrayList<String[]> listeConge=cs.lecture((System.getProperty("user.dir") + "\\listes\\conge_personnel.csv"));
       addPersonnel(listePersonnel);
       addMission(listeMission);
       addCompetence(listeComp);
       //pour chaque personne dans l'entreprise on appel la méthode d'ajout de compétences
       for (Personnel per : Entreprise.ListePersonnel){
            per.addCompetence(listeCompPer, this);
            per.initConge(listeConge);
        }
        //pour chaque mission dans l'entreprise on appel la méthode d'ajout de compétence et de personnel
        for (Mission mis : Entreprise.ListeMission) {
            mis.ajoutCompetence(listeCompMiss, this);
            mis.addPersonnel(listePerMiss, this);
        }
    }

    @Override
    public String toString() {
        return "yo";
    }

    /**
     * cette méthode sauvegarde toutes les données présentes dans l'entreprise
     * dans les fichiers csv adéquats
     */
    public void sauvegarde() {
        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();
        StringBuilder builder3 = new StringBuilder();
        String tmp = "";
        CSVmanager cs = new CSVmanager();

        for (Personnel per : Entreprise.ListePersonnel) {
            builder1.append(per.toString() + "\n");
            tmp = Integer.toString(per.getId());
            for (Competence c : per.getCompetence()) {
                tmp = tmp + ";" + c.getIdentifiant();

            }
            builder2.append(tmp + "\n");
            tmp = Integer.toString(per.getId());
            if (!per.getConges().isEmpty()) {
                for (Conge c : per.getConges()) {
                    tmp = tmp + ";" + c.toString();
                }
                builder3.append(tmp + "\n");
            }
        }
        cs.ecrire("\\listes\\liste_personnel.csv", builder1);
        cs.ecrire("\\listes\\competences_personnel.csv", builder2);
        cs.ecrire("\\listes\\conge_personnel.csv", builder3);

        builder1 = new StringBuilder();
        builder2 = new StringBuilder();
        builder3 = new StringBuilder();

        for (Competence c : Entreprise.ListeCompetence) {
            builder1.append(c.toString() + "\n");
        }
        cs.ecrire("\\listes\\liste_competences.csv", builder1);
        builder1 = new StringBuilder();

        for (Mission m : Entreprise.ListeMission) {
            builder1.append(m.toString()+"\n");
            tmp = m.getNom();
            if (!m.getCompetences().isEmpty()) {
                for (Competence c : m.getCompetences()) {
                    tmp = tmp + ";" + c.getIdentifiant();
                }
                builder2.append(tmp + "\n");
                tmp = m.getNom();
            }
            if (!m.getPersonnels().isEmpty()) {
                for (Personnel p : m.getPersonnels()) {
                    tmp = tmp + ";" + p.getId();
                    System.out.println(p.getId());
                }
                builder3.append(tmp + "\n");
            }
        }
        cs.ecrire("\\listes\\liste_missions.csv", builder1);
        cs.ecrire("\\listes\\competences_mission.csv", builder2);
        cs.ecrire("\\listes\\personnel_mission.csv", builder3);
    }
}
