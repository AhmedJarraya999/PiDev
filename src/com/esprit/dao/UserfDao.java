/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.dao;

import com.esprit.entity.Userf;
import com.esprit.utils.ConnexionSingleton;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author jaray
 */
public class UserfDao implements Idao<Userf>{

    Connection cnx = ConnexionSingleton.getInstance().getCnx();
    private static UserfDao instance;
    private Statement st;
    private ResultSet rs;
    
     private UserfDao() {
        ConnexionSingleton cs = ConnexionSingleton.getInstance();
        try {
            st = cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(UserfDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public static UserfDao getInstance() {
        if (instance == null) {
            instance = new UserfDao();
        }
        return instance;
    }
    @Override
    public void insert(Userf o) {
       String req = "insert into user (name,lastname,identifier,email,tel) values ('" + o.getName() + "','" + o.getLastname() + "','" + o.getIdentifier() + "','" + o.getEmail() + "','" + o.getTel() + "')";
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(UserfDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Userf o) {
        String req = "delete from user where id=" + o.getId();
        Userf p = displayById(o.getId());

        if (p != null) {
            try {

                st.executeUpdate(req);

            } catch (SQLException ex) {
                Logger.getLogger(UserfDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("n'existe pas");
        }
    }

    @Override
    public ObservableList<Userf> displayAll() {
       String req = "select * from user";
        ObservableList<Userf> list = FXCollections.observableArrayList();

        try {
            rs = st.executeQuery(req);
            while (rs.next()) {
                Userf p = new Userf();
                p.setId(rs.getInt(1));
                p.setName(rs.getString("name"));
                p.setLastname(rs.getString(3));
                p.setIdentifier(rs.getString(4));
                p.setTel(rs.getInt(5));
               // p.setBirthdate(rs.getString(6));

                list.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserfDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Userf displayById(int id) {
        String req = "select * from user where id =" + id;
        Userf p = new Userf();
        try {
            rs = st.executeQuery(req);
            // while(rs.next()){
            rs.next();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setLastname(rs.getString("lastname"));
            p.setIdentifier(rs.getString(4));
            p.setEmail(rs.getString(5));
            p.setTel(rs.getInt(6));
            // p.setBirthdate(rs.getString(6));
            //}  
        } catch (SQLException ex) {
            Logger.getLogger(UserfDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public boolean update(Userf os) {
         String qry = "UPDATE user SET name = '" + os.getName() + "', lastname = '" + os.getLastname() + "', Identifier = '" + os.getIdentifier() + "', Email = '" + os.getEmail() + "', Tel = '" + os.getTel() + "' WHERE id = " + os.getId();

        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserfDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void updatev2(Userf os) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }

    

