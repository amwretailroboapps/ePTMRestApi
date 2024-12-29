package com.ehrs.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ehrs.restapi.models.ModelAppointmentScheduler;
import com.ehrs.restapi.models.ModelDoctors;

@Repository
public interface DoctorsRepository   extends JpaRepository<ModelDoctors, Integer>{
	@Query(value = "select fungetdocnewnumber()")
    List<String> getNewDoctorNumber();
	
//	@Query(value ="SELECT u FROM ModelDoctors u WHERE u.sys_id = :doctor_id")
//	ModelAppointmentScheduler findByIdDirect(@Param("doctor_id") String doctor_id);
}
