package com.hibernate.crud;

import com.hibernate.classes.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadObject {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = factory.getCurrentSession();


        try {
            Student student = new Student("Sravani", "T", "sravani@gmail.com");

            session.beginTransaction();

            int id = (Integer) session.save(student);

            session.getTransaction().commit();

            System.out.println("Saved student with ID: "+id);

            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Getting student with ID: "+student.getId());
            Student addedStudent = session.get(Student.class, student.getId());

            System.out.println("Student is: "+addedStudent);

            session.getTransaction().commit();

            System.out.println("Done");
        }

        catch(Exception e) {
            e.printStackTrace();
        }

        finally {
            factory.close();
        }
    }
}
