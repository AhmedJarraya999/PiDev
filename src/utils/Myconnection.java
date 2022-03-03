/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jarrraya
 */
public class Myconnection {
    private final String URL="jdbc:mysql://127.0.0.1:3306/booking" ;
    private final String USER="root";
    private final String PWD="24149100";
    
    private static Connection cnx;
    private static Myconnection instance;

    private Myconnection() {
        
        try {
            cnx=DriverManager.getConnection(URL,USER,PWD);
            System.out.println("connexion etablie avec succes");
        } catch (SQLException ex) {
            Logger.getLogger(Myconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Myconnection getInstance(){
        if (instance==null){
            instance=new Myconnection();
        }else{
            System.out.println("deja connecte");
        }
        return instance;
    }
    
    public static Connection getCnx(){
        return cnx;
    }

    
}
