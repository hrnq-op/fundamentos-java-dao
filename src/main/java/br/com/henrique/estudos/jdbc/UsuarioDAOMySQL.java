package br.com.henrique.estudos.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOMySQL implements IUsuarioDAO{
	
	@Override 
	public void inserir(Usuario u) throws SQLException{
		String sql = "INSERT INTO usuario (nome, ano_nasc, sexo) VALUES (?,?,?)";
		
		try (Connection conn = Conexao.getConnection();
			 PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setString(1, u.getNome());
			stmt.setInt(2, u.getAno_nasc());
			stmt.setString(3, u.getSexo());
			stmt.executeUpdate();
			}
	}
	
	@Override
	public List<Usuario> listar() throws SQLException{
		String sql = "SELECT * FROM usuario";
		List<Usuario> lista = new ArrayList<>();
		try (Connection conn = Conexao.getConnection();
			 PreparedStatement stmt = conn.prepareStatement(sql);
			 ResultSet rs = stmt.executeQuery()){
				while (rs.next()) {
					Usuario u = new Usuario(rs.getString("nome"), rs.getInt("ano_nasc"), rs.getString ("sexo"));
					u.setId(rs.getInt("id"));
					lista.add(u);
				}
		}
		return lista;
	}
	
	@Override
	public Usuario pesquisar(int id) throws SQLException{
		String sql = "SELECT * FROM usuario WHERE id = ?";
		Usuario u = null;
		
		try (Connection conn = Conexao.getConnection();
			 PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setInt(1, id);
			
				try(ResultSet rs = stmt.executeQuery()){
					if (rs.next()) {
						u = new Usuario(rs.getString("nome"), rs.getInt("ano_nasc"), rs.getString("sexo"));
						u.setId(rs.getInt("id"));
					}
			}
		}
		return u;	
	}
	
	@Override 
	public void alterar (int id, String nome, String sexo, int ano_nasc) throws SQLException{
		String sql = "UPDATE usuario SET nome = ?, sexo = ?, ano_nasc = ? WHERE id = ?";
		
		try(Connection conn = Conexao.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setString(1, nome);
			stmt.setString(2, sexo);
			stmt.setInt(3, ano_nasc);
			stmt.setInt(4, id);
			
			stmt.executeUpdate();
		}
	}
	
	@Override
	public void excluir (int id) throws SQLException {
		String sql = "DELETE FROM usuario WHERE id = ?";
		try(Connection conn = Conexao.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setInt(1, id);
			stmt.executeUpdate();
		}

	}
	
}