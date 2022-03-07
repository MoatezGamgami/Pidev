/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tests;

import edu.esprit.crud.CommentCrud;
import edu.esprit.crud.DeliveryRateCrud;
import edu.esprit.crud.ReclamationCrud;
import edu.esprit.entites.Comment;
import edu.esprit.entites.DeliveryRate;
import edu.esprit.entites.Livreur;
import edu.esprit.entites.Reclamation;
import edu.esprit.utils.Myconnection;

/**
 *
 * @author moatez
 */
public class Mainclass {
    public static void main(String[] args ){
       Myconnection mc = Myconnection.getInstance();
       // CommentCrud sp = new CommentCrud();
        //Comment p1 = new Comment(1,"test modif");
        //sp.modifComment(p1);
     // System.out.println(sp.afficheComment());
      //  sp.ajoutReclamation();
       // DeliveryRateCrud sp = new DeliveryRateCrud();
      //  Livreur h = new Livreur(1,"sami",4.0);
       // sp.modif1erlivreur(h,3.5);
        
    
      //sp.suppressionreclamation(h);
    // System.out.println(sp.affichedelivertyrate());
    
    ReclamationCrud pp = new ReclamationCrud();
      
      
      
     //Reclamation r= new Reclamation(3,"daccord");
     //pp.modifrecreponse(r);
     //pp.modifrecstatus(r);
              
    }
          
    
}
