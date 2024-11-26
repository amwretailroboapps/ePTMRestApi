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
import com.ehrs.restapi.Models.ModelPatient;
import com.ehrs.restapi.Repository.DoctorsRepository;


//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/ehrs_almeezan/api/v1/")
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
	public ResponseEntity<String> createNewRecord(@RequestBody ModelDoctors addRecordPayload) {
		try
		{
			ModelDoctors added = doctorRepository.save(addRecordPayload);
			return ResponseEntity.ok(String.valueOf(added.getSys_id()));	
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
	        	recnumber = record.get(0).toString();
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
	public ResponseEntity<ModelDoctors> updateRecordById(@PathVariable Integer id, @RequestBody ModelDoctors updateRecordPayload){
		ModelDoctors update = doctorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("updatedoctorprofile/doctor/{id}", "doctor profile not exist with id :" + id));
		try
		{
                update.setDocasst_number(updateRecordPayload.getDocasst_number());
                update.setFirst_name(updateRecordPayload.getFirst_name());
                update.setLast_name(updateRecordPayload.getLast_name());
                update.setMobile(updateRecordPayload.getMobile());
                update.setPrefix(updateRecordPayload.getPrefix());
                update.setStatus(updateRecordPayload.isStatus());
                
                if (updateRecordPayload.getAdhaar_number() != null) {
                	update.setAdhaar_number(updateRecordPayload.getAdhaar_number());
                }
                if (updateRecordPayload.getGender() != null) {
                	update.setAdhaar_number(updateRecordPayload.getGender());
                }
                if (updateRecordPayload.getDob() != null) {
                	update.setAdhaar_number(updateRecordPayload.getDob());
                }
                if (updateRecordPayload.getEmail() != null) {
                	update.setAdhaar_number(updateRecordPayload.getEmail());
                }
                if (updateRecordPayload.getWhatsapp() != null) {
                	update.setAdhaar_number(updateRecordPayload.getWhatsapp());
                }
                if (updateRecordPayload.getSpecialization() != null) {
                	update.setAdhaar_number(updateRecordPayload.getSpecialization());
                }
                
                if (updateRecordPayload.getMarital_status() != null) {
                	update.setAdhaar_number(updateRecordPayload.getMarital_status());
                }
                if (updateRecordPayload.getEmergency_contact() != null) {
                	update.setAdhaar_number(updateRecordPayload.getEmergency_contact());
                }
                if (updateRecordPayload.getArea() != null) {
                	update.setAdhaar_number(updateRecordPayload.getArea());
                }
                if (updateRecordPayload.getAddress() != null) {
                	update.setAdhaar_number(updateRecordPayload.getAddress());
                }
                if (updateRecordPayload.getCity() != null) {
                	update.setAdhaar_number(updateRecordPayload.getCity());
                }
                if (updateRecordPayload.getState() != null) {
                	update.setAdhaar_number(updateRecordPayload.getState());
                }
                if (updateRecordPayload.getCountry() != null) {
                	update.setAdhaar_number(updateRecordPayload.getCountry());
                }
                if (updateRecordPayload.getPhoto_path() != null) {
                	update.setPhoto_path(updateRecordPayload.getPhoto_path());
                }
                //system column
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
