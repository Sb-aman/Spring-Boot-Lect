package aman.example.crudSpringBootDemo.controller;

import aman.example.crudSpringBootDemo.entity.Student;
import aman.example.crudSpringBootDemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

//@Controller // ye bhi likh skte the aur RestController bhi wo spring ko batata h ki ye ek RestController h jo request accept karta h aur response print karta h
@RestController()
@RequestMapping("/api/student")
public class StudentController {
  private StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

    // ******* POST (create data) ******


    @PostMapping("/create")
    /*
    public Student createStudent( @RequestBody Student student ){
        System.out.println("inside student controller");
              Student createStudent = studentService.createStudent(student);
        System.out.println("exiting student controller");
//              return "student created";
          return createStudent;
               */


          // agar aap custom status code chahte ho lagana to dusri class use karo
    public ResponseEntity<Student> createStudent(@RequestBody Student student ){    // *** to yha @RequestBody batata h ki body json format me milegi aur phir Student use jackson(simple object) format me convert kar dega
        Student createStudent = studentService.createStudent(student);
//              return "student created";
//        return createStudent;  // ab ye ye return nhi karega


//          return ResponseEntity.ok(createStudent); // ye status code (200) ok dega

        return ResponseEntity
                .status(HttpStatus.CREATED) // ab ye created yani status code (201) jo ki sahi bhi h kyunki new thing create ki h
                .body(createStudent);
    }
    @GetMapping("/get/{id}")
     public ResponseEntity<Student> getStudent(@PathVariable Long id){ // PathVariable kyunki ek path require tha 
        Student studentRes = studentService.getStudent(id);
        if (studentRes == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentRes);

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> studentList = studentService.getAllStudent();
        if (studentList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentList);

    }

    @PutMapping("/update/{id}")
               public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student){
          Student studentRes = studentService.updateStudent(id,student);
          if (studentRes == null) {
                return ResponseEntity.notFound().build();
          }
          return ResponseEntity.ok(studentRes);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        boolean deleteRes = studentService.deleteStudent(id);
        if (!deleteRes) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Deleted");
    }
}
