package com.epatient.restapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epatient.restapi.Models.ModelPatient;
import com.epatient.restapi.Models.ModelTreatments;

public interface TreatmentsRepository   extends JpaRepository<ModelTreatments, Integer>{

}
