package com.first.myapp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Appointment {
    public final String name;
    public LocalDateTime dateTime;
    public String type;
    public Appointment(String name, LocalDateTime appointment, String type){
        this.name = name;
        this.dateTime = appointment;
        this.type = type;
    }

    @Override
    public String toString() {
        DateTimeFormatter dateForm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeForm = DateTimeFormatter.ofPattern("HH:mm");
        return ("<br>___________" +
                "<br>Appointment: <br>    Name:" + this.name +
                "<br>    Date: " + this.dateTime.format(dateForm) +
                "<br>    Time: " + this.dateTime.format(timeForm) +
                "<br>    Type: " + this.type
        );
    }
}
