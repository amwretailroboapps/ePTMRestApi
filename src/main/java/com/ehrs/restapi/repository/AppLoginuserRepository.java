package com.ehrs.restapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ehrs.restapi.models.ModelAppLoginUser;
@Repository
public interface AppLoginuserRepository   extends JpaRepository<ModelAppLoginUser, Integer>{
	//List<ModelLoginuser> findByUsernameOrMobile(String input);
	
	@Query(value ="SELECT u FROM ModelAppLoginUser u WHERE u.username = :input OR u.mobile = :input")
    ModelAppLoginUser findByUsernameOrMobile(@Param("input") String username);
	
	@Query(value ="SELECT u FROM ModelAppLoginUser u WHERE u.status = false OR u.role_name = 'Requested'")
    List<ModelAppLoginUser> getAllAppsLoginUserRequest();
	
	@Query("update ModelAppLoginUser u set u.current_status = :current_status where u.sys_id=:id and u.mobile = :mobile")
	void updateLoginStatus(@Param(value = "id") Integer id,@Param(value = "mobile") String mobile, @Param(value = "current_status") String current_status);
	
//	Optional<ModelAppLoginUser> findByUsernameAndStatus(String username, String loginStatus);
}
