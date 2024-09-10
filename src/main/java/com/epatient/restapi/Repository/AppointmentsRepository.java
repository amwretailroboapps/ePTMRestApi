package com.epatient.restapi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.epatient.restapi.Models.ModelAppointments;
import com.epatient.restapi.Models.ModelPatient;

public interface AppointmentsRepository   extends JpaRepository<ModelAppointments, Integer>{
	 @Query(value = "select funGetAppNumber()")
	    List<String> getNewAppointmentNumber();
}
