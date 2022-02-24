/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.dao;

import com.esprit.entity.User;
import com.esprit.utils.ConnexionSingleton;
import java.sql.Connection;
import java.sql.Date;
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

/**
 *
 * @author jaray
 */
public class UserDao implements Idao<User> {

    Connection cnx = ConnexionSingleton.getInstance().getCnx();
    private static UserDao instance;
    private Statement st;
    private ResultSet rs;

    private UserDao() {
        ConnexionSingleton cs = ConnexionSingleton.getInstance();
        try {
            st = cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static UserDao getInstance() {
        if (instance == null) {
            instance = new UserDao();
        }
        return instance;
    }

    @Override
    public void insert(User o) {
        String req = "insert into users (name,lastname,typeAccount,nationality,birthdate) values ('" + o.getName() + "','" + o.getLastname() + "','" + o.getTypeAccount() + "','" + o.getNationality() + "','" + o.getBirthdate() + "')";
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(User o) {
        String req = "delete from users where id=" + o.getId();
        User p = displayById(o.getId());

        if (p != null) {
            try {

                st.executeUpdate(req);

            } catch (SQLException ex) {
                Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("n'existe pas");
        }
    }

    @Override
    public ObservableList<User> displayAll() {
        String req = "select * from users";
        ObservableList<User> list = FXCollections.observableArrayList();

        try {
            rs = st.executeQuery(req);
            while (rs.next()) {
                User p = new User();
                p.setId(rs.getInt(1));
                p.setName(rs.getString("name"));
                p.setLastname(rs.getString(3));
                p.setTypeAccount(rs.getString(4));
                p.setNationality(rs.getString(5));
               // p.setBirthdate(rs.getString(6));

                list.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<User> displayAllList() {
        String req = "select * from users";
        List<User> list = new ArrayList<>();

        try {
            rs = st.executeQuery(req);
            while (rs.next()) {
                User p = new User();
                p.setId(rs.getInt(1));
                p.setName(rs.getString("name"));
                p.setLastname(rs.getString(3));
                p.setTypeAccount(rs.getString(4));
                p.setNationality(rs.getString(5));
               // p.setBirthdate(rs.getString(6));

                list.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public User displayById(int id) {
        String req = "select * from users where id =" + id;
        User p = new User();
        try {
            rs = st.executeQuery(req);
            // while(rs.next()){
            rs.next();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setLastname(rs.getString("lastname"));
            p.setTypeAccount(rs.getString(4));
            p.setNationality(rs.getString(5));
            // p.setBirthdate(rs.getString(6));
            //}  
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public boolean update(User p) {
        String qry = "UPDATE users SET name = '" + p.getName() + "', lastname = '" + p.getLastname() + "', typeAccount = '" + p.getTypeAccount() + "', nationality = '" + p.getNationality() + "', birthdate = '" + p.getBirthdate() + "' WHERE id = " + p.getId();

        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void updatev2(User os) {
        try {
            if (os.getName() != null) {

                PreparedStatement pstm = cnx.prepareStatement("update user set name=? , lastname=? , typeAccount=? , nationality=?  where id=?");
                pstm.setInt(5, os.getId());
                pstm.setString(1, os.getName());
                pstm.setString(2, os.getLastname());
                pstm.setString(3, os.getTypeAccount());
                pstm.setString(4, os.getNationality());
               // pstm.setDate(5, (Date) os.getBirthdate());
                // pstm.setString(6, u.getEmail());
                //pstm.setString(7, u.getPhoto());

                int i = pstm.executeUpdate();
                System.out.println(i + " Data Updated Successfully");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
