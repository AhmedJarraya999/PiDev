/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rating;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class RatingSampleController {

    @FXML
    private Label lb_username;
    @FXML
    private Label lb_comment;
    @FXML
    private Label lb_rate;
    @FXML
    private Button btn_mn_modify;
    @FXML
    private Button btn_mn_delete;

    
    
public void setData(RatingStay ratingStay) {
    
//lb_username.setText(ratingStay.getUserId.name);
lb_comment.setText(ratingStay.getComment());
lb_rate.setText(ratingStay.getRating());
}

            
    @FXML
    private void DeleteRate(ActionEvent event) {
        String query = "DELETE FROM rating WHERE stay_id = 2 AND user_id = 2";
        executeQuery(query);
        try {
                Parent page1 = FXMLLoader.load(getClass().getResource("displayRating.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(DisplayRatingController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void ModifyRate(ActionEvent event) {
        try {
                Parent page1 = FXMLLoader.load(getClass().getResource("modifyRating.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(DisplayRatingController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
    private void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try{
            st = conn.createStatement();
            st.executeUpdate(query);
        }catch(Exception ex){
            ex.printStackTrace();}
    }
    public Connection getConnection(){
        Connection conn;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/StarTours", "root","");
            return conn;
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }
    
}
