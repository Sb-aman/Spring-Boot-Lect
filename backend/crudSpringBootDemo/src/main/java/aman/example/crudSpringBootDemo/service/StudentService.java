package aman.example.crudSpringBootDemo.service;

import aman.example.crudSpringBootDemo.entity.Student;
import aman.example.crudSpringBootDemo.repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Business ka logic

/*
Basically controller ka kam service aur controller ke bich me manager ka kam karta  h

service ka kam db ko store karne ka nhi hona chahiye
ye repository ko bole ki tu store kar db ko
 */


//@Component
@Service // basically ye internally component hi use karta h jo batata h ki ye service class h isme business logic likha h
public class StudentService {

     private StudentRepository studentRepository;
     public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
     }


     public Student createStudent(Student student){
         /*
         abhi yha to simple h to directly controller repository ko de skta tha
         lekin agar koi validation hoti jaise subject cse hi hona chahiye
         tab iska service ka use hota h
          */

//         Student createRes = studentRepository.saveStudent(student); // ab repository interface h to ye method likhne ki need nhi h
         Student createRes = studentRepository.save(student); // ye save function insert aur update dono ka kam karega
         return createRes;
     }


     public Student getStudent(Long id){
//         Student createReq = studentRepository.findById(id);
         // agar direct Student kar dete to error aata kyunki findById() me agar id exist karti h to tk lekin nhi karti tab error aata isliye optional use agar exist karegi to print else null

         Optional<Student> studentRes = studentRepository.findById(id);
         if(studentRes.isPresent()){
             return studentRes.get();
         }
         return null;
     }



     public List<Student> getAllStudent(){
         List<Student> studentList = studentRepository.findAll();
         return studentList;
     }



     public Student updateStudent(Long id, Student student){
         Optional<Student> existingStudent = studentRepository.findById(id);
         if(existingStudent.isEmpty()){
             return null;
         }
         Student  studentToSave = existingStudent.get();
//         studentToSave.setId(student.getId());
         studentToSave.setName(student.getName());
         studentToSave.setAge(student.getAge());
         studentToSave.setEmail(student.getEmail());
         studentToSave.setSubject(student.getSubject());
          return studentRepository.save(studentToSave);
     }


    public Boolean deleteStudent(Long id) {
         boolean isStudent = studentRepository.existsById(id);
         if(!isStudent){
             return false;
         }
         studentRepository.deleteById(id);
         return true;
    }
}
