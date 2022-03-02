/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxblog.dao;

import java.sql.SQLException;
import java.util.List;
import javafx.collections.ObservableList;
import javafxblog.entity.Experience;

/**
 *
 * @author tasni
 */
public interface ExperienceServiceImp <Experience> {
    
    public void add_Experience(Experience experience);
    public void delete_Experience(int id);
    public boolean modify_Experience(Experience experience);
    public ObservableList<Experience> getExperienceList();
    public List<Experience> DisplayExperience() throws SQLException;
    public Experience displayById(int id);
    
}
