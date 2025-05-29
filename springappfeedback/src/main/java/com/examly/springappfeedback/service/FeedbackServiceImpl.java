package com.examly.springappfeedback.service;

import com.examly.springappfeedback.model.Feedback;
import com.examly.springappfeedback.repository.FeedbackRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    
    private FeedbackRepository feedbackRepository;
    private RestTemplate restTemplate;
    public FeedbackServiceImpl(FeedbackRepository feedbackRepository, RestTemplate restTemplate) {
        this.feedbackRepository = feedbackRepository;
        this.restTemplate = restTemplate;
    }


    private static final String INVESTMENT_SERVICE_URL = "http://INVESTMENT-SERVICE/api/investments/";

    @Override
    public Feedback addFeedback(Feedback feedback) {
        // Optional: validate investmentId if present
        if (feedback.getInvestment() != null && feedback.getInvestment().getInvestmentId() != null) {
            String url = INVESTMENT_SERVICE_URL + feedback.getInvestment().getInvestmentId();
            restTemplate.getForObject(url, Object.class); // throws if investment not found
        }
        return feedbackRepository.save(feedback);
    }

    @Override
    public Feedback getFeedbackById(Long id) {
        return feedbackRepository.findById(id)
                .orElseThrow(()->new RuntimeException("feedback not found"));
    }

    @Override
    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    @Override
    public List<Feedback> getFeedbacksByUser(Long userId) {
        return feedbackRepository.findByUserUserId(userId);
    }

    @Override
    public void deleteFeedback(Long id) {
        Feedback feedback = getFeedbackById(id);
        feedbackRepository.delete(feedback);
    }
}
