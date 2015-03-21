package br.com.senai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.senai.model.Usuario;

public class UsuarioDao {
	private Connection connection;

	public UsuarioDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void salvar(Usuario usuario) {
		String sql = "insert into usuario (login) value (?)";
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, usuario.getLogin());
			
			stm.execute();
			stm.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
	}

	public void deletar(String login) {
		String sql = "delete from usuario where login = ?";
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, login);
			
			stm.execute();
			stm.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
	}
}
