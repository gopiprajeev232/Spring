package com.hibernate.manytomany;

import com.hibernate.manytomany.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesAndStudents {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Course course1 = new Course("C# programming");
            Course course2 = new Course("ASP.NET framework");

            Student student1 = new Student("John", "Doe", "johndoe@gmail.com");

            session.save(student1);

            course1.addStudent(student1);
            course2.addStudent(student1);

            session.save(course1);
            session.save(course2);

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
