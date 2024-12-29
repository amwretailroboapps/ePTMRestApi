package com.ehrs.restapi.controllers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ehrs.restapi.Exception.DatabaseLogger;
import com.ehrs.restapi.Exception.InternalServerErrorException;
import com.ehrs.restapi.Exception.ResourceNotFoundException;
import com.ehrs.restapi.models.ModelAppointment;
import com.ehrs.restapi.repository.AppointmentsRepository;

import jakarta.persistence.Column;


//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/ehrs_almeezan/api/v1/appointment")
public class AppointmentController  {
    @Autowired
	private AppointmentsRepository appointmentRepository;
	
	// get all Patient
	@GetMapping("/all")
	public List<ModelAppointment> getAllRecords(){
		try
		{
			return appointmentRepository.findAll();
		}
		catch(Exception e)
		{
			DatabaseLogger.logToDatabase("/appointment/create", e.getMessage());
			throw new InternalServerErrorException("/appointment/all","Error occurred while creating the record.");
		}
	}	

    // create Patient rest api
	@PostMapping("/create")
	public ModelAppointment createNewRecord(@RequestBody ModelAppointment addRecordPayload) {
		try
		{
			return appointmentRepository.save(addRecordPayload);    
		}
		catch(Exception e)
		{
			DatabaseLogger.logToDatabase("/appointment/create", e.getMessage());
			throw new InternalServerErrorException("/appointment/create","Error occurred while creating the record.");
		}
	}

