/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usermanagement;

import entity.Role;
import entity.User;
import services.UserService;
import utils.CryptWithMD5;
import utils.Mailapi;

/**
 *
 * @author Mortadha
 */
public class UserManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        UserService us=new UserService();
        User u =new User("firstname2", "lastname2", "username2", "email2", "password", 6555512, Role.HOST);
        System.out.println(us.findByUsername("user5"));
        System.out.println(us.findByEmailb("user5@gmail.com"));
        
        // Mailapi.send("testapimail63@gmail.com", "TESTapimail2022", u.getEmail(), "Forgot password", "This is your code for updating your password: ");
        //us.add(u);
        //us.delete(2);
        //us.update(1, u);
        //System.out.println(us.findAll());
    }
    
}
