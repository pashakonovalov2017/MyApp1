package com.first.myapp.Controllers;

import com.first.myapp.Appointment;
import com.first.myapp.Service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    ///

    @PostMapping("/register")
    public ResponseEntity<Appointment> register(@RequestBody Appointment appointment) {
        appointmentService.add(new Appointment(appointment.getName(),appointment.getDateTime(),appointment.getType()));
        return ResponseEntity.ok(appointment);
    }

    ///

    @GetMapping("/appointments")
    public ResponseEntity<List<Appointment>> getAppointmentsAsJSON(){
        return ResponseEntity.ok(appointmentService.getAll());
    }

    ///

    @GetMapping("/form")
    public String showForm(){
        return "form";
    }

    @GetMapping("/timetable")
    public String showTimetable(Model model){
        model.addAttribute("appointments",appointmentService.getAll());
        return "timetable";
    }
}
