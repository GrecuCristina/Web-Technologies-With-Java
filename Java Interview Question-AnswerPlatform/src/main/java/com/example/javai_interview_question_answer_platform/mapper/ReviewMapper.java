package com.example.javai_interview_question_answer_platform.mapper;

import com.example.javai_interview_question_answer_platform.dto.QuestionDto;
import com.example.javai_interview_question_answer_platform.dto.ReviewDto;
import com.example.javai_interview_question_answer_platform.model.Question;
import com.example.javai_interview_question_answer_platform.model.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {

    public Review reviewDtoToReview(ReviewDto reviewDto){
        return new Review(reviewDto.getReviewType(), reviewDto.getUserReviewId(), reviewDto.getAnswerId());
    }
}
