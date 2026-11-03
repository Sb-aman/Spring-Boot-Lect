package aman.example.crudSpringBootDemo.repository;


import aman.example.crudSpringBootDemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

// save to db


@Component
public interface StudentRepository extends JpaRepository<Student ,Long> {
    Optional<Student> findByIdAndDeletedIsFalse(Long id);

    List<Student> findByDeletedIsFalse();


    // ham ab manually data save nhi karenge
    /*
    public Student saveStudent( Student student ){

        System.out.println("inside student repository");
        System.out.println("exiting student repository");

          Student s1 = new Student();
          s1.setAge(24);
          s1.setName("akash");
          s1.setEmail("akash@gmail.com");
               return s1;

     */

}
