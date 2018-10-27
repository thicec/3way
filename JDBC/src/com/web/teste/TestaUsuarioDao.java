package com.web.teste;

import com.web.dao.ClienteDao;
import com.web.modelo.Cliente;

public class TestaUsuarioDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cliente cliente = new Cliente();
		cliente.setSenha("SENHA5");
		cliente.setLogin("LOGIN5");
		
		ClienteDao clienteDao = new ClienteDao();
		
		cliente = clienteDao.obter(cliente);
		cliente.setEndereco("ENDERECO NOVO");
		
		clienteDao.alterar(cliente);
		
		
		System.out.println(cliente.getNome());
		
		System.out.println(cliente.getEndereco());
		
		System.out.println(cliente.getBairro());
		
		System.out.println(cliente.getCidade());
		
		System.out.println("************");
		
		
//		Cliente cliente2 = new Cliente();
//		cliente2.setNome("NOME1");
//		cliente2.setLogin("LOGIN1");
//		cliente2.setSenha("SENHA1");
//		cliente2.setEndereco("ENDERECO1");
//		cliente2.setBairro("BAIRRO1");
//		cliente2.setCidade("CIDADE2");
//		
//			
//		ClienteDao clienteDao2 = new ClienteDao();
//		
////		cliente2 = clienteDao2.inserir(cliente2);
		
		System.out.println("************");
		
		
		
	}
}
