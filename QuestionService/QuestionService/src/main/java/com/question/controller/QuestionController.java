package com.question.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.Service.QuestionService;
import com.question.entity.Question;

@RestController
@RequestMapping("/question")

public class QuestionController {

    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public Question create(@RequestBody Question question) {
        return questionService.create(question);
    }

    @GetMapping
    public List<Question> getAll() {
        return questionService.get();

    }

    @GetMapping("/{questionID}")
    public Question getAll(@PathVariable Long questionID) {
        return questionService.getOne(questionID);
    }

    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionsOfQuiz(@PathVariable Long quizId) {
        return questionService.getQuestionsOfQuiz(quizId);
    }
}
