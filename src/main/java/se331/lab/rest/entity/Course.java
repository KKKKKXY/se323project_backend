package se331.lab.rest.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String activityId;
    String activityName;
    String semester;
    String academic;
    String participant;
    String credit;
    @ManyToOne
    @JsonBackReference
    Lecturer lecturer;
    @ManyToMany
    @Builder.Default
    @ToString.Exclude
    List<Student> students = new ArrayList<>();
}
