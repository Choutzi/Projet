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
public interface Manager {
    /**
     * Méthode permettant de renvoyer les données lu dans un fichier à un répertoire donné sous la forme de arraylist<String[]>
     * @param Dir
     * @return ArrayList<String[]>
     */
    public ArrayList<String[]> lecture(String Dir);
    
    /**
     * Permet d'écrire des données sous la fomre de StringBuilder à un répertoire donné
     * @param Dir
     * @param builder 
     */
    public void ecrire(String Dir, StringBuilder builder);
}
