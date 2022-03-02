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
public class Asset {
    private int id_Asset;
    private String image_Asset;

    public Asset(int id_Asset, String image_Asset) {
        this.id_Asset = id_Asset;
        this.image_Asset = image_Asset;
    }
    
    public Asset(String image_Asset) {
        this.image_Asset = image_Asset;
    }

    public int getId_Asset() {
        return id_Asset;
    }

    public void setId_Asset(int id_Asset) {
        this.id_Asset = id_Asset;
    }

    public String getImage_Asset() {
        return image_Asset;
    }

    public void setImage_Asset(String image_Asset) {
        this.image_Asset = image_Asset;
    }

    @Override
    public String toString() {
        return "Asset{" + "id_Asset=" + id_Asset + ", image_Asset=" + image_Asset + '}';
    }
    
    
}
