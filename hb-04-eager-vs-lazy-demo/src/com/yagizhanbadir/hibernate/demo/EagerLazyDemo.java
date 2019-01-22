package com.yagizhanbadir.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.yagizhanbadir.hibernate.demo.entity.Course;
import com.yagizhanbadir.hibernate.demo.entity.Instructor;
import com.yagizhanbadir.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// get the instructor from db
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);

			System.out.println("hey Instructor: " + tempInstructor);

			System.out.println("hey Courses: " + tempInstructor.getCourses());

			// commit transaction
			session.getTransaction().commit();

			// close the session
			session.close();

			System.out.println("\nhey: The session is now closed!\n");
			
			// option 1: call getter method while session is open
			
			// get courses for the instructor
			System.out.println("hey Courses: " + tempInstructor.getCourses());

			System.out.println("hey Done!");

		} finally {

			// add clean up code
			session.close();

			factory.close();
		}
	}

}
