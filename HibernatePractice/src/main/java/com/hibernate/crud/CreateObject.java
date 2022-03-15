package com.hibernate.crud;

import com.hibernate.classes.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateObject {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = factory.getCurrentSession();


        try {
            Student student1 = new Student("Pranav", "Kaushik", "pranav@yahoo.com");
            Student student2 = new Student("Ravi", "Kalyan", "rk@gmail.com");
            Student student3 = new Student("Krishna", "Sai", "krishna@gmail.com");
            session.beginTransaction();

            System.out.println("Saving the student...");
            session.save(student1);
            session.save(student2);
            session.save(student3);

            session.getTransaction().commit();

            System.out.println("Done!");
        }

        catch(Exception e) {
            e.printStackTrace();
        }

        finally {
            factory.close();
        }
    }
}
