/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sclab.car_rent_web;

import java.util.List;
import java.util.Random;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Faseih Saad
 */
public class CarController {
    public static List<Car> getAvailableCars(){
        Configuration con = new Configuration().configure().addAnnotatedClass(Admin.class).addAnnotatedClass(User.class).addAnnotatedClass(Car.class);
        SessionFactory sf=con.buildSessionFactory();
        Session ses=sf.openSession();
         Transaction tx=ses.beginTransaction();
        
        //Adding Admin in the database
        try{
            return ses.createQuery("From Car where C_in_use=false").list();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            tx.rollback();
            return null;
        }
    }
    
    public static Car getCar(int id){
        Configuration con = new Configuration().configure().addAnnotatedClass(Admin.class).addAnnotatedClass(User.class).addAnnotatedClass(Car.class);
        SessionFactory sf=con.buildSessionFactory();
        Session ses=sf.openSession();
         Transaction tx=ses.beginTransaction();
        
        //Adding Admin in the database
        try{
            return (Car)ses.get(Car.class,id);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            tx.rollback();
            return null;
        }
    }
    
    public static boolean updateCar(Car car){
        Configuration con = new Configuration().configure().addAnnotatedClass(Admin.class).addAnnotatedClass(User.class).addAnnotatedClass(Car.class);
        SessionFactory sf=con.buildSessionFactory();
        Session ses=sf.openSession();
         Transaction tx=ses.beginTransaction();
        
        //Adding Admin in the database
        try{
            ses.merge(car);
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
