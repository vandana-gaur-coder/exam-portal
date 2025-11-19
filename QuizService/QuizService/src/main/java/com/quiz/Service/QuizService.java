package com.quiz.Service;

import com.quiz.enitity.Quiz;

import java.util.List;

public interface QuizService {
    Quiz add(Quiz quiz);
    List<Quiz> get();
    Quiz get(Long id);

}
