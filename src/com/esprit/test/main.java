/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.test;

import com.esprit.dao.UserDao;
import com.esprit.dao.UserfDao;
import com.esprit.entity.User;
import java.util.Date;

/**
 *
 * @author jaray
 */
public class main {
    public static void main(String[] args) {
         
        Date firstDate1 =  new Date();
       
         User u9 = new User("housine","jnaya7","Guest","tunisia",firstDate1);
   UserDao udao = UserDao.getInstance();
   
   
    // edheya tetaada   udao.insert(u9);
       
  //pdao.displayById(0);
        //  edheya tetaada  System.out.println( udao.displayById(2));     
  
   //display  by id  display alli list w insertion mriguel deete wel update exceptions
   
        // edheya tetaaada System.out.println(udao.displayAllList());
      //  udao.update( new User(4, "ridha ","charfeddine","Guest","tunisia",firstDate1));
   // hatta hedhi habetch tetaada udao.updatev2(new User(4, "ridha ","charfeddine","Guest","tunisia",firstDate1));
      
      udao.update(new User(3, "maher ","kenzari","Guest","tunisia",firstDate1));
       
    }
    
}
