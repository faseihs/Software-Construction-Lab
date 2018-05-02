/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sclab.car_rent_web;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Faseih Saad
 */
@Entity
public class Admin {
    @Id
    private int a_id;
    private String a_name;
    private String a_email;
    private int a_contact;
    private String a_password;

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public String getA_name() {
        return a_name;
    }

    public void setA_name(String a_name) {
        this.a_name = a_name;
    }

    public String getA_email() {
        return a_email;
    }

    public void setA_email(String a_email) {
        this.a_email = a_email;
    }

    public int getA_contact() {
        return a_contact;
    }

    public void setA_contact(int a_contact) {
        this.a_contact = a_contact;
    }

    public String getA_password() {
        return a_password;
    }

    public void setA_password(String a_password) {
        this.a_password = a_password;
    }

    @Override
    public String toString() {
        return "Admin{" + "a_id=" + a_id + ", a_name=" + a_name + ", a_email=" + a_email + ", a_contact=" + a_contact + ", a_password=" + a_password + '}';
    }

    public Admin(int a_id, String a_name, String a_email, int a_contact, String a_password) {
        this.a_id = a_id;
        this.a_name = a_name;
        this.a_email = a_email;
        this.a_contact = a_contact;
        this.a_password = a_password;
    }
    
    public Admin(){};
    
    
}
