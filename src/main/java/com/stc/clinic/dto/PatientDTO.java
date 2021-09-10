package com.stc.clinic.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import java.util.List;

@Data
public class PatientDTO {


    private Long id;

    private String name;

    @JsonIgnore
    private List<AppointmentDTO> appointment;

}
