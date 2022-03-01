/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Stay;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Myconnection;

/**
 *
 * @author Mortadha
 */
public class StayService implements IService<Stay>{
    Connection cnx;
    public StayService(){
        cnx=Myconnection.getInstance().getCnx();
    }

    @Override
    public void add(Stay t) {
        try {
            Statement st;
            st=cnx.createStatement();
            String query="INSERT INTO `stay`"
                    + "( `capacity`, `description`,"
                    + " `startdate_availability`,"
                    + " `enddate_availability`, `idhost`)"
                    + " VALUES ('"+t.getCapacity()+"','"+t.getDescription()+"',"
                    + "'"+t.getStartdate_availability()+"','"+t.getEnddate_availability()+"',"
                    + "'"+t.getIdhost()+"')";
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(StayService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void update(int id, Stay t) {
        try {
            PreparedStatement st;
            st=cnx.prepareStatement("UPDATE `stay` SET `capacity`=?,`description`=?,"
                    + "`startdate_availability`=?,`enddate_availability`=? WHERE id=?");
            st.setInt(1, t.getCapacity());
            
            st.setString(2,t.getDescription());
            st.setDate(3,new java.sql.Date(t.getStartdate_availability().getTime()));
            st.setDate(4,new java.sql.Date(t.getEnddate_availability().getTime()));
            
            st.setInt(5, id);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StayService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        try {
            Statement st=cnx.createStatement();
            String query="delete from stay where id="+id;
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(StayService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Stay> findAll() {
        List<Stay> ls=new ArrayList<>();
        try {
            Statement st=cnx.createStatement();
            String query="select * from stay";
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                Stay s =new Stay();
                s.setId(rs.getInt("id"));
                s.setCapacity(rs.getInt("capacity"));
                s.setDescription(rs.getString("description"));
                s.setStartdate_availability(rs.getDate("startdate_availability"));
                s.setEnddate_availability(rs.getDate("enddate_availability"));
                s.setIdhost(rs.getInt("idhost"));
                ls.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StayService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ls;
    }
    
}
