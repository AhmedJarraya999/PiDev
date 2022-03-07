/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rating;

/**
 *
 * @author ACER
 */
public class rating { 
    
    private int rating_id;
    private String rating;
    private String comment;
    
    Stay s;
    User u;

    public rating(int rating_id, int stay_id, int user_id, String rating, String comment) {
        this.rating_id = rating_id;
        this.s = new Stay();
        this.u =new User();
        this.rating = rating;
        this.comment = comment;
    }

    public rating(int stay_id, int user_id, String rating, String comment) {
        this.s = new Stay();
        this.u =new User();
        this.rating = rating;
        this.comment = comment;
    }
    
    public rating(String rating, String comment) {
        this.rating = rating;
        this.comment = comment;
    }

    public int getRating_Id() {
        return rating_id;
    }
    
    public String getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public void setRating_Id(int rating_id) {
        this.rating_id = rating_id;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    
}
