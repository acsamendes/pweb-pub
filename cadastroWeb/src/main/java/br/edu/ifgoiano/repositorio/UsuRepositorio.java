package br.edu.ifgoiano.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifgoiano.entidade.Usuario;

public class UsuRepositorio {

	Connection conn;

	public UsuRepositorio() {
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<Usuario> listarUsuarios() {
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();

		String sql = "select nome, email from usuario";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				Usuario usuario = new Usuario();
				usuario.setNome(result.getString("nome"));
				usuario.setEmail(result.getString("email"));

				listaUsuarios.add(usuario);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaUsuarios;
	}
	
	public void inserirUsuario (Usuario usuario) {
		String sql = "insert into usuario (nome, email) values (?, ?)";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1,usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
