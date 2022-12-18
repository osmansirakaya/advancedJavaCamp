package com.hibernatedemo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.loader.plan.exec.internal.CollectionReferenceAliasesImpl;

import java.util.List;
import org.hibernate.Session;


public class Main {
	public static void main(String[] args) {
		selectData();
		
  }
	
	public static void selectData() {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(City.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();		
		try {
			session.beginTransaction();
			List<City> cities = session.createQuery("from City c where c.countryCode='TUR'").getResultList();// city tablosundan çek		
			for(City city:cities)
				System.out.println(city.getName());				
		}finally {
			factory.close();
		}
	}
	
	public static void insertData() {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(City.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();		
		try {
			session.beginTransaction();
			  City city = new City(); 
			  	city.setName("düzce 10"); 
			  	city.setCountryCode("TUR");
			  	city.setDistrict("karadeniz"); 
			  	city.setPopulation("10000");
			  session.save(city);
			session.getTransaction().commit(); // işlem başarıyla bitince DB'ye basar
			System.out.println("sehir eklendi");
		}finally {
			factory.close();
		}
	}
	
	public static void updateData() {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(City.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();		
		try {
			session.beginTransaction();
			City city = session.get(City.class, 235760); //id'si 235760 olan veriyi getir.
			city.setName("Ankara");	
			session.getTransaction().commit(); 
			System.out.println("sehir güncellendi");
		}finally {
			factory.close();
		}		
	}
	
	public static void deleteData() {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(City.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();	
		try {
			session.beginTransaction();
			City city = session.get(City.class, 4080);
			session.delete(city);			
			session.getTransaction().commit(); 
			System.out.println("şehir silindi");
		}finally {
			factory.close();
		}
	}
	
}
