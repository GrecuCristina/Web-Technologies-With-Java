package com.example.javai_interview_question_answer_platform.repository;

import com.example.javai_interview_question_answer_platform.model.Question;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class QuestionRepository {

    private List<Question> questionList = new ArrayList<>();
    public Question addQuestion(Question question) {
        //pt moment setez asa id-ul, dupa ce se face legatura la BD se va modifica metoda de setare
        question.setId(questionList.size()+1);
        question.setDate(new Date());
        questionList.add(question);
        return question;
    }
}

