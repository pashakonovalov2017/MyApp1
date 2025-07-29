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


@Controller
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    ///

    @PostMapping(value = "/add_appointment" , consumes = "application/json")
    public void addAppointmentJSON(@RequestBody Appointment appointment) {
        appointmentService.add(new Appointment(appointment.getName(),appointment.getDateTime(),appointment.getType()));
    }

    /*
    @PostMapping(value = "/add_appointment" , consumes = "application/x-www-form-urlencoded")
    public void addAppointmentForm(Appointment appointment) {
        System.out.println(appointment.getName()+appointment.getDateTime()+appointment.getType());
        appointmentService.add(appointment);
    }
    */

    ///

    @GetMapping("/get_all")
    public ResponseEntity<List<Appointment>> getAllAppointmets(){
        return ResponseEntity.ok(appointmentService.getAll());
    }

    /*
    @GetMapping("/find_by_id/{id}")
    public ResponseEntity<Appointment> findAppointmentById(Long id){
        return ResponseEntity.ok(appointmentService.findById(id));
    }
    */

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
