package com.epatient.restapi.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.epatient.restapi.Models.ModelPatient;

public interface PatientRepository  extends JpaRepository<ModelPatient, Integer>{
    @Query(value = "select funGetPaNewNumber()")
    List<String> getNewPatientNumber();
    
    
}
