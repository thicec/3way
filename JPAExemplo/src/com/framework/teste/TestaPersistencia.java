package com.framework.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.framework.model.Pessoa;

public class TestaPersistencia {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPAExemplo");
		EntityManager entityManager = factory.createEntityManager();

		Pessoa pessoa = new Pessoa();
//		comando para inserir pessoa. Toda vez q eu rodar ele será incluida uma nova pessoa no banco// 
//		pessoa.setCpf("12312312323");
//		pessoa.setName("Fabio Costa");

		entityManager.getTransaction().begin();
		entityManager.persist(pessoa);
		entityManager.getTransaction().commit();

		List<Pessoa> todasPessoaJPA = entityManager.createQuery("FROM " + Pessoa.class.getName()).getResultList();
		for (Pessoa pessoaLaco : todasPessoaJPA) {
			System.out.println(pessoaLaco);
		}
	}
}
