package com.ehrs.restapi.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ehrs.restapi.Exception.DatabaseLogger;
import com.ehrs.restapi.Exception.InternalServerErrorException;
import com.ehrs.restapi.Exception.ResourceNotFoundException;
import com.ehrs.restapi.Models.Log;
import com.ehrs.restapi.Models.ModelAppAccessRules;
import com.ehrs.restapi.Models.ModelDoctors;
import com.ehrs.restapi.Repository.DoctorsRepository;
import com.ehrs.restapi.Repository.RepositoryAppAccessRules;
import com.ehrs.restapi.Service.CustomLogService;

@RestController
@RequestMapping("/api/v1/")
public class AppAccessRulesController 
{
	@Autowired
	RepositoryAppAccessRules repositoryAppaccessrules; 
		
	// get all doctors
	@GetMapping("/appaccessrules")
	public List<ModelAppAccessRules> getAllRecords(){
		try
		{
			return repositoryAppaccessrules.findAll();
		}
		catch(Exception e)
		{
			DatabaseLogger.logToDatabase("/repositoryAppaccessrules", e.getMessage());
			throw new InternalServerErrorException("/repositoryAppaccessrules","Error occurred while getting the record.");
		}
	}	

    // create App Access Rules rest api
	@PostMapping("/appaccessrules/create")
	public ModelAppAccessRules createNewRecord(@RequestBody ModelAppAccessRules addRecordPayload) {
		try
		{
			return repositoryAppaccessrules.save(addRecordPayload);   
		}
		catch(Exception e)
		{
			DatabaseLogger.logToDatabase("/repositoryAppaccessrules/create", e.getMessage());
			throw new InternalServerErrorException("/repositoryAppaccessrules/create","Error occurred while getting the record.");
		}
	}

	// get repositoryAppaccessrules by id rest api
	@GetMapping("/appaccessrules/{id}")
	public ResponseEntity<ModelAppAccessRules> getRecordById(@PathVariable Integer id) {
		try
		{
			ModelAppAccessRules record = repositoryAppaccessrules.findById(id).orElseThrow(() -> new ResourceNotFoundException("getAppointmentById/ModelAppAccessRules/{id}","doctor profile not exist with System Id :" + id));
			return ResponseEntity.ok(record);
		}
		catch(Exception e)
		{
			DatabaseLogger.logToDatabase("getappaccessruleById/doctor/{id}", e.getMessage());
			throw new InternalServerErrorException("getappaccessruleById/doctor/{id}","Error occurred while getting the record.");
		}
	}


    // update updateappaccessruleById rest api
	@PutMapping("/appaccessrules/{id}")
	public ResponseEntity<ModelAppAccessRules> updateRecordById(@PathVariable Integer id, @RequestBody ModelAppAccessRules updatePayloadRecord){
		ModelAppAccessRules update = repositoryAppaccessrules.findById(id).orElseThrow(() -> new ResourceNotFoundException("updateappaccessruleById/repositoryAppaccessrules/{id}", "doctor profile not exist with id :" + id));
		try
		{
                update.setLastresponse(null);
                update.setLogin_id(updatePayloadRecord.getLogin_id());
                update.setMobile(updatePayloadRecord.getMobile());
                update.setRole_name(updatePayloadRecord.getRole_name());
                update.setStatus(updatePayloadRecord.isStatus());
                //system column
                update.setCreated(updatePayloadRecord.getCreated());
                update.setCreated_by(updatePayloadRecord.getCreated_by());
                update.setUpdated(updatePayloadRecord.getUpdated());
                update.setUpdated_by(updatePayloadRecord.getUpdated_by());
                ModelAppAccessRules updatedRecord = repositoryAppaccessrules.save(update);
                return ResponseEntity.ok(updatedRecord);
		}
		catch(Exception e)
		{
			DatabaseLogger.logToDatabase("updateappaccessruleById/repositoryAppaccessrules/{id}", e.getMessage());
			throw new InternalServerErrorException("updateappaccessruleById/repositoryAppaccessrules/{id}","Error occurred while getting the record.");
		}
	}

    // delete Patient rest api
    @DeleteMapping("/appaccessrules/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteRecordById(@PathVariable Integer id){
    	ModelAppAccessRules record = repositoryAppaccessrules.findById(id).orElseThrow(() -> new ResourceNotFoundException("deletePatient/doctor/{id}","doctor profile not exist with id :" + id));
    	try
    	{
    		repositoryAppaccessrules.delete(record);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return ResponseEntity.ok(response);
    	}
		catch(Exception e)
		{
			DatabaseLogger.logToDatabase("deleteRecordById/repositoryAppaccessrules/{id}", e.getMessage());
			throw new InternalServerErrorException("deleteRecordById/repositoryAppaccessrules/{id}","Error occurred while getting the record.");
		}
    }
}
