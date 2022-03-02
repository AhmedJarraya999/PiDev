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

/**
 * FXML Controller class
 *
 * @author tasni
 */
public class ModifyexperienceController implements Initializable {

    @FXML
    private TextField tftitle;
    @FXML
    private TextField tfContent;
    @FXML
    private Button btnInsert;
    @FXML
    private Button btn_back;
    @FXML
    private TextField tf_idexp;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modify_Experience(ActionEvent event) {
        int ID_exp = Integer.parseInt(tf_idexp.getText());
        Experience e = new Experience(ID_exp,tftitle.getText(),tfContent.getText());
            ExperienceService experienceService = ExperienceService.getInstance();
            experienceService.modify_Experience(e);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Hotel modified !");
            alert.show();
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
