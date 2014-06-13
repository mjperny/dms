package dao;

import play.db.jpa.JPA;
import play.db.jpa.Model;
import play.db.jpa.Transactional;

public class GeneralDAO <T extends Model> {
	public void save(T object){
		JPA.em().getTransaction().begin();
		JPA.em().persist(object);
		JPA.em().getTransaction().commit();
	}
	
	public T createOrLoad(long id){
		
		return null;
	}
}
