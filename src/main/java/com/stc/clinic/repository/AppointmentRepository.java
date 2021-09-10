package com.stc.clinic.repository;

import com.stc.clinic.domain.Appointment;
import com.stc.clinic.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
   List<Appointment> findAllByAppointmentDate(String date);

}
