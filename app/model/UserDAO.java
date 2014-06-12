package model;

import javax.persistence.EntityManager;

/**
 * @author Gary Ye
 * @version 2014-06-07
 */
public class UserDAO {
	/**
	 * Returns the user with the given name.
	 * @param name the name of the user
	 * @return on success the user, otherwise null
	 */
	public static User getUserByName(String name) {
		EntityManager em = HibernateUtils.getEntityManager();
		return em.find(User.class, name);
	}
}
