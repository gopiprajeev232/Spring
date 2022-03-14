package com.hibernate.onetoone.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="instructor")
public @Data
class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="instructor_detail_id")
    @ToString.Exclude
    private InstructorDetail instructorDetail;

    public Instructor() {

    }

    public Instructor(String firstName, String lastName, String email) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }


}
