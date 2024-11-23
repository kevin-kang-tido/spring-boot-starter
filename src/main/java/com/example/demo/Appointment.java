package com.example.demo;

import java.time.LocalDate;

// dto
public class Appointment {
    private int id;
    private String uname;
    private LocalDate apdate;
    private String location;

    public Appointment(int id, String uname, LocalDate apdate, String location) {
        this.id = id;
        this.uname = uname;
        this.apdate = apdate;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public LocalDate getApdate() {
        return apdate;
    }

    public void setApdate(LocalDate apdate) {
        this.apdate = apdate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
