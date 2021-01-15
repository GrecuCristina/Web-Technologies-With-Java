package com.example.javai_interview_question_answer_platform.service;

import com.example.javai_interview_question_answer_platform.exception.QuizNotFoundException;
import com.example.javai_interview_question_answer_platform.exception.UserNotFoundException;
import com.example.javai_interview_question_answer_platform.exception.UserNotLoggedInException;
import com.example.javai_interview_question_answer_platform.model.*;
import com.example.javai_interview_question_answer_platform.repository.UserQuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserQuizService {

    private final UserQuizRepository userQuizRepository;
    private QuizAnswerService quizAnswerService;
    private QuizQuestionService quizQuestionService;
    private UserService userService;
    private QuizService quizService;

    public UserQuizService(UserQuizRepository userQuizRepository, QuizAnswerService quizAnswerService, QuizQuestionService quizQuestionService, UserService userService, QuizService quizService) {
        this.userQuizRepository = userQuizRepository;
        this.quizAnswerService = quizAnswerService;
        this.quizQuestionService = quizQuestionService;
        this.userService = userService;
        this.quizService = quizService;
    }


    public UserQuiz create(UserQuiz userQuiz) {
        return userQuizRepository.create(userQuiz);
    }

    public List<UserQuiz> getAll(int userId, int quizId) {
       return userQuizRepository.getAll(userId, quizId);
    }

    public int quizScore(int userId, int quizId){
        Optional<User> user = userService.getById(userId);
        if (user.isEmpty() == true){
            throw  new UserNotFoundException(userId);
        }
        Optional<Quiz> quiz = quizService.getById(quizId);
        if(quiz.isEmpty() == true){
            throw  new QuizNotFoundException(quizId);
        }
        if(user.get().isLoggedIn() == false){
            throw  new UserNotLoggedInException();
        }
        int finalScore = 0;
        System.out.println("quizService");
        List<UserQuiz> userQuizList = userQuizRepository.getAll(userId, quizId);
        for (UserQuiz userQuiz :  userQuizList){
            Optional<QuizAnswer> quizAnswer = quizAnswerService.getById(userQuiz.getaId());
            if(quizAnswer.isEmpty() == false){

                System.out.println(quizAnswer.get().getIsCorrect());
                if(quizAnswer.get().getIsCorrect().equals("Yes")){

                    Optional<QuizQuestion> quizQuestion = quizQuestionService.getById(userQuiz.getQeId());
                    if(quizQuestion.isEmpty() == false) {

                        finalScore = finalScore + quizQuestion.get().getPoint();
                    }

                }
            }

        }
        return finalScore;

    }
    public String QuizCorrectAnswers(int userId, int quizId){
        System.out.println("QuizCorrect");
        Optional<User> user = userService.getById(userId);
        if (user.isEmpty() == true){
            throw  new UserNotFoundException(userId);
        }
        Optional<Quiz> quiz = quizService.getById(quizId);
        if(quiz.isEmpty() == true){
            throw  new QuizNotFoundException(quizId);
        }
        if(user.get().isLoggedIn() == false){
            throw  new UserNotLoggedInException();
        }
        String finalString = "";
        List<QuizQuestion> questionList = quizQuestionService.getAll(quizId);
        for(QuizQuestion question :questionList){

            finalString = finalString.concat(question.getDescription()+ " corect answer : ");
            Optional<QuizAnswer> quizAnswer = quizAnswerService.getCorrectAnswer(question.getId());
            if(quizAnswer.isEmpty() == false){

                finalString = finalString.concat(quizAnswer.get().getId()+ ". "+quizAnswer.get().getDescription() +'\n');
            }
        }
        return finalString;
    }


}
