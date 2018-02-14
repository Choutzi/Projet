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

    public Mission(String nom, String descriptif, Date dateDeb, int duree) {
        this.nom = nom;
        this.descriptif = descriptif;
        this.dateDeb = dateDeb;
        this.duree = duree;
    }
    private int duree;
    private ArrayList<Personnel> equipe = new ArrayList<Personnel>();

    private enum statut {
        Preparation, Planifiee, EnCours
    };
    private String stat;
    private int taille;

    public Mission(String[] mission) throws ParseException {
        this.nom = mission[0];
        this.descriptif = mission[1];
        this.dateDeb = new SimpleDateFormat("dd/MM/yyyy").parse(mission[2]);
        this.duree = Integer.parseInt(mission[3]);
        this.stat = mission[4];
        this.taille = Integer.parseInt(mission[5]);
    }

    public int getTaille() {
        return this.taille;
    }

    // Initialisation des missions et de leur personnel à partir du fichier csv mission_personnel(idMission : idPers)
    public void addPersonnel(ArrayList<String[]> liste, Entreprise ent) {
        if (this.taille > this.equipe.size()) {
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

    @Override
    public String toString() {
        return this.nom + ";" + this.descriptif + ";" + (new SimpleDateFormat("dd/MM/yyyy").format(this.dateDeb)) + ";" + this.duree + ";" + this.stat + ";" + this.equipe;
    }

    public Date getFin() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.dateDeb);
        cal.add(Calendar.DATE, this.duree);
        return cal.getTime();
    }

    public void affecterPers(Personnel unePersonne) throws affecterPersException {
        //si pour chaque congé de la personne
        for (Conge unConge : unePersonne.getConges()) {
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
        }
    }
}
