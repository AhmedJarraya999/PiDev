/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rating;

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
public class RatingService {
    
    private static RatingService instance;
    Connection cnx =  ConnetionSingletion.getInstance().getCnx();
    private Statement statement;
    private ResultSet resultSet;
    
    public RatingService() {
        ConnetionSingletion cs = ConnetionSingletion.getInstance();
        try {
            statement = cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(RatingService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static RatingService getInstance() {
        if (instance == null)
            instance = new RatingService();
        return instance;
    }
    public ObservableList<RatingStay> getRatingList() {
        ObservableList<RatingStay> ratingList = FXCollections.observableArrayList();
        String query = "SELECT * FROM rating";
      
        try {
            statement = cnx.createStatement();
            resultSet = statement.executeQuery(query);
            RatingStay rating;
                while (resultSet.next()) {
                 rating = new RatingStay(resultSet.getInt("rating_id"), resultSet.getInt("stay_id"), resultSet.getInt("user_id"), resultSet.getString("rating"), resultSet.getString("comment"));
                ratingList.add(rating);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ratingList;
    }

}

