package com.example.javai_interview_question_answer_platform.service;

import com.example.javai_interview_question_answer_platform.exception.QuestionNotFoundException;
import com.example.javai_interview_question_answer_platform.exception.UserNotFoundException;
import com.example.javai_interview_question_answer_platform.model.Answer;
import com.example.javai_interview_question_answer_platform.model.Question;
import com.example.javai_interview_question_answer_platform.model.User;
import com.example.javai_interview_question_answer_platform.repository.AnswerRepository;
import com.example.javai_interview_question_answer_platform.repository.QuestionRepository;
import com.example.javai_interview_question_answer_platform.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;

    public UserService(UserRepository userRepository, QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    public User createUser(User user) {

        return userRepository.createUser(user);
    }

    public User getUser(String email, String password) {

        Optional<User> userOptional = userRepository.getUser(email, password);

        if(userOptional.isPresent()){
            return userOptional.get();
        }
        else{
            throw new UserNotFoundException();
        }


    }

    public Question addQuestion(Question question){
        return questionRepository.addQuestion(question);

    }
    public boolean removeQuestion(int id) {
        Optional<Question> question = Optional.ofNullable(questionRepository.getOneQuestion(id));
        if(question.isPresent())
        {
            return questionRepository.removeQuestion(question.get(), id);
        }
        else{
          
            throw new QuestionNotFoundException();
        }

    }
    public List<User> getAllUsers(){
        return userRepository.getAllUsers();
    }

    public Answer addAnswer(Answer answer) {
       // System.out.println("Answer Service ");
        return answerRepository.addAnswer(answer);
    }
}
