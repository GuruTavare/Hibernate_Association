package com.prowings.Unidirectional.ManyToMany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.prowings.HibernateUtil.HibernateUtil;

public class TestManyToMany {

	public static void main(String[] args) {
		
		SessionFactory sf = null;
		Session s = null;
		Transaction tx = null;

		try {
			sf = HibernateUtil.getSessionFactory();
			s = sf.openSession();
			tx = s.beginTransaction();
			Author a1 =new Author();
			a1.setName("Ram");
			Author a2 = new Author();
			a2.setName("Sita");
			Author a3 = new Author();
			a2.setName("tara");
			Author a4 = new Author();
			a2.setName("Sima");
			Author a5 = new Author();
			a2.setName("rasika");
			
			Set<Author> a =new HashSet<>();
			a.add(a1);
			a.add(a2);
			a.add(a3);
			a.add(a4);
			a.add(a5);
			
			
			Book b1 = new Book();
			b1.setTitle("The Psychology Of Money");
			b1.setAuthors(a);
			
			Book b2 = new Book();
			b2.setTitle("How to Win Frinend and Influence People");
			b2.setAuthors(a);
			
//			s.save(a);
			
			
			s.save(a1);
			s.save(a2);
			s.save(a3);
			s.save(a4);
			s.save(a5);
			s.save(b2);
			s.save(b1);
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
