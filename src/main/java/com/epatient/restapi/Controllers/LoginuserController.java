package com.epatient.restapi.Controllers;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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

import com.epatient.restapi.Exception.ResourceNotFoundException;
import com.epatient.restapi.Models.ModelAppLoginUser;
import com.epatient.restapi.Repository.AppLoginuserRepository;
import com.epatient.restapi.Service.LoginuserService;


//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/v1/")
public class LoginuserController {
    @Autowired
	private AppLoginuserRepository loginuserRepository;
    private LoginuserService loginuserService;
	
	// get all AppUsers
	@GetMapping("/loginusers")
	public List<ModelAppLoginUser> getAllLoginUser(){
		return loginuserRepository.findAll();
	}	
	
	@GetMapping("/loginusers/loginrequest")
	public List<ModelAppLoginUser> getAllLoginUserRequest(){
		return loginuserRepository.getAllAppsLoginUserRequest();
	}	

    // create Patient rest api
	@PostMapping("/loginusers/create")
	public ModelAppLoginUser createloginuser(@RequestBody ModelAppLoginUser addRecordPayload) {
			return loginuserRepository.save(addRecordPayload);        
	}

	// get Patient by id rest api
	@GetMapping("/loginusers/{id}")
	public ResponseEntity<ModelAppLoginUser> getLoginuserById(@PathVariable Integer id) {
		ModelAppLoginUser record = loginuserRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("login profile not exist with System Id :" + id));
		return ResponseEntity.ok(record);
	}
	

    // update Doctor rest api
	@PutMapping("/loginusers/{id}")
	public ResponseEntity<ModelAppLoginUser> updateLoinguser(@PathVariable Integer id, @RequestBody ModelAppLoginUser updatePayloadRecord){
		ModelAppLoginUser update = loginuserRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("doctor profile not exist with id :" + id));	
//                update.setAddress(updatePayloadRecord.getAddress());
//                update.setAdhaar_number(updatePayloadRecord.getAdhaar_number());
//                update.setAge(updatePayloadRecord.getAge());
//                update.setCity(updatePayloadRecord.getCity());
//                update.setCountry(updatePayloadRecord.getCountry());
//                update.setCreated(updatePayloadRecord.getCreated());
//                update.setCreated_by(updatePayloadRecord.getCreated_by());
//                update.setDob(updatePayloadRecord.getDob());
//                update.setEmail(updatePayloadRecord.getEmail());
//                update.setEmergency_contact(updatePayloadRecord.getEmergency_contact());
//                update.setFirst_name(updatePayloadRecord.getFirst_name());
//                update.setGender(updatePayloadRecord.getGender());
//                update.setLast_name(updatePayloadRecord.getLast_name());
//                update.setMarital_status(updatePayloadRecord.getMarital_status());
//                update.setMobile(updatePayloadRecord.getMobile());
//                update.setOccupation(updatePayloadRecord.getOccupation());
//                update.setPnumber(updatePayloadRecord.getPnumber());
//                update.setPrefix(updatePayloadRecord.getPrefix());
//                update.setState(updatePayloadRecord.getState());
//                update.setUpdated(updatePayloadRecord.getUpdated());
//                update.setUpdated_by(updatePayloadRecord.getUpdated_by());
//                update.setWhatsapp(updatePayloadRecord.getWhatsapp());
		ModelAppLoginUser updatedRecord = loginuserRepository.save(update);
		return ResponseEntity.ok(updatedRecord);
	}

    // delete Patient rest api
    @DeleteMapping("/loginusers/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteLoginuser(@PathVariable Integer id){
    	ModelAppLoginUser patient = loginuserRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("login user profile not exist with id :" + id));
    	loginuserRepository.delete(patient);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/loginusers/search")
    public ResponseEntity<ModelAppLoginUser> searchUserByUsernameOrEmail(@RequestParam String input, @RequestParam String passCode) {
        ModelAppLoginUser user = loginuserRepository.findByUsernameOrMobile(input, passCode);
        if (user == null) {
        	return ResponseEntity.notFound().build();
        }
        else if (user != null && user.getPin().equals(passCode)) {
            // Passwords match, return success
        	 return ResponseEntity.ok(user);
        } else {
            // Passwords don't match, return error
        	user.setLastresponse("Invalid Pin is entered.");
            return ResponseEntity.ok(user);
        }
    }

}
