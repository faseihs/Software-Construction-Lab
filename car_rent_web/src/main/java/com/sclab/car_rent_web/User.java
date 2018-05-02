/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sclab.car_rent_web;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author Faseih Saad
 */
@Entity
public class User {
    @Id
    private int u_id;
    private String u_name;
    private String u_email;
    private int u_contact;
    private String u_password;
    @ManyToMany
    private List<Car> car = new ArrayList<Car>();
    
    
    public List<Car> getCar() {
        return car;
    }

    public void setCar(List<Car> car) {
        this.car = car;
    }
    

    public User(int u_id, String u_name, String u_email, int u_contact, String u_password) {
        this.u_id = u_id;
        this.u_name = u_name;
        this.u_email = u_email;
        this.u_contact = u_contact;
        this.u_password = u_password;
    }

    public User(){};
    
    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_email() {
        return u_email;
    }

    public void setU_email(String u_email) {
        this.u_email = u_email;
    }

    public int getU_contact() {
        return u_contact;
    }

    public void setU_contact(int u_contact) {
        this.u_contact = u_contact;
    }

    public String getU_password() {
        return u_password;
    }

    public void setU_password(String u_password) {
        this.u_password = u_password;
    }
    
    
}
