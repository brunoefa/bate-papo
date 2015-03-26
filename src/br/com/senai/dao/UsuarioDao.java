package br.com.senai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.senai.model.Usuario;

public class UsuarioDao {
	private Connection connection;

	public UsuarioDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void salvar(Usuario usuario) throws SQLException{
		String sql = "insert into usuario (login) value (?)";
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, usuario.getLogin());
			
			stm.execute();
			stm.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}
	
	public void cadastrar(Usuario usuario) {
		String sql = "insert into cadastro (login, nome, senha) value (?, ?, ?)";
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, usuario.getLogin());
			stm.setString(2, usuario.getNome());
			stm.setString(3, usuario.getSenha());
			
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
	
	public Boolean existe(String login) {
			Boolean resultado = false;
			String sql = "select * from usuario where login = ?";
			try {
				PreparedStatement stm = connection.prepareStatement(sql);
				stm.setString(1, login);
				
				ResultSet rs = stm.executeQuery();

				while (rs.next()) {
					resultado = true;
				}
				
				rs.close();
				stm.close();
				
				return resultado;
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				throw new RuntimeException();
			}
	}
}
