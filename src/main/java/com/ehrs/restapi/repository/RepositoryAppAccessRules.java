package com.ehrs.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ehrs.restapi.models.ModelAppAccessRules;
import com.ehrs.restapi.models.ModelPatient;

public interface RepositoryAppAccessRules  extends JpaRepository<ModelAppAccessRules, Integer>{

}
