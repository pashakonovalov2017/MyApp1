package com.first.myapp.Repository;

import com.first.myapp.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> { }
