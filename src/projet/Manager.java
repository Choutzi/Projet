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
    public ArrayList<String[]> lecture(String Dir);
    public void sauvegarde(ArrayList<String[]> o);
}
