/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.test;

import com.esprit.dao.UserfDao;
import com.esprit.entity.Userf;
import java.util.Date;

/**
 *
 * @author jaray
 */
public class mainf {
    public static void main(String[] args) {
        Date firstDate1 =  new Date();
     //Userf u1= new Userf("Jihene","SAIDI","jonjon123","jihene.saidi@esprit.tn",24149100);
     
        //Userf u3= new Userf("Tasnim","REGAIEG","tas123","tasnim.regaieg@esprit.tn",24149102);
      //  Userf u4= new Userf("Ibtihel","KOUKA","kouka123","ibtihel.kouka@esprit.tn",24149103);
     UserfDao udao =UserfDao.getInstance();
    
        System.out.println( udao.displayById(8));
        // udao.delete(new Userf (8,"salah","SAIDI","jonjon123","jonjon.saidi@esprit.tn",24149100));
         //udao.delete(new Userf (7,"salah","SAIDI","jonjon123","jonjon.saidi@esprit.tn",24149100));
         //udao.delete(new Userf (6,"salah","SAIDI","jonjon123","jonjon.saidi@esprit.tn",24149100));
         //udao.delete(new Userf (5,"salah","SAIDI","jonjon123","jonjon.saidi@esprit.tn",24149100));
         //udao.delete(new Userf (4,"salah","SAIDI","jonjon123","jonjon.saidi@esprit.tn",24149100));
        udao.insert( new Userf("Ahmed","JARRAYA","jarjar","jarraya.ahmed@esprit.tn",24149105) );
         // udao.insert( new Userf("Tasnim","REGAIEG","tas123","regaieg.tasnim@esprit.tn",24149107) );
            // udao.insert( new Userf("Ibtihel","KOUKA","kouka123","kouka.ibtihel@esprit.tn",24149109) );
        
    }
     
     
     
     
    
}
