package com.epatient.restapi.Controller;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
		return patientRepository.findAll();
	}	

    // create Patient rest api
	@PostMapping("/patients/create")
	public ModelPatient createPatient(@RequestBody ModelPatient addRecordPayload) {
		return patientRepository.save(addRecordPayload);
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
	public ResponseEntity<ModelPatient> updatePatient(@PathVariable Integer id, @RequestBody ModelPatient updatedRecordPayload){
		ModelPatient update = patientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		update.setAddress(updatedRecordPayload.getAddress());
		update.setAdhaar_number(updatedRecordPayload.getAdhaar_number());
		update.setAge(updatedRecordPayload.getAge());
		update.setCity(updatedRecordPayload.getCity());
		update.setCountry(updatedRecordPayload.getCountry());
		update.setCreated(updatedRecordPayload.getCreated());
		update.setCreated_by(updatedRecordPayload.getCreated_by());
		update.setDob(updatedRecordPayload.getDob());
		update.setEmail(updatedRecordPayload.getEmail());
		update.setEmergency_contact(updatedRecordPayload.getEmergency_contact());
		update.setFirst_name(updatedRecordPayload.getFirst_name());
		update.setGender(updatedRecordPayload.getGender());
		update.setLast_name(updatedRecordPayload.getLast_name());
		update.setMarital_status(updatedRecordPayload.getMarital_status());
		update.setMobile(updatedRecordPayload.getMobile());
		update.setOccupation(updatedRecordPayload.getOccupation());
		update.setPnumber(updatedRecordPayload.getPnumber());
		update.setPrefix(updatedRecordPayload.getPrefix());
		update.setState(updatedRecordPayload.getState());
		update.setUpdated(updatedRecordPayload.getUpdated());
		update.setUpdated_by(updatedRecordPayload.getUpdated_by());
		update.setWhatsapp(updatedRecordPayload.getWhatsapp());
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
