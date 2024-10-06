package com.ehrs.restapi.Controllers;
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
import com.ehrs.restapi.Models.ModelAppointment;
import com.ehrs.restapi.Repository.AppointmentsRepository;


//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/v1/")
public class AppointmentController  {
    @Autowired
	private AppointmentsRepository appointmentRepository;
	
	// get all Patient
	@GetMapping("/appointments")
	public List<ModelAppointment> getAllRecords(){
		try
		{
			return appointmentRepository.findAll();
		}
		catch(Exception e)
		{
			DatabaseLogger.logToDatabase("/appointments", e.getMessage());
		}
		return null;
	}	

    // create Patient rest api
	@PostMapping("/appointment/create")
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

	// get Patient by id rest api
	@GetMapping("/appointment/{id}")
	public ResponseEntity<ModelAppointment> getRecordById(@PathVariable Integer id) {
		ModelAppointment patient = appointmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("extends ResponseEntityExceptionHandler /appointment/{id}","Appointment not exist with System Id :" + id));
		return ResponseEntity.ok(patient);
	}
	
    // get Appointment by id rest api
    @GetMapping(value = "/appointment/getappointmentnumber", produces = MediaType.APPLICATION_JSON_VALUE)
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
	@PutMapping("/appointment/{id}")
	public ResponseEntity<ModelAppointment> updateRecordById(@PathVariable Integer id, @RequestBody ModelAppointment updatePayloadRecord){
		ModelAppointment update = appointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("updateAppointment/appointment/{id}","Appointment not exist with id :" + id));
		try
		{
            update.setApply_date(updatePayloadRecord.getApply_date());
            update.setAppt_date(updatePayloadRecord.getAppt_date());
            update.setAppt_message(updatePayloadRecord.getAppt_message());
            update.setAppt_number(updatePayloadRecord.getAppt_number());
            update.setAppt_time(updatePayloadRecord.getAppt_time());
            update.setDoctor_id(updatePayloadRecord.getDoctor_id());
            update.setPat_email(updatePayloadRecord.getPat_email());
            update.setPat_id(updatePayloadRecord.getPat_id());
            update.setPat_mobile(updatePayloadRecord.getPat_mobile());
            update.setPat_name(updatePayloadRecord.getPat_name());
            update.setPat_whatsapp(updatePayloadRecord.getPat_whatsapp());
            update.setRegistrDate(updatePayloadRecord.getRegistrDate());
            update.setRemarks(updatePayloadRecord.getRemarks());
            update.setSpecialization(updatePayloadRecord.getSpecialization());
            update.setStatus(updatePayloadRecord.getStatus());
            update.setCreated(updatePayloadRecord.getCreated());
            update.setCreated_by(updatePayloadRecord.getCreated_by());
            update.setUpdated(updatePayloadRecord.getUpdated());
            update.setUpdated_by(updatePayloadRecord.getUpdated_by());
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
    @DeleteMapping("/appointment/{id}")
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
