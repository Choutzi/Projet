/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.util.ArrayList;
import javax.swing.JComboBox;
import projet.Competence;
import projet.Mission;
import projet.Personnel;

/**
 *
 * @author Choutzi
 */
public class jComboboxPersonnel extends JComboBox {

    private Mission m;
    private int row;

    public jComboboxPersonnel(Mission m, int r) {
        super();
        this.m = m;
        this.row=r;
        this.populate();
    }

    /**
     * Méthode de sélection d'un personnel pour une compétence
     */
    private void populate() {
        int tab[]=null;
        for (int i=0; i<m.getPersonnels().size();i++) {
            tab[i]=0;
            for(Competence c : m.getCompetences()){
                if(frmStart.e.getPersonnel().get(i).avoirComp(c));
                tab[i]++;
            }
        }
    }
    

}
