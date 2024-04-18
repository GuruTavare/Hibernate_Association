package com.prowings.Unidirectional.ManyToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.prowings.HibernateUtil.HibernateUtil;

public class TestManyToOne {

	public static void main(String[] args) {
		SessionFactory sf = null;
		Session s = null;
		Transaction tx = null;

		try {
			sf = HibernateUtil.getSessionFactory();
			s = sf.openSession();
			tx = s.beginTransaction();

			Department d = new Department();
			d.setName("Mechanical");

			Student s1 = new Student();
			s1.setName("Rama");
			s1.setDepartment(d);

			Student s2 = new Student();
			s2.setName("Raghav");
			s2.setDepartment(d);

			Student s3 = new Student();
			s3.setName("Shiv");
			s3.setDepartment(d);

			s.save(d);
			s.save(s1);
			s.save(s2);
			s.save(s1);

			tx.commit();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();

		} finally {
			s.close();
			sf.close();
		}

	}

}
