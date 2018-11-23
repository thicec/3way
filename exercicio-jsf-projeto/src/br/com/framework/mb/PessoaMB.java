package br.com.framework.mb;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean(name = "helloMapeamento")
public class PessoaMB {
	
	private Pessoa pessoa = new Pessoa();
	
	@PostConstruct
	public void init() {
		System.out.println("Método init() executado na inicialização devido a anotação @nnnnnnn");
		pessoa.setNomeCompleto("Fábio Alves Gomes");
		pessoa.setIdade("34");
		pessoa.setSexo("masculino");
		
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
}
	
	
