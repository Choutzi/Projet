/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import javax.swing.JComboBox;
import projet.Competence;
import projet.Personnel;

/**
 *
 * @author Choutzi
 */
public class jComboboxPersonnel extends JComboBox {

    private Competence c;

    public jComboboxPersonnel(Competence c) {
        super();
        this.c = c;
        this.populate();
    }

    private void populate() {
        for (Personnel p : frmStart.e.getPersonnel()) {
            if (p.avoirComp(c)) {
                this.addItem(p);
                System.out.println("added");
            }
        }
    }

    public void afficher() {
        for (int i = 0; i < this.getItemCount() - 1; i++) {
            System.out.println(this.getItemAt(i).toString() + "fin");
        }
    }
}
