package com.ehrs.restapi.Controllers;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
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
import com.ehrs.restapi.Models.ModelAppLoginUser;
import com.ehrs.restapi.Repository.AppLoginuserRepository;
import com.ehrs.restapi.Service.LoginuserService;


//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/ehrs_almeezan/api/v1")
public class LoginuserController {
    @Autowired
	private AppLoginuserRepository loginuserRepository;
    private LoginuserService loginuserService;
	
	// get all apploginuser
	@GetMapping("/loginusers")
	public List<ModelAppLoginUser> getAllRecords(){
		try
		{
			return loginuserRepository.findAll();
		}
		catch(Exception e)
		{
			DatabaseLogger.logToDatabase("getAllRecords/loginusers", e.getMessage());
			throw new InternalServerErrorException("getAllRecords/loginusers","Error occurred while getting the record.");
		}
	}	
	
	@GetMapping("/loginusers/loginrequest")
	public List<ModelAppLoginUser> getAllLoginUserRequest(){
		try
		{
			return loginuserRepository.getAllAppsLoginUserRequest();	
		}
		catch(Exception e)
		{
			DatabaseLogger.logToDatabase("getAllLoginUserRequest/loginusers", e.getMessage());
			throw new InternalServerErrorException("getAllLoginUserRequest/loginusers","Error occurred while getting the record.");
		}
	}	

    // create apploginuser rest api
	@PostMapping("/loginusers/create")
	public ResponseEntity<ModelAppLoginUser> createNewRecord(@RequestBody ModelAppLoginUser addRecordPayload) 
	{
		try
		{
			ModelAppLoginUser useradded =  loginuserRepository.save(addRecordPayload);
			return ResponseEntity.ok(useradded);
		}
		catch(Exception e)
		{
			DatabaseLogger.logToDatabase("createloginuser/loginusers", e.getMessage());
			throw new InternalServerErrorException("createloginuser/loginusers","Error occurred while creating the record.");
		}
	}

	// get apploginuser by id rest api
	@GetMapping("/loginusers/{id}")
	public ResponseEntity<ModelAppLoginUser> getRecordById(@PathVariable Integer id) {
		ModelAppLoginUser record = loginuserRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("getLoginuserById/loginusers/{id}","login profile not exist with System Id :" + id));
		return ResponseEntity.ok(record);
	}
	
    // update apploginuser rest api
	@PutMapping("/loginusers/{id}")
	public ResponseEntity<ModelAppLoginUser> updateRecordById(@PathVariable Integer id, @RequestBody ModelAppLoginUser updateRecordPayload){
		ModelAppLoginUser update = loginuserRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("updateLoinguser/loginusers/{id}","login profile not exist with id :" + id));
		try
		{
			if (updateRecordPayload.getEmail() != null) {
				update.setEmail(updateRecordPayload.getEmail());
			}
			if (updateRecordPayload.getLastresponse() != null) {
				update.setLastresponse(updateRecordPayload.getLastresponse());
			}
			
			if (updateRecordPayload.getDevice_id() != null) {
				update.setDevice_id(updateRecordPayload.getDevice_id());
			}
			
			if (updateRecordPayload.getMobile() != null) {
				update.setMobile(updateRecordPayload.getMobile());
			}
			if (updateRecordPayload.getPassword() != null) {
				update.setPassword(updateRecordPayload.getPassword());
			}
			if (updateRecordPayload.getPin() != null) {
				update.setPin(updateRecordPayload.getPin());
			}
			if (updateRecordPayload.getRole_name() != null) {
				update.setRole_name(updateRecordPayload.getRole_name());
			}
			if (updateRecordPayload.getUsername() != null) {
				update.setUsername(updateRecordPayload.getUsername());
			}
			if (updateRecordPayload.getDevice_id() != null) {
				update.setUsername(updateRecordPayload.getDevice_id());
			}
			if (updateRecordPayload.getCurrent_status() != null) {
				update.setCurrent_status(updateRecordPayload.getCurrent_status());
			}
			
			if (updateRecordPayload.isStatus() == false ) {
				update.setStatus(false);
			}
			if (updateRecordPayload.isStatus() == true ) {
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
	        
			ModelAppLoginUser updatedRecord = loginuserRepository.save(update);
			return ResponseEntity.ok(updatedRecord);
		}
		catch(Exception e)
		{
			DatabaseLogger.logToDatabase("updateLoinguser/loginusers", e.getMessage());
			throw new InternalServerErrorException("updateLoinguser/loginusers","Error occurred while updating the record.");
		}
	}

    // delete apploginuser rest api
    @DeleteMapping("/loginusers/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteRecordById(@PathVariable Integer id){
    	ModelAppLoginUser patient = loginuserRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("deleteLoginuser/loginusers/{id}","login profile not exist with id :" + id));
    	try
    	{
	    	loginuserRepository.delete(patient);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return ResponseEntity.ok(response);
    	}
		catch(Exception e)
		{
			DatabaseLogger.logToDatabase("deleteLoginuser/loginusers", e.getMessage());
			throw new InternalServerErrorException("deleteLoginuser/loginusers","Error occurred while deleting the record.");
		}
    }
    @GetMapping("/loginusers/search")
    public ResponseEntity<ModelAppLoginUser> searchUserByUsernameOrEmail(@RequestParam String input, @RequestParam String passcode) {
        ModelAppLoginUser user = loginuserRepository.findByUsernameOrMobile(input);
        try
        {
        	if (user == null) {
            	return ResponseEntity.notFound().build();
            }
            else if (user != null && user.getPin().equals(passcode)) {
                // Passwords match, return success
            	 return ResponseEntity.ok(user);
            } else {
                // Passwords don't match, return error
            	ModelAppLoginUser errorUser = new ModelAppLoginUser();
            	errorUser.setLastresponse("Invalid Pin is entered.");
                return ResponseEntity.ok(errorUser);
            }
        }
        catch(Exception e)
		{
			DatabaseLogger.logToDatabase("searchUserByUsernameOrEmail/loginusers", e.getMessage());
			throw new InternalServerErrorException("searchUserByUsernameOrEmail/loginusers","Error occurred while deleting the record.");
		}       
    }
    

}
