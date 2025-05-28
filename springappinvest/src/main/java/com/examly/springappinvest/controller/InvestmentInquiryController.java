package com.examly.springappinvest.controller;

import java.util.List;

import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springappinvest.model.InvestmentInquiry;
import com.examly.springappinvest.service.InvestmentInquiryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/inquiries")
@RequiredArgsConstructor
public class InvestmentInquiryController{

    
    private final InvestmentInquiryService service;

    // Add Inquiry (User)
    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<InvestmentInquiry> addInquiry(@RequestBody InvestmentInquiry inquiry) {
        InvestmentInquiry created = service.addInquiry(inquiry);
        return ResponseEntity.status(HttpStatus.SC_CREATED).body(created);
    }

    // Get Inquiry by ID (Admin/User)
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<InvestmentInquiry> getInquiry(@PathVariable Long id) {
        return ResponseEntity.ok(service.getInquiryById(id));
    }

    // Get All Inquiries by User (User)
    @GetMapping("/user/{userId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<InvestmentInquiry>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getInquiriesByUserId(userId));
    }

    // Get All Inquiries (Admin)
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<InvestmentInquiry>> getAll() {
        return ResponseEntity.ok(service.getAllInquiries());
    }

    // Update Inquiry (Admin)
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<InvestmentInquiry> updateInquiry(@PathVariable Long id,
                                                           @RequestBody InvestmentInquiry inquiry) {
        return ResponseEntity.ok(service.updateInquiry(id, inquiry));
    }

    // Delete Inquiry (User)
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Void> deleteInquiry(@PathVariable Long id) {
        service.deleteInquiry(id);
        return ResponseEntity.ok().build();
    }
}
