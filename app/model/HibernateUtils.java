package model;
import javax.persistence.EntityManager;


public class HibernateUtils {
	private static EntityManager entityManager;

	/**
	 * @return the entityManager
	 */
	public static EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * @param entityManager the entityManager to set
	 */
	public static void setEntityManager(EntityManager entityManager) {
		HibernateUtils.entityManager = entityManager;
	}	
}
