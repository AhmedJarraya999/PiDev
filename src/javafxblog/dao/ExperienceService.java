/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxblog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafxblog.entity.Experience;
import javafxblog.utils.ConnetionSingletion;

/**
 *
 * @author tasni
 */
public class ExperienceService implements ExperienceServiceImp<Experience> {
    
    private static ExperienceService instance;
    Connection cnx =  ConnetionSingletion.getInstance().getCnx();
    private Statement statement;
    private ResultSet resultSet;
    
    public ExperienceService() {
        ConnetionSingletion cs = ConnetionSingletion.getInstance();
        try {
            statement = cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ExperienceService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ExperienceService getInstance() {
        if (instance == null)
            instance = new ExperienceService();
        return instance;
    }
 
    
    @Override
    public void add_Experience(Experience experience) {
         String req="insert into experience (id_author,title,content,likes,date) values ('"+experience.getId_author()+"','"+experience.getTitle_Content()+"','"+experience.getTxt_Content()+"','0','"+experience.getDate()+"')";
        try {
            statement.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ExperienceService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
//    @Override
//    public void add_Experience(Experience experience) { 
//      try {
//            String query = "INSERT INTO experience(id_author,title,content,likes,date) VALUES (?,?,?,?,?)";
//            PreparedStatement preparedStatement = ConnetionSingletion.getInstance().getCnx().prepareStatement(query);
//            preparedStatement.setInt(1, experience.getId_author());
//            preparedStatement.setString(2, experience.getTitle_Content());
//            preparedStatement.setString(3, experience.getTxt_Content());
//            preparedStatement.setInt(4, experience.getLikes_Content());
//            preparedStatement.setString(5, experience.getDate());
//            preparedStatement.executeUpdate();
//            
//      } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//        }
//    }
    
    @Override
    public void delete_Experience(int id) {
       try {
         String req="delete from experience where id='"+id+"'";
         PreparedStatement preparedStatement = cnx.prepareStatement(req);
         preparedStatement.executeUpdate();
      } catch (SQLException ex) {
          System.err.println(ex.getMessage());
        }
    }
  

    @Override
    public boolean modify_Experience(Experience experience) {
            String qry = "UPDATE experience SET title = '"+experience.getTitle_Content()+"', content = '"+experience.getTxt_Content()+"' WHERE id = "+experience.getId_Experience();
        
        try {
            if (statement.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ExperienceServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    

    @Override
    public ObservableList<Experience> getExperienceList(){
          String req="select * from experience";
        ObservableList<Experience> list=FXCollections.observableArrayList();       
        
        try {
            resultSet=statement.executeQuery(req);
            while(resultSet.next()){
                Experience e=new Experience();
                e.setId_Experience(resultSet.getInt(1));
                e.setId_author(resultSet.getInt(2));
                e.setTitle_Content(resultSet.getString(3));
                e.setTxt_Content(resultSet.getString(4));
                e.setLikes_Content(resultSet.getInt(5));
                e.setDate(resultSet.getString(6));
                list.add(e);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ExperienceServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
        }

    @Override
    public Experience displayById(int id_Experience) {
   String req="select * from experience where id ="+id_Experience;
           Experience e= new Experience();
        try {
            resultSet=statement.executeQuery(req);
           // while(rs.next()){
            resultSet.next();
                e.setId_Experience(resultSet.getInt("id"));
                e.setId_author(resultSet.getInt("id_author"));
                e.setTxt_Content(resultSet.getString("Content"));
                e.setLikes_Content(resultSet.getInt("likes"));
                e.setTitle_Content(resultSet.getString("title"));
                e.setDate(resultSet.getString("date"));
//}  
        } catch (SQLException ex) {
            Logger.getLogger(ExperienceServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    return e;
        }

    public ObservableList<Experience> displayAll() {
           String req="select * from experience";
        ObservableList<Experience> list=FXCollections.observableArrayList();       
        
        try {
            resultSet=statement.executeQuery(req);
            while(resultSet.next()){
                Experience p=new Experience();
                p.setId_Experience(resultSet.getInt(1));
                p.setId_author(resultSet.getInt(2));
                p.setTitle_Content(resultSet.getString(3));
                p.setTxt_Content(resultSet.getString(4));
                p.setLikes_Content(resultSet.getInt(5));
                p.setDate(resultSet.getString(6));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ExperienceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    @Override
    public List<Experience> DisplayExperience() throws SQLException {
        List<Experience> experiences = new ArrayList<>();
        String req = "select * from experience";
        statement = cnx.createStatement();
        ResultSet rst = statement.executeQuery(req);

        while (rst.next()) {
            Experience e = new Experience(resultSet.getInt("id"),//or rst.getInt(1)
                    resultSet.getInt("id_author"),
                    resultSet.getString("title"),
                    resultSet.getString("content"),
                    resultSet.getInt("likes"),
                    resultSet.getString("date"));
            experiences.add(e);
        }
        return experiences;
    }

    
    }
    



  

