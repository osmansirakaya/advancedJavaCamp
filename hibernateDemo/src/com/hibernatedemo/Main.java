package com.hibernatedemo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.loader.plan.exec.internal.CollectionReferenceAliasesImpl;

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
			// HQL -> "Hibernate Query Languange"
			// ("from City c where c.countryCode='TUR' AND c.district='Ankara'")
			// ("from City c where c.name LIKE '%kar%'")
//			List<City> cities = session.createQuery("select c.countryCode from City c GROUP  BY c.countryCode'").getResultList();// city tablosundan çek
//			
//			for(City city:cities)
//				System.out.println(city.getName());
			
			// insert		
//			  City city = new City(); 
//			  city.setName("düzce 10"); 
//			  city.setCountryCode("TUR");
//			  city.setDistrict("karadeniz"); 
//			  city.setPopulation("10000");
//			  session.save(city);
			
			// update 
			//City city = session.get(City.class, 4080); // id'si 4080 olan veriyi getir.
			//city.setPopulation("90000");
			//session.save(city);
			
			//delete
			City city = session.get(City.class, 4080);
			session.delete(city);			
			session.getTransaction().commit(); // işlem bitince DB'ye basar
			System.out.println("şehir silindi");
		}finally {
			factory.close();
		}
  }
}