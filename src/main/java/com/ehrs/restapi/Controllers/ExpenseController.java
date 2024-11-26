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
import com.ehrs.restapi.Models.ModelExpense;
import com.ehrs.restapi.Repository.ExpenseRepository;


//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/ehrs_almeezan/api/v1/")
public class ExpenseController {
    @Autowired
	private ExpenseRepository expenseRepository;
	
	// get all doctors
	@GetMapping("/expense")
	public List<ModelExpense> getAllRecords(){
		try
		{
			return expenseRepository.findAll();
		}
		catch(Exception e)
		{
			DatabaseLogger.logToDatabase("/expense", e.getMessage());
			throw new InternalServerErrorException("/expense","Error occurred while getting the record.");
		}
	}	

    // create Patient rest api
	@PostMapping("/expense/create")
	public ModelExpense createNewRecord(@RequestBody ModelExpense addRecordPayload) {
		try
		{
			return expenseRepository.save(addRecordPayload);   
		}
		catch(Exception e)
		{
			DatabaseLogger.logToDatabase("/expense/create", e.getMessage());
			throw new InternalServerErrorException("/expense/create","Error occurred while getting the record.");
		}
	}

	// get Patient by id rest api
	@GetMapping("/expense/{id}")
	public ResponseEntity<ModelExpense> getRecordById(@PathVariable Integer id) {
		try
		{
			ModelExpense record = expenseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("getAppointmentById/expense/{id}","doctor profile not exist with System Id :" + id));
			return ResponseEntity.ok(record);
		}
		catch(Exception e)
		{
			DatabaseLogger.logToDatabase("getRecordById/expense/{id}", e.getMessage());
			throw new InternalServerErrorException("getRecordById/expense/{id}","Error occurred while getting the record.");
		}
	}
	

    // update Doctor rest api
	@PutMapping("/expense/{id}")
	public ResponseEntity<ModelExpense> updateRecordById(@PathVariable Integer id, @RequestBody ModelExpense updateRecordPayload){
		ModelExpense update = expenseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("updatedoctorprofile/expense/{id}", "doctor profile not exist with id :" + id));
		try
		{
                update.setApproval_date(updateRecordPayload.getApproval_date());
                update.setApproval_staus(updateRecordPayload.isApproval_staus());
                update.setApprover_comments(updateRecordPayload.getApprover_comments());
                update.setExpense_amount(updateRecordPayload.getExpense_amount());
                update.setExpense_attachment(updateRecordPayload.getImageURL());
                update.setExpense_category(updateRecordPayload.getExpense_category());
                update.setExpense_date(updateRecordPayload.getExpense_date());
                update.setExpense_name(updateRecordPayload.getExpense_name());
                update.setExpense_source(updateRecordPayload.getExpense_source());
                update.setReference_num(updateRecordPayload.getReference_num());
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
                ModelExpense updatedRecord = expenseRepository.save(update);
                return ResponseEntity.ok(updatedRecord);
		}
		catch(Exception e)
		{
			DatabaseLogger.logToDatabase("updateRecordById/expense/{id}", e.getMessage());
			throw new InternalServerErrorException("updateRecordById/expense/{id}","Error occurred while getting the record.");
		}
	}

    // delete Patient rest api
    @DeleteMapping("/expense/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteRecordById(@PathVariable Integer id){
    	ModelExpense record = expenseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("deletePatient/expense/{id}","doctor profile not exist with id :" + id));
    	try
    	{
	        expenseRepository.delete(record);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return ResponseEntity.ok(response);
    	}
		catch(Exception e)
		{
			DatabaseLogger.logToDatabase("deleteRecordById/expense/{id}", e.getMessage());
			throw new InternalServerErrorException("deleteRecordById/expense/{id}","Error occurred while getting the record.");
		}
    }

}
