package com.yagizhanbadir.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.yagizhanbadir.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// query students
			List<Student> theStudents = session.createQuery("from Student").list();

			// display the students
			displayStudents(theStudents);

			// query students: firstName='yagizhan'
			theStudents = session.createQuery("from Student s where s.firstName='yagizhan'").list();

			// display the students
			System.out.println("\n\nStudents who have first name of yagizhan");
			displayStudents(theStudents);

			// query students: lastName='hernandez' OR firstName='ilhan'
			theStudents = session.createQuery("from Student s where s.lastName='hernandez' OR s.firstName='ilhan'")
					.list();

			System.out.println("\n\nStudents who have last name of hernandez OR first name ilhan");
			displayStudents(theStudents);

			// query students where email LIKE '%gmail.com'
			theStudents = session.createQuery("from Student s where s.email LIKE '%gmail.com'").list();
			System.out.println("\n\nStudents who email ends with gmail.com");
			displayStudents(theStudents);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
