package com.hibernate.crud;

import com.hibernate.classes.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateObject {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            int id = 1;

            session.beginTransaction();

            System.out.println("Getting student with ID: "+id);
            Student stu = session.get(Student.class, id);

            System.out.println("Retrieved student is: "+stu);

            System.out.println("Updating student name...");
            stu.setFirstName("Rakesh");

            session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
            session.getTransaction().commit();
        }

        catch (Exception e) {

        }

        finally {
            factory.close();
        }
    }
}
