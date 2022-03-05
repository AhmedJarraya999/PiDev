/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Booking;
import entity.Stay;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import utils.Myconnection;

/**
 *
 *@author Jihene
 */
public class BookingService implements IService<Booking>{
    Connection cnx;
    public BookingService(){
        cnx=Myconnection.getInstance().getCnx();
    }
    @Override
    public void add(Booking t) {
        try {
            Statement st1;
            st1=cnx.createStatement();
            String query="INSERT INTO `booking`"
                    + "( `idhost`, `idguest`,"
                    + " `bookingdate`,"
                    + " `firstdate`, `lastdate`)"
                    + " VALUES ('"+t.getIdhost()+"','"+t.getIdguest()+"',"
                    + "'"+t.getBookingdate()+"','"+t.getFirstDate()+"',"
                    + "'"+t.getLastDate()+"')";
            st1.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(BookingService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(int id, Booking t) {
        try {
            PreparedStatement st;
            st=cnx.prepareStatement("UPDATE `booking` SET `idhost`=?,`idguest`=?,"
                    + "`bookingdate`=?,`firstdate`=?,`lastdate`=? WHERE id=?");
            st.setInt(1, t.getIdhost());
            
            st.setInt(2,t.getIdguest());
            st.setDate(3,new java.sql.Date(t.getBookingdate().getTime()));
            st.setDate(4,new java.sql.Date(t.getFirstDate().getTime()));
            st.setDate(5,new java.sql.Date(t.getLastDate().getTime()));
            st.setInt(6, id);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BookingService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        try {
            Statement st=cnx.createStatement();
            String query="delete from booking where id="+id;
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(BookingService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Booking> findAll() {
        List<Booking> lb=new ArrayList<>();
        try {
            Statement st=cnx.createStatement();
            String query="select * from booking";
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                Booking b =new Booking();
                b.setId(rs.getInt("id"));
                b.setIdguest(rs.getInt("idguest"));
                b.setIdhost(rs.getInt("idhost"));
                b.setBookingdate(rs.getDate("bookingdate"));
                b.setFirstDate(rs.getDate("firstdate"));
                b.setLastDate(rs.getDate("lastdate"));
                
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;
    }
    public List<Booking> findByIdhost(int id){
        List<Booking> lb=new ArrayList<>();
        try {
            Statement st=cnx.createStatement();
            String query="select * from booking where idhost="+id;
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                Booking b =new Booking();
                b.setId(rs.getInt("id"));
                b.setIdguest(rs.getInt("idguest"));
                b.setIdhost(rs.getInt("idhost"));
                b.setBookingdate(rs.getDate("bookingdate"));
                b.setFirstDate(rs.getDate("firstdate"));
                b.setLastDate(rs.getDate("lastdate"));
                
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;
    }
    public List<Booking> findByIdguest(int id){
        List<Booking> lb=new ArrayList<>();
        try {
            Statement st=cnx.createStatement();
            String query="select * from booking where idguest="+id;
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                Booking b =new Booking();
                b.setId(rs.getInt("id"));
                b.setIdguest(rs.getInt("idguest"));
                b.setIdhost(rs.getInt("idhost"));
                b.setBookingdate(rs.getDate("bookingdate"));
                b.setFirstDate(rs.getDate("firstdate"));
                b.setLastDate(rs.getDate("lastdate"));
                
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;
        
    }
    public List<Booking> sortedByDate(){
        List<Booking> bookings=findAll();
        List<Booking> resultat=bookings.stream().sorted(Comparator.comparing(Booking::getBookingdate)).collect(Collectors.toList());
        return resultat;
    }
}
