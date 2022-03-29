package com.prajeev.demo.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="college")
@NoArgsConstructor
@AllArgsConstructor
public class College {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="college_id")
    private int id;

    @Column(name="college_name")
    @NotEmpty(message = "College name cannot be empty!")
    private String collegeName;

    @Column(name="college_location")
    @NotEmpty(message = "Location cannot be empty!")
    private String collegeLocation;

    @OneToMany(mappedBy = "college",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Student> students;

    public College(String collegeName, String collegeLocation) {
        this.collegeLocation = collegeLocation;
        this.collegeName = collegeName;
    }

    public void add(Student student) {
        if(students == null) {
            students = new ArrayList<>();
        }

        students.add(student);

        student.setCollege(this);
    }
}
