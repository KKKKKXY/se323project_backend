package se331.lab.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import se331.lab.rest.entity.Lecturer;
import se331.lab.rest.entity.Student;

import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {
    Long id;
    String activityId;
    String activityName;
    String semester;
    String academic;
    String participant;
    String credit;
    LecturerDto lecturer;
    List<StudentDto> students = new ArrayList<>();

}