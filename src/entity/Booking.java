/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author Mortadha
 */
public class Booking {
    private int id;
    private int idhost;
    private int idguest;
    private Date bookingdate;
    private Date firstDate;
    private Date lastDate;

    public Booking() {
    }

    public Booking(int idhost, int idguest, Date bookingdate, Date firstDate, Date lastDate) {
        this.idhost = idhost;
        this.idguest = idguest;
        this.bookingdate = bookingdate;
        this.firstDate = firstDate;
        this.lastDate = lastDate;
    }

    public Booking(int id, int idhost, int idguest, Date bookingdate, Date firstDate, Date lastDate) {
        this.id = id;
        this.idhost = idhost;
        this.idguest = idguest;
        this.bookingdate = bookingdate;
        this.firstDate = firstDate;
        this.lastDate = lastDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdhost() {
        return idhost;
    }

    public void setIdhost(int idhost) {
        this.idhost = idhost;
    }

    public int getIdguest() {
        return idguest;
    }

    public void setIdguest(int idguest) {
        this.idguest = idguest;
    }

    public Date getBookingdate() {
        return bookingdate;
    }

    public void setBookingdate(Date bookingdate) {
        this.bookingdate = bookingdate;
    }

    public Date getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(Date firstDate) {
        this.firstDate = firstDate;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    @Override
    public String toString() {
        return "Booking{" + "id=" + id + ", idhost=" + idhost + ", idguest=" + idguest + ", bookingdate=" + bookingdate + ", firstDate=" + firstDate + ", lastDate=" + lastDate + '}'+"\n";
    }
    
    
}
