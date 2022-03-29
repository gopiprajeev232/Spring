package com.hibernate.onetomany;

import com.hibernate.onetomany.entity.Course;
import com.hibernate.onetomany.entity.Instructor;
import com.hibernate.onetomany.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyTest {
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

            Instructor instructor = session.get(Instructor.class, 1);

            System.out.println("Instructor: "+instructor);
            session.getTransaction().commit();

            System.out.println("Courses: "+ instructor.getCourses());

            session.close();
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
