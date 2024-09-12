package com.epatient.restapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epatient.restapi.Models.ModelDoctors;


public interface DoctorsRepository   extends JpaRepository<ModelDoctors, Integer>{

}
