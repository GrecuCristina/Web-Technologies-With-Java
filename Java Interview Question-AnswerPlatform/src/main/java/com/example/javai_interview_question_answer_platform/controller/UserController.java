package com.example.javai_interview_question_answer_platform.controller;

import com.example.javai_interview_question_answer_platform.dto.UserDto;
import com.example.javai_interview_question_answer_platform.mapper.UserMapper;
import com.example.javai_interview_question_answer_platform.model.User;
import com.example.javai_interview_question_answer_platform.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@Validated
@RequestMapping("/user")
public class UserController {


    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;

    }
    @GetMapping("/showAllUsers")
    @ApiOperation(value = "Show all Users",
            notes = " Show all Users - based on the information received in the request")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/register")
    @ApiOperation(value = "Create an User",
            notes = "Creates a new User by registering - based on the information received in the request")
    public ResponseEntity<User>createUser(@Valid @RequestBody UserDto userDto){

        User user = userMapper.userDtoToUser(userDto);
        User createdUser = userService.createUser(user);
        return ResponseEntity
                .created(URI.create("/user/" + createdUser.getId()))
                .body(createdUser);



    }
    @GetMapping("/login/{email}/{password}")
    @ApiOperation(value = "Login an User",
            notes = "Login an user- based on the information received in the request")
    public User getUser(@PathVariable String email, @PathVariable String password){
        return userService.login(email, password);
    }
    @GetMapping("/logout/{id}")
    @ApiOperation(value = "Logout an User",
            notes = "Logout an user- based on the information received in the request")
    public User logoutUser(@PathVariable int id){
        return userService.logoutUser(id);
    }


    @PutMapping("/{id}")
    @ApiOperation(value = "Edit personal info for  an User",
            notes = "Edit personal info for  an Use: fname, lname, age - based on the information received in the request")
    public void editUserInfo(@Valid @RequestBody UserDto userDto, @PathVariable int id) {
        User user = userMapper.userDtoToUser(userDto);
        userService.editUserInfo(user, id);
    }
    @GetMapping("/totalPositiveReviews/{userId}")
    @ApiOperation(value = "Positive Reviews for  an User",
            notes = "Percentage of positive reviews based on the added answers ")
    public String TotalPositiveReviews(@PathVariable int userId){
        return userService.TotalPositiveReviews(userId);
    }

}
