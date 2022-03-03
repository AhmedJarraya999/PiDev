/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
import entity.Role;
import entity.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import services.UserService;
import utils.CryptWithMD5;

/**
 * FXML Controller class
 *
 * @author Mortadha
 */
public class AuthentificationController implements Initializable {

    @FXML
    private AnchorPane defaultLayer;
    @FXML
    private AnchorPane mainLayer;
    @FXML
    private VBox vbox0;
    @FXML
    private TextField firstnametf;
    @FXML
    private TextField emailTF;
    @FXML
    private PasswordField passwordPF;
    @FXML
    private TextField phonetf;
    @FXML
    private VBox vbox2;
    @FXML
    private TextField lastnametf;
    @FXML
    private TextField usernametf;
    @FXML
    private JFXButton signupbtn;
    @FXML
    private VBox vbox3;
    @FXML
    private TextField loginTF;
    @FXML
    private PasswordField passwordTF;
    @FXML
    private Label settingLB1;
    @FXML
    private JFXButton btnlogin;
    @FXML
    private Label closeLB;
    @FXML
    private ImageView phoneicon;
    @FXML
    private ImageView passwordIcon;
    @FXML
    private ImageView matFIcon;
    @FXML
    private ImageView deviseIcon;
    @FXML
    private ImageView numtel1Icon;
    @FXML
    private ImageView emailIcon;
    @FXML
    private ImageView passIcon;
    @FXML
    private ImageView rsIcon;
    @FXML
    private Circle reduceBtn;
    @FXML
    private Circle closeBtn;
    @FXML
    private Button btnfp;
    @FXML
    private AnchorPane animLayer;
    @FXML
    private Label varLB;
    @FXML
    private JFXButton signUpBtn;
    @FXML
    private JFXButton swapbtn;
    @FXML
    private Label helloLB;
    

    UserService us=new UserService();
    User u =new User();
    @FXML
    private RadioButton rbhost;
    @FXML
    private RadioButton rbstay;
    @FXML
    private ToggleGroup g1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setloginvisibilite(false);
        setsignupvisibilite(true);
    }    
    
    
    boolean x=false;
    @FXML
    private void swapForm(MouseEvent event) {
        if(x==false){
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.7));
            slide.setNode(animLayer);
            setloginvisibilite(true);
            setsignupvisibilite(false);
            swapbtn.setText("SignUP");
            mainLayer.setTranslateX(-400);
            slide.setToX(689);
            slide.play();
            slide.setOnFinished((e -> {

            }));
            x=true;
        }
        else{
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.7));
            slide.setNode(animLayer);

            mainLayer.setTranslateX(0);
            setloginvisibilite(false);
            setsignupvisibilite(true);
            swapbtn.setText("Login");
            slide.setToX(0);

            slide.play();

            slide.setOnFinished((e -> {

            }));
            x=false;
        }
    }
    public void setloginvisibilite(boolean state){
        settingLB1.setText("Login");
        vbox3.setVisible(state);
        phoneicon.setVisible(state);
        passwordIcon.setVisible(state);
        btnfp.setVisible(state);
        btnlogin.setVisible(state);
        varLB.setVisible(state);
        
        
        
        
    }
    public void setsignupvisibilite(boolean state){
        settingLB1.setText("Signup");
        vbox0.setVisible(state);
        vbox2.setVisible(state);
        rsIcon.setVisible(state);
        emailIcon.setVisible(state);
        passIcon.setVisible(state);
        numtel1Icon.setVisible(state);
        matFIcon.setVisible(state);
        deviseIcon.setVisible(state);
        signupbtn.setVisible(state);
        
        helloLB.setVisible(state);
        
    }

    @FXML
    private void performeSignup(MouseEvent event) {
        String errors="";
        if(firstnametf.getText().trim().isEmpty()){
            errors+="- Please enter a firstname\n";
        }
        if(lastnametf.getText().trim().isEmpty()){
            errors+="- Please enter a lastname\n";
        }
        if(usernametf.getText().trim().isEmpty()){
            errors+="- Please enter a username\n";
        }
        if(emailTF.getText().trim().isEmpty()){
            errors+="- Please enter a email\n";
        }
        if(passwordPF.getText().trim().isEmpty()){
            errors+="- Please enter a password\n";
        }
        if(phonetf.getText().trim().isEmpty()){
            errors+="- Please enter a phone number\n";
        }
        if(rbhost.isSelected()==false && rbstay.isSelected()==false){
            errors+="- Please select a role\n";
        }
        if(errors.length()>0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid inputs");
            alert.setContentText(errors);
            alert.showAndWait();
        }
        else{
            u.setFirstname(firstnametf.getText());
            u.setLastname(lastnametf.getText());
            u.setUsername(usernametf.getText());
            u.setEmail(emailTF.getText());
            u.setPassword(passwordPF.getText());
            u.setPhone(Integer.parseInt(phonetf.getText()));
            if(rbhost.isSelected()){
                u.setRole(Role.HOST);
            }
            else{
                u.setRole(Role.STAY);
            }
            us.add(u);
        }
        
        
    }

    @FXML
    private void performLogIn(MouseEvent event) {
        User login=us.checklogin(loginTF.getText(), CryptWithMD5.cryptWithMD5(passwordTF.getText()));
        if(login!=null){
            if(login.getRole().equals(Role.ADMIN)){
                try {
                    Stage stageclose=(Stage) ((Node)event.getSource()).getScene().getWindow();

                    stageclose.close();
                    Parent root=FXMLLoader.load(getClass().getResource("/GUI/FXMLadmin.fxml"));
                    Stage stage =new Stage();

                    Scene scene = new Scene(root);

                    stage.setTitle("signup");
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(AuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(login.getRole().equals(Role.HOST)){
                System.out.println("interface host");
            }
            else{
                System.out.println("interface GUEST");
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login fail");
            alert.setContentText("invalid username or password");
            alert.showAndWait();
        }
    }

    @FXML
    private void closeScene(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void reduceOnClick(MouseEvent event) {
        Stage currentStage;
        currentStage = (Stage) ((Node) (event.getSource())).getScene().getWindow().getScene().getWindow();
        currentStage.setIconified(true);
        
    }

    @FXML
    private void closeOnClick(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void forgotpassword(ActionEvent event) {
        try {
            Stage stageclose=(Stage) ((Node)event.getSource()).getScene().getWindow();
            
            stageclose.close();
            Parent root=FXMLLoader.load(getClass().getResource("/GUI/FXMLforgotpassword.fxml"));
            Stage stage =new Stage();
            
            Scene scene = new Scene(root);
            
            stage.setTitle("signup");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void signUpForm(MouseEvent event) {
    }

    
}
