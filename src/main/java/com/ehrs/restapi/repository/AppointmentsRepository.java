package com.ehrs.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ehrs.restapi.models.ModelAppointment;
import com.ehrs.restapi.models.ModelAppointmentScheduler;
@Repository
public interface AppointmentsRepository   extends JpaRepository<ModelAppointment, Integer>{
	 @Query(value = "select fungetappointnumber()")
	 List<String> getNewAppointmentNumber();
	  
	 @Query(value ="SELECT u FROM ModelAppointment u WHERE u.appt_date =:appt_date AND u.slot =:slot AND u.appt_time =:appt_time AND u.doctor_id =:doctor_id")
	 ModelAppointment getAppointmentRecordForBooking(@Param("doctor_id") String doctor_id, @Param("appt_date") String appt_date,@Param("slot") String slot, @Param("appt_time") String appt_time );
	 
	 @Query(value ="SELECT u FROM ModelAppointment u WHERE u.appt_date =:appt_date AND u.slot =:slot AND u.doctor_id =:doctor_id")
	 List<ModelAppointment> getAppointmentRecordsByDocSlots(@Param("doctor_id") String doctor_id, @Param("appt_date") String appt_date,@Param("slot") String slot);
	 

}
