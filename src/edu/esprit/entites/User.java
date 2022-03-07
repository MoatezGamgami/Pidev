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
public class User {
    private int ID;
    private String name;
    private String Aftername;
    private String Email;
    private String Profile;
    private String Password;
    private String Role;

    public User(int ID, String name, String Aftername, String Email, String Profile, String Password, String Role) {
        this.ID = ID;
        this.name = name;
        this.Aftername = Aftername;
        this.Email = Email;
        this.Profile = Profile;
        this.Password = Password;
        this.Role = Role;
    }

    public User() {
    }

    public User(String name, String Aftername) {
        this.name = name;
        this.Aftername = Aftername;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAftername() {
        return Aftername;
    }

    public void setAftername(String Aftername) {
        this.Aftername = Aftername;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getProfile() {
        return Profile;
    }

    public void setProfile(String Profile) {
        this.Profile = Profile;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    @Override
    public String toString() {
        return "User{" + "ID=" + ID + ", name=" + name + ", Aftername=" + Aftername + ", Email=" + Email + ", Profile=" + Profile + ", Password=" + Password + ", Role=" + Role + '}';
    }
    
    
}
