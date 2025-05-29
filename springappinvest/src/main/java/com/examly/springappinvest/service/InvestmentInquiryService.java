package com.examly.springappinvest.service;

import java.util.List;

import com.examly.springappinvest.model.InvestmentInquiry;

public interface InvestmentInquiryService {
    InvestmentInquiry addInquiry(InvestmentInquiry inquiry);
    InvestmentInquiry getInquiryById(Long id);
    List<InvestmentInquiry> getInquiriesByUserId(Long userId);
    List<InvestmentInquiry> getAllInquiries() ;
    InvestmentInquiry updateInquiry(Long id, InvestmentInquiry updated);
    void deleteInquiry(Long id);

    
}
