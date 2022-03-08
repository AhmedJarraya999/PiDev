/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rating;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;
import reclamation.AddReclamationController;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class AddRatingController {
    
    @FXML
    private Button fxmod_btn;
    private Button fxdel_btn;
    @FXML
    private Rating fxrating;
    @FXML
    private TextArea fxcomment;
    @FXML
    private Button fxsub_btn;
    @FXML
    private JFXButton btnback;
    @FXML
    private JFXButton fxdel_btn1;
    
//    Stay s;
//    User u;
        
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource() == fxsub_btn){
            addRating();
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
    
    public 
        
        ObservableList<RatingStay> getRating(){
        ObservableList<RatingStay> ratingList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM rating";
        Statement st;
        ResultSet rs;
        
        try{
             st = conn.createStatement();
             rs = st.executeQuery(query);
             RatingStay rate;
             while(rs.next())
             {
                 rate = new RatingStay(rs.getInt("rating_id"), rs.getInt("stay_id"), rs.getInt("user_id"), rs.getString("rating"), rs.getString("comment"));
                 ratingList.add(rate);
             }
    
    }
        catch(Exception ex){
            ex.printStackTrace();
    }
        return ratingList;
    }
        
    private void addRating() {
        String query = "INSERT INTO rating (stay_id, user_id, rating, comment) VALUES ('2','2','" + Double.toString(fxrating.getRating()) + "','" + fxcomment.getText() + "')";
      //Integer.toString(s.getStay_Id()) + "','" + Integer.toString(u.getId())     
        executeQuery(query);
        
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

    @FXML
    private void Back(ActionEvent event) {
                try {
                Parent page1 = FXMLLoader.load(getClass().getResource("displayRating.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AddReclamationController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
