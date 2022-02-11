/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.entities;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author jaray
 */
public class User {
    private int id ;
    private String name;
    private String lastname;
    private String email;
    private String image;
    private String password;
    private LocalDate birthDate;
    private String typeUser ;
    private String Country;
    private String gender;

    public User(int id, String name, String lastname, String email, String image, String password, LocalDate birthDate, String typeUser, String Country, String gender) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.image = image;
        this.password = password;
        this.birthDate = birthDate;
        this.typeUser = typeUser;
        this.Country = Country;
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public String getCountry() {
        return Country;
    }

    public String getGender() {
        return gender;
    }
    
    

    public String getImage() {
        return image;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.id;
        hash = 71 * hash + Objects.hashCode(this.email);
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
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
