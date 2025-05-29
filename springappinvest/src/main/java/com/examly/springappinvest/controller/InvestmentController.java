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
import com.examly.springappinvest.model.Investment;
import com.examly.springappinvest.service.InvestmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/investments")
@RequiredArgsConstructor
public class InvestmentController {

    
    private final InvestmentService investmentService;

    // Add Investment (Admin)
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Investment> addInvestment(@RequestBody Investment investment) {
        Investment created = investmentService.addInvestment(investment);
        return ResponseEntity.status(HttpStatus.SC_CREATED).body(created);
    }

    // View Investment by ID (ALL)
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<Investment> getInvestmentById(@PathVariable Long id) {
        Investment investment = investmentService.getInvestmentById(id);
        return ResponseEntity.ok(investment);
    }

    // View All Investments (ALL)
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<List<Investment>> getAllInvestments() {
        return ResponseEntity.ok(investmentService.getAllInvestments());
    }

    // Update Investment (Admin)
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Investment> updateInvestment(@PathVariable Long id, @RequestBody Investment investment) {
        Investment updated = investmentService.updateInvestment(id, investment);
        return ResponseEntity.ok(updated);
    }

    // Delete Investment (Admin)
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteInvestment(@PathVariable Long id) {
        investmentService.deleteInvestment(id);
        return ResponseEntity.ok().build();
    }
}

