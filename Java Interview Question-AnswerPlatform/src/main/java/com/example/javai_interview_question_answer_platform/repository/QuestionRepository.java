package com.example.javai_interview_question_answer_platform.repository;

import com.example.javai_interview_question_answer_platform.model.Question;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    public boolean removeQuestion(Question question, int id) {

        Optional<Question> questionToRemove = questionList.stream().filter(question1 -> question1.equals(question)).findFirst();
        if(questionToRemove.isPresent()){
            System.out.println("Sterg intrebarea question :"+questionToRemove);
            questionList.remove(id-1);
            System.out.println("lista intrebarilor dupa stergere este : "+questionList);
            return true;

        }
        return false;
    }

    public <Optional>Question getOneQuestion(int id) {
        System.out.println("Sterg intrebarea :"+questionList.get(id-1));
        return questionList.get(id-1);
    }
}

