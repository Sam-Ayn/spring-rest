package ru.springcourse.lessons.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.springcourse.lessons.entities.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("Mary","Jane"));
        students.add(new Student("Rahul","Rajput"));
        students.add(new Student("Priyanka","Patil"));
        return students;
    }
}
