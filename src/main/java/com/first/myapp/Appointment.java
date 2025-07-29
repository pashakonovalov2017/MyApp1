package com.first.myapp;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "appointments")
public class Appointment {
    private String name;
    private LocalDateTime dateTime;
    private String type;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Appointment(){}

    public Appointment(String name, LocalDateTime appointment, String type){
        this.name = name;
        this.dateTime = appointment;
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return this.name;
    }
    public LocalDateTime getDateTime() {
        return this.dateTime;
    }
    public String getType() {
        return this.type;
    }


}
