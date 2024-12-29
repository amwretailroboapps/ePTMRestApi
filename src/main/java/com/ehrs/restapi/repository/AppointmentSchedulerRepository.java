package com.ehrs.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ehrs.restapi.models.ModelAppAccessRules;
import com.ehrs.restapi.models.ModelAppointmentScheduler;
import com.ehrs.restapi.models.ModelDoctors;

@Repository
public interface AppointmentSchedulerRepository   extends JpaRepository<ModelAppointmentScheduler, Integer>{
	
	@Query(value ="SELECT u FROM ModelAppointmentScheduler u WHERE u.doctor_id = :doctor_id")
    List<ModelAppointmentScheduler> getAllRecordsByDoctorId(@Param("doctor_id") String doctor_id);
	
	@Query(value ="SELECT u FROM ModelAppointmentScheduler u WHERE TO_DATE(:available_date, '%dd-%MM-%yyyy') BETWEEN TO_DATE(start_date, '%dd-%MM-%yyyy') AND TO_DATE(end_date, '%dd-%MM-%yyyy') AND u.doctor_id = :doctor_id")
    List<ModelAppointmentScheduler> getAllRecordsByDoctorIdAndDate(@Param("doctor_id") String doctor_id, @Param("available_date") String available_date);
	
}
