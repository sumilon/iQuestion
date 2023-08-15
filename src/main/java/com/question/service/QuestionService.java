package com.question.service;

import com.question.model.QuestionEntity;

import java.util.List;
import java.util.Optional;

public interface QuestionService {

    public Optional<QuestionEntity> getQuestionById(long id);

    public void updateQuestion(QuestionEntity questionEntity);

    public void deleteQuestion(long id);

    public void saveQuestion(QuestionEntity questionEntity);

    public List<QuestionEntity> fetchAllQuestionData();

    public List<String> doAutoComplete(final String input);
}
