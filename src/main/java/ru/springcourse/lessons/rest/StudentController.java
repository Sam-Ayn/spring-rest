package ru.springcourse.lessons.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.springcourse.lessons.entities.Student;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private List<Student> students;

    @PostConstruct
    private void loadData(){
        students = new ArrayList<>();
        students.add(new Student("Mary","Jane"));
        students.add(new Student("Rahul","Rajput"));
        students.add(new Student("Priyanka","Patil"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId){
        return students.get(studentId);
    }
}
