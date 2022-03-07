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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jaray
 */
public class GuestHomeController implements Initializable {

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
    private void Availablestays(ActionEvent event) {
        //setUi("ProfileSettings");
        
    }
      @FXML
    private void Rankings(ActionEvent event) {
        //setUi("ProfileSettings");
        
    }
    private void Myexperiences(ActionEvent event) {
        //setUi("ProfileSettings");
        
    }
    private void MyBookings(ActionEvent event) {
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
