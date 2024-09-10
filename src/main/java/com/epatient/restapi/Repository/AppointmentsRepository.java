package com.epatient.restapi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.epatient.restapi.Models.ModelAppointment;

public interface AppointmentsRepository   extends JpaRepository<ModelAppointment, Integer>{
	 @Query(value = "select fungetappointnumber()")
	    List<String> getNewAppointmentNumber();
}
