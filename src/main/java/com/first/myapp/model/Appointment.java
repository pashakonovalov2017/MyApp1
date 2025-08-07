package com.first.myapp.model;


import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class Appointment {
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dateTime;
    private String content;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    @Column(name="appointment_type")
    private AppointmentType appointmentType;

    public Appointment(){}

    public Appointment(String name, LocalDateTime appointment, String content, AppointmentType appointmentType){
        this.name = name;
        this.dateTime = appointment;
        this.content = content;
        this.appointmentType = appointmentType;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setAppointmentType(AppointmentType appointmentType) {
        this.appointmentType = appointmentType;
    }

    public Long getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public LocalDateTime getDateTime() {
        return this.dateTime;
    }
    public String getContent() {
        return this.content;
    }
    public AppointmentType getAppointmentType() {
        return this.appointmentType;
    }


}
