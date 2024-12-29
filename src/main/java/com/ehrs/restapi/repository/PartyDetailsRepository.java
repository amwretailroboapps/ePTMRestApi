package com.ehrs.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.ehrs.restapi.models.*;

@Repository
public interface PartyDetailsRepository extends JpaRepository<ModelPartyDetails, Integer> {
	
	@Query(value ="SELECT u FROM ModelPartyDetails u WHERE u.party_parent_id =:party_id OR u.party_type = 'Branch'")
	ResponseEntity<List<ModelPartyDetails>> getAllPartyBranch(@Param("party_id") String party_id);

}
