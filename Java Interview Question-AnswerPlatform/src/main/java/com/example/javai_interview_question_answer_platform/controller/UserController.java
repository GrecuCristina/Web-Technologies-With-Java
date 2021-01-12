package com.example.javai_interview_question_answer_platform.controller;

import com.example.javai_interview_question_answer_platform.dto.UserDto;
import com.example.javai_interview_question_answer_platform.mapper.UserMapper;
import com.example.javai_interview_question_answer_platform.model.User;
import com.example.javai_interview_question_answer_platform.service.UserService;
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
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/register")
    public ResponseEntity<User>createUser(@Valid @RequestBody UserDto userDto){

        User user = userMapper.userDtoToUser(userDto);
        User createdUser = userService.createUser(user);
        return ResponseEntity
                .created(URI.create("/user/" + createdUser.getId()))
                .body(createdUser);



    }
    @GetMapping("/login/{email}/{password}")
    public User getUser(@PathVariable String email, @PathVariable String password){
        return userService.login(email, password);
    }
    @GetMapping("/logout/{id}")
    public User logoutUser(@PathVariable int id){
        return userService.logoutUser(id);
    }


    @PutMapping("/{id}")
    public void editUserInfo(@Valid @RequestBody UserDto userDto, @PathVariable int id) {
        User user = userMapper.userDtoToUser(userDto);
        userService.editUserInfo(user, id);
    }
    @GetMapping("/totalPositiveReviews/{userId}")
    public String TotalPositiveReviews(@PathVariable int userId){
        return userService.TotalPositiveReviews(userId);
    }

}
