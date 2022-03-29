package com.hibernate.onetoone;

import com.hibernate.onetoone.entity.Instructor;
import com.hibernate.onetoone.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;


public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Instructor instructor = new Instructor("Ravi", "B", "ravi@gmail.com");
            InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com/ravi", "Sleeping");

            instructor.setInstructorDetail(instructorDetail);

            session.beginTransaction();

            System.out.println("Saving instructor: "+instructor);
            session.save(instructor);

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
