package com.examly.springappinvest.service;

import java.util.List;

import com.examly.springappinvest.model.Investment;

public interface InvestmentService {
    Investment addInvestment(Investment investment);
     Investment getInvestmentById(Long id);
      List<Investment> getAllInvestments();
      Investment updateInvestment(Long id, Investment updatedInvestment);
      void deleteInvestment(Long id);
    
} 