


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controller;

//import com.esprit.entity.Personne;
import com.esprit.entity.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jaray
 */
public class DisplayUserController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<User> personsTable;
    @FXML
    private TableColumn<User, String> NomColonne;
    @FXML
    private TableColumn<User, String> PrenomColonne;

    @FXML
    private Label idLabel;
    @FXML
    private Label nomLabel;
    @FXML
    private Label prenomLabel;

    private ListData2 listdata = new ListData2();

    @FXML
    private Button btn_pie;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
/*          personsTable.setItems(listdata.getUsers());
        NomColonne.setCellValueFactory(cell -> cell.
                getValue().getName());
        PrenomColonne.setCellValueFactory(cell -> cell.
                getValue().getLastname());
        */
        ///eli elfou9 lezmou yarjaa mbaad
        
        personsTable.setOnMouseClicked(event->{
        idLabel.setText(String.valueOf(listdata.getUsers()
                .get(personsTable.getSelectionModel().getSelectedIndex())
                .getId()));
        nomLabel.setText(listdata.getUsers()
                .get(personsTable.getSelectionModel().getSelectedIndex())
                .getName());
        prenomLabel.setText(listdata.getUsers()
                .get(personsTable.getSelectionModel().getSelectedIndex())
                .getLastname());
    
  
        });
    
     //Redirection vers l'interface PieChart
        btn_pie.setOnAction(event->{
            try {
                System.out.println("testttttttttttttt");
                Parent pagePieChart=FXMLLoader.load(getClass().getResource("/com/esprit/view/PieChartView.fxml"));
                Scene scene=new Scene(pagePieChart);
                Stage stage=(Stage) ((Node) event.getSource())
                        .getScene()
                        .getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AfficherPersonneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    
}
