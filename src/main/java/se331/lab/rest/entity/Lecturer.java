package se331.lab.rest.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Lecturer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String surname;
    @OneToMany(mappedBy = "advisor")
    @Builder.Default
    @ToString.Exclude
    List<Student> advisees = new ArrayList<>();
    @OneToMany(mappedBy = "lecturer")
    @Builder.Default
    @JsonManagedReference
    @ToString.Exclude
    List<Course> courses = new ArrayList<>();
}
