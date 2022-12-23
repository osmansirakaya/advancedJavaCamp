package com.javacourse.project.hibernateAndJpa.DataAccess;
import java.util.List; 
import com.javacourse.project.hibernateAndJpa.Entities.City; // City başka pakette olduğu için import ediyoruz


public interface ICityDal { // veri erişim için temel interface 
	
	List<City> getAll(); // şehirleri listelicek yapı
	void add(City city);
	void update(City city);
	void delete(City city);
	City getById(int id);

}
