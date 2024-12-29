package com.ehrs.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ehrs.restapi.models.ModelExpense;

@Repository
public interface ExpenseRepository   extends JpaRepository<ModelExpense, Integer>{

}
