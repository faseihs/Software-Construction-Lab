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
public class Car {
    @Id
    private int c_id;
    private String c_model;
    private String c_brand;
    private String c_color;
    private boolean c_in_use;
    @ManyToMany(mappedBy="car")
    private List<User> user =new ArrayList<User>();
    public Car(int c_id, String c_model, String c_brand, String c_color, boolean c_in_use) {
        this.c_id = c_id;
        this.c_model = c_model;
        this.c_brand = c_brand;
        this.c_color = c_color;
        this.c_in_use = c_in_use;
    }
    public Car(){
    };

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getC_model() {
        return c_model;
    }

    public void setC_model(String c_model) {
        this.c_model = c_model;
    }

    public String getC_brand() {
        return c_brand;
    }

    public void setC_brand(String c_brand) {
        this.c_brand = c_brand;
    }

    public String getC_color() {
        return c_color;
    }

    public void setC_color(String c_color) {
        this.c_color = c_color;
    }

    public boolean isC_in_use() {
        return c_in_use;
    }

    public List<User> getUser() {
        return user;
    }

    public void setC_in_use(boolean c_in_use) {
        this.c_in_use = c_in_use;
    }

    @Override
    public String toString() {
        return "Car{" + "c_id=" + c_id + ", c_model=" + c_model + ", c_brand=" + c_brand + ", c_color=" + c_color + ", c_in_use=" + c_in_use + '}';
    }
    
}
