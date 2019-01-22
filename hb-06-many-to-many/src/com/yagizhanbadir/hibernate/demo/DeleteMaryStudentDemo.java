package com.yagizhanbadir.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.yagizhanbadir.hibernate.demo.entity.Course;
import com.yagizhanbadir.hibernate.demo.entity.Instructor;
import com.yagizhanbadir.hibernate.demo.entity.InstructorDetail;
import com.yagizhanbadir.hibernate.demo.entity.Review;
import com.yagizhanbadir.hibernate.demo.entity.Student;

public class DeleteMaryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// get the student yagizhan from database
			int theId = 2;
			Student tempStudent = session.get(Student.class, theId);
			System.out.println("\nLoaded student: " + tempStudent);
			System.out.println("Course: " + tempStudent.getCourses());

			// delete student
			System.out.println("\nDeleting student: " + tempStudent);
			session.delete(tempStudent);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {

			// add clean up code
			session.close();

			factory.close();
		}
	}

}
