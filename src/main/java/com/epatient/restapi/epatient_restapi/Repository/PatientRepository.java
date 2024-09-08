package com.epatient.restapi.epatient_restapi.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.epatient.restapi.epatient_restapi.Models.ModelPatient;

public interface PatientRepository  extends JpaRepository<ModelPatient, Integer>{
    @Query(value = "select funGetPaNewNumber()")
    List<String> getNewPatientNumber();
}
