/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.crud;

import edu.esprit.entites.Comment;
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
public class CommentCrud {
    Connection cnx;
    public CommentCrud(){
        cnx = Myconnection.getInstance().getcnx();}
    public void ajoutComment(){
       try {
           String requet1 = "INSERT INTO comment (comment)" + "VALUES ('jai aimé ce plat')";
           Statement st = cnx.createStatement();
           st.executeUpdate(requet1);
           System.out.println("Commeataire ajouté");
       } catch (SQLException ex) {
           System.err.println(ex.getMessage());
       }
    }
        public void ajoutComment2(Comment r){
       try {
           String requet2 = "INSERT INTO comment (comment)" + "VALUES (?)";
           PreparedStatement st = cnx.prepareStatement(requet2);
           st.setString(1,r.getComment());
           st.executeUpdate();
           System.out.println("commentaire ajouté");
       } catch (SQLException ex) {
           System.err.println(ex.getMessage());
       }
    }
        public List<Comment> afficheComment(){
             List<Comment> mylist = new ArrayList<>();
       try {
          
           String requet3 = "SELECT * FROM comment";
           Statement st = cnx.createStatement();
           ResultSet rs = st.executeQuery(requet3);
           while (rs.next()){
               Comment r = new Comment();
               r.setIdcomment(rs.getInt(1));
               r.setComment(rs.getString("comment"));
               
               mylist.add(r);
               
           }
       } catch (SQLException ex) {
            System.err.println(ex.getMessage());
       }
            return mylist;
            
            
    }
        public void modifComment(Comment r){
       try {
           String requet4 = "UPDATE comment SET  comment=? WHERE idcomment=?";
           PreparedStatement st = cnx.prepareStatement(requet4);
           
                
           st.setString(1,r.getComment());
           st.setInt(2,r.getIdcomment());
           
          
           int rowsUpdated = st.executeUpdate();
           if (rowsUpdated > 0) {
               System.out.println("An existing comment was updated successfully!");
           }} catch (SQLException ex) {
           System.err.println(ex.getMessage());
       }
   }
        public void suppressionComment(Comment r){
       try {
           String sql = "DELETE FROM comment WHERE idcomment=?";
           PreparedStatement statement = cnx.prepareStatement(sql);
           statement.setInt(1,r.getIdcomment());
           
           int rowsDeleted = statement.executeUpdate();
           if (rowsDeleted > 0) {
               System.out.println("A comment was deleted successfully!");
           }      } catch (SQLException ex) {
                System.err.println(ex.getMessage());
       }
    }
    
}
