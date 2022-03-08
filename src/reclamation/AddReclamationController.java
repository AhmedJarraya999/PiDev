/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reclamation;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Rating;
import org.controlsfx.control.textfield.CustomTextField;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class AddReclamationController {

    @FXML
    private JFXTextField fts;
    @FXML
    private CustomTextField ftr;
    @FXML
    private JFXButton btnsend;
    @FXML
    private JFXButton btnback;
   

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource() == btnsend){
            sendReclamation();
            fts.setText("");
            ftr.setText("");
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
    
    public ObservableList<Reclamations> getReclamationList(){
        ObservableList<Reclamations> reclamationList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM reclamation";
        Statement st;
        ResultSet rs;
        
        try{
             st = conn.createStatement();
             rs = st.executeQuery(query);
             Reclamations rec;
             while(rs.next())
             {
                 rec = new Reclamations(rs.getInt("reclamation_id"), rs.getInt("user_id"), rs.getString("email"), rs.getString("subject"), rs.getString("reclamation"));
                 reclamationList.add(rec);
             }
    
    }
        catch(Exception ex){
            ex.printStackTrace();
    }
        return reclamationList;
    }
    private void sendReclamation(){
        String query = "INSERT INTO reclamation (user_id, email, subject, reclamation) VALUES ('3','user@email.com','"+ fts.getText()+"','"+ftr.getText()+"')";
        //+ Integer.toString(u.getId()) "','" + u.getEmail + "',
        executeQuery(query);
        TrayNotification tray = new TrayNotification();
           
        AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle("Reclamation Sent");
            tray.setMessage("You successufuly sent your reclamation");
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.millis(1000));
        
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
                Parent page1 = FXMLLoader.load(getClass().getResource("displayReclamation.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AddReclamationController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}
