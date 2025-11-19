package com.quiz.controller;

import com.quiz.Service.QuizService;
import com.quiz.enitity.Quiz;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")

public class QuizController {

    private QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    //Create
    @PostMapping
    public Quiz create(@RequestBody Quiz quiz) {
        return quizService.add(quiz);

    }

    //getall
    @GetMapping
    public List<Quiz> get() {
        return quizService.get();

    }

    @GetMapping("/{id}")
    public Quiz getOne(@PathVariable Long id) {
        return quizService.get(id);


    }
}