package com.ehrs.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ehrs.restapi.models.ModelVisits;
@Repository
public interface TreatmentsRepository   extends JpaRepository<ModelVisits, Integer>{

}
