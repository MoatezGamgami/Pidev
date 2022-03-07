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
public class Reclamation {
    private int idrec;
    private String description;
    private String repense	;
    private int status;

    public Reclamation(String repense, int status) {
        this.repense = repense;
        this.status = status;
    }

    public Reclamation(int idrec, String repense) {
        this.idrec = idrec;
        this.repense = repense;
    }

    public Reclamation() {
    }

    public Reclamation(String description) {
        this.description = description;
    }

    public Reclamation(int idrec) {
        this.idrec = idrec;
    }
  
    public Reclamation(String description, String repense, int status) {
        this.description = description;
        this.repense = repense;
        this.status = status;
    }

    public Reclamation(int idrec, String description, String repense, int status) {
        this.idrec = idrec;
        this.description = description;
        this.repense = repense;
        this.status = status;
    }

    public int getIdrec() {
        return idrec;
    }

    public void setIdrec(int idrec) {
        this.idrec = idrec;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRepense() {
        return repense;
    }

    public void setRepense(String repense) {
        this.repense = repense;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "idrec=" + idrec + ", description=" + description + ", repense=" + repense + ", status=" + status + '}';
    }
    
    
}
