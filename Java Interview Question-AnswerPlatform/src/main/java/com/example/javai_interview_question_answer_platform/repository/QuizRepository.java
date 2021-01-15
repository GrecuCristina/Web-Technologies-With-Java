package com.example.javai_interview_question_answer_platform.repository;

import com.example.javai_interview_question_answer_platform.model.JobType;
import com.example.javai_interview_question_answer_platform.model.Question;
import com.example.javai_interview_question_answer_platform.model.Quiz;
import com.example.javai_interview_question_answer_platform.model.QuizQuestion;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class QuizRepository {

 private JdbcTemplate jdbcTemplate;

    public QuizRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<Quiz> getQuizById(int id) {

        String sql = "select * from quizzes where id = ?";

        RowMapper<Quiz> mapper = (resultSet, rowNum) ->
                new Quiz(resultSet.getInt("id"),
                        resultSet.getInt("totalPoints")


                );


        List<Quiz> quizzes = jdbcTemplate.query(sql, mapper, id);
        if(quizzes!= null && quizzes.isEmpty() ==  false) {

            return Optional.of(quizzes.get(0));
        } else {
            return Optional.empty();
        }

    }

    public List<Quiz> getAll() {
        String sql = "SELECT * from quizzes";

        RowMapper<Quiz> mapper = (resultSet, rowNum) ->
                new Quiz(resultSet.getInt("id"),
                        resultSet.getInt("totalPoints")
                );

        return jdbcTemplate.query(sql, mapper);
    }
}
