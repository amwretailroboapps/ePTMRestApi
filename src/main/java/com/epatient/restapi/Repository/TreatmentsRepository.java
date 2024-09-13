package com.epatient.restapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epatient.restapi.Models.ModelTreatments;
@Repository
public interface TreatmentsRepository   extends JpaRepository<ModelTreatments, Integer>{

}
