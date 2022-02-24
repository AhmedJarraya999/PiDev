/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.dao;

import com.esprit.entity.Stay;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author jaray
 */
public interface Istay {
    public List<Stay>DisplayStay()throws SQLException;
    public void updateStay(int id, Stay e);
    public void deleteStay(int id);
    public Stay getStayById(int idU);
    public void AddStay(Stay s);
}
