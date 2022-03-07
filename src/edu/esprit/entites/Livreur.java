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
public class Livreur {
    Integer iddg;
    Double stars;
    String name;

    public Livreur() {
    }

    public Livreur(Integer iddg) {
        this.iddg = iddg;
    }

    public Livreur(Double stars) {
        this.stars = stars;
    }
    

    public Livreur(Integer iddg, String name, Double stars) {
        this.iddg = iddg;
        this.stars = stars;
        this.name = name;
    }

    public Livreur(String name) {
        this.name = name;
    }

    public Integer getIddg() {
        return iddg;
    }

    public void setIddg(Integer iddg) {
        this.iddg = iddg;
    }

    public Double getStars() {
        return stars;
    }

    public void setStars(Double stars) {
        this.stars = stars;
    }

  

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    
}
