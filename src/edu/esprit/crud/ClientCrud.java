/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.crud;

import edu.esprit.utils.Myconnection;
import java.sql.Connection;

/**
 *
 * @author moatez
 */
public class ClientCrud {
    Connection cnx;
    public ClientCrud(){
        cnx = Myconnection.getInstance().getcnx();
    
}
    
}
