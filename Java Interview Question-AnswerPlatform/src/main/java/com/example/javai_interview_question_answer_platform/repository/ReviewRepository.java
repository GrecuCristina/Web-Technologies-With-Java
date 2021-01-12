package com.example.javai_interview_question_answer_platform.repository;

import com.example.javai_interview_question_answer_platform.model.Answer;
import com.example.javai_interview_question_answer_platform.model.JobType;
import com.example.javai_interview_question_answer_platform.model.Review;
import com.example.javai_interview_question_answer_platform.model.ReviewType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class ReviewRepository {

    private JdbcTemplate jdbcTemplate;

    public ReviewRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Review addReview(Review review) {

        String sql = "insert into reviews values (?, ?, ?, ?, ?)";


        PreparedStatementCreator preparedStatementCreator = (connection) -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setObject(1, null);
            preparedStatement.setString(2, review.getReviewType().toString());
            preparedStatement.setTimestamp(3, new java.sql.Timestamp(System.currentTimeMillis()));
            preparedStatement.setInt(4, review.getUserReviewId());
            preparedStatement.setInt(5, review.getAnswerId());

            return preparedStatement;
        };
        ;

        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator, generatedKeyHolder);
        review.setId(generatedKeyHolder.getKey().intValue());
        review.setDate(new java.sql.Timestamp(System.currentTimeMillis()));

        return review;
    }

    public List<Review> getAllReviews(int answerId) {
        String sql = "SELECT * from reviews where answerId = ?";

        RowMapper<Review> mapper = (resultSet, rowNum) ->
                new Review(resultSet.getInt("id"),
                        ReviewType.valueOf(resultSet.getString("reviewType")),
                        resultSet.getTimestamp("date"),
                        resultSet.getInt("userReviewId"),
                        resultSet.getInt("answerId")

                );

        return jdbcTemplate.query(sql, mapper, answerId);
    }
}
