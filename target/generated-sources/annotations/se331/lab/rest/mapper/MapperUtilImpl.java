package se331.lab.rest.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import se331.lab.rest.dto.CourseDto;
import se331.lab.rest.dto.LecturerDto;
import se331.lab.rest.dto.StudentDto;
import se331.lab.rest.entity.Course;
import se331.lab.rest.entity.Lecturer;
import se331.lab.rest.entity.Student;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-26T19:51:09+0700",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.6 (JetBrains s.r.o)"
)
public class MapperUtilImpl implements MapperUtil {

    @Override
    public LecturerDto getLecturerDto(Lecturer lecturer) {
        if ( lecturer == null ) {
            return null;
        }

        LecturerDto lecturerDto = new LecturerDto();

        lecturerDto.setId( lecturer.getId() );
        lecturerDto.setName( lecturer.getName() );
        lecturerDto.setSurname( lecturer.getSurname() );
        lecturerDto.setAdvisees( getStudentDto( lecturer.getAdvisees() ) );

        return lecturerDto;
    }

    @Override
    public List<LecturerDto> getLecturerDto(List<Lecturer> lecturer) {
        if ( lecturer == null ) {
            return null;
        }

        List<LecturerDto> list = new ArrayList<LecturerDto>( lecturer.size() );
        for ( Lecturer lecturer1 : lecturer ) {
            list.add( getLecturerDto( lecturer1 ) );
        }

        return list;
    }

    @Override
    public StudentDto getStudentDto(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDto studentDto = new StudentDto();

        studentDto.setId( student.getId() );
        studentDto.setStudentId( student.getStudentId() );
        studentDto.setName( student.getName() );
        studentDto.setSurname( student.getSurname() );
        studentDto.setGpa( student.getGpa() );
        studentDto.setImage( student.getImage() );

        return studentDto;
    }

    @Override
    public List<StudentDto> getStudentDto(List<Student> students) {
        if ( students == null ) {
            return null;
        }

        List<StudentDto> list = new ArrayList<StudentDto>( students.size() );
        for ( Student student : students ) {
            list.add( getStudentDto( student ) );
        }

        return list;
    }

    @Override
    public CourseDto getCourseDto(Course course) {
        if ( course == null ) {
            return null;
        }

        CourseDto courseDto = new CourseDto();

        courseDto.setId( course.getId() );
        courseDto.setActivityId( course.getActivityId() );
        courseDto.setActivityName( course.getActivityName() );
        courseDto.setSemester( course.getSemester() );
        courseDto.setAcademic( course.getAcademic() );
        courseDto.setParticipant( course.getParticipant() );
        courseDto.setCredit( course.getCredit() );
        courseDto.setLecturer( getLecturerDto( course.getLecturer() ) );
        courseDto.setStudents( getStudentDto( course.getStudents() ) );

        return courseDto;
    }

    @Override
    public List<CourseDto> getCourseDto(List<Course> courses) {
        if ( courses == null ) {
            return null;
        }

        List<CourseDto> list = new ArrayList<CourseDto>( courses.size() );
        for ( Course course : courses ) {
            list.add( getCourseDto( course ) );
        }

        return list;
    }
}
