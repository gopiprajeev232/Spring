package com.prajeev.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name="student")
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    @NotEmpty(message = "First name cannot be empty!")
    private String firstName;

    @Column(name="last_name")
    @NotEmpty(message = "Last name cannot be empty!")
    private String lastName;

    @Column(name="student_dept")
    @Pattern(regexp = "^[a-zA-Z]{2,3}$", message = "Length must be 2 or 3 characters!")
    private String studentDept;

    @Column(name="student_email")
    @Pattern(regexp = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$", message = "Invalid format.")
    private String studentEmail;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name="college_id")
    @ToString.Exclude
    private College college;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "student_club",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "club_id"))
    @NotEmpty(message = "Please select at least one club!")
    private Set<Club> clubs = new HashSet<>();

    public Student(String firstName, String lastName, String studentDept, String studentEmail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentEmail = studentEmail;
        this.studentDept = studentDept;
    }

    public Student(String firstName, String lastName, String studentDept, String studentEmail, College college) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentEmail = studentEmail;
        this.studentDept = studentDept;
        this.college = college;
    }


    public void addClub(Club club) {
        clubs.add(club);
    }

    public void removeClub(Club club) {
        this.clubs.remove(club);
    }
}
