package com.epatient.restapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epatient.restapi.Models.ModelPatient;

public interface TreatmentsRepository   extends JpaRepository<ModelPatient, Integer>{

}
