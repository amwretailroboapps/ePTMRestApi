package com.ehrs.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ehrs.restapi.models.ModelTreatments;
@Repository
public interface VisitsRepository   extends JpaRepository<ModelTreatments, Integer>{

}
