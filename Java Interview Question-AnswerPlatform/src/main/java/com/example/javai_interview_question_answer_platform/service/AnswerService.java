package com.example.javai_interview_question_answer_platform.service;

import com.example.javai_interview_question_answer_platform.exception.QuestionNotFoundException;
import com.example.javai_interview_question_answer_platform.exception.UserNotFoundException;
import com.example.javai_interview_question_answer_platform.exception.UserNotLoggedInException;
import com.example.javai_interview_question_answer_platform.model.Answer;
import com.example.javai_interview_question_answer_platform.model.Question;
import com.example.javai_interview_question_answer_platform.model.User;
import com.example.javai_interview_question_answer_platform.repository.AnswerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {


    public AnswerService(UserService userService, AnswerRepository answerRepository, QuestionService questionService) {
        this.userService = userService;
        this.answerRepository = answerRepository;
        this.questionService = questionService;
    }

    private UserService userService;
    private AnswerRepository answerRepository;
    private QuestionService questionService;

    public Optional<Answer> getById(int id){
        return answerRepository.getById(id);
    }

    public Answer addAnswer(Answer answer){

        Optional<User> user = userService.getById(answer.getAuthorId());
        Optional<Question> question = questionService.getById(answer.getQuestionId());
        if(user.isEmpty()){

            throw new UserNotFoundException(answer.getAuthorId());

        }

        if(question.isEmpty()){
            throw new QuestionNotFoundException();
        }
        else {
            if(user.get().isLoggedIn() == true)
                return answerRepository.addAnswer(answer);
            else{
                throw new UserNotLoggedInException();
            }
        }

    }

    public List<Answer> getAllAnswers(int questionId) {
        Optional<Question> question = questionService.getById(questionId);
        if(question.isEmpty() == true){
            throw new QuestionNotFoundException();
        }
        else
        return answerRepository.getAllAnswers(questionId);
    }
}
