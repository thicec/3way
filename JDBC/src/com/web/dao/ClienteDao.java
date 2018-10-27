package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.web.conexao.FabricaConexao;
import com.web.modelo.Cliente;

public class ClienteDao {

	private static final String SELECT_SQL = "SELECT * " // "asterisco" quer dizer q estou selecionando todas as
															// variaveis do banco de dados
			+ " FROM CLIENTE WHERE SENHA = ? and LOGIN = ?";

	private static final String INSERT_SQL = "INSERT INTO CLIENTE" + "(NOME, LOGIN, SENHA, ENDERECO, CIDADE, BAIRRO) "
			+ "VALUES (?, ?, ?, ?, ?, ?)";

	private static final String UPDATE_SQL = "UPDATE cliente SET "
			+ "SENHA = ?, LOGIN = ?, ENDERECO = ?, CIDADE = ?, BAIRRO = ?  WHERE ID = ?";

	public Cliente obter(Cliente cliente) {

		try (Connection conexao = FabricaConexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(SELECT_SQL)) {

			consulta.setString(1, cliente.getSenha());
			consulta.setString(2, cliente.getLogin());
			ResultSet resultado = consulta.executeQuery();

			if (resultado.next()) {
				cliente.setId(resultado.getInt("ID"));
				cliente.setNome(resultado.getString("NOME"));
				cliente.setSenha(resultado.getString("SENHA"));
				cliente.setLogin(resultado.getString("LOGIN"));
				cliente.setEndereco(resultado.getString("ENDERECO"));
				cliente.setCidade(resultado.getString("CIDADE"));
				cliente.setBairro(resultado.getString("BAIRRO"));
			} else {
				cliente = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente;
	}

	public Cliente inserir(Cliente cliente) {
		try (Connection conexao = FabricaConexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(INSERT_SQL)) {
			consulta.setString(1, cliente.getNome());
			consulta.setString(2, cliente.getLogin());
			consulta.setString(3, cliente.getSenha());
			consulta.setString(4, cliente.getEndereco());
			consulta.setString(5, cliente.getCidade());
			consulta.setString(6, cliente.getBairro());

			consulta.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente;
	}

	public void alterar(Cliente cliente) {

		try (Connection conexao = FabricaConexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(UPDATE_SQL)) {
			consulta.setString(1, cliente.getSenha());
			consulta.setString(2, cliente.getLogin());
			consulta.setString(3, cliente.getEndereco());
			consulta.setString(4, cliente.getCidade());
			consulta.setString(5, cliente.getBairro());
			consulta.setInt(6, cliente.getId());

			consulta.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	public void remover(Cliente entidade) {
//		String sql = "DELETE FROM cliente WHERE ID = ?";
//		
//		try {
//			PreparedStatement consulta = conexao.prepareStatement(sql);
//			
//			consulta.setLong(1, entidade.getId());
//			
//			consulta.executeUpdate();
//		} catch (SQLException e) {
//			System.out.println("Erro ao realizar Delete: " + e.getMessage());
//		}
//	}
}
