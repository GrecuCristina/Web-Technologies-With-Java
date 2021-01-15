package com.example.javai_interview_question_answer_platform.controller;

import com.example.javai_interview_question_answer_platform.dto.ReviewDto;
import com.example.javai_interview_question_answer_platform.mapper.ReviewMapper;
import com.example.javai_interview_question_answer_platform.model.Review;
import com.example.javai_interview_question_answer_platform.service.ReviewService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RestController
@Validated
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;
    private final ReviewMapper reviewMapper;

    public ReviewController(ReviewService reviewService, ReviewMapper reviewMapper) {
        this.reviewService = reviewService;
        this.reviewMapper = reviewMapper;
    }

    @PostMapping
    @ApiOperation(value = "Add review",
            notes = "Add review for a posted answer (useful/useless) - based on the information received in the request")
    public ResponseEntity<Review> addReview(@Valid @RequestBody ReviewDto reviewDto){
        Review review = reviewMapper.reviewDtoToReview(reviewDto);
        Review createdReview = reviewService.addReview(review);
        return ResponseEntity
                .created(URI.create("/review/" + createdReview.getId()))
                .body(createdReview);

    }
}
