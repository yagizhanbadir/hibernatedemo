package com.yagizhanbadir.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.yagizhanbadir.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		//create session factory
				SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
				
				//create session
				Session session = factory.getCurrentSession();
				try {
					//create 5 student objects
					System.out.println("Creating 5 student objects...");
					Student student = new Student("yagizhan","badir","yagizhanbadir@gmail.com");
					Student student1 = new Student("sila","badir","silabadir@gmail.com");
					Student student2 = new Student("ilhan","mansiz","ilhanmansiz123@gmail.com");
					Student student3 = new Student("guti","hernandez","guti14@gmail.com");
					Student student4 = new Student("ricardo","quaresma","q7@gmail.com");

					
					//start a transaction
					session.beginTransaction();
					
					//save the student objects
					System.out.println("Saving the students...");
					session.save(student);
					session.save(student1);					
					session.save(student2);
					session.save(student3);
					session.save(student4);

					
					//commit transaction
					session.getTransaction().commit();
					
					System.out.println("Done!");
					
				}finally {
					factory.close();
				}
	}
}
