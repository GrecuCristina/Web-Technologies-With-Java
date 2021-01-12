package com.example.javai_interview_question_answer_platform.service;

import com.example.javai_interview_question_answer_platform.exception.*;
import com.example.javai_interview_question_answer_platform.model.Answer;
import com.example.javai_interview_question_answer_platform.model.Review;
import com.example.javai_interview_question_answer_platform.model.User;
import com.example.javai_interview_question_answer_platform.repository.AnswerRepository;
import com.example.javai_interview_question_answer_platform.repository.QuestionRepository;
import com.example.javai_interview_question_answer_platform.repository.ReviewRepository;
import com.example.javai_interview_question_answer_platform.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;
    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;
    private ReviewRepository reviewRepository;

    public UserService(UserRepository userRepository, QuestionRepository questionRepository, AnswerRepository answerRepository, ReviewRepository reviewRepository) {
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.reviewRepository = reviewRepository;
    }

    public User createUser(User user) {
        Optional<User> existingUserSameEmail = userRepository.getByEmail(user.getEmail());
        existingUserSameEmail.ifPresent(e -> {
           // System.out.println(user.getEmail());
            throw new DuplicateEmailException();
        });

        return userRepository.createUser(user);
    }

    public Optional<User> getById(int id) {
        return userRepository.getById(id);
    }

    public User getUser(String email, String password) {

        Optional<User> userOptional = userRepository.getUser(email, password);

        if (userOptional.isPresent()) {

            return userOptional.get();

        } else {
            throw new UserNotFoundException();
        }


    }

    public User login(String email, String password) {

        Optional<User> userOptional = userRepository.getUser(email, password);

        if (userOptional.isPresent()) {
           // System.out.println("userul este " + userOptional.get());
            if (userOptional.get().isLoggedIn() == false) {
               // System.out.println("Am intrat pe update login status service");
                userRepository.editUserLoginStatus(userOptional.get().getId(), true);
                Optional<User> userOptionalAfterStatusChanged = userRepository.getUser(email, password);
                return userOptionalAfterStatusChanged.get();

            } else {
                throw new UserAlreadyLoggedInException();
            }
        } else {
            throw new UserNotFoundException();
        }


    }

    public User logoutUser(int id) {

        Optional<User> userOptional = userRepository.getUserById(id);

        if (userOptional.isPresent()) {
            if (userOptional.get().isLoggedIn() == true) {

                userRepository.editUserLoginStatus(userOptional.get().getId(), false);
                Optional<User> userOptionalAfterStatusChanged = userRepository.getUserById(id);
                return userOptionalAfterStatusChanged.get();

            } else {
                throw new UserNotLoggedInException();
            }
        } else {
            throw new UserNotFoundException();
        }

    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public void editUserInfo(User user, int id) {
        Optional<User> existingUser = userRepository.getUserById(id);
        if(existingUser.isEmpty() == true){
            throw new UserNotFoundException(id);

        }
        else {
            if(user.isLoggedIn() == true)
            userRepository.editUserInfo(id, user.getFirstName(), user.getLastName(), user.getAge());
            else{
                throw new UserNotLoggedInException();
            }
        }
    }

    public String TotalPositiveReviews(int userId) {
        Optional<User> user = userRepository.getUserById(userId);
        if(user.isEmpty() == true){
            throw new UserNotFoundException(userId);
        }
        else {
            List<Answer> answerList = answerRepository.getAllAnswers();
            long positiveReviewsToAnswers = 0;
            long totalReviews = 0;
            answerList = answerList.stream().filter(answer -> answer.getAuthorId() == userId).collect(Collectors.toList());

            for (Answer answer : answerList) {

                List<Review> reviewList = reviewRepository.getAllReviews(answer.getId());
                totalReviews = totalReviews + reviewList.stream().count();
                positiveReviewsToAnswers = positiveReviewsToAnswers + reviewList.stream().filter(review -> review.getReviewType().toString() == "USEFUL").count();
            }

            if (totalReviews > 0){
                String s = String.valueOf((100 * positiveReviewsToAnswers) / totalReviews);
                return s+"% good reviews of user's answers"+ user.get().getFirstName() + " "+user.get().getLastName();
            }
            else {
                throw new NoReviewException();
            }
        }
    }

}
