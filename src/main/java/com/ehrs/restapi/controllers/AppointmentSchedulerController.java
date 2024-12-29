package com.ehrs.restapi.controllers;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
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
import com.ehrs.restapi.models.ModelAppAccessRules;
import com.ehrs.restapi.models.ModelAppointment;
import com.ehrs.restapi.models.ModelAppointmentScheduler;
import com.ehrs.restapi.models.ModelPatient;
import com.ehrs.restapi.repository.AppointmentSchedulerRepository;
import com.ehrs.restapi.repository.AppointmentsRepository;
import com.ehrs.restapi.repository.DoctorsRepository;

import jakarta.persistence.Column;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/ehrs_almeezan/api/v1/appointmentscheduler")
public class AppointmentSchedulerController {
	@Autowired
	private AppointmentSchedulerRepository apptscheduleRepository;
	@Autowired
	private AppointmentsRepository appointmentsRepository;

	// get all AppointmentScheduler
	@GetMapping("/all")
	public List<ModelAppointmentScheduler> getAllRecords() {
		try {
			return apptscheduleRepository.findAll();
		} catch (Exception e) {
			DatabaseLogger.logToDatabase("/appointmentscheduler", e.getMessage());
			throw new InternalServerErrorException("/appointmentscheduler", "Error occurred while getting the record.");
		}
	}

	// create AppointmentScheduler rest api
	@PostMapping("/create")
	public ResponseEntity<String> createNewRecord(@RequestBody ModelAppointmentScheduler addRecordPayload) {
		try {
			ModelAppointmentScheduler added = apptscheduleRepository.save(addRecordPayload);
			if (added.getSys_id() > 0) {
				try {
					// generate the schedule and insert into the appointment table
					// Input data
					String startDateString = added.getStart_date(); // "2024-12-20"; // Start date
					String endDateString = added.getEnd_date(); // "2024-12-25"; // End date
					String startTimeString = added.getStart_time(); // "09:00"; // Daily start time
					String endTimeString = added.getEnd_time(); // "18:00"; // Daily end time

					//System.out.println("Start Date: " + startDateString);
					//System.out.println("End Date: " + endDateString);
					System.out.println("Start Time: " + startTimeString);
					System.out.println("End Time: " + endTimeString);

					// Formatter for output & parsing
					DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
					LocalDate startDate = LocalDate.parse(startDateString, dateFormatter);
					LocalDate endDate = LocalDate.parse(endDateString, dateFormatter);
					
					// Formatter for output & parsing
					DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a", Locale.ENGLISH);
					LocalTime startTime = LocalTime.parse(startTimeString, timeFormatter);
					LocalTime endTime = LocalTime.parse(endTimeString, timeFormatter);
					//System.out.println("Local Start Date: " + startDate);
					//System.out.println("Local End Date: " + endDate);
					//System.out.println("Local Start Time: " + startTime);
					//System.out.println("Local End Time: " + endTime);

					// scheduler data.
					int sys_id_scheduler = added.getSys_id();
					String schedule_id = added.getSchedule_id();
					String appt_slot = added.getSlot(); // "Morning";
					// Doctor Data
					String doctor_id = added.getDoctor_id();
					String doctor_mobile = added.getDoctor_mobile();
					String doctor_name = added.getDoctor_name();

					// Generate intervals
					LocalDate currentDate = startDate;
					String selectedDays[] = added.getAvail_days().split(",");
					//System.out.println(added.getAvail_days());
					while (!currentDate.isAfter(endDate)) 
					{
						String current_day_name =  currentDate.getDayOfWeek().name();
						//System.out.println("current_date: " + currentDate);
						//System.out.println("current_day_name: " + current_day_name);
						boolean selected_day = false;
				        for (String day : selectedDays) 
				        {
				        	//System.out.println("current_day_name::Loop " + day);
				            if (day.trim().equalsIgnoreCase(current_day_name)) 
				            {
				            	selected_day = true;
				                break;
				            }
				        }
						//System.out.println("selected_day: " + selected_day);
						if (selected_day) // currentDate.getDayOfWeek() != DayOfWeek.SUNDAY
						{
							LocalTime currentTime = startTime;

							while (!currentTime.isAfter(endTime)) {
								ModelAppointment appointment = new ModelAppointment();
								// Output : 2024-12-20 09:00
								//System.out.println(currentDate.format(dateFormatter) + " " + currentTime.format(timeFormatter));
								// Set Doctor Data
								appointment.setDoctor_id(Integer.parseInt(doctor_id));
								appointment.setDoctor_mobile(doctor_mobile);
								appointment.setDoctor_name(doctor_name);
								// Set Scheduler Data
								appointment.setSys_id_scheduler(sys_id_scheduler);
								appointment.setSchedule_id(schedule_id);
								appointment.setSlot(appt_slot);
								// Set Appointment Data
								// Patient Data
								appointment.setPat_id(0);
								appointment.setPat_email(null);
								appointment.setPat_mobile(null);
								appointment.setPat_name(null);
								appointment.setPat_whatsapp(null);
								// Appointment Data
								appointment.setApply_date(null);
								appointment.setAppt_time(currentTime.format(timeFormatter));
								appointment.setAppt_date(currentDate.format(dateFormatter));
								appointment.setAppt_message(null);
								appointment.setAppt_number(null);
								appointment.setRegistrDate(null);
								appointment.setRemarks("Scheduled By Doctor");
								appointment.setStatus("Scheduled");
								// system fields
								appointment.setCreated(added.getCreated());
								appointment.setUpdated(added.getUpdated());
								appointment.setUpdated_by(added.getUpdated_by());
								appointment.setCreated_by(added.getCreated_by());
								System.out.println(appointment);
								appointmentsRepository.save(appointment);
								appointment = null;
								currentTime = currentTime.plusMinutes(15); // Increment by 15 minutes
							}
						}
						currentDate = currentDate.plusDays(1); // Move to the next day
					}
				} catch (Exception e) {
					throw (e);
				}
			}
			return ResponseEntity.ok(String.valueOf(added.getSys_id()));
		} catch (Exception e) {
			DatabaseLogger.logToDatabase("/appointmentscheduler/create", e.getMessage());
			throw new InternalServerErrorException("/appointmentscheduler/create",
					"Error occurred while getting the record.");
		}
	}

