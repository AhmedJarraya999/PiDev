/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controller;

import com.esprit.dao.PersonneDao;
import com.esprit.dao.UserDao;
import com.esprit.entity.Personne;
import com.esprit.entity.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author jaray
 */
public class AddUserController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button btn;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
            btn.setOnAction(event -> {
            
            User p = new User(nom.getText(), prenom.getText());
            UserDao pdao = UserDao.getInstance();
            pdao.insert(p);
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("User inserted succefully!");
        alert.show();
        nom.setText("");
        prenom.setText("");
        });
        
        
    }
    }    
    

