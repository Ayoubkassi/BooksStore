/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.td4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author ryota
 */
public class Scraper {
    
    ArrayList<Livre> books = new ArrayList<Livre>();
    
    
    //methode qui scrappe les livres 
    public ArrayList<Livre> getBooks(String url, int limit) throws IOException{
        
        //10 -> 100 row
        limit/=10;
        for (int j = 1; j <= limit; j++) {
        String url1 = url;     
        url1=url+j;
        System.out.println(url1);

        final Document document = Jsoup.connect(url1).get();
        Elements booksElements = document.select("div.row > div");
        
        for(Element el : booksElements){
            Elements tags = el.select("div.item");
            String link = tags.select("a").attr("href");
            Elements hElements = tags.select("h6");
            String title = null,auteur = null,isbn = null,stock1 = null,prix = null,image = null;
            int i =0;
            Livre book = new Livre();
            for(Element ele: hElements){
                if(i == 0){
                       title = ele.text();
                       book.setNom(title);
                }
                else if(i == 1){
                        auteur = ele.text();
                        if(auteur.length()>9){
                        auteur = auteur.substring(9);
                        book.setAuteur(auteur);
                        }
                        
                }
                else if(i == 2){
                        isbn = ele.text();
                        isbn = isbn.substring(7);
                        book.setIsbn(isbn);
                }
                else if(i == 3){
                        stock1 = ele.text();
                        stock1 = stock1.split(":")[1].trim();
                        int stock = Integer.parseInt(stock1);
                        book.setStock(stock);
                }
                else if (i == 4){
                    prix = ele.text();
                    prix = prix.substring(7);
                    book.setPrix(prix);
                }
                else{
                    image = ele.select("a").attr("href");
                    book.setImage(image);
                    book.link=link;
                    //le dernier feature alors on stocke notre livre
                    books.add(book);

                }
              
                i++;
                    
                }
            
                //book.affiche();
            
            }
        
        }
        
        for(Livre livre : books){
            livre.affiche();
        }
            
            //stocker dans un fichier texte
            
             FileWriter fw = new FileWriter("data.txt");      
           
             for(Livre book : books){
                 fw.write(book.toString());
                 fw.write(System.getProperty("line.separator"));
             }
             
             fw.close();
            
            return books;
        }
    }

    
    
    

