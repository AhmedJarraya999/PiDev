/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entity.Stay;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import service.StayService;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Jihene
 */
public class FXMLhostController implements Initializable {

    @FXML
    private TextField tfcapacity;
    @FXML
    private DatePicker dpstardate;
    @FXML
    private DatePicker dpenddate;
    @FXML
    private TextArea tfdescription;
    StayService ss=new StayService();
    @FXML
    private TableView<Stay> listviewstay;
    ObservableList<Stay> data=FXCollections.observableArrayList();
    @FXML
    private TableColumn<Stay, Integer> idstay;
    @FXML
    private TableColumn<Stay, Integer> capacity;
    @FXML
    private TableColumn<Stay, Integer> idhost;
    @FXML
    private TableColumn<Stay, String> description;
    @FXML
    private TableColumn<Stay, Date> startdate;
    @FXML
    private TableColumn<Stay, Date> enddate;
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        refreshlist();
    }    

    @FXML
    private void gotoview(ActionEvent event) {
        try {
            Stage stageclose=(Stage) ((Node)event.getSource()).getScene().getWindow();
            
            stageclose.close();
            Parent root=FXMLLoader.load(getClass().getResource("/GUI/FXMLviewreservation.fxml"));
            Stage stage =new Stage();
            
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/GUI/newCascadeStyleSheet.css");
            stage.setTitle("View reservation");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLhostController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void disconnect(ActionEvent event) {
        System.exit(0);
    }
    public boolean isNumeric(String strNum) {
    if (strNum == null) {
        return false;
    }
    try {
        double d = Double.parseDouble(strNum);
    } catch (NumberFormatException nfe) {
        return false;
    }
    return true;
}

    @FXML
    private void addstay(ActionEvent event) {
        
        String errors="";
        if(tfcapacity.getText().trim().isEmpty()){
            errors+="- Please enter a capacity\n";
           
        }
        if(tfdescription.getText().trim().isEmpty()){
             errors+="- Please enter a description\n";
        }
        if(dpstardate.getValue()==null){
             errors+="- Please enter a Start date\n";
        }
        if(dpenddate.getValue()==null){
             errors+="- Please enter a End date\n";
        }
        if(!isNumeric(tfcapacity.getText())){
            errors+="- Please enter a valid number";
        }
        if(dpstardate.getValue().compareTo(dpenddate.getValue())>0)
        {
            errors+="- Please enter a valid date";
            
        }
        if(errors.length()>0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Fail add stay");
            alert.setContentText(errors);
            alert.showAndWait();
        }
        else{
            ss.add(new Stay(Integer.parseInt(tfcapacity.getText()),
                5, tfdescription.getText(),
                Date.valueOf(dpstardate.getValue()), 
                Date.valueOf(dpenddate.getValue())));
        TrayNotification tray = new TrayNotification();
            
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle("Stay add Success");
            tray.setMessage("You successufuly added a stay in our application");
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.millis(2000));
            refreshlist();
        }
        
        
        
    }


    @FXML
    private void updatestay(ActionEvent event) {
        String errors="";
        if(tfcapacity.getText().trim().isEmpty()){
            errors+="- Please enter a capacity\n";
           
        }
        if(tfdescription.getText().trim().isEmpty()){
             errors+="- Please enter a description\n";
        }
        if(dpstardate.getValue()==null){
             errors+="- Please enter a Start date\n";
        }
        if(dpenddate.getValue()==null){
             errors+="- Please enter a End date\n";
        }
        if(!isNumeric(tfcapacity.getText())){
            errors+="- Please enter a valid number";
        }
        if(dpstardate.getValue().compareTo(dpenddate.getValue())>0)
        {
            errors+="- Please enter a valid date";
            
        }
        if(errors.length()>0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Fail update stay");
            alert.setContentText(errors);
            alert.showAndWait();
        }
        else{
            ss.update(listviewstay.getSelectionModel().getSelectedItem().getId(),new Stay(Integer.parseInt(tfcapacity.getText()),
                5, tfdescription.getText(),
                Date.valueOf(dpstardate.getValue()), 
                Date.valueOf(dpenddate.getValue())));
        TrayNotification tray = new TrayNotification();
            
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle("Stay update success");
            tray.setMessage("You successufuly updated a stay in our application");
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.millis(2000));
            refreshlist();
        }
    }

    @FXML
    private void deletestay(ActionEvent event) {
        if(listviewstay.getSelectionModel().getSelectedItem()!=null){
            ss.delete(listviewstay.getSelectionModel().getSelectedItem().getId());
            TrayNotification tray = new TrayNotification();
            
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle("Stay delete success");
            tray.setMessage("You successufuly deleted a stay in our application");
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.millis(2000));
            refreshlist();
        }
    }

    @FXML
    private void fillforum(MouseEvent event) {
        Stay s=listviewstay.getSelectionModel().getSelectedItem();
        if(s!=null){
            tfcapacity.setText(String.valueOf(s.getCapacity()));
        tfdescription.setText(s.getDescription());
        Instant instant = Instant.ofEpochMilli(s.getEnddate_availability().getTime());
        LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
        dpenddate.setValue(ldt.toLocalDate());
        Instant instant1 = Instant.ofEpochMilli(s.getStartdate_availability().getTime());
        LocalDateTime ldt1 = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
        dpstardate.setValue(ldt1.toLocalDate());
        }
        
    }
    public void refreshlist(){
        data.clear();
        data=FXCollections.observableArrayList(ss.findAll());
         
        idstay.setCellValueFactory(new PropertyValueFactory<>("id"));
        capacity.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        idhost.setCellValueFactory(new PropertyValueFactory<>("idhost"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        startdate.setCellValueFactory(new PropertyValueFactory<>("startdate_availability"));
        enddate.setCellValueFactory(new PropertyValueFactory<>("enddate_availability"));
        listviewstay.setItems(data);
    }
    
}
