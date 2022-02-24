/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.entity;

/**
 *
 * @author jaray
 */
public class Userf {
    int id ;
    String name;
    String lastname;
    String identifier;
    String email;
    int tel;

    public Userf() {
    }

    public Userf(String name, String lastname, String identifier, String email, int tel) {
        this.name = name;
        this.lastname = lastname;
        this.identifier = identifier;
        this.email = email;
        this.tel = tel;
    }

    public Userf(int id, String name, String lastname, String identifier, String email, int tel) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.identifier = identifier;
        this.email = email;
        this.tel = tel;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.id;
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
        final Userf other = (Userf) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getEmail() {
        return email;
    }

    public int getTel() {
        return tel;
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

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Userf{" + "id=" + id + ", name=" + name + ", lastname=" + lastname + ", identifier=" + identifier + ", email=" + email + ", tel=" + tel + '}';
    }
    
    
}
