package com.hibernate.onetoone;

import com.hibernate.onetoone.entity.Instructor;
import com.hibernate.onetoone.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Instructor instructor = (Instructor) session.createQuery("from Instructor where firstName = 'Gopi'").getSingleResult();

            if(instructor != null) {
                System.out.println("Deleting instructor: "+instructor.getFirstName()+" "+instructor.getLastName());
                session.delete(instructor);
            }

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
