package com.stc.clinic.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class AppointmentDTO  {


    private Long id;

    private String appointmentDate;

    private AppointmentStatusDTO appointmentStatus;

    private String appointmentCancellationReason;

    private List<PatientDTO> patients;

}
