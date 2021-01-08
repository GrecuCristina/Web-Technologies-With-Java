package com.example.javai_interview_question_answer_platform.service;

import com.example.javai_interview_question_answer_platform.exception.*;
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
        Optional<User> existingUserSameEmail = userRepository.getByEmail(user.getEmail());
        existingUserSameEmail.ifPresent(e -> {
            throw new DuplicateEmailException();
        });

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
    public User login(String email, String password) {

        Optional<User> userOptional = userRepository.getUser(email, password);

        if(userOptional.isPresent()){
           if(userOptional.get().isLoggedIn() == false){
               System.out.println("Am intrat pe update login status service");
               userRepository.editUserLoginStatus(userOptional.get().getId(), true);
               Optional<User> userOptionalAfterStatusChanged = userRepository.getUser(email, password);
               return userOptionalAfterStatusChanged.get();

           }
         else{
               throw new UserAlreadyLoggedInException();
           }
        }
        else{
            throw new UserNotFoundException();
        }


    }
    public User logoutUser(int id) {

        Optional<User> userOptional = userRepository.getUserById(id);

        if(userOptional.isPresent()){
            if(userOptional.get().isLoggedIn() == true){

                userRepository.editUserLoginStatus(userOptional.get().getId(), false);
                Optional<User> userOptionalAfterStatusChanged = userRepository.getUserById(id);
                return userOptionalAfterStatusChanged.get();

            }
            else{
                throw new UserNotLoggedInException();
            }
        }
        else{
            throw new UserNotFoundException();
        }


    }


    public List<User> getAllUsers(){
        return userRepository.getAllUsers();
    }

    public Answer addAnswer(Answer answer) {
       // System.out.println("Answer Service ");
        return answerRepository.addAnswer(answer);
    }
    public void editUserInfo(User user, int id){
        userRepository.editUserInfo(id, user.getFirstName(), user.getLastName());
    }
//    public void editUserLoginStatus(int id, boolean status){
//        userRepository.editUserLoginStatus(id, status);
//    }
}
