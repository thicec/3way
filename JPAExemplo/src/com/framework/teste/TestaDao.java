package com.framework.teste;

import java.util.List;

import com.framework.dao.PessoaDao;
import com.framework.model.Pessoa;

public class TestaDao {
	static PessoaDao pessoaDao = PessoaDao.getInstance();

	public static void main(String[] args) {

		listarTodasPessoas();
//		incluirPessoa();
		excluirPessoa();
		listarTodasPessoas();
		

	}

	private static void listarTodasPessoas() {
		List<Pessoa> todasPessoasJPA = pessoaDao.findAll();
		for (Pessoa pessoaLaco : todasPessoasJPA) {
			// implementar toString() via suporte da ferramenta
			System.out.println(pessoaLaco);
		}
	}

	private static void alterarPessoa() {
		Pessoa pessoaAlterar = pessoaDao.getById(2);
		pessoaAlterar.setName("Outro cara alterado");

		pessoaDao.update(pessoaAlterar);
	}

	private static void incluirPessoa() {
		Pessoa incluirPessoa = new Pessoa();
		incluirPessoa.setName("Joao da Silva");
		incluirPessoa.setCpf("123456789-11");
		pessoaDao.persist(incluirPessoa);
	}
	
	private static void excluirPessoa() {
		pessoaDao.removeById(2);
		
		
		
		
	}

}
