package com.hibernatedemo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;
import org.hibernate.Session;


public class Main {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(City.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();			
			List<City> cities = session.createQuery("from City").getResultList();// city tablosundan çek
			
			for(City city:cities)
				System.out.println(city.getName());
			session.getTransaction().commit(); // işlem bitince DB'ye basar
		}finally {
			factory.close();
		}
  }
}