/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rating;

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
public class DisplayRatingController implements Initializable {

    @FXML
    private JFXButton btn_addrates;
    @FXML
    private VBox ratingLayout;
    
    
    public List<RatingStay> listRating(){
     RatingService ratingService= RatingService.getInstance();
     return new ArrayList<>(ratingService.getRatingList());
    }
    
    public void Display(List<RatingStay> ratingStays) {
        for (RatingStay ratingStay : ratingStays) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("ratingSample.fxml"));
            try {
                VBox vBox = fxmlLoader.load();
                RatingSampleController ratingSampleController = fxmlLoader.getController();
                ratingSampleController.setData(ratingStay);
                ratingLayout.getChildren().add(vBox);
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
      Display(listRating());
    }    

    @FXML
    private void AddRate(ActionEvent event) {
         try {
                Parent page1 = FXMLLoader.load(getClass().getResource("addRating.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(DisplayRatingController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}
