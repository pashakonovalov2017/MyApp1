package com.first.myapp.Service;

import com.first.myapp.Appointment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService {
    private final List<Appointment> appointments = new ArrayList<>();

    public void add(Appointment appointment){
        appointments.add(appointment);
    }

    public List<Appointment> getAll(){
        return appointments;
    }
}
