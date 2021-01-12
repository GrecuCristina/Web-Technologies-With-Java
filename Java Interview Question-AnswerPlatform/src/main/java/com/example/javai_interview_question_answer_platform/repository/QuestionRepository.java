package com.example.javai_interview_question_answer_platform.repository;

import com.example.javai_interview_question_answer_platform.model.JobType;
import com.example.javai_interview_question_answer_platform.model.Question;
import com.example.javai_interview_question_answer_platform.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository
public class QuestionRepository {


    private JdbcTemplate jdbcTemplate;

    public QuestionRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Question addQuestion(Question question) {

        String sql = "insert into questions values (?, ?, ?, ?, ?, ?)";

        PreparedStatementCreator preparedStatementCreator = (connection) -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setObject(1, null);
            preparedStatement.setString(2, question.getDescription());
            preparedStatement.setString(3, question.getJobType().toString());
            preparedStatement.setTimestamp(4, new java.sql.Timestamp(System.currentTimeMillis()));
            preparedStatement.setInt(5, question.getUserId());
            preparedStatement.setString(6, question.getCompanyName());


            return preparedStatement;
        };
    ;

        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator, generatedKeyHolder);
        question.setId(generatedKeyHolder.getKey().intValue());
        question.setDate(new java.sql.Timestamp(System.currentTimeMillis()));

        return question;
    }
    public Optional<Question> getQuestionById(int id) {

        String sql = "select * from questions where id = ?";

        RowMapper<Question> mapper = (resultSet, rowNum) ->
                new Question(resultSet.getInt("id"),
                        resultSet.getString("description"),
                         JobType.valueOf(resultSet.getString("jobType")),
                        resultSet.getTimestamp("date"),
                        resultSet.getInt("userId"),
                        resultSet.getString("companyName")

                );


        List<Question> questions = jdbcTemplate.query(sql, mapper, id);
        if(questions!= null && questions.isEmpty() ==  false) {

            return Optional.of(questions.get(0));
        } else {
            return Optional.empty();
        }

    }

    public boolean removeQuestion(int id) {
        String sql = "delete from questions where id =?";
        return jdbcTemplate.update(sql, id) !=0 ;
    }
    public List<Question> getAll() {
        String sql = "SELECT * from questions";

        RowMapper<Question> mapper = (resultSet, rowNum) ->
                new Question(resultSet.getInt("id"),
                        resultSet.getString("description"),
                        JobType.valueOf(resultSet.getString("jobType")),
                        resultSet.getTimestamp("date"),
                        resultSet.getInt("userId"),
                        resultSet.getString("companyName")

                );

        return jdbcTemplate.query(sql, mapper);
    }
}

