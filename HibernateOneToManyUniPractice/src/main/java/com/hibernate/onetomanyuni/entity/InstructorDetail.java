package com.hibernate.onetomanyuni.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="instructor_detail")
@Data
public class InstructorDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    @Column(name="youtube_channel")

    private String youtubeChannel;

    @Column(name="hobby")

    private String hobby;

    @ToString.Exclude
    @OneToOne(mappedBy = "instructorDetail", cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    private Instructor instructor;

    public InstructorDetail() {

    }

    public InstructorDetail(String youtubeChannel, String hobby) {
        this.hobby = hobby;
        this.youtubeChannel = youtubeChannel;
    }


}
