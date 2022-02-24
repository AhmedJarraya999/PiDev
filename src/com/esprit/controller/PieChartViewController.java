/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controller;

import com.esprit.dao.PersonneDao;
import com.esprit.entity.Personne;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;

/**
 * FXML Controller class
 *
 * @author wiemhjiri
 */
public class PieChartViewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private PieChart pieChart;
    ObservableList<Data> list=FXCollections.
            observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        PersonneDao pdao=PersonneDao.getInstance();
        List<Personne> pers=pdao.displayAllList();
        for(Personne p:pers) {
            list.addAll(
                new Data(p.getNom(), 12.0)             
        );
        }
        pieChart.setAnimated(true);
        pieChart.setData(list);
        
    }

}
