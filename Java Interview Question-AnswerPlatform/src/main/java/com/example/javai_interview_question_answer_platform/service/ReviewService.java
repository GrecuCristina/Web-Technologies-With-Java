package com.example.javai_interview_question_answer_platform.service;

import com.example.javai_interview_question_answer_platform.exception.AnswerNotFoundException;
import com.example.javai_interview_question_answer_platform.exception.UserNotFoundException;
import com.example.javai_interview_question_answer_platform.exception.UserNotLoggedInException;
import com.example.javai_interview_question_answer_platform.model.Answer;
import com.example.javai_interview_question_answer_platform.model.Question;
import com.example.javai_interview_question_answer_platform.model.Review;
import com.example.javai_interview_question_answer_platform.model.User;
import com.example.javai_interview_question_answer_platform.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    private final UserService userService;
    private final AnswerService answerService;
    private final ReviewRepository reviewRepository;

    public ReviewService(UserService userService, AnswerService answerService, ReviewRepository reviewRepository) {
        this.userService = userService;
        this.answerService = answerService;
        this.reviewRepository = reviewRepository;
    }

    public Review addReview(Review review) {
        Optional<User> user = userService.getById(review.getUserReviewId());
        Optional<Answer>  answer =  answerService.getById(review.getAnswerId());

        if(user.isEmpty()){
            throw new UserNotFoundException(review.getUserReviewId());
        }
        if(answer.isEmpty()){
            throw new AnswerNotFoundException(review.getAnswerId());
        }

       else{
            if(user.get().isLoggedIn() == true)
                return reviewRepository.addReview(review);
            else{
                throw new UserNotLoggedInException();
            }
        }

    }
    public List<Review> getAllReviews(int answerId) {
        return reviewRepository.getAllReviews(answerId);
    }
}
