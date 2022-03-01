/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.Role;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import static utils.CryptWithMD5.cryptWithMD5;
import utils.Myconnection;

/**
 *
 * @author jarrraya
 */
public class UserService implements ISservice<User>{
    Connection cnx;

    public UserService() {
        cnx=Myconnection.getInstance().getCnx();
    }
    

    @Override
    public void add(User t) {
        try {
            Statement st;
            st=cnx.createStatement();
            String query="INSERT INTO `user`( `firstname`, `lastname`, `username`, `email`, `phone`, `password`, `role`) "
                    + "VALUES ('"+t.getFirstname()+"','"+t.getLastname()+"','"+t.getUsername()+"','"+t.getEmail()+"','"+t.getPhone()+"','"+cryptWithMD5(t.getPassword())+"','"+t.getRole()+"')";
            st.executeUpdate(query);
            System.out.println("user added");
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(int id, User t) {
        try {
            PreparedStatement st;
            st=cnx.prepareStatement("UPDATE `user` SET `firstname`=?,`lastname`=?,"
                    + "`username`=?,`email`=?,`phone`=?,"
                    + "`password`=?,`role`=? WHERE id=?");
            st.setString(1, t.getFirstname());
            st.setString(2,t.getLastname());
            st.setString(3,t.getUsername());
            st.setString(4,t.getEmail());
            st.setInt(5, t.getPhone());
            st.setString(6,cryptWithMD5( t.getPassword()));
            st.setString(7, t.getRole().toString());
            
            st.setLong(8, id);
            if (st.executeUpdate()==1){
            System.out.println("user updated");
            }else {
                System.out.println("fail to update");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void delete(int id) {
        try {
            Statement st=cnx.createStatement();
            String query="delete from user where id="+id;
            if(st.executeUpdate(query)==1){
            System.out.println("user deleted");
            }else {
                System.out.println("fail to delete");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<User> findAll() {
        List<User> lu=new ArrayList<>();
        try {
            Statement st=cnx.createStatement();
            String query="select * from user";
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                User u =new User();
                u.setFirstname(rs.getString("firstname"));
                u.setLastname(rs.getString("lastname"));
                u.setEmail(rs.getString("email"));
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPhone(rs.getInt("phone"));
                u.setPassword(cryptWithMD5(rs.getString("password")));                
                u.setRole(Role.valueOf(rs.getString("role")));
                lu.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lu;
    }
    public User checklogin(String username,String password){
        User u=new User();
        try {
            Statement st=cnx.createStatement();
            String query="select * from user where username='"+username+"' AND password='"+password+"'";
            ResultSet rs=st.executeQuery(query);
            if(rs.next()){
                u.setFirstname(rs.getString("firstname"));
                u.setLastname(rs.getString("lastname"));
                u.setEmail(rs.getString("email"));
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPhone(rs.getInt("phone"));
                u.setPassword(cryptWithMD5(rs.getString("password")));                
                u.setRole(Role.valueOf(rs.getString("role")));
            }
            else{
                u=null;
                System.out.println("login fail");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
    public List<User> findByEmail(String email){
         List<User> users = findAll();
         List<User> resultat=users.stream().filter(user->email.equals(user.getEmail())).collect(Collectors.toList());
         if(resultat.isEmpty()){
            System.out.println("l utilisateur n existe pas");
        }else{
            System.out.println("l utilisateur existe");
        }
         return resultat;
     }
    public User findById(long id){
         User u =new User();
          try {
            Statement st=cnx.createStatement();
            String query="select * from user where id="+id;
            ResultSet rs=st.executeQuery(query);
            if(rs.next()){
                
                u.setFirstname(rs.getString("firstname"));
                u.setLastname(rs.getString("lastname"));
                u.setEmail(rs.getString("email"));
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPhone(rs.getInt("phone"));
                u.setPassword(cryptWithMD5(rs.getString("password")));                
                u.setRole(Role.valueOf(rs.getString("role")));
            }else{
                System.out.println("erreru");
                
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
}
