package com.first.myapp.Controllers;

import com.first.myapp.Appointment;
import com.first.myapp.Service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/appointment")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    ///

    @PostMapping(value = "/create" , consumes = "application/json")
    public ResponseEntity<Appointment> addAppointmentJSON(@RequestBody Appointment appointment) {
        appointmentService.add(new Appointment(appointment.getName(),appointment.getDateTime(),appointment.getType()));
        return ResponseEntity.ok(appointment);
    }

    @PostMapping(value = "/create" , consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<Appointment> addAppointmentForm(Appointment appointment) {
        appointmentService.add(appointment);
        return ResponseEntity.ok(appointment);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Appointment> changeAppointment(@RequestBody Appointment appointment, @PathVariable Long id) {
        appointmentService.update(appointment,id);
        return findAppointmentById(id);
    }

    ///

    @GetMapping("/get-all")
    public ResponseEntity<List<Appointment>> getAllAppointmets(){
        return ResponseEntity.ok(appointmentService.getAll());
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Appointment> findAppointmentById(@PathVariable Long id){
        Optional<Appointment> optAppointment = appointmentService.findById(id);
        if(optAppointment.isPresent()) {
            return ResponseEntity.ok(optAppointment.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete-by-id/{id}")
    public ResponseEntity<Void> deleteAppointmentById(@PathVariable Long id){
        appointmentService.deleteById(id);
        return ResponseEntity.notFound().build();
    }

    /*     Не сбрасывает ID в базе
    @DeleteMapping("/delete-all")
    public ResponseEntity<Void> deleteAll(){
        appointmentService.deleteAll();
        return ResponseEntity.notFound().build();
    }
    */
}
