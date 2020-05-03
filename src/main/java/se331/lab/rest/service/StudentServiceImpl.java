package se331.lab.rest.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se331.lab.rest.dao.StudentDao;
import se331.lab.rest.entity.Course;
import se331.lab.rest.entity.Student;

import java.util.List;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;

    @Autowired
    StudentService studentService;


    @Override
    public List<Student> getAllStudent() {
        log.info("service received called");
        List<Student> students = studentDao.getAllStudent();
        log.info("service received {} \n from dao", students);
        return students;
    }

    @Override
    public Student findById(Long id) {
        return studentDao.findById(id);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentDao.saveStudent(student);
    }

//    @Override
//    public Student enrollActivity(Enroll enroll) {
//        Student student = enroll.getStudent();
//        Course course = enroll.getActivity();
//        student.getEnrolledCourses().add(course);
//        return studentDao.saveStudent(student);
//    }

    @Override
    public Student enrollActivity(Course course) {
        Student student = studentService.findById((long) 1);
        student.getEnrolledCourses().add(course);
        return studentDao.saveStudent(student);
    }
}
