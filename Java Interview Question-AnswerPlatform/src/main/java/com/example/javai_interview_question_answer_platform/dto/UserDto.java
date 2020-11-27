package com.example.javai_interview_question_answer_platform.dto;

import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.*;

public class UserDto {

    @NotBlank(message = "FirstName cannot be empty")
    private String firstName;
    @NotBlank(message = "LastName cannot be empty")
    private String lastName;
    @Email(message = "Email must be valid")

    private String email;
    @Min(0)
    @Max(150)
    private int age;
    @Pattern(regexp = com.example.javai_interview_question_answer_platform.model.Pattern.PASSWORD, message = "Password must contain uppercase, letter, numbers, special characters minimum 8 length")
    private String password;
    public UserDto() {
    }

    public UserDto(String firstName, String lastName, String email, int age, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
