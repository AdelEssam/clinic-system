package com.stc.clinic.controller;

import com.stc.clinic.dto.AppointmentDTO;
import com.stc.clinic.dto.ResponseMessage;
import com.stc.clinic.service.AppointmentService;
import com.stc.clinic.utilities.HelperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private AppointmentService appointmentService;


    @GetMapping("/all")
    public ResponseEntity<List<AppointmentDTO>> getAllTodayAppointments(){
        List<AppointmentDTO> appointments= appointmentService.getAllTodayAppointments();
        if(appointments.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(appointments);
    }

    @PostMapping("/add")
    public ResponseEntity addAppointment(@Valid @RequestBody AppointmentDTO appointmentRequest){
        AppointmentDTO appointmentDTO= appointmentService.addNewAppointment(appointmentRequest);
        return ResponseEntity.ok(appointmentDTO);
    }

    @GetMapping(value = "/find/{name}")
    public ResponseEntity getAppointmentsByPatientName(@PathVariable String name) {
        try {
            return ResponseEntity.ok().body(appointmentService.getAllAppointmentByPatientName(name));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ResponseMessage(e.getMessage()));
        }
    }

    @PostMapping("/cancel")
    public ResponseEntity cancelAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        try {
            AppointmentDTO cancelledAppointment=appointmentService.cancelAppointment(appointmentDTO);
            return ResponseEntity.ok().body(cancelledAppointment);
        }catch (Exception ex){
            ex.printStackTrace();
            return ResponseEntity.badRequest().body(new ResponseMessage("Unable to cancel appointment"));
        }
    }

    @GetMapping(value = "/find")
    public ResponseEntity getAppointmentsByDate(@RequestParam("from") @DateTimeFormat(pattern="dd-MM-yyyy") String fromDate) {
        try {
            return ResponseEntity.ok().body(appointmentService.getAllAppointmentByDate(fromDate));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ResponseMessage(e.getMessage()));
        }
    }
}
