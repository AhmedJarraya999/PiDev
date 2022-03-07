/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entity.User;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import services.UserService;
import utils.CryptWithMD5;

/**
 * FXML Controller class
 *
 * @author jaray
 */
public class ProfileSettingsController implements Initializable {

    @FXML
    private Button p4;
    @FXML
    private AnchorPane ap;
    @FXML
    private Label fnom;
    @FXML
    private Label fprenom;
    @FXML
    private Label ffemail;
    @FXML
    private TextField tfnom;
    @FXML
    private Button btninfo;
    @FXML
    private TextField tfprenom;
    @FXML
    private TextField tfemail;
    @FXML
    private Label tfpw1;
    @FXML
    private Label tfpw2;
    @FXML
    private Button btnpw;
    @FXML
    private PasswordField tfoldpw1;
    @FXML
    private PasswordField tfnewpw;
    @FXML
    private Button fdelete;
    @FXML
    private Label id_user;
    UserService us=new UserService();

    /**
     * Initializes the controller class.
     */
    User u=us.findById(AuthentificationController.idglobal);
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        tfemail.setText(u.getEmail());
        tfnom.setText(u.getFirstname());
        tfprenom.setText(u.getLastname());
       
    }    

    @FXML
    private void changeinfo(ActionEvent event) {
        u.setEmail(tfemail.getText());
        u.setFirstname(tfprenom.getText());
        u.setLastname(tfnom.getText());
        us.update(u.getId(), u);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Account modification");
            alert.setContentText("You have successfully modified your account");
            alert.setHeaderText("Successful account modification");
            alert.showAndWait();
    }

    @FXML
    private void changepassword(ActionEvent event) {
        System.out.println(u.getPassword());
        System.out.println(CryptWithMD5.cryptWithMD5(tfoldpw1.getText()));
        if(u.getPassword().equals(CryptWithMD5.cryptWithMD5(tfoldpw1.getText()))){
            u.setPassword(tfnewpw.getText());
            us.update(u.getId(), u);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("password modification");
            alert.setContentText("You have successfully modified your password ");
            alert.setHeaderText("Successful password modification");
            alert.showAndWait();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid password");
            alert.setContentText("You entred invalid old password please check again");
            alert.showAndWait();
        }
    }

    @FXML
    private void deleteaccount(ActionEvent event) {
        

        Alert.AlertType type = Alert.AlertType.CONFIRMATION;
        Alert alert = new Alert (type, "");
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.getDialogPane().setContentText("press OK or Cancel");
        alert.getDialogPane().setHeaderText("Are you sure you want to delete your account?");
        Optional<ButtonType> result  = alert.showAndWait();
        if (result.get()==ButtonType.OK)
        {
        us.delete(u.getId());
        
                try {
                    Stage stageclose=(Stage) ((Node)event.getSource()).getScene().getWindow();

                    stageclose.close();
                    Parent root=FXMLLoader.load(getClass().getResource("/GUI/Authentification.fxml"));
                    Stage stage =new Stage();

                    Scene scene = new Scene(root);

                    stage.setTitle("signup");
                    stage.setScene(scene);
                    stage.show();
                     }
                   catch (IOException ex) 
                      {
                    Logger.getLogger(AuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
                      }
        }
    
    else  if (result.get()==ButtonType.CANCEL)
    {System.out.println("canceled");}
    }
}
 