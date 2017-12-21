/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

/**
 *
 * @author Choutzi
 */
public class Competence {
    private String identifiant;
    private String descriptionEng;
    private String descriptionFr;
    
    public Competence(String[] comp){
        this.identifiant=comp[0];
        this.descriptionEng=comp[1];
        this.descriptionFr=comp[2];
    }
    
    @Override
    public String toString(){
        return this.identifiant+" : "+this.descriptionEng+" >> Traduction : "+this.descriptionFr;
    }
}
