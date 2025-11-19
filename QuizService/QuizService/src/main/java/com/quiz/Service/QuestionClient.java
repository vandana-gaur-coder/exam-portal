package com.quiz.Service;

import com.quiz.enitity.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@EnableFeignClients( url ="http://localhost:8082",value = "Question-Client")
public interface QuestionClient {
    @GetMapping("/question/quiz/{quizId}")
    List<Question> getQuestionOfQuiz(@PathVariable ("quizId")Long quizId);
}
