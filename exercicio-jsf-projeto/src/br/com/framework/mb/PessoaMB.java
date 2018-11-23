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
		System.out.println("M�todo init() executado na inicializa��o devido a anota��o @nnnnnnn");
		pessoa.setNomeCompleto("F�bio Alves Gomes");
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
	
	
