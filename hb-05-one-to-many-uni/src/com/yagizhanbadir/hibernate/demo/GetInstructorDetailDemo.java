package com.yagizhanbadir.hibernate.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.yagizhanbadir.hibernate.demo.entity.Instructor;
import com.yagizhanbadir.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// get the instructor detail object
			int theId = 223232;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

			// print the instructor detail object
			System.out.println("tempInstructorDetail: " + tempInstructorDetail);

			// print the associated instructor
			System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			// handle connection leak issue
			session.close();
			
			factory.close();
		}
	}

}
