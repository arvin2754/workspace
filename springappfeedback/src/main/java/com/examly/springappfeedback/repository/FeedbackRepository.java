
package com.examly.springappfeedback.repository;

import com.examly.springappfeedback.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findByUserUserId(Long userId);
}
