/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.test;
import com.esprit.test.main;
import com.esprit.controller.AfficherPersonneController;
import com.esprit.controller.ListData;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
//eli melouta are just hajet imported lel tojrab

import com.esprit.dao.Idao;
import com.esprit.utils.ConnexionSingleton;
import com.esprit.dao.PersonneDao;
import com.esprit.entity.Personne;
import com.esprit.utils.ConnexionSingleton;
import com.esprit.entity.User;
import com.esprit.dao.UserDao;
import java.text.SimpleDateFormat;
import java.util.Date;



/**
 *
 * @author wiemhjiri
 */
public class ConnexionBDJavafx extends Application {



    private Stage primaryStage;
    private Parent parentPage;
   
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        
        
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Hello World");
        
        parentPage = FXMLLoader.load(getClass().getResource("/com/esprit/view/Accueil.fxml"));
        Scene scene = new Scene(parentPage);
        this.primaryStage.setScene(scene);
        this.primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //main m = new main();
 /*Personne p = new Personne("ahmed","jarraya");
PersonneDao pdao = PersonneDao.getInstance();
pdao.insert(p);
   
         System.out.println("succefully inserted");
   */
        
        Date firstDate1 =  new Date();
        //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // your template here
        // 2 java.util.Date dateStr = formatter.parse(firstDate1);
        //2 String datee = new SimpleDateFormat("yyyy-MM-dd").format(firstDate1);
    // User u = new User("ahmed","jarraya","Host","tunisia",firstDate1);
         //User u1 = new User("salah","belkdadhi","Guest","USA",firstDate1);
          //User u2 = new User("sami","ben ayed","Guest","Germany",firstDate1);
           //User u3 = new User("wissem","lemsi","Host","France",firstDate1);
       //User u4= new User(1,"wadii","chamakhi","Host","Belguim",firstDate1);
       //User u5= new User(2,"habib","zoghlami","Guest","thailanda",firstDate1);
       //User u6= new User(3,"anas","benbrahim","Guest","suisse",firstDate1);
       //User u7= new User("aymen","khiari","Host","singapoure",firstDate1);
      // User u8= new User("samia","zouaoui","Host","norvege",firstDate1);
       
     //UserDao udao = UserDao.getInstance();
//   Personne p1 = new Personne("salih","ben salah");
  // PersonneDao pdao=PersonneDao.getInstance();
   User u9 = new User("housine","jnaya7","Guest","tunisia",firstDate1);
   UserDao udao = UserDao.getInstance();
    // edheya tetaada   udao.insert(u9);
       
  //pdao.displayById(0);
        //  edheya tetaada  System.out.println( udao.displayById(2));     
  
   //display  by id  display alli list w insertion mriguel deete wel update exceptions
   
        // edheya tetaaada System.out.println(udao.displayAllList());
      //  udao.update( new User(4, "ridha ","charfeddine","Guest","tunisia",firstDate1));
   // hatta hedhi habetch tetaada udao.updatev2(new User(4, "ridha ","charfeddine","Guest","tunisia",firstDate1));
      udao.delete( new User(4, "Mondher ","kebaier","Guest","tunisia",firstDate1));
   
   
     //udao.displayAll();
     //udao.displayAllList();
     //udao.insert(u5);
     //udao.insert(u6);
     //udao.insert(u7);
     //udao.insert(u8);
    
     
     
        // launch(args);
    }

}
