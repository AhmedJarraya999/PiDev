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
public class RatingStay { 
    
    private int rating_id;
    private String rating;
    private String comment;
    private int user_id;
    private int stay_id;

    
    Stay s;
    User u;

    public RatingStay(int rating_id, int stay_id, int user_id, String rating, String comment) {
        this.rating_id = rating_id;
        this.stay_id = stay_id;
        this.user_id = user_id;
        this.rating = rating;
        this.comment = comment;
    }

    public RatingStay(int stay_id, int user_id, String rating, String comment) {
        this.stay_id = stay_id;
        this.user_id = user_id;
        this.rating = rating;
        this.comment = comment;
    }
    
    public RatingStay(String rating, String comment) {
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
