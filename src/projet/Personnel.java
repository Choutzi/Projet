/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Choutzi
 */
public class Personnel {
    private String nom;
    private String prenom;
    private Date entree;
    private int identifiant;
    private ArrayList<Competence> competences=new ArrayList<Competence>();
    
    public Personnel(String[] personnel) throws ParseException{
        this.nom=personnel[0];
        this.prenom=personnel[1];
        this.entree=new SimpleDateFormat("dd/MM/yyyy").parse(personnel[2]);;
        this.identifiant=Integer.parseInt(personnel[3]);
    }
    
    public void addCompetence(String s, Entreprise e){
        
        if(e.existCompetence(s)!=null)
            this.competences.add(e.existCompetence(s));
    }
}
