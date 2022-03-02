/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxblog.control;

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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafxblog.dao.ExperienceService;
import javafxblog.entity.Experience;
import java.util.Date;

/**
 * FXML Controller class
 *
 * @author tasni
 */
public class AddExperienceController implements Initializable {

    
    @FXML
    private TextField tftitle;
    @FXML
    private TextField tfContent;
    @FXML
    private Button btnInsert;
    @FXML
    private Button btn_back;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

      
    }

    @FXML
    private void add_Experience(ActionEvent event) {
            Date dt = new Date();
            Experience e = new Experience(1, tftitle.getText(), tfContent.getText(),0,dt.toString()); //NEED TO CHANGE TO USER_ID
            ExperienceService pdao = ExperienceService.getInstance();
            pdao.add_Experience(e);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Experience Added!");
            alert.show();

            tftitle.setText("");
            tfContent.setText("");
    }


    @FXML
    private void goBack(ActionEvent event) {
            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/javafxblog/view/ListExperience.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ListExperienceController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}