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
public class DeliveryRate {
    private int idrate;
    private int stars;

    public DeliveryRate() {
    }
   
    public DeliveryRate(int stars) {
        this.stars = stars;
    }

    public DeliveryRate(int idrate, int stars) {
        this.idrate = idrate;
        this.stars = stars;
    }

    public int getIdrate() {
        return idrate;
    }

    public void setIdrate(int idrate) {
        this.idrate = idrate;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "DeliveryRate{" + "idrate=" + idrate + ", stars=" + stars + '}';
    }
    
    
      
}
