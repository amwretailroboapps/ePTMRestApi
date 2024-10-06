package com.ehrs.restapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ehrs.restapi.Models.Log;
@Repository
public interface LogRepository extends JpaRepository<Log, Integer> {

}
