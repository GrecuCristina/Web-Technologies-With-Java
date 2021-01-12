package com.example.javai_interview_question_answer_platform.repository;

import com.example.javai_interview_question_answer_platform.model.Answer;
import com.example.javai_interview_question_answer_platform.model.JobType;
import com.example.javai_interview_question_answer_platform.model.Question;
import com.example.javai_interview_question_answer_platform.model.ReviewType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AnswerRepository {

    private JdbcTemplate jdbcTemplate;

    public AnswerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Answer addAnswer(Answer answer) {

        String sql = "insert into answers values (?, ?, ?, ?, ?)";

        PreparedStatementCreator preparedStatementCreator = (connection) -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setObject(1, null);
            preparedStatement.setString(2, answer.getDescription());
            preparedStatement.setTimestamp(3, new java.sql.Timestamp(System.currentTimeMillis()));
            preparedStatement.setInt(4, answer.getAuthorId());
            preparedStatement.setInt(5, answer.getQuestionId());


            return preparedStatement;
        };


        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator, generatedKeyHolder);
        answer.setId(generatedKeyHolder.getKey().intValue());
        answer.setDate(new java.sql.Timestamp(System.currentTimeMillis()));

        return answer;
    }
    public List<Answer> getAllAnswers() {
        String sql = "SELECT * from answers";

        RowMapper<Answer> mapper = (resultSet, rowNum) ->
                new Answer(resultSet.getInt("id"),
                        resultSet.getString("description"),
                        resultSet.getTimestamp("date"),
                        resultSet.getInt("authorId"),
                        resultSet.getInt("questionId")

                );

        return jdbcTemplate.query(sql, mapper);
    }
    public List<Answer> getAllAnswers(int questionId) {
        String sql = "SELECT * from answers where questionId = ?";

        RowMapper<Answer> mapper = (resultSet, rowNum) ->
                new Answer(resultSet.getInt("id"),
                        resultSet.getString("description"),
                        resultSet.getTimestamp("date"),
                        resultSet.getInt("authorId"),
                        resultSet.getInt("questionId")

                );

        return jdbcTemplate.query(sql, mapper, questionId);
    }

    public Optional<Answer> getById(int id) {
        String sql = "select * from answers where id = ?";

        RowMapper<Answer> mapper = (resultSet, i) ->
                new Answer(resultSet.getInt("id"),
                        resultSet.getString("description"),
                        resultSet.getTimestamp("date"),
                        resultSet.getInt("authorId"),
                        resultSet.getInt("questionId")
                );
        List<Answer> answers = jdbcTemplate.query(sql, mapper, id);
        if(answers != null && answers.isEmpty() == false){
            return Optional.of(answers.get(0));
        }
        else{
            return Optional.empty();
        }
    }
}
