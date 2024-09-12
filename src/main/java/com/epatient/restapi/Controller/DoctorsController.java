package com.epatient.restapi.Controller;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.epatient.restapi.Exception.ResourceNotFoundException;
import com.epatient.restapi.Models.ModelDoctors;
import com.epatient.restapi.Repository.DoctorsRepository;


//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/v1/")
public class DoctorsController {
    @Autowired
	private DoctorsRepository doctorRepository;
	
	// get all Patient
	@GetMapping("/doctors")
	public List<ModelDoctors> getAllDoctors(){
		return doctorRepository.findAll();
	}	

    // create Patient rest api
	@PostMapping("/doctor/create")
	public ModelDoctors createappointment(@RequestBody ModelDoctors addRecordPayload) {
			return doctorRepository.save(addRecordPayload);        
	}

	// get Patient by id rest api
	@GetMapping("/doctor/{id}")
	public ResponseEntity<ModelDoctors> getAppointmentById(@PathVariable Integer id) {
		ModelDoctors record = doctorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("doctor profile not exist with System Id :" + id));
		return ResponseEntity.ok(record);
	}
	
    // get Appointment by id rest api
//    @RequestMapping(value = "/appointment/getappointmentnumber", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<String> getNewAppointmentNumber() {
//		List<String> patient = doctorRepository.getNewAppointmentNumber();
//        String panumber = "-1";
//        if(patient.size() > 0)
//        {
//            panumber = patient.get(0);
//        }
//		return ResponseEntity.ok(panumber);
//	}

    // update Doctor rest api
	@PutMapping("/doctor/{id}")
	public ResponseEntity<ModelDoctors> updateAppointment(@PathVariable Integer id, @RequestBody ModelDoctors updatePayloadRecord){
		ModelDoctors update = doctorRepository.findById(id)
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
		ModelDoctors updatedRecord = doctorRepository.save(update);
		return ResponseEntity.ok(updatedRecord);
	}

    // delete Patient rest api
    @DeleteMapping("/doctor/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePatient(@PathVariable Integer id){
    	ModelDoctors patient = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("doctor profile not exist with id :" + id));
        
        doctorRepository.delete(patient);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
