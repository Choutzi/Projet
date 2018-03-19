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
        this.row = r;
        this.populate();
    }

    /**
     * Méthode de sélection d'un personnel pour une compétence
     */
    private void populate() {
        ArrayList<Personnel> tab = frmStart.e.classePerso(m);
            if(m.getPersonnels().size()>this.row && m.getPersonnels().get(this.row).getId()!=-1){
                this.addItem(m.getPersonnels().get(this.row));
            }
        for(Personnel p : tab){
            if (p.avoirComp(m.getCompetences().get(this.row)))
                this.addItem(p);
        }
    }
}
