package com.example.javai_interview_question_answer_platform.service;

import com.example.javai_interview_question_answer_platform.exception.QuizNotFoundException;
import com.example.javai_interview_question_answer_platform.model.Quiz;
import com.example.javai_interview_question_answer_platform.model.QuizAnswer;
import com.example.javai_interview_question_answer_platform.model.QuizQuestion;
import com.example.javai_interview_question_answer_platform.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    
    private QuizRepository quizRepository;
    private QuizAnswerService quizAnswerService;
    private QuizQuestionService quizQuestionService;

    public QuizService(QuizRepository quizRepository, QuizAnswerService quizAnswerService, QuizQuestionService quizQuestionService) {
        this.quizRepository = quizRepository;
        this.quizAnswerService = quizAnswerService;
        this.quizQuestionService = quizQuestionService;
    }
    public List<Quiz> getAll(){
        return quizRepository.getAll();
    }
    public Optional<Quiz> getById(int id){
        Optional<Quiz> quiz = quizRepository.getQuizById(id);
        if (quiz.isEmpty() == true){
            throw new QuizNotFoundException(id);
        }
        return quizRepository.getQuizById(id);
    }

    public String showQuiz(int id){
        Optional<Quiz> quiz = quizRepository.getQuizById(id);
        if (quiz.isEmpty() == true){
            throw new QuizNotFoundException(id);
        }
        List<QuizQuestion> questionList = quizQuestionService.getAll(id);
        String finalString = "";
        for (QuizQuestion question : questionList){
           String s = question.getId() +". "+ question.getDescription() + " : ";
           finalString = finalString.concat(s)+'\n';
            finalString = finalString.concat("  answers :"+'\n');
           List<QuizAnswer> answers = quizAnswerService.getAll(question.getId());
           for(QuizAnswer answer : answers)
           {

               finalString =finalString.concat("   "+answer.getId() +". "+ answer.getDescription()) + '\n';
           }


        }
        return finalString;
    }
}
