package com.epatient.restapi.Controllers;
import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.multipart.MultipartFile;

import com.epatient.restapi.Exception.ResourceNotFoundException;
import com.epatient.restapi.Models.ModelPatient;
import com.epatient.restapi.Repository.PatientRepository;

//@GetMapping("/patients/getnewpanumber", produces = MediaType.APPLICATION_JSON_VALUE)
//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/v1/")
public class PatientController {
    @Autowired
	private PatientRepository patientRepository;
	
	// get all Patient
	@GetMapping("/patients")
	public List<ModelPatient> getAllPatients(){
		//return patientRepository.findAll(Sort.by(Dec));
        return patientRepository.findAll(Sort.by("pnumber").descending());
	}	

    // create Patient rest api
	@PostMapping("/patients/create")
	public ResponseEntity<String> createPatient(@RequestBody ModelPatient createRecordPayload) {
		//, MultipartFile userImage
		//createRecordPayload.setUserImage(userImage.getBytes());
		ModelPatient added = patientRepository.save(createRecordPayload);
		return ResponseEntity.ok(String.valueOf(added.getSys_id()));
			
	}

    // get Patient by id rest api
	@GetMapping("/patients/{id}")
	public ResponseEntity<ModelPatient> getPatientById(@PathVariable Integer id) {
		ModelPatient patient = patientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Patient not exist with System Id :" + id));
		return ResponseEntity.ok(patient);
	}
    // get Patient by id rest api
    @RequestMapping(value = "/patients/getnewpanumber", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getNewPatientNumber() {
		List<String> patient = patientRepository.getNewPatientNumber();
        String panumber = "-1";
        if(patient.size() > 0)
        {
            panumber = patient.get(0);
        }
		return ResponseEntity.ok(panumber);
	}

    // update Patient rest api
	@PutMapping("/patients/{id}")
	public ResponseEntity<ModelPatient> updatePatient(@PathVariable Integer id, @RequestBody ModelPatient updateRecordPayload){
		ModelPatient update = patientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
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
		ModelPatient updatedRecord = patientRepository.save(update);
		return ResponseEntity.ok(updatedRecord);
	}

    // delete Patient rest api
    @DeleteMapping("/patients/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePatient(@PathVariable Integer id){
        ModelPatient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not exist with id :" + id));
        
        patientRepository.delete(patient);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
