package se331.lab.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import se331.lab.rest.entity.Course;
import se331.lab.rest.mapper.MapperUtil;
import se331.lab.rest.service.CourseService;
import se331.lab.rest.service.LecturerService;

@Controller
public class CourseController {
    @Autowired
    CourseService courseService;
    @GetMapping("/courses")
    public ResponseEntity getAllLecturer() {
        return ResponseEntity.ok(MapperUtil.INSTANCE.getCourseDto(courseService.getAllCourses()));
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity getCourseById(@PathVariable("id") Long id) {
        //return ResponseEntity.ok(courseService.findById(id));
        return ResponseEntity.ok(MapperUtil.INSTANCE.getCourseDto(courseService.findById(id)));
    }
    @PostMapping("/courses")
    public ResponseEntity saveCourse(@RequestBody Course course) {
        return ResponseEntity.ok(courseService.saveCourse(course));
    }
}
