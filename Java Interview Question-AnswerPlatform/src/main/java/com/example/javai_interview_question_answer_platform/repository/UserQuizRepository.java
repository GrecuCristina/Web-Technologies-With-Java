package com.example.javai_interview_question_answer_platform.repository;

import com.example.javai_interview_question_answer_platform.model.JobType;
import com.example.javai_interview_question_answer_platform.model.Question;
import com.example.javai_interview_question_answer_platform.model.User;
import com.example.javai_interview_question_answer_platform.model.UserQuiz;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class UserQuizRepository {

    private JdbcTemplate jdbcTemplate;

    public UserQuizRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public UserQuiz create(UserQuiz userQuiz) {
        String sql = "insert into userQuizzes values (?, ?, ?, ?, ?, ?)";
        PreparedStatementCreator preparedStatementCreator = (connection) -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setObject(1, null);
            preparedStatement.setInt(2, userQuiz.getuId());
            preparedStatement.setInt(3, userQuiz.getQuId());
            preparedStatement.setInt(4, userQuiz.getQeId());
            preparedStatement.setInt(5, userQuiz.getaId());
            preparedStatement.setInt(6, userQuiz.getPoints());
            return preparedStatement;
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator, generatedKeyHolder);

        userQuiz.setId(generatedKeyHolder.getKey().intValue());

        return userQuiz;
    }

    public List<UserQuiz> getAll(int userId, int quizId) {
        String sql = "SELECT * from userquizzes where uId = ? and quId = ?";

        RowMapper<UserQuiz> mapper = (resultSet, rowNum) ->
                new UserQuiz(resultSet.getInt("id"),
                        resultSet.getInt("uId"),
                        resultSet.getInt("quId"),
                        resultSet.getInt("qeId"),
                        resultSet.getInt("aId"),
                        resultSet.getInt("points")

                );

        return jdbcTemplate.query(sql, mapper, userId, quizId);
    }

}
