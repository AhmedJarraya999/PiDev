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
public class Reclamations {
    private int reclamation_id; 
    User u;
    final private String email;
    final private String subject;
    final private String reclamation;
    private int user_id;

    public Reclamations(int reclamation_id, int user_id, String email, String subject, String reclamation) {
        this.reclamation_id = reclamation_id;
        this.user_id = user_id;
        this.email = email;
        this.subject = subject;
        this.reclamation = reclamation;
    }

    public Reclamations(int user_id, String email, String subject, String reclamation) {
        this.user_id = user_id;
        this.email = email;
        this.subject = subject;
        this.reclamation = reclamation;
    }

    public int getReclamation_Id() {
        return reclamation_id;
    }

    public String getEmail() {
        return email;
    }

    public String getSubject() {
        return subject;
    }

    public String getReclamation() {
        return reclamation;
    }   
    
    public int getUser_Id() {
        return user_id;
    }

    
}
