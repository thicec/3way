package com.framework.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.sql.ordering.antlr.GeneratedOrderByFragmentRendererTokenTypes;

import com.framework.model.Pessoa;

public class PessoaDao {
	EntityManager entityManager;

	// Nossa classe PessoaDao segue o padrao de projeto
	// Singleton que garante que apenas uma insistencia dessa
	// classe seria criada durante toda a aplicacao

	private static PessoaDao instance;

	public static PessoaDao getInstance() {
		if (instance == null) {
			instance = new PessoaDao();
		}
		return instance;
	}

	private PessoaDao() {
		entityManager = getEntityManager();

	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPAExemplo");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}

	public void persist(Pessoa pessoa) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(pessoa);
			entityManager.getTransaction().commit();

		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public Pessoa getById(final int id) {
		return entityManager.find(Pessoa.class, id);

	}

	// utiliza o createQuery que recebe um JPQL
	// Java Presistence Query Language) que uma alternativa aqo SQL
	@SuppressWarnings("unchecked")
	public List<Pessoa> findAll() {
		return entityManager.createQuery("FROM " + Pessoa.class.getName()).getResultList();
	}

	// o metodo merge segue o principio do metodo persist,
	// a unica diferenca é que o merge atualiza o registro e nao
	// apenas inseri ele no banco

	public void update(Pessoa pessoa) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(pessoa);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(Pessoa pessoa) {
		try {
			entityManager.getTransaction().begin();
			
			// torna o objeto gerenciado/sincronizado pela JPA
			pessoa = entityManager.find(Pessoa.class, pessoa.getId());
			
			entityManager.remove(pessoa);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	public void removeById(final int id) {
		try {
			Pessoa pessoa = getById(id);
			remove(pessoa);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
