package br.com.henrique.estudos.jdbc;

import java.sql.SQLException;
import java.util.List;

public interface IUsuarioDAO {
	void inserir(Usuario u) throws SQLException;
	List<Usuario> listar() throws SQLException;
	Usuario pesquisar(int id) throws SQLException;
	void alterar (int id, String nome, String sexo, int ano_nasc) throws SQLException;
	void excluir (int id) throws SQLException;
}
