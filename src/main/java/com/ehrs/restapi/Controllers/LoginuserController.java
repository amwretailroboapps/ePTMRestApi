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
@RequestMapping("/api/v1")
public class LoginuserController {
    @Autowired
	private AppLoginuserRepository loginuserRepository;
    private LoginuserService loginuserService;
	
	// get all AppUsers
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

    // create Patient rest api
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

	// get Patient by id rest api
	@GetMapping("/loginusers/{id}")
	public ResponseEntity<ModelAppLoginUser> getRecordById(@PathVariable Integer id) {
		ModelAppLoginUser record = loginuserRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("getLoginuserById/loginusers/{id}","login profile not exist with System Id :" + id));
		return ResponseEntity.ok(record);
	}
	
    // update Doctor rest api
	@PutMapping("/loginusers/{id}")
	public ResponseEntity<ModelAppLoginUser> updateRecordById(@PathVariable Integer id, @RequestBody ModelAppLoginUser updatePayloadRecord){
		ModelAppLoginUser update = loginuserRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("updateLoinguser/loginusers/{id}","login profile not exist with id :" + id));
		try
		{
			if (updatePayloadRecord.getEmail() != null) {
				update.setEmail(updatePayloadRecord.getEmail());
			}
			if (updatePayloadRecord.getLastresponse() != null) {
				update.setLastresponse(updatePayloadRecord.getLastresponse());
			}
			if (updatePayloadRecord.getMobile() != null) {
				update.setMobile(updatePayloadRecord.getMobile());
			}
			if (updatePayloadRecord.getPassword() != null) {
				update.setPassword(updatePayloadRecord.getPassword());
			}
			if (updatePayloadRecord.getPin() != null) {
				update.setPin(updatePayloadRecord.getPin());
			}
			if (updatePayloadRecord.getRole_name() != null) {
				update.setRole_name(updatePayloadRecord.getRole_name());
			}
			if (updatePayloadRecord.getUsername() != null) {
				update.setUsername(updatePayloadRecord.getUsername());
			}
	        update.setStatus(updatePayloadRecord.isStatus());       
	        
	        update.setUpdated(updatePayloadRecord.getUpdated());
	        update.setUpdated_by(updatePayloadRecord.getUpdated_by());
			ModelAppLoginUser updatedRecord = loginuserRepository.save(update);
			return ResponseEntity.ok(updatedRecord);
		}
		catch(Exception e)
		{
			DatabaseLogger.logToDatabase("updateLoinguser/loginusers", e.getMessage());
			throw new InternalServerErrorException("updateLoinguser/loginusers","Error occurred while updating the record.");
		}
	}

    // delete Patient rest api
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
