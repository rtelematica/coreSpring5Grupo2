package org.certificatic.spring.orm.practica27.dao.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.certificatic.spring.orm.practica27.dao.IGenericDAO;
import org.certificatic.spring.orm.practica27.domain.entities.Account;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;

public abstract class GenericJpaDAO<T, ID extends Serializable>
		implements IGenericDAO<T, ID> {

	protected @Getter final Class<T> persistentClass;

	// Inyectar EntityManager
	@PersistenceContext
	protected @Getter EntityManager entityManager;

	public GenericJpaDAO(final Class<T> type) {
		this.persistentClass = type;
	}
	
	@Override
	public void insert(T entity) {
		this.entityManager.persist(entity);
	}

	@Override
	public void update(T entity) {
		this.entityManager.merge(entity);
	}

	@Override
	public T findById(ID id) {
		return (T) this.entityManager.find(this.persistentClass, id);
	}

	@Override
	public T delete(ID id) {
		final T entity = this.findById(id);
		return this.delete(entity);
	}

	@Override
	public T delete(T entity) {
		if (entity != null) {
			this.entityManager.remove(entity);
		}
		return entity;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return (List<T>) this.entityManager
				.createQuery("FROM " + this.persistentClass.getName())
				.getResultList();
	}

	@Override
	public void detach(T entity) {
		this.entityManager.detach(entity);
	}

}
