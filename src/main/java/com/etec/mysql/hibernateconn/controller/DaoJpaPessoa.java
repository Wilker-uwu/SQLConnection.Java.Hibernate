package com.etec.mysql.hibernateconn.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.etec.mysql.hibernateconn.model.Pessoa;

/**
 * This is a Data Access Object class for manipulating the table
 * of the class {@link com.etec.mysql.hibernateconn.model.Pessoa}
 */
public class DaoJpaPessoa {
	
	private static DaoJpaPessoa instance = null;
	private static EntityManager manager = null;
	
	/**
	 * Constructor method for {@link #DaoJpaPessoa}
	 */
	private DaoJpaPessoa() {
		manager = getEntityManager();
	}
	
	/**
	 * Creates an entity manager for manipulating tables.
	 * @return the EntityManager instance
	 */
	private static EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dashboardConn");
		return (manager == null)?
				manager = factory.createEntityManager():
				manager;
	}
	
	/**
	 * Gathers an instance of this <a href="#DaoJpaPessoa">DAO</a>
	 * @return the static instance of {@link #DaoJpaPessoa}
	 */
	public static DaoJpaPessoa getInstance() {
		return instance==null?instance=new DaoJpaPessoa():instance;
	}
	
	/**
	 * Looks for a registry instance according to the offered ID.
	 * @param id
	 * @return the encountered instance of {@code Pessoa}, if any.
	 */
	public static Pessoa findById(final int id) {
		return getEntityManager().find(Pessoa.class, id);
	}
	
	/**
	 * Gathers all rows of the table from {@code Pessoa}
	 * @return the list of all the instances of {@code Pessoa}
	 */
	@SuppressWarnings("unchecked") //return the converted list of instances of Pessoa without checking
	public static List<Pessoa> findAll() {
		return getEntityManager().createQuery("FROM tb"+Pessoa.class.getSimpleName())
			.getResultList();
	}
	
	/**
	 * Insert method for {@code Pessoa}
	 * @param ppl
	 */
	public static void persist(Pessoa ppl) {
		try {
			getEntityManager().getTransaction().begin();
			getEntityManager().persist(ppl);
			getEntityManager().getTransaction().commit();
		} catch(Exception exp) {
			getEntityManager().getTransaction().rollback();
			exp.printStackTrace();
		}
	}
	
	/**
	 * Update method for {@code Pessoa}
	 * @param ppl
	 */
	public static void merge(Pessoa ppl) {
		try {
			getEntityManager().getTransaction().begin();
			getEntityManager().merge(ppl);
			getEntityManager().getTransaction().commit();
		} catch(Exception exp) {
			getEntityManager().getTransaction().rollback();
			exp.printStackTrace();
		}
	}
	
	/**
	 * Delete method for {@code Pessoa}
	 * @param ppl
	 */
	public static void remove(Pessoa ppl) {
		try {
			getEntityManager().getTransaction().begin();
			getEntityManager().remove(findById(ppl.getId()));
			getEntityManager().getTransaction().commit();
		} catch(Exception exp) {
			getEntityManager().getTransaction().rollback();
			exp.printStackTrace();
		}
	}
	
	/**
	 * Delete method for {@code Pessoa}, exept that only ID is used.
	 * @param id is the id of the registry to be deleted.
	 * @see {@link #remove(Pessoa)}
	 */
	public static void removeById(final int id) {
		Pessoa ppl = findById(id);
		remove(ppl);
	}

}
