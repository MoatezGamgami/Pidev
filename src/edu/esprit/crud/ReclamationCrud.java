/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.crud;

import edu.esprit.utils.Myconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.esprit.entites.Reclamation;
import edu.esprit.entites.count0;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author moatez
 */
public class ReclamationCrud {
   Connection cnx;
    public ReclamationCrud(){
        cnx = Myconnection.getInstance().getcnx();
    
}
    public void ajoutReclamation(){
       try {
           String requet1 = "INSERT INTO reclamation (description,repense,status)" + "VALUES ('probleme','daccord','1')";
           Statement st = cnx.createStatement();
           st.executeUpdate(requet1);
           System.out.println("reclamation ajouté");
       } catch (SQLException ex) {
           System.err.println(ex.getMessage());
       }
    }
        public void ajoutReclamation2(Reclamation r){
       try {
           String requet2 = "INSERT INTO reclamation (description,repense,status)" + "VALUES (?,?,?)";
           PreparedStatement st = cnx.prepareStatement(requet2);
           st.setString(1,r.getDescription());
           st.setString(2,r.getRepense());
           st.setInt(3,r.getStatus());
           st.executeUpdate();
           System.out.println("reclamation ajouté");
       } catch (SQLException ex) {
           System.err.println(ex.getMessage());
       }
    }
        public List<Reclamation> affichereclamation(){
             List<Reclamation> mylist = new ArrayList<>();
       try {
          
           String requet3 = "SELECT * FROM reclamation";
           Statement st = cnx.createStatement();
           ResultSet rs = st.executeQuery(requet3);
           while (rs.next()){
               Reclamation r = new Reclamation();
               r.setIdrec(rs.getInt(1));
               r.setDescription(rs.getString("description"));
               r.setRepense(rs.getString("repense"));
               r.setStatus(rs.getInt(4));
               mylist.add(r);
               
           }
       } catch (SQLException ex) {
            System.err.println(ex.getMessage());
       }
            return mylist;
            
            
    }
        public void modifreclamation(Reclamation r){
       try {
           String requet4 = "UPDATE reclamation SET description=?, repense=?, status=? WHERE idrec=?";
           PreparedStatement st = cnx.prepareStatement(requet4);
           
           st.setString(1,r.getDescription());
           st.setString(2,r.getRepense());
           st.setInt(3,r.getStatus());
           st.setInt(4,r.getIdrec());
          
           int rowsUpdated = st.executeUpdate();
           if (rowsUpdated > 0) {
               System.out.println("An existing reclamation was updated successfully!");
           }} catch (SQLException ex) {
           System.err.println(ex.getMessage());
       }
   }
        public void suppressionreclamation(Reclamation r){
       try {
           String sql = "DELETE FROM reclamation WHERE idrec=?";
           PreparedStatement statement = cnx.prepareStatement(sql);
           statement.setInt(1,r.getIdrec());
           
           int rowsDeleted = statement.executeUpdate();
           if (rowsDeleted > 0) {
               System.out.println("A reclamation was deleted successfully!");
           }      } catch (SQLException ex) {
                System.err.println(ex.getMessage());
       }
    }
        public List<Reclamation> recherchereclamation(int x){
             List<Reclamation> mylist = new ArrayList<>();
       try {
          
           String requet3 = "SELECT * FROM reclamation where idrec = '"+ x + "' ";
           Statement st = cnx.createStatement();
           ResultSet rs = st.executeQuery(requet3);
           while (rs.next()){
               Reclamation r = new Reclamation();
               r.setIdrec(rs.getInt(1));
               r.setDescription(rs.getString("description"));
               r.setRepense(rs.getString("repense"));
               r.setStatus(rs.getInt(4));
               mylist.add(r);
               
           }
       } catch (SQLException ex) {
            System.err.println(ex.getMessage());
       }
            return mylist;
            
            
    }
        public List<Reclamation> rechercherecstatus(int x){
             List<Reclamation> mylist = new ArrayList<>();
       try {
          
           String requet3 = "SELECT * FROM reclamation where status = '"+ x + "' ";
           Statement st = cnx.createStatement();
           ResultSet rs = st.executeQuery(requet3);
           while (rs.next()){
               Reclamation r = new Reclamation();
               r.setIdrec(rs.getInt(1));
               r.setDescription(rs.getString("description"));
               r.setRepense(rs.getString("repense"));
               r.setStatus(rs.getInt(4));
               mylist.add(r);
               
           }
       } catch (SQLException ex) {
            System.err.println(ex.getMessage());
       }
            return mylist;
            
            
    }
        public void modifrecreponse(Reclamation r){
       try {
           String requet4 = "UPDATE reclamation SET repense=?  WHERE idrec=?";
           PreparedStatement st = cnx.prepareStatement(requet4);
           
           st.setString(1,r.getRepense());
            st.setInt(2,r.getIdrec());
           int rowsUpdated = st.executeUpdate();
           if (rowsUpdated > 0) {
               System.out.println("An existing reclamation was responded successfully!");
           }} catch (SQLException ex) {
           System.err.println(ex.getMessage());
       }
   }
        public void modifrecstatus(Reclamation r){
       try {
           String requet4 = "UPDATE reclamation SET status=?+1  WHERE idrec=?";
           PreparedStatement st = cnx.prepareStatement(requet4);
           
           st.setInt(1,r.getStatus());
           st.setInt(2,r.getIdrec());
           int rowsUpdated = st.executeUpdate();
           if (rowsUpdated > 0) {
               System.out.println("An existing reclamation was responded successfully!");
           }} catch (SQLException ex) {
           System.err.println(ex.getMessage());
       }
   }
        public static boolean Bad(String ch){
            List<String> mylist = new ArrayList<>();
            
            mylist.add("voila");
            mylist.add("badword");
            mylist.add("fuck");
            for(int i=0; i<mylist.size(); i++){
                if(ch.equals(mylist.get(i))) {
                     return true;
                }
            }
       return false;
           
            
        } 
            
         public List<count0> affichecount(){
             List<count0> mylist = new ArrayList<>();
       try {
          
           String requet3 = "SELECT Region, COUNT(*) AS nombrenonrepondu FROM reclamation GROUP BY Region";
           Statement st = cnx.createStatement();
           ResultSet rs = st.executeQuery(requet3);
             while (rs.next()){
               count0 r = new count0();
               r.setNombrenonrepondu(rs.getInt("nombrenonrepondu"));
               r.setRegion(rs.getString("Region"));
               
               
               mylist.add(r);
               }
           
       } catch (SQLException ex) {
            System.err.println(ex.getMessage());
       }
            return mylist;
            
            
    }
}
