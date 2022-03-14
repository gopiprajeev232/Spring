package com.hibernate.onetoone;

import com.hibernate.onetoone.entity.Instructor;
import com.hibernate.onetoone.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BidirectionalMapping {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            System.out.println("Comes here");

            InstructorDetail instructorDetail = (InstructorDetail) session.createQuery("from InstructorDetail where id = 4").getSingleResult();

            System.out.println("Instructor ID: "+instructorDetail.getId());
            System.out.println("Associated instructor: "+instructorDetail.getInstructor());

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
