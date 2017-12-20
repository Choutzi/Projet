/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.util.ArrayList;

/**
 *
 * @author Choutzi
 */
public class Projet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int j=0;
        CSVmanager cs=new CSVmanager();
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
        
    }
    
}
