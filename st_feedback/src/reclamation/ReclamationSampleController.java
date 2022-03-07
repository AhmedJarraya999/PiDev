/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reclamation;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class ReclamationSampleController {

    @FXML
    private VBox box;
    @FXML
    private Label subject;
    @FXML
    private Label reclamation;

public void setData(Reclamations rec) {
subject.setText(rec.getSubject());
reclamation.setText(rec.getReclamation());
}
    
}
