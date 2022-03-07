/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entites;

/**
 *
 * @author moatez
 */
public class count0 {

   
    Integer nombrenonrepondu;
    String Region;
    
    
    
     public count0(Integer nombrenonrepondu, String Region) {
        this.nombrenonrepondu = nombrenonrepondu;
        this.Region = Region;
    }

    public count0() {
    }

    public count0(Integer nombrenonrepondu) {
        this.nombrenonrepondu = nombrenonrepondu;
    }

    public count0(String Region) {
        this.Region = Region;
    }

    public Integer getNombrenonrepondu() {
        return nombrenonrepondu;
    }

    public void setNombrenonrepondu(Integer nombrenonrepondu) {
        this.nombrenonrepondu = nombrenonrepondu;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }
     
}
