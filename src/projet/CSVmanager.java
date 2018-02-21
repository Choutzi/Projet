/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Choutzi
 */
public class CSVmanager implements Manager{
    
    
    @Override
    public ArrayList<String[]> lecture(String Dir) {

        ArrayList<String[]> ListeParametres=new ArrayList<String[]>();
        BufferedReader br = null;
        String line = "";
        String csvSplitBy=";";

        try {

            br = new BufferedReader(new FileReader(Dir));
            while ((line = br.readLine()) != null) {

                // ; comme séparateur
                String[] parametre = line.split(csvSplitBy);
                ListeParametres.add(parametre);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                    
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return ListeParametres;
    }
    
    @Override
    public void ecrire(String dir, StringBuilder builder){
        PrintWriter pw = null;
        try {
                pw = new PrintWriter(new File(System.getProperty("user.dir") + dir));
        } catch (FileNotFoundException err) {
            err.printStackTrace();
        }
        pw.write(builder.toString());
        pw.close();
    }
}

