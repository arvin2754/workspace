package com.examly.springappinvest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.springappinvest.model.InvestmentInquiry;

public interface InvestmentInquiryRepository extends JpaRepository<InvestmentInquiry,Long>{
    List<InvestmentInquiry> findByUserId(Long userId);
}
