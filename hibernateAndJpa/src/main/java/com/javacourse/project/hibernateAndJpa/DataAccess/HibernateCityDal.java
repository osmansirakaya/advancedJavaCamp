package com.javacourse.project.hibernateAndJpa.DataAccess;
import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javacourse.project.hibernateAndJpa.Entities.City;

// JPA - bir ORM gibi ortaya çıkmıştır. daha sonra javada standart olmuştur 
@Repository
public class HibernateCityDal implements ICityDal{
	
	@Autowired // bu anatosyon, entityManager'ın implementasyonu nedir diye gerekli enjeksiyon yapacak
	public HibernateCityDal(EntityManager entityManager) { // constructor 
		this.entityManager = entityManager;
	}

	private EntityManager entityManager; // jpa'dan gelen session'a karşılık gelir
	//AOP - Aspect Oriented Programming
	@Override
	@Transactional
	public List<City> getAll() {
		Session session = entityManager.unwrap(Session.class); 
		List<City> cities = session.createQuery("from City", City.class).getResultList(); // City class'ına map edecek
		return cities;
	}

	@Override
	public void add(City city) {
		Session session = entityManager.unwrap(Session.class); 
		session.saveOrUpdate(city);		
	}

	@Override
	public void update(City city) {
		Session session = entityManager.unwrap(Session.class); 
		session.saveOrUpdate(city);		
	}

	@Override
	public void delete(City city) {
		Session session = entityManager.unwrap(Session.class); 
		City cityToDelete = session.get(City.class, city.getId());
		session.delete(cityToDelete);	
	}

	@Override
	public City getById(int id) {
		Session session = entityManager.unwrap(Session.class); 
		
	City city = session.get(City.class, id);
	return city;
	}
}
