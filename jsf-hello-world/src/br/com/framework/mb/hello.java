package br.com.framework.mb;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean(name = "helloMapeamento")
public class hello {
	
	private String message;
	private String message2;
	private String nomeCompleto;
	
	@PostConstruct
	public void init() {
		System.out.println("M�todo init() executado na inicializa��o devido a anota��o @nnnnnnn");
		setNomeCompleto("F�bio Alves Gomes");
		setMessage("Hello World JSF! 444");
		setMessage2("Hello World JSF! 555");
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage2() {
		return message2;
	}

	public void setMessage2(String message2) {
		this.message2 = message2;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	
}
