package com.example.javai_interview_question_answer_platform.repository;

import com.example.javai_interview_question_answer_platform.model.JobType;
import com.example.javai_interview_question_answer_platform.model.Question;
import com.example.javai_interview_question_answer_platform.model.QuizQuestion;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class QuizQuestionRepository {
    private JdbcTemplate jdbcTemplate;

    public QuizQuestionRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<QuizQuestion> getAll(int id) {
        String sql = "SELECT * from quizQuestions where quizId = ?";

        RowMapper<QuizQuestion> mapper = (resultSet, rowNum) ->
                new QuizQuestion(resultSet.getInt("id"),
                        resultSet.getInt("quizId"),
                        resultSet.getString("description"),
                        resultSet.getInt("point")


                );

        return jdbcTemplate.query(sql, mapper, id);
    }
    public Optional<QuizQuestion> getById(int id) {
        String sql = "SELECT * from quizQuestions where id = ?";

        RowMapper<QuizQuestion> mapper = (resultSet, rowNum) ->
                new QuizQuestion(resultSet.getInt("id"),
                        resultSet.getInt("quizId"),
                        resultSet.getString("description"),
                        resultSet.getInt("point")


                );

        List<QuizQuestion> questions = jdbcTemplate.query(sql, mapper, id);
        if(questions!= null && questions.isEmpty() ==  false) {

            return Optional.of(questions.get(0));
        } else {
            return Optional.empty();
        }
    }



}
