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
public class DeliveryGuy  {
    private int iddg;
    private String name;

    public DeliveryGuy() {
    }

    public DeliveryGuy(int iddg, String name) {
        this.iddg = iddg;
        this.name = name;
    }

    public DeliveryGuy(int iddg) {
        this.iddg = iddg;
    }

    public DeliveryGuy(String name) {
        this.name = name;
    }

    public int getIddg() {
        return iddg;
    }

    public void setIddg(int iddg) {
        this.iddg = iddg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
      
    
    
}
