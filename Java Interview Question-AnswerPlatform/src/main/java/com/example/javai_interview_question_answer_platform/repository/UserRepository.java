package com.example.javai_interview_question_answer_platform.repository;

import com.example.javai_interview_question_answer_platform.model.Question;
import com.example.javai_interview_question_answer_platform.model.User;
import org.apache.tomcat.jni.Time;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserRepository {

    private List<User>userList = new ArrayList<>();


    public User createUser(User user) {
        //pt moment setez asa id-ul, dupa ce se face legatura la BD se va modifica metoda de setare
        user.setId(userList.size()+1);
        userList.add(user);
        return user;
    }

    public List<User>getAllUsers(){
        List<User>myUsers = new ArrayList<>();
        myUsers = userList.stream().filter(user -> user.getEmail().equals("grecu_cristina98@yahoo.com")).collect(Collectors.toList());
        return myUsers;
    }
    public Optional<User> getUser(String email, String password) {

        return userList.stream().filter(user -> user.getEmail().equals(email) & user.getPassword().equals(password)).findFirst();

    }


}
