package com.ehrs.restapi.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ehrs.restapi.models.ModelPatient;
@Repository
public interface PatientRepository  extends JpaRepository<ModelPatient, Integer>{
    @Query(value = "select funGetPaNewNumber()")
    List<String> getNewPatientNumber();   
    
	@Query(value ="SELECT u FROM ModelPatient u WHERE u.mobile = :value ")
	List<ModelPatient> findPatientByMobile(@Param("value") String value);
	
	@Query(value ="SELECT u FROM ModelPatient u WHERE u.full_name LIKE CONCAT('%',:value,'%')")
	List<ModelPatient> findPatientByName(@Param("value") String value);
}
