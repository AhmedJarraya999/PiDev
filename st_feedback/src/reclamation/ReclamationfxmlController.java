/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reclamation;

import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class ReclamationfxmlController implements Initializable {

    
    @FXML
    private TextField ftui;
    @FXML
    private TextField ftem;
    @FXML
    private TextField fts;
    @FXML
    private TextArea ftr;
    @FXML
    private TableView<Reclamations> tvreclamation;
    @FXML
    private TableColumn<Reclamations, Integer> colid;
    @FXML
    private TableColumn<Reclamations, Integer> colui;
    @FXML
    private TableColumn<Reclamations, String> colem;
    @FXML
    private TableColumn<Reclamations, String> cols;
    @FXML
    private TableColumn<Reclamations, String> colr;
    @FXML
    private Button btnsend;
    
    //User s;
    

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource() == btnsend){
            sendReclamation();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showReclamations();
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
        
    public void showReclamations(){
        ObservableList<Reclamations> list = getReclamationList();
        
        colid.setCellValueFactory(new PropertyValueFactory<Reclamations, Integer>("Reclamation_Id"));
        colui.setCellValueFactory(new PropertyValueFactory<Reclamations, Integer>("User_Id")); 
        colem.setCellValueFactory(new PropertyValueFactory<Reclamations, String>("Email"));
        cols.setCellValueFactory(new PropertyValueFactory<Reclamations, String>("Subject"));
        colr.setCellValueFactory(new PropertyValueFactory<Reclamations, String>("Reclamation"));
        
        tvreclamation.setItems(list);
    
    }
    
     private void sendReclamation(){
        String query = "INSERT INTO reclamation (user_id, email, subject, reclamation) VALUES ('" 
                //+ Integer.toString(u.getId()) "','"
                +  parseInt(ftui.getText())+"','"+ftem.getText()+"','"+ fts.getText()+"','"+ftr.getText()+"')";
        executeQuery(query);
        TrayNotification tray = new TrayNotification();
           
        AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle("Reclamation Sent");
            tray.setMessage("You successufuly sent your reclamation");
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.millis(1000));
        showReclamations();
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
    


}
