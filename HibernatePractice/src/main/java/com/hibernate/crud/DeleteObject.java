package com.hibernate.crud;

import com.hibernate.classes.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DeleteObject {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

/*            List<Student> student = session.createQuery("from Student where firstName = 'Sravani'").list();
            int id = student.get(0).getId();

            System.out.println("Deleting student with ID: "+id);

            session.delete(student.get(0)); */

//            Another way to delete:

            session.createQuery("delete from Student where id=1").executeUpdate();

            session.getTransaction().commit();
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        finally {
            factory.close();
        }
    }
}
