package com.example.javai_interview_question_answer_platform.repository;

import com.example.javai_interview_question_answer_platform.model.Answer;
import com.example.javai_interview_question_answer_platform.model.Question;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AnswerRepository {

    private List<Answer> answerList = new ArrayList<>();

    public Answer addAnswer(Answer answer) {
        //id-ul  in viitor o sa fie automat realizat cand facem legatura la BD
       // System.out.println("In Answer Repo ");
        answer.setId(answerList.size());

        answerList.add(answer);

        return answer;

    }
}
