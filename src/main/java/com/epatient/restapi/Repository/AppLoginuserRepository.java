package com.epatient.restapi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.epatient.restapi.Models.ModelAppLoginUser;
@Repository
public interface AppLoginuserRepository   extends JpaRepository<ModelAppLoginUser, Integer>{
	//List<ModelLoginuser> findByUsernameOrMobile(String input);
	
	@Query(value ="SELECT u FROM ModelAppLoginUser u WHERE u.username = :input OR u.mobile = :input")
    List<ModelAppLoginUser> findByUsernameOrMobile(@Param("input") String input);
}
