package com.hibernate.onetomanyuni;

import com.hibernate.onetomanyuni.entity.Course;
import com.hibernate.onetomanyuni.entity.Instructor;
import com.hibernate.onetomanyuni.entity.InstructorDetail;
import com.hibernate.onetomanyuni.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviews {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Course course = new Course("Java Programming");

            course.addReview(new Review("Good course! Liked it."));
            course.addReview(new Review("Could be better."));
            course.addReview(new Review("Did not like it at all!"));

            System.out.println(course);
            System.out.println(course.getReviews());

            session.save(course);

            session.getTransaction().commit();
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        finally {
            session.close();
            factory.close();
        }
    }
}
