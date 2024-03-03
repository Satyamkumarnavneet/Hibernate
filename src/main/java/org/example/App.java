package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        // Create a Student object
        Student s1 = new Student();
        s1.setRollNo(1);
        s1.setName("Sam");
        s1.setStatus("Active");
        s1.setGender("Male");
        s1.setGrade("A");

        // Create configuration
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Student.class);

        // Create session factory
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            // Open session
            try (Session session = sessionFactory.openSession()) {
                // Begin transaction
                Transaction transaction = session.beginTransaction();

                // Save the student object
                session.save(s1);

                // Commit transaction
                transaction.commit();

                System.out.println("Student saved successfully.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
