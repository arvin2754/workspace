package com.examly.springappinvest.service;

import java.util.List;

import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.examly.springappinvest.model.Investment;
import com.examly.springappinvest.repository.InvestmentRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class InvestmentServiceImpl implements InvestmentService{
    private final InvestmentRepository investmentRepository;

    public Investment addInvestment(Investment investment) {
        return investmentRepository.save(investment);
    }

    public Investment getInvestmentById(Long id) {
        return investmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Investment not found with ID: " + id));
    }

    public List<Investment> getAllInvestments() {
        return investmentRepository.findAll();
    }

    public Investment updateInvestment(Long id, Investment updatedInvestment) {
        Investment existing = getInvestmentById(id);

        existing.setName(updatedInvestment.getName());
        existing.setDescription(updatedInvestment.getDescription());
        existing.setType(updatedInvestment.getType());
        existing.setPurchasePrice(updatedInvestment.getPurchasePrice());
        existing.setCurrentPrice(updatedInvestment.getCurrentPrice());
        existing.setQuantity(updatedInvestment.getQuantity());
        existing.setPurchaseDate(updatedInvestment.getPurchaseDate());
        existing.setStatus(updatedInvestment.getStatus());

        return investmentRepository.save(existing);
    }

    public void deleteInvestment(Long id) {
        Investment existing = getInvestmentById(id);
        investmentRepository.delete(existing);
    }

}
