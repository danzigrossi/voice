/**
 * 
 */
package br.com.jarbas.factory.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import br.com.jarbas.model.entity.Acao;

/**
 * @author <a
 * 1 de jun de 2017
 */
public class BasicDao<T> {
	
	@PersistenceContext
	protected EntityManager em;
	public void pesist (T obj) {
		em.persist(obj);
	}
	
	public T merge (T obj) {
		return em.merge(obj);
	}

}
