package com.paul.CrudJavaApp.rest;

import com.paul.CrudJavaApp.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {


    private List<Student> theStudents;

    // Add @PostConstruct to load students - it's called only once
    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<Student>();
        theStudents.add(new Student("Paul", "Crt"));
        theStudents.add(new Student("Mario", "Str"));

    }
    //define endpoint for /students
    @GetMapping("/students")
    public List<Student> students() {
        return theStudents;
    }
    @GetMapping("/student/{id}")
    public Student student(@PathVariable int id) {

        // check student id
        if (id > students().size() || id < 0) {
            throw new StudentNotFoundException("Student id can not be found " + id);
        }
        return theStudents.get(id);
    }

}
