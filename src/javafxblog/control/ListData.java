/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxblog.control;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafxblog.dao.ExperienceService;
import javafxblog.entity.Experience;


/**
 *
 * @author tasni
 */
public class ListData {
    
    private ObservableList<Experience> experiences =FXCollections.observableArrayList();

    public ListData(){
        ExperienceService pdao=ExperienceService.getInstance();
        experiences = pdao.displayAll();
        System.out.println(experiences);
    }
    
    public ObservableList<Experience> getPersons(){
        return experiences;
    }
}
    
