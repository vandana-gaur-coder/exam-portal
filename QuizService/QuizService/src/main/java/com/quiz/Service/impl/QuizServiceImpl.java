package com.quiz.Service.impl;

import com.quiz.Service.QuestionClient;
import com.quiz.Service.QuizService;
import com.quiz.enitity.Question;
import com.quiz.enitity.Quiz;
import com.quiz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service

public class QuizServiceImpl implements QuizService {


    private QuizRepository quizRepository;



    private QuestionClient questionClient;

    public QuizServiceImpl(QuizRepository quizRepository,QuestionClient questionClient){
        this.quizRepository = quizRepository;
        this.questionClient = questionClient;
    }


    @Override
    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

//    @Override
//    public List<Quiz> get() {
//        return  quizRepository.findAll();
//
//    }
//
//    @Override
//    public Quiz get(Long id) {
//        return quizRepository.findById(id).orElseThrow(()-> new RuntimeException("Quiz Not Found "));
//    }

//    @Override
//    public List<Quiz> get() {
//        List<Quiz> quizzes = quizRepository.findAll();
//
//        List<Quiz> newQuizList = quizzes.stream().map(quiz -> {
//            quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
//            return quiz;
//        }).collect(Collectors.toList());
//
//        return newQuizList;
//    }

    @Override
    public List<Quiz> get() {
        List<Quiz> quizzes = quizRepository.findAll();

        return quizzes.stream()
                .map(quiz -> {
                    quiz.setQuestions(
                            questionClient.getQuestionOfQuiz(quiz.getId())
                    );
                    return quiz;
                })
                .collect(Collectors.toList());
    }

//
//    @Override
//    public Quiz get(Long id) {
//
//        Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
//        quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
//        return quiz;
//
//
//    }
@Override
public Quiz get(Long id) {

    Quiz quiz = quizRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Quiz not found"));

    quiz.setQuestions(
            questionClient.getQuestionOfQuiz(quiz.getId())
    );

    return quiz;
}

}