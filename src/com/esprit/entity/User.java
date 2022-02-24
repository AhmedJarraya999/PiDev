/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.entity;

import java.util.Date;

/**
 *
 * @author jaray
 */



public class User {

    public User(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public User(String name, String lastname, String typeAccount, String nationality, Date Birthdate) {
        this.name = name;
        this.lastname = lastname;
        this.typeAccount = typeAccount;
        this.nationality = nationality;
        this.Birthdate = Birthdate;
    }
     public User(int id, String name, String lastname, String typeAccount, String nationality, Date Birthdate) {
         this.id=id;
        this.name = name;
        this.lastname = lastname;
        this.typeAccount = typeAccount;
        this.nationality = nationality;
        this.Birthdate = Birthdate;
    }

    public User() {
    }
    private int id;
    private String name;
    private String lastname;
    private  String typeAccount;
    private String nationality;
    private Date Birthdate;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getTypeAccount() {
        return typeAccount;
    }

    public String getNationality() {
        return nationality;
    }

    public Date getBirthdate() {
        return Birthdate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setTypeAccount(String typeAccount) {
        this.typeAccount = typeAccount;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setBirthdate(Date Birthdate) {
        this.Birthdate = Birthdate;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", lastname=" + lastname + ", typeAccount=" + typeAccount + ", nationality=" + nationality + ", Birthdate=" + Birthdate + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
    
    
    
    
}
