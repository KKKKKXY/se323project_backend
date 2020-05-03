package se331.lab.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import se331.lab.rest.entity.Course;
import se331.lab.rest.entity.Lecturer;
import se331.lab.rest.entity.Student;
import se331.lab.rest.repository.CourseRepository;
import se331.lab.rest.repository.LecturerRepository;
import se331.lab.rest.repository.StudentRepository;

import javax.transaction.Transactional;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    LecturerRepository lecturerRepository;
    @Autowired
    CourseRepository courseRepository;
    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        Student student1 = Student.builder()
                .studentId("SE-001")
                .name("Prayuth")
                .surname("The minister")
                .gpa(3.59)
                .image("https://firebasestorage.googleapis.com/v0/b/test-331-lab05.appspot.com/o/tu.jpg?alt=media&token=f16b5c1c-fbea-4d98-9fa3-732b69a1bae8")
                .penAmount(15)
                .description("The great man ever!!!!")
                .build();
        Student student2 = Student.builder()
                .studentId("SE-002")
                .name("Cherprang ")
                .surname("BNK48")
                .gpa(4.01)
                .image("https://firebasestorage.googleapis.com/v0/b/test-331-lab05.appspot.com/o/cherprang.png?alt=media&token=2e6a41f3-3bf0-4e42-ac6f-8b7516e24d92")
                .penAmount(2)
                .description("Code for Thailand")
                .build();
        Student student3 = Student.builder()
                .studentId("SE-003")
                .name("Nobi")
                .surname("Nobita")
                .gpa(1.77)
                .image("https://firebasestorage.googleapis.com/v0/b/test-331-lab05.appspot.com/o/nobita.jpg?alt=media&token=16e30fb0-9904-470f-b868-c35601df8326")
                .penAmount(0)
                .description("Welcome to Olympic")
                .build();
        Student student4 = Student.builder()
                .studentId("SE-004")
                .name("Jurgen")
                .surname("Klopp")
                .gpa(2.56)
                .image("https://firebasestorage.googleapis.com/v0/b/test-331-lab05.appspot.com/o/kloop.png?alt=media&token=eda404ff-b854-43ed-96ee-92f26cdd4380")
                .penAmount(200)
                .description("The manager")
                .build();
        Student student5 = Student.builder()
                .studentId("SE-005")
                .name("Mohamed")
                .surname("Salah")
                .gpa(2.44)
                .image("https://firebasestorage.googleapis.com/v0/b/test-331-lab05.appspot.com/o/salah.jpg?alt=media&token=a2f1f204-f17f-443e-b280-0c06e184a99a")
                .penAmount(0)
                .description("The King of Egypt")
                .build();


        student1 = studentRepository.save(student1);
        student2 = studentRepository.save(student2);
        student3 = studentRepository.save(student3);
        student4 = studentRepository.save(student4);
        student5 = studentRepository.save(student5);

        Lecturer lecturer1 = Lecturer.builder()
                .name("Chartchai")
                .surname("Doungsa-ard")
                .build();
        Lecturer lecturer2 = Lecturer.builder()
                .name("Jayakrit")
                .surname("Hirisajja")
                .build();
        Lecturer lecturer3 = Lecturer.builder()
                .name("Pree")
                .surname("Thiengburanathum")
                .build();
        lecturer1 = this.lecturerRepository.save(lecturer1);
        lecturer2 = this.lecturerRepository.save(lecturer2);
        lecturer3 = this.lecturerRepository.save(lecturer3);
        Course course1 = Course.builder()
                .activityId("953331")
                .activityName("Component Based Software Dev")
                .semester("1")
                .academic("2020")
                .participant("100")
                .credit("5")
                .build();
        Course course2 = Course.builder()
                .activityId("953xxx")
                .activityName("X project")
                .semester("1")
                .academic("2020")
                .participant("100")
                .credit("5")
                .build();
        Course course3 = Course.builder()
                .activityId("953494")
                .activityName("Selected Topics in SE 1")
                .semester("2")
                .academic("2020")
                .participant("50")
                .credit("10")
                .build();
        Course course4 = Course.builder()
                .activityId("953234")
                .activityName("Advance Software Development")
                .semester("2")
                .academic("2020")
                .participant("60")
                .credit("10")
                .build();

        course1 = this.courseRepository.save(course1);
        course2  = this.courseRepository.save(course2);
        course3 = this.courseRepository.save(course3);
        course4 = this.courseRepository.save(course4);
        lecturer1.getAdvisees().add(student1);
        student1.setAdvisor(lecturer1);
        lecturer1.getAdvisees().add(student2);
        student2.setAdvisor(lecturer1);
        lecturer2.getAdvisees().add(student3);
        student3.setAdvisor(lecturer2);
        lecturer3.getAdvisees().add(student4);
        student4.setAdvisor(lecturer3);
        lecturer3.getAdvisees().add(student5);
        student5.setAdvisor(lecturer3);

        student1.getEnrolledCourses().add(course1);
        course1.getStudents().add(student1);
        student1.getEnrolledCourses().add(course2);
        course2.getStudents().add(student1);
        student1.getEnrolledCourses().add(course3);
        course3.getStudents().add(student1);

        student2.getEnrolledCourses().add(course2);
        course2.getStudents().add(student2);

        student3.getEnrolledCourses().add(course3);
        course3.getStudents().add(student3);

//        student1.getEnrolledCourses().add(course1);
//        course1.getStudents().add(student1);
//        student1.getEnrolledCourses().add(course2);
//        course2.getStudents().add(student1);
//        student2.getEnrolledCourses().add(course1);
//        course1.getStudents().add(student2);
//        student3.getEnrolledCourses().add(course2);
//        course2.getStudents().add(student3);
//        course3.getStudents().add(student4);
//        course3.getStudents().add(student5);
//        course3.getStudents().add(student1);
//        student1.getEnrolledCourses().add(course3);
//        student4.getEnrolledCourses().add(course3);
//        student5.getEnrolledCourses().add(course3);
//        course4.getStudents().add(student1);
//        course4.getStudents().add(student2);
//        course4.getStudents().add(student3);
//        course4.getStudents().add(student4);
//        course4.getStudents().add(student5);
//        student1.getEnrolledCourses().add(course4);
//        student2.getEnrolledCourses().add(course4);
//        student3.getEnrolledCourses().add(course4);
//        student4.getEnrolledCourses().add(course4);
//        student5.getEnrolledCourses().add(course4);


        course1.setLecturer(lecturer2);
        lecturer2.getCourses().add(course1);
        course2.setLecturer(lecturer1);
        lecturer1.getCourses().add(course2);
        course3.setLecturer(lecturer3);
        lecturer3.getCourses().add(course3);
        course4.setLecturer(lecturer1);
        lecturer1.getCourses().add(course4);
    }


}

