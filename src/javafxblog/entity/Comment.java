/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxblog.entity;

/**
 *
 * @author tasni
 */
public class Comment {
    
    private int comment_id;
    private int comment_author;
    private String comment_content;
    private String comment_date;
    private int comment_likes;

    public Comment(int comment_id, int comment_author, String comment_content, String comment_date, int comment_likes) {
        this.comment_id = comment_id;
        this.comment_author = comment_author;
        this.comment_content = comment_content;
        this.comment_date = comment_date;
        this.comment_likes = comment_likes;
    }

    public Comment(int comment_author, String comment_content, String comment_date, int comment_likes) {
        this.comment_author = comment_author;
        this.comment_content = comment_content;
        this.comment_date = comment_date;
        this.comment_likes = comment_likes;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public int getComment_author() {
        return comment_author;
    }

    public void setComment_author(int comment_author) {
        this.comment_author = comment_author;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public String getComment_date() {
        return comment_date;
    }

    public void setComment_date(String comment_date) {
        this.comment_date = comment_date;
    }

    public int getComment_likes() {
        return comment_likes;
    }

    public void setComment_likes(int comment_likes) {
        this.comment_likes = comment_likes;
    }

    @Override
    public String toString() {
        return "Comment{" + "comment_id=" + comment_id + ", comment_author=" + comment_author + ", comment_content=" + comment_content + ", comment_date=" + comment_date + ", comment_likes=" + comment_likes + '}';
    }

   

    
}
