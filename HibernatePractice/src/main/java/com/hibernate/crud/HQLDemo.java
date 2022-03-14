package com.hibernate.crud;

import com.hibernate.classes.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HQLDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = factory.getCurrentSession();


        try {
            session.beginTransaction();

            List<Student> students = session.createQuery("from Student").list();

            for (Student student : students) {
                System.out.println(student);
            }

            students = session.createQuery("from Student s where s.email like '%yahoo.com'").list();

            for (Student student : students) {
                System.out.println(student);
            }

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
