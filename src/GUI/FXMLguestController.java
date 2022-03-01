/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entity.Booking;
import entity.Stay;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import service.BookingService;
import service.StayService;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import utils.Mailapi;

/**
 * FXML Controller class
 *
 * @author Mortadha
 */
public class FXMLguestController implements Initializable {
    int id;

    @FXML
    private ListView<Stay> listviewstay;
    @FXML
    private TextField tfsearch;
    ObservableList<Stay> data = FXCollections.observableArrayList();
    StayService ss=new StayService();
    BookingService bs=new BookingService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        refreshlist();
        recherche_avance();
    }    

    @FXML
    private void disconnect(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void makereservation(ActionEvent event) {
        Stay s=listviewstay.getSelectionModel().getSelectedItem();
        if(s!=null){
            Booking b=new Booking();
            
            b.setBookingdate(Date.valueOf(LocalDate.now()));
            b.setFirstDate(s.getStartdate_availability());
            b.setLastDate(s.getEnddate_availability());
            b.setIdhost(s.getIdhost());
            b.setIdguest(5);
            bs.add(b);
            ss.delete(s.getId());
            
        
        TrayNotification tray = new TrayNotification();
            
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle("Reservation success");
            tray.setMessage("You successufuly make a reservation in our application, this is your reservation code " + b.getId()  +  "  We wish you  happy holidays" );
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.millis(1000));
        refreshlist();
        String emailmessage ="You successufuly make a reservation in our application, this is your reservation code "  + b.getId() +  "  We wish you  happy holidays :) ";
       //System.out.println(emailmessage);
            Mailapi.send("testapimail63@gmail.com", "TESTapimail2022", "jihene.saidi@esprit.tn", "Reservation", emailmessage);
        }
    }

    @FXML
    private void viewfamily(ActionEvent event) {
        id=listviewstay.getSelectionModel().getSelectedItem().getIdhost();
    }
    public void refreshlist(){
        data=FXCollections.observableArrayList(ss.findAll());
        listviewstay.setItems(data);
    }
    public void recherche_avance(){
        FilteredList<Stay> filtereddata=new FilteredList<>(data,b->true);
        tfsearch.textProperty().addListener((observable,oldvalue,newValue) -> {
            filtereddata.setPredicate(s->{
                if(newValue==null||newValue.isEmpty()){
                    return true;
                }
                String lowercasefilter=newValue.toLowerCase();
                if(String.valueOf(s.getId()).toLowerCase().indexOf(lowercasefilter)!=-1){
                    return true;
                }
                
                else if(String.valueOf(s.getIdhost()).toLowerCase().indexOf(lowercasefilter)!=-1){
                    return true;
                }
                else if(s.getEnddate_availability().toString().toLowerCase().indexOf(lowercasefilter)!=-1){
                    return true;
                }
                
                else if(s.getStartdate_availability().toString().toLowerCase().indexOf(lowercasefilter)!=-1){
                    return true;
                }
                
                else if(s.getDescription().toLowerCase().indexOf(lowercasefilter)!=-1){
                    return true;
                }
                else if(String.valueOf(s.getCapacity()).toLowerCase().indexOf(lowercasefilter)!=-1){
                    return true;
                }
                
                else{
                    return false;
                }
                
            });
        });
        
        listviewstay.setItems(filtereddata);
    }
}
