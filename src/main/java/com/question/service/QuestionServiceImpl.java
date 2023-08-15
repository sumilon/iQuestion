package com.question.service;

import com.question.model.QuestionEntity;
import com.question.repository.AutoCompleteDao;
import com.question.repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepo questionRepo;

    @Override
    public Optional<QuestionEntity> getQuestionById(long id) {
        return questionRepo.findById(id);
    }

    @Override
    public void updateQuestion(QuestionEntity questionEntity) {
        questionRepo.save(questionEntity);
    }

    @Override
    public void deleteQuestion(long id) {
        Optional<QuestionEntity> question = questionRepo.findById(id);
        question.ifPresent(value -> questionRepo.delete(value));
    }

    @Override
    public void saveQuestion(QuestionEntity questionEntity) {
        questionRepo.save(questionEntity);
    }

    @Override
    public List<QuestionEntity> fetchAllQuestionData() {
        return questionRepo.findAll();
    }

    @Override
    public List<String> doAutoComplete(final String input) {
        return AutoCompleteDao.getStrings(input);
    }
}
