package com.ehrs.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ehrs.restapi.models.ModelAppointment;
import com.ehrs.restapi.models.ModelLog;
@Repository
public interface LogRepository extends JpaRepository<ModelLog, Integer> {

}
