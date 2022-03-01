/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingmanagement;

import entity.Booking;
import entity.Stay;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import service.BookingService;
import service.StayService;

/**
 *
 * @author Mortadha
 */
public class BookingManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Date d1 =Date.valueOf(LocalDate.of(2022, Month.MARCH, 17));
        Date d2 =Date.valueOf(LocalDate.of(2022, Month.APRIL, 17));
        Date d3 =Date.valueOf(LocalDate.now());
        Stay s=new Stay(5, 2, "description", d1, d2);
        Booking b=new Booking(5, 3, d3, d1, d2);
        StayService ss=new StayService();
        BookingService bs=new BookingService();
        //ss.add(s);
        //System.out.println(ss.findAll());
        //bs.add(b);
        System.out.println(bs.findAll());
    }
    
}
