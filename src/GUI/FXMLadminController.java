/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entity.Role;
import entity.User;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import services.UserService;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

public class FXMLadminController implements Initializable {

    @FXML
    private ListView<User> listviewuser;
    @FXML
    private TextField tffirstname;
    @FXML
    private TextField tflastname;
    @FXML
    private TextField tfusername;
    @FXML
    private TextField tfemail;
    @FXML
    private TextField tfnumber;
    @FXML
    private PasswordField pfpassword;
    @FXML
    private ComboBox<Role> comborole;
    @FXML
    private TextField tfsearch;
    UserService us=new UserService();
    ObservableList<User> data=FXCollections.observableArrayList();
    int id_update;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        comborole.getItems().setAll(Role.values());
        refreshlist();
        recherche_avance();
    }    

    @FXML
    private void fillforum(MouseEvent event) {
        User u=us.findById(listviewuser.getSelectionModel().getSelectedItem().getId());
        tffirstname.setText(u.getFirstname());
        tflastname.setText(u.getLastname());
        tfemail.setText(u.getEmail());
        
        tfusername.setText(u.getUsername());
        
        
        tfnumber.setText(Integer.toString(u.getPhone()));
        comborole.setValue(u.getRole());
        id_update=u.getId();
    }

    @FXML
    private void add(ActionEvent event) {
        User u =new User();
        String errors="";
        if(tffirstname.getText().trim().isEmpty()){
            errors+="- Please enter a firstname\n";
        }
        if(tflastname.getText().trim().isEmpty()){
            errors+="- Please enter a lastname\n";
        }
        if(tfusername.getText().trim().isEmpty()){
            errors+="- Please enter a username\n";
        }
        if(tfemail.getText().trim().isEmpty()){
            errors+="- Please enter a email\n";
        }
        if(pfpassword.getText().trim().isEmpty()){
            errors+="- Please enter a password\n";
        }
        if(tfnumber.getText().trim().isEmpty()){
            errors+="- Please enter a phone number\n";
        }
        
        if(errors.length()>0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid inputs");
            alert.setContentText(errors);
            alert.showAndWait();
        }
        else{
            u.setFirstname(tffirstname.getText());
            u.setLastname(tflastname.getText());
            u.setUsername(tfusername.getText());
            u.setEmail(tfemail.getText());
            u.setPassword(pfpassword.getText());
            u.setPhone(Integer.parseInt(tfnumber.getText()));
            u.setRole(comborole.getValue());
            us.add(u);
            TrayNotification tray = new TrayNotification();
            
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle("Added user Success");
            tray.setMessage("You successufuly added user in ur application");
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.millis(1000));
        }
        refreshlist();
    }

    @FXML
    private void update(ActionEvent event) {
        User u =new User();
        String errors="";
        if(tffirstname.getText().trim().isEmpty()){
            errors+="- Please enter a firstname\n";
        }
        if(tflastname.getText().trim().isEmpty()){
            errors+="- Please enter a lastname\n";
        }
        if(tfusername.getText().trim().isEmpty()){
            errors+="- Please enter a username\n";
        }
        if(tfemail.getText().trim().isEmpty()){
            errors+="- Please enter a email\n";
        }
        if(pfpassword.getText().trim().isEmpty()){
            errors+="- Please enter a password\n";
        }
        if(tfnumber.getText().trim().isEmpty()){
            errors+="- Please enter a phone number\n";
        }
        
        if(errors.length()>0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid inputs");
            alert.setContentText(errors);
            alert.showAndWait();
        }
        else{
            u.setFirstname(tffirstname.getText());
            u.setLastname(tflastname.getText());
            u.setUsername(tfusername.getText());
            u.setEmail(tfemail.getText());
            u.setPassword(pfpassword.getText());
            u.setPhone(Integer.parseInt(tfnumber.getText()));
            u.setRole(comborole.getValue());
            us.update(id_update,u);
            TrayNotification tray = new TrayNotification();
            
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle("Update user Success");
            tray.setMessage("You successufuly updated user in ur application");
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.millis(1000));
        }
        refreshlist();
    }
    

    @FXML
    private void delete(ActionEvent event) {
        us.delete(listviewuser.getSelectionModel().getSelectedItem().getId());
        TrayNotification tray = new TrayNotification();
            
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle("Delete Success");
            tray.setMessage("User is deleted");
            tray.setNotificationType(NotificationType.WARNING);
            tray.showAndDismiss(Duration.millis(1000));
            refreshlist();
    }
    public void refreshlist(){
        data=FXCollections.observableArrayList(us.findAll());
        listviewuser.setItems(data);
    }
    public void recherche_avance(){
        FilteredList<User> filtereddata=new FilteredList<>(data,b->true);
        tfsearch.textProperty().addListener((observable,oldvalue,newValue) -> {
            filtereddata.setPredicate(user->{
                if(newValue==null||newValue.isEmpty()){
                    return true;
                }
                String lowercasefilter=newValue.toLowerCase();
                if(user.getFirstname().toLowerCase().indexOf(lowercasefilter)!=-1){
                    return true;
                }
                else if(user.getLastname().toLowerCase().indexOf(lowercasefilter)!=-1){
                    return true;
                }
                else if(user.getUsername().toLowerCase().indexOf(lowercasefilter)!=-1){
                    return true;
                }
                else if(user.getEmail().toLowerCase().indexOf(lowercasefilter)!=-1){
                    return true;
                }
                else if(String.valueOf(user.getPhone()).indexOf(lowercasefilter)!=-1){
                    return true;
                }
                else if(user.getRole().toString().toLowerCase().indexOf(lowercasefilter)!=-1){
                    return true;
                }
                
                else{
                    return false;
                }
                
            });
        });
        
        listviewuser.setItems(filtereddata);
    }
    
}
