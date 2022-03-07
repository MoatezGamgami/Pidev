/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.crud;

import edu.esprit.entites.DeliveryGuy;
import edu.esprit.entites.DeliveryRate;
import edu.esprit.entites.Livreur;
import edu.esprit.entites.Reclamation;
import edu.esprit.utils.Myconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author moatez
 */
public class DeliveryRateCrud {
    Connection cnx;
    public DeliveryRateCrud(){
        cnx = Myconnection.getInstance().getcnx();
    }
     
       
       
        public void modif1erlivreur(Livreur r , Double h){
       try {
           String requet4 = "UPDATE livreur SET stars='"+ h + "' WHERE iddg=?";
           PreparedStatement st = cnx.prepareStatement(requet4);
           
           
           st.setInt(1,r.getIddg());
          
          
           int rowsUpdated = st.executeUpdate();
           if (rowsUpdated > 0) {
               System.out.println("An existing deliveryrate was updated successfully!");
           }} catch (SQLException ex) {
           System.err.println(ex.getMessage());
       }
   }
        public void suppressionLivreur(Livreur r){
       try {
           String sql = "DELETE FROM livreur WHERE iddg=? and stars=?";
           PreparedStatement statement = cnx.prepareStatement(sql);
           statement.setInt(1,r.getIddg());
           statement.setDouble(2,r.getStars());
           
           int rowsDeleted = statement.executeUpdate();
           if (rowsDeleted > 0) {
               System.out.println("A deliveryrate was deleted successfully!");
           }      } catch (SQLException ex) {
                System.err.println(ex.getMessage());
       }
    }
        public void modifrecstarts(Livreur r ,Double x){
       try {
           String requet4 = "UPDATE livreur SET stars=?+'"+ x + "'/2  WHERE iddg=?";
           PreparedStatement st = cnx.prepareStatement(requet4);
           
           st.setDouble(1,r.getStars());
           st.setInt(2,r.getIddg());
           
           
           int rowsUpdated = st.executeUpdate();
           if (rowsUpdated > 0) {
               System.out.println("An existing rate was responded successfully!");
           }} catch (SQLException ex) {
           System.err.println(ex.getMessage());
       }
   }
        public List<Livreur> affichedelivertyguy(){
             List<Livreur> mylist = new ArrayList<>();
       try {
          
           String requet3 = "SELECT * FROM livreur";
           Statement st = cnx.createStatement();
           ResultSet rs = st.executeQuery(requet3);
           while (rs.next()){
               Livreur r = new Livreur();
               r.setIddg(rs.getInt(1));
               r.setName(rs.getString("name"));
               r.setStars(rs.getDouble(3));
               
               
               mylist.add(r);
               
           }
       } catch (SQLException ex) {
            System.err.println(ex.getMessage());
       }
            return mylist;
            
            
    }
        
        
}
