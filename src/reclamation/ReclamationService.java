/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reclamation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ACER
 */
import utils.ConnetionSingletion;
public class ReclamationService {
    
    private static ReclamationService instance;
    Connection cnx =  ConnetionSingletion.getInstance().getCnx();
    private Statement statement;
    private ResultSet resultSet;
    
    public ReclamationService() {
        ConnetionSingletion cs = ConnetionSingletion.getInstance();
        try {
            statement = cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ReclamationService getInstance() {
        if (instance == null)
            instance = new ReclamationService();
        return instance;
    }
    public ObservableList<Reclamations> getReclamationsList() {
        ObservableList<Reclamations> reclamationList = FXCollections.observableArrayList();
        String query = "SELECT * FROM reclamation";
      
        try {
            statement = cnx.createStatement();
            resultSet = statement.executeQuery(query);
            Reclamations reclamation;
                while (resultSet.next()) {
                 reclamation = new Reclamations(resultSet.getInt("reclamation_id"), resultSet.getInt("user_id"), resultSet.getString("email"), resultSet.getString("subject"), resultSet.getString("reclamation"));
                reclamationList.add(reclamation);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return reclamationList;
    }

}
