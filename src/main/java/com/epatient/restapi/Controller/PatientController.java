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
	public ModelPatient createPatient(@RequestBody ModelPatient addPayloadPatient) {
		return patientRepository.save(addPayloadPatient);
	}

    // get Patient by id rest api
	@GetMapping("/patients/{id}")
	public ResponseEntity<ModelPatient> getPatientById(@PathVariable Integer id) {
		ModelPatient patient = patientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Patient not exist with System Id :" + id));
		return ResponseEntity.ok(patient);
	}
    // get Patient by id rest api
	//@GetMapping("/patients/getnewpanumber", produces = MediaType.APPLICATION_JSON_VALUE)
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
	public ResponseEntity<ModelPatient> updatePatient(@PathVariable Integer id, @RequestBody ModelPatient updatePayloadPatient){
		ModelPatient patient = patientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
                patient.setAddress(updatePayloadPatient.getAddress());
                patient.setAdhaar_number(updatePayloadPatient.getAdhaar_number());
                patient.setAge(updatePayloadPatient.getAge());
                patient.setCity(updatePayloadPatient.getCity());
                patient.setCountry(updatePayloadPatient.getCountry());
                patient.setCreated(updatePayloadPatient.getCreated());
                patient.setCreated_by(updatePayloadPatient.getCreated_by());
                patient.setDob(updatePayloadPatient.getDob());
                patient.setEmail(updatePayloadPatient.getEmail());
                patient.setEmergency_contact(updatePayloadPatient.getEmergency_contact());
                patient.setFirst_name(updatePayloadPatient.getFirst_name());
                patient.setGender(updatePayloadPatient.getGender());
                patient.setLast_name(updatePayloadPatient.getLast_name());
                patient.setMarital_status(updatePayloadPatient.getMarital_status());
                patient.setMobile(updatePayloadPatient.getMobile());
                patient.setOccupation(updatePayloadPatient.getOccupation());
                patient.setPnumber(updatePayloadPatient.getPnumber());
                patient.setPrefix(updatePayloadPatient.getPrefix());
                patient.setState(updatePayloadPatient.getState());
                patient.setUpdated(updatePayloadPatient.getUpdated());
                patient.setUpdated_by(updatePayloadPatient.getUpdated_by());
                patient.setWhatsapp(updatePayloadPatient.getWhatsapp());
		ModelPatient updatedEmployee = patientRepository.save(patient);
		return ResponseEntity.ok(updatedEmployee);
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
