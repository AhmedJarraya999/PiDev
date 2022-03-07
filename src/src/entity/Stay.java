/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author Jihene
 */
public class Stay {
    private int id;
    private int capacity;
    private int idhost;
    private String description;
    private Date startdate_availability ;
    private Date enddate_availability ;

    public Stay() {
    }

    public Stay(int capacity, int idhost, String description, Date startdate_availability, Date enddate_availability) {
        this.capacity = capacity;
        this.idhost = idhost;
        this.description = description;
        this.startdate_availability = startdate_availability;
        this.enddate_availability = enddate_availability;
    }

    public Stay(int id, int capacity, int idhost, String description, Date startdate_availability, Date enddate_availability) {
        this.id = id;
        this.capacity = capacity;
        this.idhost = idhost;
        this.description = description;
        this.startdate_availability = startdate_availability;
        this.enddate_availability = enddate_availability;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getIdhost() {
        return idhost;
    }

    public void setIdhost(int idhost) {
        this.idhost = idhost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartdate_availability() {
        return startdate_availability;
    }

    public void setStartdate_availability(Date startdate_availability) {
        this.startdate_availability = startdate_availability;
    }

    public Date getEnddate_availability() {
        return enddate_availability;
    }

    public void setEnddate_availability(Date enddate_availability) {
        this.enddate_availability = enddate_availability;
    }

    @Override
    public String toString() {
        return "Stay{" + "id=" + id + ", capacity=" + capacity + ", idhost=" + idhost + ", description=" + description + ", startdate_availability=" + startdate_availability + ", enddate_availability=" + enddate_availability + '}'+"\n";
    }
    
}
