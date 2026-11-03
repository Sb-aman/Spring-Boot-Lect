package aman.example.crudSpringBootDemo.dto;

import jakarta.validation.constraints.*;

public class CreateStudentRequestDto {

    @NotBlank(message = " Name cannot be null/empty or blank")    // ye sare validation h
    @Size(min = 1, max = 50, message = "Student name must be within 2 to 50 character long")
    private String name;

    @Email(message = "Student email must be valid")
    @NotBlank(message = "Email cannot be blank")
    private String email;
    @Min(value = 16 , message = "Student must be at least 16 year old")
    @NotNull(message = "Age is required")
    private int age;
    @NotNull(message = "RollNo is required")
    private Integer rollNo;
    @NotBlank(message = "Subject is required ")
    private String subject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
