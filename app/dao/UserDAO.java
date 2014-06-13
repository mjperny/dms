package dao;

import play.db.jpa.JPA;
import models.User;

/**
 * @author gary
 *
 */
public class UserDAO extends GeneralDAO<User> {
	/**
	 * Returns the user with the given name.
	 * @param name the name of the user
	 * @return on success the user, otherwise null
	 */
	public User findByName(String name){
		return JPA.em().createQuery("SELECT u FROM User u WHERE u.name = :name", User.class).setParameter("name", name).getSingleResult();
	}
}
