package com.example.javai_interview_question_answer_platform.service;

import com.example.javai_interview_question_answer_platform.exception.QuestionNotFoundException;
import com.example.javai_interview_question_answer_platform.exception.UserNotAuthorizedException;
import com.example.javai_interview_question_answer_platform.exception.UserNotFoundException;
import com.example.javai_interview_question_answer_platform.exception.UserNotLoggedInException;
import com.example.javai_interview_question_answer_platform.model.Question;
import com.example.javai_interview_question_answer_platform.model.User;
import com.example.javai_interview_question_answer_platform.repository.QuestionRepository;
import com.example.javai_interview_question_answer_platform.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class QuestionService {
    private QuestionRepository questionRepository;
    private UserService userService;

    public QuestionService(QuestionRepository questionRepository, UserService userService) {
        this.questionRepository = questionRepository;
        this.userService = userService;
    }

    public Question addQuestion(Question question){

        System.out.println("inside addQuestion "+ question.getId());

        Optional<User> user = userService.getById(question.getUserId());
        if(user.isEmpty()){

            throw new UserNotFoundException(question.getUserId());

        }
        else {
            if(user.get().isLoggedIn() == true)
                return questionRepository.addQuestion(question);
            else{
                throw new UserNotLoggedInException();
            }
        }

    }



    public boolean removeQuestion(int userId, int id) {
        System.out.println(id);
        Optional<Question> questionOptional = questionRepository.getQuestionById(id);
        System.out.println(" ");
        if(questionOptional.isPresent())
        {

            Optional<User> user = userService.getById(userId);
            if(user.isEmpty() == true){
                throw new UserNotFoundException();
            }
            else {
                if(user.get().isLoggedIn() == true) {
                    //ma asigur ca autorul sterge o intrebare care ii apartine


                    if (questionOptional.get().getUserId() == user.get().getId()) {
                        return questionRepository.removeQuestion(id);
                    } else {
                        throw new UserNotAuthorizedException(user.get().getId());
                    }
                }
                else{
                    throw new UserNotLoggedInException();
                }
            }

        }
        else{

            throw new QuestionNotFoundException();
        }

    }
    public Optional<Question> getById(int id){
        return questionRepository.getQuestionById(id);
    }

    public List<Question> getAll() {
        return questionRepository.getAll();
    }

}
