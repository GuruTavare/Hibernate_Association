package com.prowings.Bidirectional.OneToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.prowings.HibernateUtil.HibernateUtil;

public class TestBiOneToMany {

	public static void main(String[] args) {

		SessionFactory sf = null;
		Session s = null;
		Transaction tx = null;
		try {
			sf = HibernateUtil.getSessionFactory();  
			s = sf.openSession();
			tx = s.beginTransaction();

			Parent p = new Parent();
			p.setName("Pandu");

			Child c1 = new Child();
			c1.setName("Arjun");
			c1.setParent(p);

			Child c2 = new Child();
			c2.setName("Bhim");
			c2.setParent(p);

			List<Child> l = new ArrayList<Child>();
			l.add(c1);
			l.add(c2);

			p.setChildren(l);
			
			s.save(p);
			s.save(c1);
			s.save(c2);
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
