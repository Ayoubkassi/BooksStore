/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.td4;

/**
 *
 * @author ryota
 */
public class Livre {
    static int id;
    String nom;
    String image;
    String auteur;
    String isbn;
    int stock;
    String prix;
    String link;
    
    //constructeur par default

    public Livre() {
    }
    
    //constructeur avec parametres

    public Livre(String nom, String image, String auteur, String isbn, int stock, String prix, String link) {
        this.nom = nom;
        this.image = image;
        this.auteur = auteur;
        this.isbn = isbn;
        this.stock = stock;
        this.prix = prix;
        this.link = link;
    }
    
    //getters and setters

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Livre.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
    //to String

    @Override
    public String toString() {
        return "Livre{" + "nom=" + nom + "; image=" + image + "; auteur=" + auteur + "; isbn=" + isbn + "; stock=" + stock + "; prix=" + prix + "; link=" + link + '}';
    }
    
    public String CSVAffiche(){
        return nom+","+image+","+auteur+","+isbn+","+stock+","+prix+","+link;
    }
    
    //affiche
    
    public void affiche(){
        System.out.println(this.toString());
    }
    
}
