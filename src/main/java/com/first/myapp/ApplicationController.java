package com.first.myapp;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

@Controller
public class ApplicationController {
    private final AppointmentService appointmentService;

    public ApplicationController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/form")
    public String showForm(){
        return "form";
    }

    @GetMapping("/timetable")
    public String showTimetable(Model model){
        model.addAttribute("appointments",appointmentService.getAll());
        return "timetable";
    }

    @PostMapping("/register")
    public String register(@RequestParam String name,
                         @RequestParam @DateTimeFormat(pattern = "HH:mm") LocalTime time,
                         @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date,
                         @RequestParam String type)
    {   LocalDateTime appointment = LocalDateTime.of(date, time);
        appointmentService.add(new Appointment(name,appointment,type));
        return "redirect:/form";}
}
