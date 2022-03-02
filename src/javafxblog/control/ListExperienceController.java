/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxblog.control;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafxblog.dao.ExperienceService;
import javafxblog.entity.Experience;

/**
 * FXML Controller class
 *
 * @author tasni
 */
public class ListExperienceController implements Initializable {

    @FXML
    private Button btn_add;
    @FXML
    private Button btn_delete;
    @FXML
    private Button btn_modify;
    @FXML
    private TextField tf_idexp;
    
    private List<Experience> TrendingExp;
    @FXML
    private HBox trendExpLayout;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        try {
//            TrendingExp = new ArrayList<>(TrendingExp());
//            for(int i=0; i<TrendingExp.size(); i++){
//                FXMLLoader fxmlLoader = new FXMLLoader();
//                fxmlLoader.setLocation(getClass().getResource("experience.fxml"));
//                HBox expBox = fxmlLoader.load();
//                ExperienceController experienceController = fxmlLoader.getController();
//                experienceController.setData(TrendingExp.get(i));
//                trendExpLayout.getChildren().add(expBox);
//            }
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(ListExperienceController.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(ListExperienceController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//     
        
        
    }    

    @FXML
    private void add_exp(ActionEvent event) {
        
                 try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/javafxblog/view/Add_experience.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ListExperienceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    

    @FXML
    private void delete_exp(ActionEvent event) {
        int ID_exp = Integer.parseInt(tf_idexp.getText());
            ExperienceService experienceservice= ExperienceService.getInstance();
            experienceservice.delete_Experience(ID_exp);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Experience deleted !");
            alert.show();
            tf_idexp.setText("");
            
    }

    @FXML
    private void modify_exp(ActionEvent event) {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader();
            Parent parent = FXMLLoader.load(getClass().getResource("/javafxblog/view/Modify_experience.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
          
            stage.show();
                     } catch (IOException ex) {
                Logger.getLogger(ListExperienceController.class.getName()).log(Level.SEVERE, null, ex);
            }

    }

    @FXML
    private void RfereshList(ActionEvent event) {
//            ExperienceService es= new ExperienceService();
//        try {
//             listexp.setItems(es.DisplayExperience().toString());
//              
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
    }
    
    private List<Experience> TrendingExp() throws SQLException{
        ExperienceService experienceservice= ExperienceService.getInstance();
        List<Experience> ls = new ArrayList<>();
        ObservableList<Experience> experience = experienceservice.getExperienceList();
        ls.add((Experience) experience);
        return ls;
        
        
    }
    
}
