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
	protected EntityManager manager = null;
	
	/**
	 * Constructor method for {@link #DaoJpaPessoa}
	 */
	public DaoJpaPessoa() {
		this.manager = getEntityManager();
	}
	
	/**
	 * Creates an entity manager for manipulating tables.
	 * @return the EntityManager instance
	 */
	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudHibernatePU");
		return (this.manager == null)?
				this.manager = factory.createEntityManager():
				this.manager;
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
	 * @return the encountered instance of {@link Pessoa}, if any.
	 */
	public Pessoa findById(final int id) {
		return this.manager.find(Pessoa.class, id);
	}
	
	/**
	 * Gathers all rows of the table from {@link Pessoa}
	 * @return the list of all the instances of {@code Pessoa}
	 */
	@SuppressWarnings("unchecked") //return the converted list of instances of Pessoa without checking
	public List<Pessoa> findAll() {
		return this.manager.createQuery("FROM tb"+Pessoa.class.getSimpleName()).getResultList();
	}
	
	/**
	 * Insert method for {@link Pessoa}
	 * @param ppl
	 */
	public void persist(Pessoa ppl) {
		this.manager.getTransaction().begin();
		this.manager.persist(ppl);
		this.manager.getTransaction().commit();
	}
}
