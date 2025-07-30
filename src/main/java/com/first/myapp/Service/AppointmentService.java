package com.first.myapp.Service;

import com.first.myapp.Appointment;
import com.first.myapp.Repository.AppointmentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    private AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public void add(Appointment appointment) {
        this.appointmentRepository.save(appointment);
    }

    public void update(Appointment appointment, Long id) {
        Optional<Appointment> opt = appointmentRepository.findById(id);
        if (opt.isPresent()) {
            Appointment existing = opt.get();
            existing.setName(appointment.getName());
            existing.setDateTime(appointment.getDateTime());
            existing.setType(appointment.getType());
            this.appointmentRepository.save(existing);
        } else {
            throw new EntityNotFoundException("Appointment not found with id: " + id);
        }
    }

    public List<Appointment> getAll() {
        return this.appointmentRepository.findAll();
    }

    public Optional<Appointment> findById(Long id){
        return this.appointmentRepository.findById(id);
    }

    public void deleteById(Long id) {
        this.appointmentRepository.deleteById(id);
    }

    public void deleteAll() {
        this.appointmentRepository.deleteAll();
    }
}
