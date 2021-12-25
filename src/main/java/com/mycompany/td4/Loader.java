/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.td4;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ryota
 */
public class Loader {
    
        static Connection connect;
        static Statement statement;
        static String url;
        static String user;
        static String password;
    
    //constructeur par defaut pour la connexion avec la base de donnes
    
    public Loader(){
        
        connect = null;
        statement = null;
        url = "jdbc:mysql://localhost:3306/TD3";
        user = "root";
        password = "guillaume";
        
    }
    
    //connection avec la base de donne
    public static Statement connectToDB() throws ClassNotFoundException, SQLException{
        
 
        
         try{
            //Definer notre driver
            Class.forName("com.mysql.jdbc.Driver");  
            //Initializer la connection
            Loader.connect = DriverManager.getConnection(Loader.url,Loader.user,Loader.password);
            //statements
            statement = connect.createStatement();
         }
        catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(com.mycompany.td4.Loader.class.getName()).log(Level.SEVERE, null, ex);
        }
         
            return statement;
    }
    
    //ajouter un seul livre
     public static void ajouterLivre(Livre livre) throws SQLException, ClassNotFoundException{

        try{
            Statement st = connectToDB();
            String sql = "select * from Livre where nom='" + livre.nom + "'and auteur ='" +livre.auteur + "'";
            ResultSet rs = st.executeQuery(sql);

            if (rs.first()){
                //verifier si l'eleve existe deja dans la base de donnes;
                System.out.println("Sorry ce Livre deja existe dans la base de donnes");
            }else{

                String requette = "INSERT INTO `Livre`(`nom`, `image`, `auteur`,`isbn`,`stock`,`prix`,`link`) "
                        + "VALUES ('" + livre.nom + "','" + livre.image + "','" + livre.auteur + "','" 
                        +livre.isbn + "','"  + livre.stock + "','"  + livre.prix + "','" + livre.link  + "')";
                st.execute(requette);
        }
        }catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(com.mycompany.td4.Loader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     
     //ajouter toutes les livres
     
     public void ajouterLivres(String url,int limit) throws IOException, SQLException, ClassNotFoundException{
         ArrayList<Livre> books = new ArrayList<Livre>();
         books = new Scraper().getBooks(url,limit);
         
         for(Livre book : books){
             try{
                ajouterLivre(book);
             }catch(ClassNotFoundException | SQLException ex){
                Logger.getLogger(com.mycompany.td4.Loader.class.getName()).log(Level.SEVERE, null, ex);
  
             }
         }
         
         System.out.println("Books addes successfully");
     }
     
     
     //voir ce qui est dans ma base de Live
      public void fetchLivres(){
        
        ArrayList<Livre> books = new ArrayList<Livre>();
        
        try{
            Statement st = connectToDB();
            String sql = "select * from Livre ";
            ResultSet rs = st.executeQuery(sql);
             while (rs.next()) {
                Livre book = new Livre(rs.getString("nom"), rs.getString("image"), rs.getString("auteur"),rs.getString("isbn"),rs.getShort("stock")
                ,rs.getString("prix"),rs.getString("link"));
                books.add(book);
                book.affiche();
            }
        }catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(com.mycompany.td4.Loader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    


     

    
    
    
}
