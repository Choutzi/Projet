/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.exceptions;

/**
 *
 * @author efgde
 */
public class affecterPersException extends Exception{
    public affecterPersException(){
    System.out.println("Cette mission empiète sur un ou plusieurs congés de l'employé.");
}
}
