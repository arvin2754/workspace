package com.examly.springappfeedback.service;

import com.examly.springappfeedback.model.Feedback;
import java.util.List;

public interface FeedbackService {
    Feedback addFeedback(Feedback feedback);
    Feedback getFeedbackById(Long id);
    List<Feedback> getAllFeedbacks();
    List<Feedback> getFeedbacksByUser(Long userId);
    void deleteFeedback(Long id);
}
