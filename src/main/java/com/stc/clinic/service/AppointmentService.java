package com.stc.clinic.service;

import com.stc.clinic.domain.Appointment;
import com.stc.clinic.domain.AppointmentStatus;
import com.stc.clinic.domain.Patient;
import com.stc.clinic.dto.AppointmentDTO;
import com.stc.clinic.dto.PatientDTO;
import com.stc.clinic.repository.AppointmentRepository;
import com.stc.clinic.repository.PatientRepository;
import com.stc.clinic.utilities.HelperUtils;
import com.stc.clinic.utilities.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;


    public List<AppointmentDTO> getAllTodayAppointments() {
        String todayDate=HelperUtils.formatDate(LocalDate.now());
        return ObjectMapperUtils.mapAll(appointmentRepository.findAllByAppointmentDate(todayDate), AppointmentDTO.class);
    }

    public AppointmentDTO addNewAppointment(AppointmentDTO appointmentDTO) {
        ArrayList<Patient> patients=new ArrayList<>();
        Appointment newAppointment=ObjectMapperUtils.map(appointmentDTO, Appointment.class);
        Patient patient=ObjectMapperUtils.map(appointmentDTO.getPatients().get(0), Patient.class);
        newAppointment.setAppointmentStatus(AppointmentStatus.CONFIRMED);
        patients.add(patient);
        newAppointment.setPatients(patients);
        return ObjectMapperUtils.map(appointmentRepository.save(newAppointment),AppointmentDTO.class);
    }

    public AppointmentDTO cancelAppointment(AppointmentDTO appointmentDTO){
        Optional<Appointment> cancelledAppointment=appointmentRepository.findById(appointmentDTO.getId());
        cancelledAppointment.get().setAppointmentStatus(AppointmentStatus.CANCELLED);
        cancelledAppointment.get().setAppointmentCancellationReason(appointmentDTO.getAppointmentCancellationReason());
        return ObjectMapperUtils.map(appointmentRepository.save(cancelledAppointment.get()), AppointmentDTO.class);
    }

    public List<AppointmentDTO> getAllAppointmentByDate(String date){
        return ObjectMapperUtils.mapAll(appointmentRepository.findAllByAppointmentDate(date), AppointmentDTO.class);
    }

    public List<PatientDTO> getAllAppointmentByPatientName(String name){
        return ObjectMapperUtils.mapAll(patientRepository.findAllByName(name), PatientDTO.class);
    }

}
