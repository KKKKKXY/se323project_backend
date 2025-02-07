package se331.lab.rest.dao;

import se331.lab.rest.entity.Student;

import java.util.List;

public interface StudentDao {
    List<Student> getAllStudent();
    Student findById(Long studentId);
    Student saveStudent(Student student);
}
