package aman.example.crudSpringBootDemo.service;

import aman.example.crudSpringBootDemo.dto.CreateStudentRequestDto;
import aman.example.crudSpringBootDemo.dto.CreateStudentResponseDto;
import aman.example.crudSpringBootDemo.dto.UpdateStudentRequestDto;
import aman.example.crudSpringBootDemo.dto.UpdateStudentResponseDto;
import aman.example.crudSpringBootDemo.entity.Student;
import aman.example.crudSpringBootDemo.exception.ResourceNotFoundException;
import aman.example.crudSpringBootDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

// Business ka logic




//@Component
@Service // basically ye internally component hi use karta h jo batata h ki ye service class h isme business logic likha h
public class StudentService {

     private StudentRepository studentRepository;
     public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
     }



     public CreateStudentResponseDto createStudent(CreateStudentRequestDto createStudentRequestDto) {
        Student student = mapToEntity(createStudentRequestDto);
        student.setCreatedAt(LocalDateTime.parse(LocalDateTime.now().toString()));
        student.setUpdatedAt(LocalDateTime.parse(LocalDateTime.now().toString()));
        Student studentRes =  studentRepository.save(student);
        return mapToDto(studentRes);
     }




     /*
    public Student getStudent(Long id){
//         Student createReq = studentRepository.findById(id);
         // agar direct Student kar dete to error aata kyunki findById() me agar id exist karti h to tk lekin nhi karti tab error aata isliye optional use agar exist karegi to print else null

         Optional<Student> studentRes = studentRepository.findById(id);
         if(studentRes.isPresent()){
             return studentRes.get();
         }
         return null;
     }

      */

    public CreateStudentResponseDto getStudent(Long id) {
//        Optional<Student> studentRes = studentRepository.findById(id);

        Student studentRes = studentRepository
                .findById(id) // to particular id present hogi to de dena otherwise exception milega
                .orElseThrow(()->new ResourceNotFoundException("student with id "+id+" not found"));

        return  mapToDto(studentRes);
    }



     public List<CreateStudentResponseDto> getAllStudent(){
         List<Student> studentList = studentRepository.findByDeletedIsFalse();

         return studentList.stream()
                 .map(this::mapToDto)
                 .toList();
     }


/*
     public UpdateStudentResponseDto updateStudent(Long id, UpdateStudentRequestDto student){
         Optional<Student> existingStudent = studentRepository.findById(id);
         if(existingStudent.isEmpty()){
             return null;
         }
         Student  studentToSave = existingStudent.get();
         studentToSave.setName(student.getName());
         studentToSave.setRollNo(student.getRollNo());
         studentToSave.setAge(student.getAge());
         studentToSave.setSubject(student.getSubject());
         studentToSave.setDeleted(false);
         studentToSave.setUpdatedAt(LocalDateTime.parse(LocalDateTime.now().toString()));
          Student savedStudent = studentRepository.save(studentToSave);
          return mapToUpdateDto(savedStudent);
     }

 */
public UpdateStudentResponseDto updateStudent(Long id, UpdateStudentRequestDto student) {
    Student existingStudent = studentRepository
            .findByIdAndDeletedIsFalse(id)
            .orElseThrow(()->new ResourceNotFoundException("student with id "+id+" not found"));

 
    existingStudent.setName(student.getName());
    existingStudent.setRollNo(student.getRollNo());
    existingStudent.setAge(student.getAge());
    existingStudent.setSubject(student.getSubject());
    existingStudent.setDeleted(false);
    existingStudent.setUpdatedAt(LocalDateTime.parse(LocalDateTime.now().toString()));
    Student savedStudent = studentRepository.save(existingStudent);
    return mapToUpdateDto(savedStudent);
}




    public void deleteStudent(Long id) {
       Student studentToBeDeleted = studentRepository
               .findById(id)
               .orElseThrow(()->new ResourceNotFoundException("student with id "+id+" not found"));
       studentRepository.delete(studentToBeDeleted);
    }


    private Student mapToEntity(CreateStudentRequestDto createStudentRequestDto) {
         Student student = new Student();
         student.setName(createStudentRequestDto.getName());
         student.setAge(createStudentRequestDto.getAge());
         student.setEmail(createStudentRequestDto.getEmail());
         student.setSubject(createStudentRequestDto.getSubject());
        student.setRollNo(createStudentRequestDto.getRollNo());

        student.setDeleted(false);
        return student;
    }


    private CreateStudentResponseDto mapToDto(Student student) {
         CreateStudentResponseDto createStudentResponseDto = new CreateStudentResponseDto();
         createStudentResponseDto.setId(student.getId());
         createStudentResponseDto.setName(student.getName());
         createStudentResponseDto.setAge(student.getAge());
         createStudentResponseDto.setEmail(student.getEmail());
         createStudentResponseDto.setSubject(student.getSubject());
         createStudentResponseDto.setRollNo(student.getRollNo());
         createStudentResponseDto.setMessage("details saved successfully");
         createStudentResponseDto.setCreatedAt(student.getCreatedAt());
         createStudentResponseDto.setUpdatedAt(student.getUpdatedAt());
         return createStudentResponseDto;
    }

    private UpdateStudentResponseDto mapToUpdateDto(Student savedStudent) {
         UpdateStudentResponseDto updateStudentResponseDto = new UpdateStudentResponseDto();
         updateStudentResponseDto.setId(savedStudent.getId());
         updateStudentResponseDto.setName(savedStudent.getName());
         updateStudentResponseDto.setAge(savedStudent.getAge());
         updateStudentResponseDto.setEmail(savedStudent.getEmail());
         updateStudentResponseDto.setSubject(savedStudent.getSubject());
         updateStudentResponseDto.setRollNo(savedStudent.getRollNo());
         updateStudentResponseDto.setMessage("details updated successfully");
         updateStudentResponseDto.setUpdatedAt(LocalDateTime.parse(savedStudent.getUpdatedAt().toString()));
         return updateStudentResponseDto;

    }

}
