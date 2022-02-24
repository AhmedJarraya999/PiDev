/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controller;

import com.esprit.dao.UserDao;
import com.esprit.entity.Personne;
import com.esprit.entity.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author jaray
 */


   
public class ListData2 {
     private ObservableList<User> users=FXCollections.observableArrayList();
      public ListData2() 
      
      
      {
          UserDao pdao=UserDao.getInstance();
        users= pdao.displayAll();
        System.out.println(users);
      }
      
      public ObservableList<User> getUsers(){
        return users;
    }
      
}
