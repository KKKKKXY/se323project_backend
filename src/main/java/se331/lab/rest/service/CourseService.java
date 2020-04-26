package se331.lab.rest.service;

import se331.lab.rest.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();

    Course findById(Long courseId);
    Course saveCourse(Course course);
}
