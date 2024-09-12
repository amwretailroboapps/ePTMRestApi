package com.epatient.restapi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.epatient.restapi.Models.ModelDoctors;


public interface DoctorsRepository   extends JpaRepository<ModelDoctors, Integer>{
	@Query(value = "select fungetdocnewnumber()")
    List<String> fungetdocnewnumber();
}
