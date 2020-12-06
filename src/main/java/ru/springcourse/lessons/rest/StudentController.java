package ru.springcourse.lessons.rest;

import org.springframework.web.bind.annotation.*;
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

        if(studentId >= students.size() || studentId < 0){
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return students.get(studentId);
    }
}
