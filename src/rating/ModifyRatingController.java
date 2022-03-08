/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rating;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;
import reclamation.AddReclamationController;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class ModifyRatingController implements Initializable {

    @FXML
    private Rating rate;
    @FXML
    private TextArea comment;
    @FXML
    private JFXButton update;
    @FXML
    private JFXButton back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void updateRate(ActionEvent event) {
        String query = "UPDATE  rating SET rating = '" + Double.toString(rate.getRating()) + "', comment = '"  + comment.getText() + "' WHERE stay_id = 2 AND user_id = 2";
        executeQuery(query);
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

    @FXML
    private void BackBtn(ActionEvent event) {
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