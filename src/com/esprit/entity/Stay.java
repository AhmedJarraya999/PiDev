/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.entity;

import java.util.Date;

/**
 *
 * @author jaray
 */
public class Stay {
int id ;
int idHost;
Date startingAv;
Date endingAv;
int maxnbp;
int minnbp;

    public Stay() {
    }

    public Stay(int id, int idHost, Date startingAv, Date endingAv, int maxnbp, int minnbp) {
        this.id = id;
        this.idHost = idHost;
        this.startingAv = startingAv;
        this.endingAv = endingAv;
        this.maxnbp = maxnbp;
        this.minnbp = minnbp;
    }

    public Stay(int idHost, Date startingAv, Date endingAv, int maxnbp, int minnbp) {
        this.idHost = idHost;
        this.startingAv = startingAv;
        this.endingAv = endingAv;
        this.maxnbp = maxnbp;
        this.minnbp = minnbp;
    }

    public int getId() {
        return id;
    }

    public int getIdHost() {
        return idHost;
    }

    public Date getStartingAv() {
        return startingAv;
    }

    public Date getEndingAv() {
        return endingAv;
    }

    public int getMaxnbp() {
        return maxnbp;
    }

    public int getMinnbp() {
        return minnbp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdHost(int idHost) {
        this.idHost = idHost;
    }

    public void setStartingAv(Date startingAv) {
        this.startingAv = startingAv;
    }

    public void setEndingAv(Date endingAv) {
        this.endingAv = endingAv;
    }

    public void setMaxnbp(int maxnbp) {
        this.maxnbp = maxnbp;
    }

    public void setMinnbp(int minnbp) {
        this.minnbp = minnbp;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Stay other = (Stay) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Stay{" + "id=" + id + ", idHost=" + idHost + ", startingAv=" + startingAv + ", endingAv=" + endingAv + ", maxnbp=" + maxnbp + ", minnbp=" + minnbp + '}';
    }

    



}

