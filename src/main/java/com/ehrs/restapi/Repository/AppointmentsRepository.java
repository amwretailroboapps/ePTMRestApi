package com.ehrs.restapi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ehrs.restapi.Models.ModelAppointment;
@Repository
public interface AppointmentsRepository   extends JpaRepository<ModelAppointment, Integer>{
	 @Query(value = "select fungetappointnumber()")
	   List<String> getNewAppointmentNumber();
}
