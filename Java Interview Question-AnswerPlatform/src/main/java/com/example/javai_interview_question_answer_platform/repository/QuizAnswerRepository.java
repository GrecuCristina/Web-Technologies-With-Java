package com.example.javai_interview_question_answer_platform.repository;

import com.example.javai_interview_question_answer_platform.model.JobType;
import com.example.javai_interview_question_answer_platform.model.Question;
import com.example.javai_interview_question_answer_platform.model.QuizAnswer;
import com.example.javai_interview_question_answer_platform.model.QuizQuestion;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class QuizAnswerRepository {
    private JdbcTemplate jdbcTemplate;

    public QuizAnswerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<QuizAnswer> getAll(int id) {
        String sql = "SELECT * from quizAnswers where quizQuestionId = ?";

        RowMapper<QuizAnswer> mapper = (resultSet, rowNum) ->
                new QuizAnswer(resultSet.getInt("id"),
                        resultSet.getInt("quizQuestionId"),
                        resultSet.getString("description"),
                        resultSet.getString("isCorrect")


                );

        return jdbcTemplate.query(sql, mapper, id);
    }

    public Optional<QuizAnswer> getById(int id) {

        String sql = "select * from quizAnswers where id = ?";

        RowMapper<QuizAnswer> mapper = (resultSet, rowNum) ->
                new QuizAnswer(resultSet.getInt("id"),
                        resultSet.getInt("quizQuestionId"),
                        resultSet.getString("description"),
                        resultSet.getString("isCorrect")

                );


        List<QuizAnswer> answers = jdbcTemplate.query(sql, mapper, id);
        if(answers!= null && answers.isEmpty() ==  false) {

            return Optional.of(answers.get(0));
        } else {
            return Optional.empty();
        }

    }
    public Optional<QuizAnswer> getCorrectAnswer(int questionId) {

        String sql = "select * from quizAnswers where quId = ? and isCorrect = ?";

        RowMapper<QuizAnswer> mapper = (resultSet, rowNum) ->
                new QuizAnswer(resultSet.getInt("id"),
                        resultSet.getInt("quizQuestionId"),
                        resultSet.getString("description"),
                        resultSet.getString("isCorrect")

                );


        List<QuizAnswer> answers = jdbcTemplate.query(sql, mapper, questionId, "Yes");
        if(answers!= null && answers.isEmpty() ==  false) {

            return Optional.of(answers.get(0));
        } else {
            return Optional.empty();
        }

    }
}


