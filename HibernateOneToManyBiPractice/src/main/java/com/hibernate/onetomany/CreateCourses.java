package com.hibernate.onetomany;

import com.hibernate.onetomany.entity.Course;
import com.hibernate.onetomany.entity.Instructor;
import com.hibernate.onetomany.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Column;

public class CreateCourses {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Instructor instructor = (Instructor) session.createQuery("from Instructor i where i.firstName = 'Gopi'").getSingleResult();

            Course course1 = new Course("Data Structures and Algorithms using Java");
            Course course2 = new Course("Software Engineering Basics");
            Course course3 = new Course("OOPs using Java Programming");

            instructor.add(course1);
            instructor.add(course2);
            instructor.add(course3);

            System.out.println(course3.getInstructor());

            session.save(course1);
            session.save(course2);
            session.save(course3);

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
