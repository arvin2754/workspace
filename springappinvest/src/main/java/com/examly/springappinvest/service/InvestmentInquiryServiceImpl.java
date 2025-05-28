package com.examly.springappinvest.service;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.examly.springappinvest.model.InvestmentInquiry;
import com.examly.springappinvest.repository.InvestmentInquiryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InvestmentInquiryServiceImpl implements InvestmentInquiryService{

    private final InvestmentInquiryRepository inquiryRepo;

     public InvestmentInquiry addInquiry(InvestmentInquiry inquiry) {
        inquiry.setInquiryDate(LocalDateTime.now());
        return inquiryRepo.save(inquiry);
    }

    public InvestmentInquiry getInquiryById(Long id) {
        return inquiryRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Inquiry not found with ID: " + id));
    }

    public List<InvestmentInquiry> getInquiriesByUserId(Long userId) {
        return inquiryRepo.findByUserId(userId);
    }

    public List<InvestmentInquiry> getAllInquiries() {
        return inquiryRepo.findAll();
    }

    public InvestmentInquiry updateInquiry(Long id, InvestmentInquiry updated) {
        InvestmentInquiry existing = getInquiryById(id);

        existing.setMessage(updated.getMessage());
        existing.setStatus(updated.getStatus());
        existing.setPriority(updated.getPriority());
        existing.setAdminResponse(updated.getAdminResponse());
        existing.setContactDetails(updated.getContactDetails());
        existing.setResponseDate(LocalDateTime.now());

        return inquiryRepo.save(existing);
    }

    public void deleteInquiry(Long id) {
        InvestmentInquiry existing = getInquiryById(id);
        inquiryRepo.delete(existing);
    }
    
}
