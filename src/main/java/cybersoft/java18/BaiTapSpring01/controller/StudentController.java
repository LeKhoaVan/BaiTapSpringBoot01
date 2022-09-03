package cybersoft.java18.BaiTapSpring01.controller;

import cybersoft.java18.BaiTapSpring01.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    List<Student> students = new ArrayList<>();

    @GetMapping("/add-requestparam")
    public List<Student> addStudentRequestParam(
            @RequestParam("name") String name,
            @RequestParam("age") int age
    ){
        Student student = new Student();
        student.setName(name);
        student.setAge(age);

        students.add(student);
        return students;
    }

    @GetMapping("/add-pathvariable/{name}/{age}")
    public List<Student> addStudentPathVariable(
            @PathVariable("name") String name,
            @PathVariable("age") int age
    ){
        Student student = new Student();
        student.setName(name);
        student.setAge(age);

        students.add(student);
        return students;
    }

    @GetMapping("/add-body")
    public ResponseEntity addStudent(
            @RequestBody  Student student
    ){
        students.add(student);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
