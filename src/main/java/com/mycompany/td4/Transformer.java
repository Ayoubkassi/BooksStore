/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.td4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author ryota
 */
public class Transformer {
    
    static ArrayList<Livre> books = new ArrayList<Livre>();

    public void transforme(String path){
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            int i =0;
            System.out.println("****************** CSV Format to handle Database ********************");

            while ((line = br.readLine()) != null) {
                    try{
                        //System.out.println(line);
                        String title = line.split(";")[0].substring(10);
                        String image = line.split(";")[1].substring(7);
                        String auteur = line.split(";")[2].substring(8);
                        String isbn = line.split(";")[3].substring(6);
                        int stock = Integer.parseInt(line.split(";")[4].substring(7).trim());
                        
                        String prix = line.split(";")[5].substring(6);
                        String link = line.split(";")[6].substring(6);
                        
                        Livre livre = new Livre(title,image,auteur,isbn,stock,prix,link);
                        
                        //afficher en forlat csv
                        
                        //format csv pour analyse de donne
                        System.out.println(livre.CSVAffiche());
                    }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
        }catch(Exception e){
                e.printStackTrace();
            }
    }

}
