package Doctors;


import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lamnthe130553
 */
public class Doctor {
    private int id;
    private String name;
    private Date dob;
    private String specialization;
    private int availability;
    private String email;
    private String phone;
    
    public Doctor() {
        
    }

    public Doctor(int id, String name, Date dob, String specialization, int availability, String email, String phone) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.specialization = specialization;
        this.availability = availability;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getAvailabilityName() {
       switch(availability) {
           case 0:
               return "In Vacation";
           case 1:
               return "Available";
           case 2:
               return "Busy in emergency case";
           case 3: 
               return "Diagnosing case";
           default:
               return "Dunno";
       }
    }
    
    public String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(dob);
    }
}
