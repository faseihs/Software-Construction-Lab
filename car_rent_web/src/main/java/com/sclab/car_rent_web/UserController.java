/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sclab.car_rent_web;

import java.util.Random;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Faseih Saad
 */
public class UserController {
    public static boolean register(User user){
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Admin.class).addAnnotatedClass(User.class).addAnnotatedClass(Car.class);
        SessionFactory sf=con.buildSessionFactory();
        Session ses=sf.openSession();
         Transaction tx=ses.beginTransaction();
        
        //Adding Admin in the database
        try{
            Random rn=new Random();
            user.setU_id(rn.nextInt(1000));
            ses.save(user);
            tx.commit();
            return true;
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            tx.rollback();
            return false;
        }
       
    }
    
    public static User getUserbyEmail(String email){
        Configuration con = new Configuration().configure().addAnnotatedClass(Admin.class).addAnnotatedClass(User.class).addAnnotatedClass(Car.class);
        SessionFactory sf=con.buildSessionFactory();
        Session ses=sf.openSession();
    
        return (User)ses.createQuery("From User where u_email = :email").setString("email", email).uniqueResult();
        
    }
    
    public static boolean updateUser(User user){
        Configuration con = new Configuration().configure().addAnnotatedClass(Admin.class).addAnnotatedClass(User.class).addAnnotatedClass(Car.class);
        SessionFactory sf=con.buildSessionFactory();
        Session ses=sf.openSession();
         Transaction tx=ses.beginTransaction();
        
        //Adding Admin in the database
        try{
            ses.merge(user);
            tx.commit();
            return true;
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            tx.rollback();
            return false;
        }
    }
}
