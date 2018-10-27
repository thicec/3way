package com.web.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

	public static String url = "jdbc:postgresql://localhost:5432/web-aula01";
	public static String usuario = "postgres";
	public static String senha = "123456";

	public static Connection getConexao() throws SQLException {

		try {
			Class.forName("org.postgresql.Driver");

			return DriverManager.getConnection(url, usuario, senha);
		} catch (ClassNotFoundException e) {
			throw new SQLException(e.getMessage());
		}
	}
}
