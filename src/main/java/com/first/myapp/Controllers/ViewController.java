package com.first.myapp.Controllers;

import com.first.myapp.Service.AppointmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ViewController {
    private final AppointmentService appointmentService;

    public ViewController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    ///

    @GetMapping("/create-appointment")
    public String showForm(){
        return "create-appointment-form";
    }

    @GetMapping("/show-timetable")
    public String showTimetable(Model model){
        model.addAttribute("appointments",appointmentService.getAll());
        return "timetable";
    }
}
