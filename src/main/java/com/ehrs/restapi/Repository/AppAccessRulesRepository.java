package com.ehrs.restapi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.ehrs.restapi.Models.ModelAppAccessRules;
import com.ehrs.restapi.Models.ModelAppLoginUser;

public interface AppAccessRulesRepository  extends JpaRepository<ModelAppAccessRules, Integer>{
	@Query(value ="SELECT u FROM ModelAppAccessRules u WHERE u.mobile = :input")
    List<ModelAppAccessRules> getUserAppAccessRules(@Param("input") String mobile);
	
	@Query(value ="SELECT u FROM ModelAppAccessRules u WHERE u.mobile = :mobile AND u.role_name = :role_name")
	List<ModelAppAccessRules>  checkUserAppAccessDuplicateByRole(@Param("mobile") String mobile, @Param("role_name") String role_name);
}
