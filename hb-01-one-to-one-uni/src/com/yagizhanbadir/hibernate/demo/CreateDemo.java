package com.yagizhanbadir.hibernate.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.yagizhanbadir.hibernate.demo.entity.Instructor;
import com.yagizhanbadir.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// create the objects
			/*
			 * Instructor tempInstructor = new Instructor("Yagizhan", "Badir",
			 * "yagizhanbadir@gmail.com");
			 * 
			 * InstructorDetail tempInstructorDetail = new
			 * InstructorDetail("yagizhanbadir.com/youtube", "Ben Yagizhan");
			 */
			Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");

			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube",
					"Luv 2 code");

			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);

			// start a transaction
			session.beginTransaction();

			// save the instructor
			//
			// Note : this will ALSO save the details objects
			// because of CascadeType.ALL
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			factory.close();
		}
	}

}
