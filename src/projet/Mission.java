/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Choutzi
 */
public class Mission {
    
    private String nom;
    private String descriptif;
    private Date dateDeb;
    private int duree;
    private ArrayList<Personnel> equipe;
    private enum statut{Preparation, Planifiee, EnCours};
    
    public Mission(String[] mission){
        
    }
}
