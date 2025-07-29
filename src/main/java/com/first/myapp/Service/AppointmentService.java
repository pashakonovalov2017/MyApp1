package com.first.myapp.Service;

import com.first.myapp.Appointment;
import com.first.myapp.Repository.AppointmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    private AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public void add(Appointment appointment) {
        this.appointmentRepository.save(appointment);
    }

    public List<Appointment> getAll() {
        return this.appointmentRepository.findAll();
    }

    /*
    public Appointment findById(Long id){
        return this.appointmentRepository.findById(id);
    }
    */

    public void deleteById(Long id) {
        this.appointmentRepository.deleteById(id);
    }
}
