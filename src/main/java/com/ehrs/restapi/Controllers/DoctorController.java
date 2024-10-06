package com.ehrs.restapi.Controllers;
import java.io.IOException;
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
import com.ehrs.restapi.Models.ModelDoctors;
import com.ehrs.restapi.Repository.DoctorsRepository;


//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/v1/")
public class DoctorController {
    @Autowired
	private DoctorsRepository doctorRepository;
	
	// get all doctors
	@GetMapping("/doctors")
	public List<ModelDoctors> getAllRecords(){
		try
		{
			return doctorRepository.findAll();
		}
		catch(Exception e)
		{
			DatabaseLogger.logToDatabase("/doctors", e.getMessage());
			throw new InternalServerErrorException("/doctors","Error occurred while getting the record.");
		}
	}	

    // create Patient rest api
	@PostMapping("/doctor/create")
	public ModelDoctors createNewRecord(@RequestBody ModelDoctors addRecordPayload) {
		try
		{
			return doctorRepository.save(addRecordPayload);   
		}
		catch(Exception e)
		{
			DatabaseLogger.logToDatabase("/doctors/create", e.getMessage());
			throw new InternalServerErrorException("/doctors/create","Error occurred while getting the record.");
		}
	}

	// get Patient by id rest api
	@GetMapping("/doctor/{id}")
	public ResponseEntity<ModelDoctors> getRecordById(@PathVariable Integer id) {
		try
		{
			ModelDoctors record = doctorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("getAppointmentById/doctor/{id}","doctor profile not exist with System Id :" + id));
			return ResponseEntity.ok(record);
		}
		catch(Exception e)
		{
			DatabaseLogger.logToDatabase("getRecordById/doctor/{id}", e.getMessage());
			throw new InternalServerErrorException("getRecordById/doctor/{id}","Error occurred while getting the record.");
		}
	}
	
    // get Doctor by id rest api
    //@RequestMapping(value = "/doctor/getdocnewnumber", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping(value = "/doctor/getdocnewnumber", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getNewDoctorNumber() {
		List<String> record = doctorRepository.getNewDoctorNumber();
		try
		{
	        String recnumber = "-1";
	        if(record.size() > 0)
	        {
	        	recnumber = record.getFirst();
	        }
			return ResponseEntity.ok(recnumber);
		}
		catch(Exception e)
		{
			DatabaseLogger.logToDatabase("getdocnewnumber/doctor/{id}", e.getMessage());
			throw new InternalServerErrorException("getdocnewnumber/doctor/{id}","Error occurred while getting the record.");
		}
	}

    // update Doctor rest api
	@PutMapping("/doctor/{id}")
	public ResponseEntity<ModelDoctors> updateRecordById(@PathVariable Integer id, @RequestBody ModelDoctors updatePayloadRecord){
		ModelDoctors update = doctorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("updatedoctorprofile/doctor/{id}", "doctor profile not exist with id :" + id));
		try
		{
                update.setDocasst_number(updatePayloadRecord.getDocasst_number());
                update.setAdhaar_number(updatePayloadRecord.getAdhaar_number());
                update.setFirst_name(updatePayloadRecord.getFirst_name());
                update.setLast_name(updatePayloadRecord.getLast_name());
                update.setGender(updatePayloadRecord.getGender());
                update.setDob(updatePayloadRecord.getDob());
                update.setEmail(updatePayloadRecord.getEmail());
                update.setPrefix(updatePayloadRecord.getPrefix());
                update.setMobile(updatePayloadRecord.getMobile());
                update.setWhatsapp(updatePayloadRecord.getWhatsapp());
                update.setSpecialization(updatePayloadRecord.getSpecialization());
                update.setStatus(updatePayloadRecord.isStatus());
                //system column
                update.setCreated(updatePayloadRecord.getCreated());
                update.setCreated_by(updatePayloadRecord.getCreated_by());
                update.setUpdated(updatePayloadRecord.getUpdated());
                update.setUpdated_by(updatePayloadRecord.getUpdated_by());
                ModelDoctors updatedRecord = doctorRepository.save(update);
                return ResponseEntity.ok(updatedRecord);
		}
		catch(Exception e)
		{
			DatabaseLogger.logToDatabase("updateRecordById/doctor/{id}", e.getMessage());
			throw new InternalServerErrorException("updateRecordById/doctor/{id}","Error occurred while getting the record.");
		}
	}

    // delete Patient rest api
    @DeleteMapping("/doctor/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteRecordById(@PathVariable Integer id){
    	ModelDoctors record = doctorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("deletePatient/doctor/{id}","doctor profile not exist with id :" + id));
    	try
    	{
	        doctorRepository.delete(record);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return ResponseEntity.ok(response);
    	}
		catch(Exception e)
		{
			DatabaseLogger.logToDatabase("deleteRecordById/doctor/{id}", e.getMessage());
			throw new InternalServerErrorException("deleteRecordById/doctor/{id}","Error occurred while getting the record.");
		}
    }

}
