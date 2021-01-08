package com.example.javai_interview_question_answer_platform.repository;

import com.example.javai_interview_question_answer_platform.exception.UserNotFoundException;
import com.example.javai_interview_question_answer_platform.model.User;
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
import java.util.stream.Collectors;

@Repository
public class UserRepository {

    private List<User>userList = new ArrayList<>();

    private JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public User createUser(User user) {
        String sql = "insert into users values (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatementCreator preparedStatementCreator = (connection) -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setObject(1, null);
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setInt(5, user.getAge());
            preparedStatement.setString(6, user.getPassword());
            preparedStatement.setString(7, "false");
            return preparedStatement;
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator, generatedKeyHolder);

        user.setId(generatedKeyHolder.getKey().intValue());
        return user;
    }

    public List<User>getAllUsers(){
        List<User>myUsers = new ArrayList<>();
        myUsers = userList.stream().filter(user -> user.getEmail().equals("grecu_cristina98@yahoo.com")).collect(Collectors.toList());
        return myUsers;
    }
    public Optional<User> getUser(String email, String password) {

        String sql = "select * from users where email = ? and password = ?";

        RowMapper<User> mapper = (resultSet, rowNum) ->
                new User(resultSet.getInt("id"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("email"),
                        resultSet.getInt("age"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("isLoggedIn")
                        );

        List<User> users = jdbcTemplate.query(sql, mapper, email, password);
        if(users!= null && !users.isEmpty()) {
            return Optional.of(users.get(0));
        } else {
            return Optional.empty();
        }

    }
    public Optional<User> getUserById(int id) {

        String sql = "select * from users where id = ?";

        RowMapper<User> mapper = (resultSet, rowNum) ->
                new User(resultSet.getInt("id"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("email"),
                        resultSet.getInt("age"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("isLoggedIn")
                );

        List<User> users = jdbcTemplate.query(sql, mapper, id);
        if(users!= null && !users.isEmpty()) {
            return Optional.of(users.get(0));
        } else {
            return Optional.empty();
        }

    }
    public void editUserInfo(int id, String firstName, String lastName) {
        String sql = "update users u set u.firstName = ?, u.lastName = ? where u.id = ?";
        System.out.println(firstName +" "+lastName+ " "+ id);
        int numberOfUpdatedUserAccounts = jdbcTemplate.update(sql, firstName, lastName, id);
        if(numberOfUpdatedUserAccounts == 0) {
            throw new UserNotFoundException();
        }

    }
    public void editUserLoginStatus(int id, boolean status) {
        System.out.println("Am intrat pe update login status repository");
        String sql = "update users u set u.isLoggedIn = ? where u.id = ?";
//        System.out.println(firstName +" "+lastName+ " "+ id);
        int numberOfUpdatedUserAccounts = jdbcTemplate.update(sql, status, id);
        if(numberOfUpdatedUserAccounts == 0) {
            throw new UserNotFoundException();
        }

    }


    public Optional<User> getByEmail(String email) {
        String sql = "select * from users u where u.email = ?";

        RowMapper<User> mapper = (resultSet, rowNum) ->
                new User(resultSet.getInt("id"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("email"),
                        resultSet.getInt("age"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("isLoggedIn")
                );

        List<User> users = jdbcTemplate.query(sql, mapper, email);
        if(users!= null && !users.isEmpty()) {
            return Optional.of(users.get(0));
        } else {
            return Optional.empty();
        }
    }



}
