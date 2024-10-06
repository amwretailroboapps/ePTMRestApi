package com.ehrs.restapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ehrs.restapi.Models.ModelAppAccessRules;
import com.ehrs.restapi.Models.ModelPatient;

public interface RepositoryAppAccessRules  extends JpaRepository<ModelAppAccessRules, Integer>{

}
