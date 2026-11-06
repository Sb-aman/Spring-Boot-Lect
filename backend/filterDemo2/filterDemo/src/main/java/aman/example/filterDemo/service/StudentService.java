package aman.example.filterDemo.service;

import aman.example.filterDemo.dto.Student;
import aman.example.filterDemo.dto.StudentResponseDto;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private Student student;

    public StudentService(Student student) {
        this.student = student;
    }

    public StudentResponseDto createStudent(Student student) {
        System.out.println("student created");
//        System.out.println("student Id : " + student.getId());
//        System.out.println("student name: " + student.getName());
//        System.out.println("student email: " + student.getEmail());
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setName(student.getName());
        studentResponseDto.setMessage("Student is saved successfully");
        return studentResponseDto;

        /*
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
                 */

    }
}
