package se331.lab.rest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import se331.lab.rest.entity.Course;
import se331.lab.rest.entity.Student;
import se331.lab.rest.mapper.MapperUtil;
import se331.lab.rest.service.StudentService;

@Controller
@Slf4j
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity getAllStudent() {
        log.info("the controller is call");
        return ResponseEntity.ok(MapperUtil.INSTANCE.getStudentDto(studentService.getAllStudent()));
    }

    @GetMapping("/students/{id}")
    public ResponseEntity getStudentById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(studentService.findById(id));
    }

    @GetMapping("/enrollActivity/{id}")
    public ResponseEntity getEnrolledActivity(@PathVariable("id") Long id) {
        return ResponseEntity.ok(MapperUtil.INSTANCE.getCourseDto(studentService.findById(id).getEnrolledCourses()));
    }

    @PostMapping("/students")
    public ResponseEntity saveStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.saveStudent(student));
    }

    @PostMapping("/enrollActivity")
    public ResponseEntity enrollActivity(@RequestBody Course course) {
        return ResponseEntity.ok(studentService.enrollActivity(course));
    }

//    @PostMapping("/enrollActivity")
//    public ResponseEntity enrollActivity(@RequestBody Enroll enroll) {
//        return ResponseEntity.ok(studentService.enrollActivity(enroll));
//    }
}
