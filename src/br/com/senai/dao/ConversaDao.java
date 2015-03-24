package br.com.senai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.senai.model.Conversa;

public class ConversaDao {
	private Connection connection;

	public ConversaDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void salvar(Conversa conversa) {
		String sql = "insert into conversa (usuario, mensagem, datahora) value (?, ?, ?)";
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, conversa.getUsuario());
			stm.setString(2, conversa.getMensagem());
			stm.setTimestamp(3, conversa.getDataHora());
			
			stm.execute();
			stm.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
	}
	
	public List<Conversa> buscarTodos() {
		List<Conversa> listaConversa = new ArrayList<Conversa>();
		String sql = "select * from conversa";
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				Conversa c = new Conversa();

				c.setId(rs.getInt("id"));
				c.setUsuario(rs.getString("usuario"));
				c.setMensagem(rs.getString("mensagem"));
//				c.setDataHora(rs.getDate("datahora"));
				
				listaConversa.add(c);
			}
			
			rs.close();
			stm.close();
			
			return listaConversa;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
	}

}
