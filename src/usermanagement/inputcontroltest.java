/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usermanagement;

import java.util.regex.Pattern;

/**
 *
 * @author jaray
 */
public class inputcontroltest {
    public static  boolean validEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        if (email.isEmpty()) {
            return false;
        }
        Pattern pat = Pattern.compile(emailRegex);
        return pat.matcher(email).matches();
    }
    public static void main(String[] args) {
        
        String name="edqsgmail.com";
        
        System.out.println("helloworld");
       System.out.println(validEmail(name));
      
    }
}
