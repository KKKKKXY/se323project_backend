package se331.lab.rest.dao;

import se331.lab.rest.entity.Course;

import java.util.List;

public interface CourseDao {
    List<Course> getAllCourses();

    Course findById(Long courseId);
    Course saveCourse(Course course);
}
