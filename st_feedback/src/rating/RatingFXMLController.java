/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rating;

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
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class RatingFXMLController implements Initializable {
   

    @FXML
    private Button fxmod_btn;
    @FXML
    private Button fxdel_btn;
    @FXML
    private Rating fxrating;
    @FXML
    private TextArea fxcomment;
    @FXML
    private Button fxsub_btn;
    @FXML
    private TableView<rating> fxtvrating;
    @FXML
    private TableColumn<rating, String> fxrating_tv;
    @FXML
    private TableColumn<rating, String> fxcomment_tv;
    @FXML
    private TextField stay_id;
    @FXML
    private TextField user_id;
    
//    Stay s;
//    User u;


    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         showRating();
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource() == fxsub_btn){       
            addRating();
            
        }
        if(event.getSource() == fxmod_btn){       
            updateComment();
            
        }
        if(event.getSource() == fxdel_btn){       
            deleteRating();
            
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
        
        ObservableList<rating> getRating(){
        ObservableList<rating> ratingList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM rating";
        Statement st;
        ResultSet rs;
        
        try{
             st = conn.createStatement();
             rs = st.executeQuery(query);
             rating rate;
             while(rs.next())
             {
                 rate = new rating(rs.getInt("rating_id"), rs.getInt("stay_id"), rs.getInt("user_id"), rs.getString("rating"), rs.getString("comment"));
                 ratingList.add(rate);
             }
    
    }
        catch(Exception ex){
            ex.printStackTrace();
    }
        return ratingList;
    }
    
    private void showRating() {
        
        ObservableList<rating> list = getRating();
        
        fxrating_tv.setCellValueFactory(new PropertyValueFactory<rating, String>("rating"));
        fxcomment_tv.setCellValueFactory(new PropertyValueFactory<rating, String>("comment"));

        fxtvrating.setItems(list);
    }    
        
    private void addRating() {
        String query = "INSERT INTO rating (stay_id, user_id, rating, comment) VALUES ('"+ 
                //Integer.toString(s.getStay_Id()) + "','" + Integer.toString(u.getId()) 
               parseInt(stay_id.getText()) + "','" + parseInt(user_id.getText()) + "','" + Double.toString(fxrating.getRating()) + "','" + fxcomment.getText() + "')";
        executeQuery(query);
        showRating();
    }
    
    private void updateComment(){

        String query = "UPDATE  rating SET rating = '" + Double.toString(fxrating.getRating()) + "', comment = '"  + fxcomment.getText() + "' WHERE stay_id = " + parseInt(stay_id.getText()) + " AND user_id = " + parseInt(user_id.getText())+ "";
        executeQuery(query);
        showRating();
    }
    
    private void deleteRating(){
        String query = "DELETE FROM rating WHERE stay_id = " + parseInt(stay_id.getText()) + " AND user_id = "+ parseInt(user_id.getText())+ "";
        executeQuery(query);
        showRating();
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
