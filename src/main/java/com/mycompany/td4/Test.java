/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.td4;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Pattern
 */
public class Test {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException{
        System.out.println("Bismi Allah");
        //new Scraper().getBooks("https://enstock.livremoi.ma/rayon/litterature-francophone?page=1");
        
        //Loader loader = new Loader();
        //loader.ajouterLivres();
        
        //afficher livre dasns la base de donne
        //loader.fetchLivres();
        
        //tester tranformer
        //new Transformer().transforme("data.txt");
        System.out.println("Entrez un URL : ");
        Scanner in = new Scanner(System.in);
        String url = in.next();
        System.out.println("Entrez le nombre d'article que vou voulez scarpez : ");
        int limit = in.nextInt();
        System.out.println("**************** Lancement du Scraping ********************* ");
        //scrapp et stocke dans la base de donne
//        if(limit > 610){
//            limit = 610;
//        }
        new Scraper().getBooks(url, limit);
//        Loader loader = new Loader();
//        loader.ajouterLivres(url,limit);
        
        
        
    }
}


//CREATE TABLE Livre(
//    id int(11) PRIMARY KEY AUTO_INCREMENT,
//    nom VARCHAR(50),
//    image VARCHAR(200),
//    auteur VARCHAR(50),
//    isbn VARCHAR(40),
//    stock INT(18),
//    prix VARCHAR(50),
//    link VARCHAR(200)
//
//);