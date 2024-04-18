package com.prowings.Unidirectional.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.prowings.HibernateUtil.HibernateUtil;

public class TestOneToOne {

	public static void main(String[] args) {

		SessionFactory sf = null;
		Session s = null;
		Transaction tx = null;

		try {
			sf = HibernateUtil.getSessionFactory();
			s = sf.openSession();
			tx = s.beginTransaction();

			Passport pp = new Passport();
			pp.setName("Raghav");
			pp.setPhone(9988556622l);
			
			s.save(pp);
			
			Person p = new Person();
			p.setName("ram");
			p.setAddress("pune");
			p.setPassport(pp);
			s.save(p);

			
			
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
