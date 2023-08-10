package com.question.controller;

import com.question.model.QuestionEntity;
import com.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showQuestion() {
        return "list-Question";
    }

    @GetMapping(value = "/getQuestionData")
    @ResponseBody
    public Map<String, List<QuestionEntity>> getAllQuestionDataJSON() {
        Map<String, List<QuestionEntity>> QuestionData = new HashMap<>();
        QuestionData.put("data", questionService.fetchAllQuestionData());
        return QuestionData;
    }

    @RequestMapping(value = "/add-Question", method = RequestMethod.GET)
    public String showAddQuestionPage(ModelMap model) {
        model.addAttribute("add-Question", new QuestionEntity());
        return "add-Question";
    }

    @RequestMapping(value = "/add-Question", method = RequestMethod.POST)
    public String addQuestion(@Valid QuestionEntity questionEntity, BindingResult result) {

        System.out.println("Question added : "+questionService);
        questionService.saveQuestion(questionEntity);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete-Question", method = RequestMethod.GET)
    public String deleteQuestion(@RequestParam long id) {
        questionService.deleteQuestion(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/update-Question", method = RequestMethod.GET)
    public String showUpdateQuestionPage(@RequestParam long id, ModelMap model) {
        QuestionEntity QuestionEntity = questionService.getQuestionById(id).get();
        model.put("add-Question", QuestionEntity);
        return "add-Question";
    }

    @RequestMapping(value = "/update-Question", method = RequestMethod.POST)
    public String updateQuestion(@Valid QuestionEntity questionEntity, BindingResult result) {

        questionService.updateQuestion(questionEntity);
        return "redirect:/";
    }
}
