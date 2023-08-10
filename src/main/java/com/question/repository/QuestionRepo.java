package com.question.repository;

import com.question.model.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<QuestionEntity, Long> {
}
