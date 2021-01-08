package com.example.javai_interview_question_answer_platform.repository;

import com.example.javai_interview_question_answer_platform.model.Question;
import com.example.javai_interview_question_answer_platform.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class QuestionRepository {


    private JdbcTemplate jdbcTemplate;

    public Question addQuestion(Question question) {
        System.out.println("Inside question Repository - add question");

        String sql = "insert into questions values (?, ?, ?, ?, ?)";
        System.out.println("ceva");
        PreparedStatementCreator preparedStatementCreator = (connection) -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setObject(1, null);
            preparedStatement.setString(2, question.getDescription());
            preparedStatement.setString(3, question.getJobType().toString());
            preparedStatement.setDate(4, new java.sql.Date(System.currentTimeMillis()));
            preparedStatement.setInt(5, question.getUserId());

            return preparedStatement;
        };
        System.out.println("ceva2");
        System.out.println("date = "+question.getDate());
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        System.out.println("ceva3");
        jdbcTemplate.update(preparedStatementCreator, generatedKeyHolder);
        System.out.println("ceva4");
        question.setId(generatedKeyHolder.getKey().intValue());
        System.out.println("ceva5");
        System.out.println("question id = "+ question.getId() + "date = "+question.getDate());



        return question;
    }

//    public boolean removeQuestion(Question question, int id) {
//
//        Optional<Question> questionToRemove = questionList.stream().filter(question1 -> question1.equals(question)).findFirst();
//        if(questionToRemove.isPresent()){
//            System.out.println("Sterg intrebarea question :"+questionToRemove);
//            questionList.remove(id-1);
//            System.out.println("lista intrebarilor dupa stergere este : "+questionList);
//            return true;
//
//        }
//        return false;
//    }
//
//    public <Optional>Question getOneQuestion(int id) {
//        System.out.println("Sterg intrebarea :"+questionList.get(id-1));
//        return questionList.get(id-1);
//    }
}

