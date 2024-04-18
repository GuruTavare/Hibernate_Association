package com.prowings.Unidirectional.OneToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.prowings.HibernateUtil.HibernateUtil;

public class TestOneToMany {

	public static void main(String[] args) {
		
		SessionFactory sf=null;
		Session s=null;
		Transaction tx=null;
		try {
			sf=HibernateUtil.getSessionFactory();
			s=sf.openSession();
			tx=s.beginTransaction();
			
			Employee e=new Employee();
			e.setId(10);
			e.setName("Raghav");
			e.setEmail("raghav@gmail.com");
			e.setPassword("123@23");
			
			Employee e2=new Employee();
			e2.setId(20);
			e2.setName("Ravi");
			e2.setEmail("ravi@gmail.com");
			e2.setPassword("23@23");
			
			
			List<Employee> l= new ArrayList<Employee>();
			l.add(e);
			l.add(e2);
			
			Company c=new Company();
			c.setName("IRFC");
			c.setAddress("Delhi");
			c.setEmployee(l);
			
			s.save(e);
			s.save(e2);
			s.save(c);
			
			tx.commit();
			
//		Employee e=s.get(Employee.class, 1);
//		
//		System.out.println(e.getEmail());
//		
//		String hql = "FROM Employee";
//		Query query = s.createQuery(hql, Employee.class);
//		List<Employee> resultList = query.getResultList();
//		
//		for(Employee emp:resultList) {
//			System.out.println(emp);
//		}
//			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			s.close();
			HibernateUtil.shutDown();
		}

	}

}
