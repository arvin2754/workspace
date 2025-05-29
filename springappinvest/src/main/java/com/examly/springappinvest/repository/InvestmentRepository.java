package com.examly.springappinvest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springappinvest.model.Investment;

@Repository
public interface InvestmentRepository extends JpaRepository<Investment,Long>{
    
}
