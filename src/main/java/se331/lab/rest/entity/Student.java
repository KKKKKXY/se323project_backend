package se331.lab.rest.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String studentId;
    String name;
    String surname;
    Double gpa;
    String image;
    Integer penAmount;
    String description;
    @ManyToOne
    @ToString.Exclude
    Lecturer advisor;
    @ManyToMany(mappedBy = "students")
    @Builder.Default
    @ToString.Exclude
    List<Course> enrolledCourses = new ArrayList<>();


}
