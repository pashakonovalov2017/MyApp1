package com.first.myapp.Service;

import com.first.myapp.model.Appointment;
import com.first.myapp.Repository.AppointmentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

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
            existing.setContent(appointment.getContent());
            existing.setAppointmentType(appointment.getAppointmentType());
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
