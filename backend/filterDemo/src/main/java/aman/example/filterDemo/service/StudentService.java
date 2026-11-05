package aman.example.filterDemo.service;

import aman.example.filterDemo.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private Student student;

    public StudentService(Student student) {
        this.student = student;
    }

    public void createStudent( Student student) {
        System.out.println("student created");
        System.out.println("student Id : " + student.getId());
        System.out.println("student name: " + student.getName());
        System.out.println("student email: " + student.getEmail());

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
