package se331.lab.rest.service;

import se331.lab.rest.entity.Course;
import se331.lab.rest.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent();
    Student findById(Long studentId);
    Student saveStudent(Student student);
    Student enrollActivity(Course course);
//    Student enrollActivity(Enroll enroll);
}
