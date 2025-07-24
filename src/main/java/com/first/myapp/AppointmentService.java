package com.first.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService {
    private final List<Appointment> as = new ArrayList<>();

    public void add(Appointment a){
        as.add(a);
    }

    public List<Appointment> getAll(){
        return as;
    }
}
