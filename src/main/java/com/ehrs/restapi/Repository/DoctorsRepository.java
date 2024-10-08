package com.ehrs.restapi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ehrs.restapi.Models.ModelDoctors;

@Repository
public interface DoctorsRepository   extends JpaRepository<ModelDoctors, Integer>{
	@Query(value = "select fungetdocnewnumber()")
    List<String> getNewDoctorNumber();
}
