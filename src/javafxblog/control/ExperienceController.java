/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxblog.control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafxblog.entity.Experience;

/**
 * FXML Controller class
 *
 * @author tasni
 */
public class ExperienceController implements Initializable {

    @FXML
    private Label lb_title;
    @FXML
    private Label lb_author;
    @FXML
    private Label lb_content;
    @FXML
    private Label lb_likes;
    @FXML
    private Label lb_date;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setData(Experience exp){
        
        
        lb_title.setText(exp.getTitle_Content());
        lb_author.setText(Integer.toString(exp.getId_author()));
        lb_content.setText(exp.getTxt_Content());
        lb_likes.setText(Integer.toString(exp.getLikes_Content()));
        lb_date.setText(exp.getDate());
        
    }
}
