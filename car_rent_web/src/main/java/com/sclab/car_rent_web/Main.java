/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sclab.car_rent_web;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


/**
 *
 * @author Faseih Saad
 */
public class Main {
    public static void main(String[] argv){
       
        //Creating Admin Object
        Admin admin=new Admin();
        admin.setA_name("Faseih Saad");
        admin.setA_id(1);
        admin.setA_contact(131);
        admin.setA_password("testing");
        admin.setA_email("faseih@gmail.com");
        
        //Creating Car Object;
        
        Car car1=new Car(1,"2018","Toyota","Black",false);
        Car car2=new Car(2,"2018","Mehran","White",false);
        
        //Creating User Object
        User user=new User(1,"Adnan","adnan@gmail.com",131,"testing");
        
        //Adding a car to user object which basically creates a mapping table (rentals table)
        user.getCar().add(car1);
        
        //COnfigueation and Session and Transaction Codes
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Admin.class).addAnnotatedClass(User.class).addAnnotatedClass(Car.class);
        SessionFactory sf=con.buildSessionFactory();
        Session ses=sf.openSession();
         Transaction tx=ses.beginTransaction();
        
        //Adding Admin in the database
        try{
            ses.save(admin);

            ses.save(car1);
            ses.save(car2);
            ses.save(user);
            tx.commit();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            tx.rollback();
        }
       
        
    }
}
