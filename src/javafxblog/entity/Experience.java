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
public class Experience {
    private int id_Experience;
    private int id_author;
    private String title_Content;
    private String txt_Content;
    private int likes_Content;
    private String date;

    public Experience(int id_Experience, int id_author, String title_Content, String txt_Content, int likes_Content, String date) {
        this.id_Experience = id_Experience;
        this.id_author = id_author;
        this.title_Content = title_Content;
        this.txt_Content = txt_Content;
        this.likes_Content = likes_Content;
        this.date = date;
    }
    
    public Experience(int id_author, String title_Content, String txt_Content, int likes_Content, String date) {
        this.id_author = id_author;
        this.title_Content = title_Content;
        this.txt_Content = txt_Content;
        this.likes_Content = likes_Content;
        this.date = date;
    }

    public Experience(int id_Experience, String title_Content, String txt_Content) {
        this.id_Experience = id_Experience;
        this.title_Content = title_Content;
        this.txt_Content = txt_Content;
    }
    

    public Experience() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    public int getId_Experience() {
        return id_Experience;
    }

    public void setId_Experience(int id_Experience) {
        this.id_Experience = id_Experience;
    }

    public int getId_author() {
        return id_author;
    }

    public void setId_author(int id_author) {
        this.id_author = id_author;
    }

    public String getTitle_Content() {
        return title_Content;
    }

    public void setTitle_Content(String title_Content) {
        this.title_Content = title_Content;
    }

    public String getTxt_Content() {
        return txt_Content;
    }

    public void setTxt_Content(String txt_Content) {
        this.txt_Content = txt_Content;
    }

    public int getLikes_Content() {
        return likes_Content;
    }

    public void setLikes_Content(int likes_Content) {
        this.likes_Content = likes_Content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Experience{" + "id_Experience=" + id_Experience + ", id_author=" + id_author + ", title_Content=" + title_Content + ", txt_Content=" + txt_Content + ", likes_Content=" + likes_Content + ", date=" + date + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id_Experience;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Experience other = (Experience) obj;
        if (this.id_Experience != other.id_Experience) {
            return false;
        }
        return true;
    }

 
     
    
}