	// get appointment record by id
	@GetMapping("/{id}")
	public ResponseEntity<ModelAppointment> getRecordById(@PathVariable Integer id) {
		ModelAppointment patient = appointmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("extends ResponseEntityExceptionHandler /appointment/{id}","Appointment not exist with System Id :" + id));
		return ResponseEntity.ok(patient);
	}
	
	// get appointment records by doctor id, appointment date & slot
	@GetMapping("/getappointmentbydocslot")
	public List<ModelAppointment> getAppointmentRecordsByDocSlots( String doctor_id, String appt_date, String slot) 
	{
		try
		{
			return appointmentRepository.getAppointmentRecordsByDocSlots(doctor_id, appt_date,slot );	
		}
		catch(Exception e)
		{
			DatabaseLogger.logToDatabase("getAllRecorgetappointmentbydocslotdsByDoctorId/appointmentscheduler/{id}", e.getMessage());
			throw new InternalServerErrorException("getAllRecordsByDoctorId/appointmentscheduler/{id}","Error occurred while getting the record.");
		}  
	}
		
	// get appointment record by id
	@GetMapping("/getavailableappointment")
	public ModelAppointment getAppointmentRecordForBooking( String doctor_id, String appt_date, String slot ,String appt_time) 
	{
		try
		{
			return appointmentRepository.getAppointmentRecordForBooking(doctor_id, appt_date,slot,appt_time );	
		}
		catch(Exception e)
		{
			DatabaseLogger.logToDatabase("getAllRecordsByDoctorId/appointmentscheduler/{id}", e.getMessage());
			throw new InternalServerErrorException("getAllRecordsByDoctorId/appointmentscheduler/{id}","Error occurred while getting the record.");
		}  
	}
	
    // generate a new appointment number
    @GetMapping(value = "/getappointmentnumber", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getNewAppointmentNumber() {
    	try
    	{
			List<String> record = appointmentRepository.getNewAppointmentNumber();
	        String panumber = "-1";
	        if(record.size() > 0)
	        {
	            panumber = record.get(0).toString();
	        }
			return ResponseEntity.ok(panumber);
    	}
    	catch(Exception e)
		{
			DatabaseLogger.logToDatabase("/appointment/getappointmentnumber", e.getMessage());
			throw new InternalServerErrorException("/appointment/getappointmentnumber","Error occurred while getting the record.");
		}
	}

    // update Appointment rest api
	@PutMapping("/{id}")
	public ResponseEntity<ModelAppointment> updateRecordById(@PathVariable Integer id, @RequestBody ModelAppointment updateRecordPayload){
		ModelAppointment update = appointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("updateAppointment/appointment/{id}","Appointment not exist with id :" + id));
		try
		{
			// Scheduler Data
		    if (updateRecordPayload.getSys_id_scheduler() > 0) {
				update.setSys_id_scheduler(updateRecordPayload.getSys_id_scheduler());
			}
		    if (updateRecordPayload.getSchedule_id() != null) {
				update.setSchedule_id(updateRecordPayload.getSchedule_id());
			}
		    if (updateRecordPayload.getSlot() != null) {
				update.setSlot(updateRecordPayload.getSlot());
			}
			// Doctor Data
			if (updateRecordPayload.getDoctor_id() > 0) {
				update.setDoctor_id(updateRecordPayload.getDoctor_id());
			}
			if (updateRecordPayload.getDoctor_mobile() != null) {
				update.setDoctor_mobile(updateRecordPayload.getDoctor_mobile());
			}
			if (updateRecordPayload.getDoctor_name() != null) {
				update.setDoctor_name(updateRecordPayload.getDoctor_name());
			}
			// Patient Data
			if (updateRecordPayload.getPat_id() > 0) {
				update.setPat_id(updateRecordPayload.getPat_id());
			}
			if (updateRecordPayload.getPat_email() != null) {
				update.setPat_email(updateRecordPayload.getPat_email());
			}
			if (updateRecordPayload.getPat_mobile() != null) {
				update.setPat_mobile(updateRecordPayload.getPat_mobile());
			}
			if (updateRecordPayload.getPat_name() != null) {
				update.setPat_name(updateRecordPayload.getPat_name());
			}
			if (updateRecordPayload.getPat_whatsapp() != null) {
				update.setPat_whatsapp(updateRecordPayload.getPat_whatsapp());
			}
			// Appointment Data
			if (updateRecordPayload.getApply_date() != null) {
				update.setApply_date(updateRecordPayload.getApply_date());
			}
			if (updateRecordPayload.getAppt_date() != null) {
				update.setAppt_date(updateRecordPayload.getAppt_date());
			}
			if (updateRecordPayload.getAppt_message() != null) {
				update.setAppt_message(updateRecordPayload.getAppt_message());
			}
			if (updateRecordPayload.getAppt_number() != null) {
				update.setAppt_number(updateRecordPayload.getAppt_number());
			}
			if (updateRecordPayload.getAppt_time() != null) {
				update.setAppt_time(updateRecordPayload.getAppt_time());
			}
			if (updateRecordPayload.getRegistrDate() != null) {
				update.setRegistrDate(updateRecordPayload.getRegistrDate());
			}
			if (updateRecordPayload.getRemarks() != null) {
				update.setRemarks(updateRecordPayload.getRemarks());
			}
			if (updateRecordPayload.getStatus() != null) {
				update.setStatus(updateRecordPayload.getStatus());
			}
			// system fields
			if (updateRecordPayload.getCreated() != null) {
				 update.setCreated(updateRecordPayload.getCreated());
			} 
			if (updateRecordPayload.getUpdated() != null) {
				update.setUpdated(updateRecordPayload.getUpdated());
			} 
	        
			if (updateRecordPayload.getUpdated_by() > 0) {
				update.setUpdated_by(updateRecordPayload.getUpdated_by());
			}
			if (updateRecordPayload.getCreated_by() > 0) {
				update.setCreated_by(updateRecordPayload.getCreated_by());
			}  
            ModelAppointment updatedRecord = appointmentRepository.save(update);
            return ResponseEntity.ok(updatedRecord);
		}
		catch(Exception e)
		{
			DatabaseLogger.logToDatabase("/appointment/update", e.getMessage());
			throw new InternalServerErrorException("/appointment/update","Error occurred while updating the record.");
		}
	}

    // delete Patient rest api
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteRecordById(@PathVariable Integer id){
    	ModelAppointment record = appointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("deletePatient/appointment/{id}", "Appointment not exist with id :" + id));
    	try
    	{
	        appointmentRepository.delete(record);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return ResponseEntity.ok(response);
    	}
		catch(Exception e)
		{
			DatabaseLogger.logToDatabase("/appointment/delete", e.getMessage());
			throw new InternalServerErrorException("/appointment/delete","Error occurred while deleting the record.");
		}
    }

}
