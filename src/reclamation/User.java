/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reclamation;
/**
 *
 * @author ACER
 */
public class User {
    private int userid;
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String password;
    private int phone;


    public User() {
    }

    public User(String firstname, String lastname, String username, String email, String password, int phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public User(int userid, String firstname, String lastname, String username, String email, String password, int phone) {
        this.userid = userid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public int getUser_Id() {
        return userid;
    }

    public void setUser_Id(int id) {
        this.userid = userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" + "userid=" + userid + ", firstname=" + firstname + ", lastname=" + lastname + ", username=" + username + ", email=" + email + ", password=" + password + ", phone=" + phone + '}'+"\n";
    }
    
    
}
