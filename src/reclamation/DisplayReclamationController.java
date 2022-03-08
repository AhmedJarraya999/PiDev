/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reclamation;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class DisplayReclamationController implements Initializable {

    @FXML
    private VBox reclamationLayout;
    @FXML
    private JFXButton sendrec;

    
public List<Reclamations> listReclamations(){
     ReclamationService reclamationservice= ReclamationService.getInstance();
     return new ArrayList<>(reclamationservice.getReclamationsList());
    }

public void Display(List<Reclamations> reclamations) {
        for (Reclamations reclamation : reclamations) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("reclamationSample.fxml"));
            try {
                VBox vBox = fxmlLoader.load();
                ReclamationSampleController reclamationSampleController = fxmlLoader.getController();
                reclamationSampleController.setData(reclamation);
                reclamationLayout.getChildren().add(vBox);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Display(listReclamations());
    }    

    @FXML
    private void SendRec(ActionEvent event) {
        try {
                Parent page1 = FXMLLoader.load(getClass().getResource("addReclamation.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(DisplayReclamationController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}
