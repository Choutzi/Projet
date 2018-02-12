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
public class poserCongeException extends Exception {

    public poserCongeException() {
        System.out.println("Vous essayez de poser un congé sur un congé existant !");
    }

}
