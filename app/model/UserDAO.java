package model;

import javax.persistence.EntityManager;

public class UserDAO {
	public static User getUserByName(String name) {
		EntityManager em = HibernateUtils.getEntityManager();
		return em.find(User.class, name);
	}
}