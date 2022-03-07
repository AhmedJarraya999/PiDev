/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jaray
 */
public class HostHomeController implements Initializable {
    Stage stage;

    @FXML
    private Button mystay;
    @FXML
    private Button rankings;
    @FXML
    private Button profilesettings;
    @FXML
    private Button reservations;
    @FXML
    private Button experiences;
    @FXML
    private Pane paneps;
    @FXML
    private Button logout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    private void setUi(String location) {
        try {
            paneps.getChildren().clear();
            paneps.getChildren().add(FXMLLoader.load(this.getClass().
                    getResource("/GUI/" + location + ".fxml")));
        } catch (IOException ex) {
            Logger.getLogger(GuestHomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @FXML
    private void profilesettings(ActionEvent event) {
        setUi("ProfileSettings");
        
    }
     @FXML
    private void MyStay(ActionEvent event) {
        //setUi("ProfileSettings");
        
    }
    @FXML
    private void Rankings(ActionEvent event) {
        //setUi("ProfileSettings");
        
    }
    @FXML
    private void Reservations(ActionEvent event) {
        //setUi("ProfileSettings");
        
    }
     @FXML
    private void Experiences(ActionEvent event) {
        //setUi("ProfileSettings");
        
    }
     @FXML
    private void logout (ActionEvent event) throws IOException
    {
        try {
                    Stage stageclose=(Stage) ((Node)event.getSource()).getScene().getWindow();

                    stageclose.close();
                    Parent root=FXMLLoader.load(getClass().getResource("/GUI/Authentification.fxml"));
                    Stage stage =new Stage();

                    Scene scene = new Scene(root);

                    stage.setTitle("signup");
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(AuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
                }
    
     
       
    }
}
