/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entity.Booking;
import entity.Stay;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
 * @author Jihene
 */
public class FXMLguestController implements Initializable {
    int id;

    
    @FXML
    private TextField tfsearch;
    ObservableList<Stay> data = FXCollections.observableArrayList();
    StayService ss=new StayService();
    BookingService bs=new BookingService();
    List<Stay> stays=ss.findAll();
    int i=0;
    int max_stays=stays.size();
    @FXML
    private ImageView imageview;
    @FXML
    private Label label;
    @FXML
    private Label labelfamily;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label21;
    @FXML
    private Label labelenddate;
    @FXML
    private Label labelstartdate;
    @FXML
    private Label labeldescription;
    @FXML
    private Label labelcapacity;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
      
        
        Stay s=stays.get(i);
        String picture ="file:" + "C:\\\\Users\\\\Mortadha\\\\Desktop\\\\PiDev-jihene\\\\src\\\\img\\\\stay"+i+".jpg";
        //String familyname=serviceuser.findbyif(s.getIdhost).getNom();
        //label.setText(familyname);
        labelfamily.setText(""+s.getIdhost());
        labelcapacity.setText(""+s.getCapacity());
        labeldescription.setText(""+s.getDescription());
        labelstartdate.setText(""+s.getStartdate_availability());
        labelenddate.setText(""+s.getEnddate_availability());
         Image image = new Image(picture);

        imageview.setImage(image);

        
    }    

    @FXML
    private void disconnect(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void makereservation(ActionEvent event) {
        
        Stay s=stays.get(i);
        if(s!=null){
            Booking b=new Booking();
            
            b.setBookingdate(Date.valueOf(LocalDate.now()));
            b.setFirstDate(s.getStartdate_availability());
            b.setLastDate(s.getEnddate_availability());
            b.setIdhost(s.getIdhost());
            b.setIdguest(5);
            bs.add(b);
            ss.delete(s.getId());
            
        }
        TrayNotification tray = new TrayNotification();
            
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle("Reservation success");
            tray.setMessage("You successufuly make a reservation in our application");
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.millis(1000));
      
            //Mailapi.send("testapimail63@gmail.com", "TESTapimail2022", "jihene.saidi@esprit.tn", "Reservation", "You successfuly make a reservation in our application ");

    }

    @FXML
    private void viewfamily(ActionEvent event) {
        
    }
    /*
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
*/
    @FXML
    private void gotofacebook(ActionEvent event) {
        Runtime rt = Runtime.getRuntime();
        String url = "https://www.facebook.com";
        try {
                rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
        } catch (IOException ioException) {
                ioException.printStackTrace();
        }
    }

    @FXML
    private void next(ActionEvent event) {
        if(i<max_stays-1){
            i++;
            Stay s=stays.get(i);
        
        
        String picture ="file:" + "C:\\\\Users\\\\Mortadha\\\\Desktop\\\\PiDev-jihene\\\\src\\\\img\\\\stay"+i+".jpg";
        //String familyname=serviceuser.findbyif(s.getIdhost).getNom();
        //label.setText(familyname);
        labelfamily.setText(""+s.getIdhost());
        labelcapacity.setText(""+s.getCapacity());
        labeldescription.setText(""+s.getDescription());
        labelstartdate.setText(""+s.getStartdate_availability());
        labelenddate.setText(""+s.getEnddate_availability());
         Image image = new Image(picture);

        imageview.setImage(image);
        }
    }

    @FXML
    private void previous(ActionEvent event) {
        if(i>0){
            i--;
            Stay s=stays.get(i);
        
        
        String picture ="file:" + "C:\\\\Users\\\\Mortadha\\\\Desktop\\\\PiDev-jihene\\\\src\\\\img\\\\stay"+i+".jpg";
        //String familyname=serviceuser.findbyif(s.getIdhost).getNom();
        //label.setText(familyname);
        labelfamily.setText(""+s.getIdhost());
        labelcapacity.setText(""+s.getCapacity());
        labeldescription.setText(""+s.getDescription());
        labelstartdate.setText(""+s.getStartdate_availability());
        labelenddate.setText(""+s.getEnddate_availability());
         Image image = new Image(picture);

        imageview.setImage(image);
        }
    }
    
}