	// get AppointmentScheduler by id rest api
	@GetMapping("/{id}")
	public ResponseEntity<ModelAppointmentScheduler> getRecordById(@PathVariable Integer id) {
		try {
			ModelAppointmentScheduler record = apptscheduleRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("getAppointmentById/doctor/{id}",
							"doctor profile not exist with System Id :" + id));
			return ResponseEntity.ok(record);
		} catch (Exception e) {
			DatabaseLogger.logToDatabase("getRecordById/appointmentscheduler/{id}", e.getMessage());
			throw new InternalServerErrorException("getRecordById/appointmentscheduler/{id}",
					"Error occurred while getting the record.");
		}
	}

	// get all app access rule by mobile name
	@GetMapping("/getschedulerlist_bydocid")
	public List<ModelAppointmentScheduler> getAllRecordsByDoctorId(String doctor_id) {
		try {
			return apptscheduleRepository.getAllRecordsByDoctorId(doctor_id);
		} catch (Exception e) {
			DatabaseLogger.logToDatabase("getAllRecordsByDoctorId/appointmentscheduler/{id}", e.getMessage());
			throw new InternalServerErrorException("getAllRecordsByDoctorId/appointmentscheduler/{id}",
					"Error occurred while getting the record.");
		}
	}

	// get all app access rule by mobile name
	@GetMapping("/getschedulerlist_docid_date")
	public List<ModelAppointmentScheduler> getAllRecordsByDoctorIdAndDate(String doctor_id, String available_date) {
		try {
			return apptscheduleRepository.getAllRecordsByDoctorIdAndDate(doctor_id, available_date);
		} catch (Exception e) {
			DatabaseLogger.logToDatabase("getAllRecordsByDoctorId/appointmentscheduler/{id}", e.getMessage());
			throw new InternalServerErrorException("getAllRecordsByDoctorId/appointmentscheduler/{id}",
					"Error occurred while getting the record.");
		}
	}

	// update AppointmentScheduler rest api
	@PutMapping("/{id}")
	public ResponseEntity<ModelAppointmentScheduler> updateRecordById(@PathVariable Integer id,
			@RequestBody ModelAppointmentScheduler updateRecordPayload) {
		ModelAppointmentScheduler update = apptscheduleRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("appointmentscheduler/{id}", "record not exist with id :" + id));
		try {

			if (updateRecordPayload.getComments() != null) {
				update.setComments(updateRecordPayload.getComments());
			}
			if (updateRecordPayload.getSchedule_id() != null) {
				update.setSchedule_id(updateRecordPayload.getSchedule_id());
			}
			if (updateRecordPayload.getAvail_days() != null) {
				update.setAvail_days(updateRecordPayload.getAvail_days());
			}

			if (updateRecordPayload.getSlot() != null) {
				update.setSlot(updateRecordPayload.getSlot());
			}
			if (updateRecordPayload.getStart_date() != null) {
				update.setStart_date(updateRecordPayload.getStart_date());

			}
			if (updateRecordPayload.getStart_time() != null) {
				update.setStart_time(updateRecordPayload.getStart_time());

			}
			if (updateRecordPayload.getEnd_date() != null) {
				update.setEnd_date(updateRecordPayload.getEnd_date());
			}
			if (updateRecordPayload.getEnd_time() != null) {
				update.setEnd_time(updateRecordPayload.getEnd_time());

			}
			if (updateRecordPayload.getDoctor_id() != null) {
				update.setDoctor_id(updateRecordPayload.getDoctor_id());
			}
			if (updateRecordPayload.getDoctor_mobile() != null) {
				update.setDoctor_mobile(updateRecordPayload.getDoctor_mobile());
			}
			if (updateRecordPayload.getDoctor_name() != null) {
				update.setDoctor_name(updateRecordPayload.getDoctor_name());
			}
			update.setStatus(updateRecordPayload.isStatus());

			// system column
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
			ModelAppointmentScheduler updatedRecord = apptscheduleRepository.save(update);
			return ResponseEntity.ok(updatedRecord);
		} catch (Exception e) {
			DatabaseLogger.logToDatabase("updateRecordById/appointmentscheduler/{id}", e.getMessage());
			throw new InternalServerErrorException("updateRecordById/appointmentscheduler/{id}",
					"Error occurred while getting the record.");
		}
	}

	// delete AppointmentScheduler rest api
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteRecordById(@PathVariable Integer id) {
		ModelAppointmentScheduler record = apptscheduleRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("deleteRecordById/appointmentscheduler/{id}",
						"record not exist with id :" + id));
		try {
			apptscheduleRepository.delete(record);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			DatabaseLogger.logToDatabase("deleteRecordById/appointmentscheduler/{id}", e.getMessage());
			throw new InternalServerErrorException("deleteRecordById/appointmentscheduler/{id}",
					"Error occurred while getting the record.");
		}
	}

}
