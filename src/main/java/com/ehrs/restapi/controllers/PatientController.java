package com.ehrs.restapi.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ehrs.restapi.Exception.DatabaseLogger;
import com.ehrs.restapi.Exception.InternalServerErrorException;
import com.ehrs.restapi.Exception.ResourceNotFoundException;
import com.ehrs.restapi.models.ModelAppLoginUser;
import com.ehrs.restapi.models.ModelPatient;
import com.ehrs.restapi.repository.PatientRepository;

//import com.ehrs.restapi.Exception.DatabaseLogger;
//import com.ehrs.restapi.Exception.InternalServerErrorException;
//import com.ehrs.restapi.Exception.ResourceNotFoundException;
//import com.ehrs.restapi.Models.ModelPatient;
//import com.ehrs.restapi.Repository.PatientRepository;

@RestController
@RequestMapping("/ehrs_almeezan/api/v1/patients")
public class PatientController {
    @Autowired
	private PatientRepository patientRepository;
	
	// get all Patient
	@GetMapping("/all")
	public List<ModelPatient> getAllPatients(){
		try
		{
			return patientRepository.findAll(Sort.by("pnumber").descending());	
		}
		catch(Exception e)
		{
			DatabaseLogger.logToDatabase("getAllPatients/patients", e.getMessage());
			throw new InternalServerErrorException("getAllPatients/patients","Error occurred while getting the record.");
		}  
	}	

	@GetMapping("/searchbymobilename")
    public List<ModelPatient> searchPatientByMobile(@RequestParam String value,@RequestParam String searchmethod) {
        try
        {
        	List<ModelPatient> records = null;
        	if(searchmethod.equals("mobile"))
    		{
        		records = patientRepository.findPatientByMobile(value);
    		}
        	if(searchmethod.equals("name"))
    		{
        		records = patientRepository.findPatientByName(value);
    		}
        	if (records == null) {
            	return (List<ModelPatient>) ResponseEntity.notFound().build();
            }
        	else
        	{
        		return records;
        	}
        }
        catch(Exception e)
		{
			DatabaseLogger.logToDatabase("searchUserByUsernameOrEmail/loginusers", e.getMessage());
			throw new InternalServerErrorException("searchUserByUsernameOrEmail/loginusers","Error occurred while deleting the record.");
		}       
    }
	
    // create Patient rest api
	@PostMapping("/create")
	public ResponseEntity<String> createPatient(@RequestBody ModelPatient createRecordPayload) {
		
		try
		{
			//, MultipartFile userImage
			//createRecordPayload.setUserImage(userImage.getBytes());
			ModelPatient added = patientRepository.save(createRecordPayload);
			return ResponseEntity.ok(String.valueOf(added.getSys_id()));	
		}
		catch(Exception e)
		{
			DatabaseLogger.logToDatabase("createPatient/patients", e.getMessage());
			throw new InternalServerErrorException("createPatient/patients","Error occurred while creating the record.");
		}
	}

    // get Patient by id rest api
	@GetMapping("/{id}")
	public ResponseEntity<ModelPatient> getPatientById(@PathVariable Integer id) {
		ModelPatient patient = patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("getPatientById/patients/{id}","Patient not exist with System Id :" + id));
		try
		{
			return ResponseEntity.ok(patient);
		}
		catch(Exception e)
		{
			DatabaseLogger.logToDatabase("getPatientById/patients", e.getMessage());
			throw new InternalServerErrorException("getPatientById/patients","Error occurred while creating the record.");
		}
	}
    // get Patient by id rest api
    @GetMapping(value = "/getnewpanumber", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getNewPatientNumber() {
		List<String> record = patientRepository.getNewPatientNumber();
		try
		{
			String panumber = "-1";
	        if(record.size() > 0)
	        {
	            panumber = record.get(0).toString();
	        }
			return ResponseEntity.ok(panumber);	
		}
		catch(Exception e)
		{
			DatabaseLogger.logToDatabase("getNewPatientNumber/patients", e.getMessage());
			throw new InternalServerErrorException("getNewPatientNumber/patients","Error occurred while gettting the record.");
		}
	}

    // update Patient rest api
	@PutMapping("/{id}")
	public ResponseEntity<ModelPatient> updatePatient(@PathVariable Integer id, @RequestBody ModelPatient updateRecordPayload){
		ModelPatient update = patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("updatePatient/patients/{id}","Patient not exist with id :" + id));
		try
		{
			update.setAddress(updateRecordPayload.getAddress());
			update.setAdhaar_number(updateRecordPayload.getAdhaar_number());
			update.setAge(updateRecordPayload.getAge());
			update.setCity(updateRecordPayload.getCity());
			update.setCountry(updateRecordPayload.getCountry());
			update.setCreated(updateRecordPayload.getCreated());
			update.setCreated_by(updateRecordPayload.getCreated_by());
			update.setDob(updateRecordPayload.getDob());
			update.setEmail(updateRecordPayload.getEmail());
			update.setEmergency_contact(updateRecordPayload.getEmergency_contact());
			update.setFirst_name(updateRecordPayload.getFirst_name());
			update.setGender(updateRecordPayload.getGender());
			update.setLast_name(updateRecordPayload.getLast_name());
			update.setMarital_status(updateRecordPayload.getMarital_status());
			update.setMobile(updateRecordPayload.getMobile());
			update.setOccupation(updateRecordPayload.getOccupation());
			update.setPnumber(updateRecordPayload.getPnumber());
			update.setPrefix(updateRecordPayload.getPrefix());
			update.setState(updateRecordPayload.getState());
			update.setUpdated(updateRecordPayload.getUpdated());
			update.setUpdated_by(updateRecordPayload.getUpdated_by());
			update.setWhatsapp(updateRecordPayload.getWhatsapp());
			update.setArea(updateRecordPayload.getArea());
			update.setPhoto_path(updateRecordPayload.getPhoto_path());
			//system columns
			
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
			
			ModelPatient updatedRecord = patientRepository.save(update);
			return ResponseEntity.ok(updatedRecord);
		}
		catch(Exception e)
		{
			DatabaseLogger.logToDatabase("updatePatient/patients", e.getMessage());
			throw new InternalServerErrorException("updatePatient/patients","Error occurred while gettting the record.");
		}
		
	}

    // delete Patient rest api
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePatient(@PathVariable Integer id){
        ModelPatient patient = patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("deletePatient/patients/{id}","Patient not exist with id :" + id));
        try
        {
	        patientRepository.delete(patient);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return ResponseEntity.ok(response);
        }
		catch(Exception e)
		{
			DatabaseLogger.logToDatabase("deletePatient/patients", e.getMessage());
			throw new InternalServerErrorException("deletePatient/patients","Error occurred while deleting the record.");
		}
    }

}
