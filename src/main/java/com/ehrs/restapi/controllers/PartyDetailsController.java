package com.ehrs.restapi.controllers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.servlet.function.EntityResponse;

import com.ehrs.restapi.models.*;
import com.ehrs.restapi.repository.*;
import com.ehrs.restapi.Exception.DatabaseLogger;
import com.ehrs.restapi.Exception.InternalServerErrorException;
import com.ehrs.restapi.Exception.ResourceNotFoundException;


@RestController
@RequestMapping("/ehrs_almeezan/api/v1/partydetails")
public class PartyDetailsController {
    @Autowired
	private PartyDetailsRepository partydetailsRepository;
	
	// get all record of partydetails
	@GetMapping("/all")
	public List<ModelPartyDetails> getAllRecords(){
		try
		{
			return partydetailsRepository.findAll();
		}
		catch(Exception e)
		{
			DatabaseLogger.logToDatabase("partydetails/getallparty", e.getMessage());
			throw new InternalServerErrorException("partydetails/getallparty","Error occurred while getting the record.");
		}
	}	
	
	@GetMapping("/getallpartybranch")
	public ResponseEntity<ResponseEntity<List<ModelPartyDetails>>> getAllPartyBranch(@RequestParam String party_id){
		try
		{
			ResponseEntity<List<ModelPartyDetails>> record = partydetailsRepository.getAllPartyBranch(party_id);
			return  ResponseEntity.ok(record);
		}
		catch(Exception e)
		{
			DatabaseLogger.logToDatabase("partydetails/getallparty", e.getMessage());
			throw new InternalServerErrorException("partydetails/getallparty","Error occurred while getting the record.");
		}
	}	

    // create partydetails rest api
	@PostMapping("/create")
	public ResponseEntity<ModelPartyDetails> createNewRecord(@RequestBody ModelPartyDetails addRecordPayload) 
	{
		try
		{
			ModelPartyDetails useradded =  partydetailsRepository.save(addRecordPayload);
			return ResponseEntity.ok(useradded);
		}
		catch(Exception e)
		{
			DatabaseLogger.logToDatabase("partydetails/create", e.getMessage());
			throw new InternalServerErrorException("partydetails/create","Error occurred while creating the record.");
		}
	}

	// get partydetails by id rest api
	@GetMapping("/{id}")
	public ResponseEntity<ModelPartyDetails> getRecordById(@PathVariable Integer id) {
		ModelPartyDetails record = partydetailsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("getLoginuserById/loginusers/{id}","login profile not exist with System Id :" + id));
		return ResponseEntity.ok(record);
	}
	
    // update partydetails rest api
	@PutMapping("/{id}")
	public ResponseEntity<ModelPartyDetails> updateRecordById(@PathVariable Integer id, @RequestBody ModelPartyDetails updateRecordPayload){
		ModelPartyDetails update = partydetailsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("partydetails/updateRecordById/{id}","login profile not exist with id :" + id));
		try
		{
			if (updateRecordPayload.getEmail() != null) {
				update.setEmail(updateRecordPayload.getEmail());
			}
			if (updateRecordPayload.getAddress() != null) {
				update.setAddress(updateRecordPayload.getAddress());
			}
			if (updateRecordPayload.getCity() != null) {
				update.setCity(updateRecordPayload.getCity());
			}		
			if (updateRecordPayload.getContactNumber1() != null) {
				update.setContactNumber1(updateRecordPayload.getContactNumber1());
			}
			if (updateRecordPayload.getContactNumber2() != null) {
				update.setContactNumber2(updateRecordPayload.getContactNumber2());
			}
			if (updateRecordPayload.getContactNumber3() != null) {
				update.setContactNumber3(updateRecordPayload.getContactNumber3());
			}
			if (updateRecordPayload.getContactNumber4() != null) {
				update.setContactNumber4(updateRecordPayload.getContactNumber4());
			}
			if (updateRecordPayload.getContactNumber5() != null) {
				update.setContactNumber5(updateRecordPayload.getContactNumber5());
			}
			if (updateRecordPayload.getCountry() != null) {
				update.setCountry(updateRecordPayload.getCountry());
			}
			if (updateRecordPayload.getEstablished_date() != null) {
				update.setEstablished_date(updateRecordPayload.getEstablished_date());
			}
			if (updateRecordPayload.getName() != null) {
				update.setName(updateRecordPayload.getName());
			}
			if (updateRecordPayload.getNotes() != null) {
				update.setNotes(updateRecordPayload.getNotes());
			}
			if (updateRecordPayload.getParty_id() != null) {
				update.setParty_id(updateRecordPayload.getParty_id());
			}
			if (updateRecordPayload.getParty_type() != null) {
				update.setParty_type(updateRecordPayload.getParty_type());
			}
			
			if (updateRecordPayload.getParty_parent_id() != null) {
				update.setParty_parent_id(updateRecordPayload.getParty_parent_id());
			}
			
			if (updateRecordPayload.getPin() != null) {
				update.setPin(updateRecordPayload.getPin());
			}
			if (updateRecordPayload.getRegistration_number() != null) {
				update.setRegistration_number(updateRecordPayload.getRegistration_number());
			}
			if (updateRecordPayload.getState() != null) {
				update.setState(updateRecordPayload.getState());
			}		
			
			if (updateRecordPayload.getStatus() == false ) {
				update.setStatus(false);
			}
			if (updateRecordPayload.getStatus() == true ) {
				update.setStatus(true);
			}
			
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
	        
			ModelPartyDetails updatedRecord = partydetailsRepository.save(update);
			return ResponseEntity.ok(updatedRecord);
		}
		catch(Exception e)
		{
			DatabaseLogger.logToDatabase("partydetails/updateRecordById", e.getMessage());
			throw new InternalServerErrorException("partydetails/updateRecordById","Error occurred while updating the record.");
		}
	}

    // delete partydetails rest api
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteRecordById(@PathVariable Integer id){
    	ModelPartyDetails patient = partydetailsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("partydetails/deleteRecordById/{id}","record not exist with id :" + id));
    	try
    	{
	    	partydetailsRepository.delete(patient);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return ResponseEntity.ok(response);
    	}
		catch(Exception e)
		{
			DatabaseLogger.logToDatabase("partydetails/deleteRecordById", e.getMessage());
			throw new InternalServerErrorException("partydetails/deleteRecordById","Error occurred while getting the record.");
		}
    }
    
    
}

