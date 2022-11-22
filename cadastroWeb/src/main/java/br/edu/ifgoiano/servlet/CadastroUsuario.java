package br.edu.ifgoiano.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifgoiano.entidade.Usuario;
import br.edu.ifgoiano.repositorio.UsuRepositorio;

@WebServlet(urlPatterns = "/cadastroUsuario")
public class CadastroUsuario extends HttpServlet {

	private static final long serialVersionUID = 1L;

	boolean cadastrou = false;


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nome = req.getParameter("nome");
		String email = req.getParameter("email");

		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setEmail(email);

		UsuRepositorio usuRepositorio = new UsuRepositorio();
		List<Usuario> listaUsuario = usuRepositorio.listarUsuarios();

		for (Usuario usu : listaUsuario) {
			if (usu.getNome().equals(nome)) {
				cadastrou = true;
				break;
			} else {
				cadastrou = false;
			}
		}


		if (cadastrou == false) {			
			UsuRepositorio repositorio = new UsuRepositorio();

			repositorio.inserirUsuario(usuario);

			listaUsuario = repositorio.listarUsuarios(); 

			if (listaUsuario.isEmpty()) {
				System.out.println("Lista vazia");
			} else {
				System.out.println("Lista preenchida");
			}


			req.setAttribute("mensagem2", "Usuário cadastrado: ".concat(nome));
			System.out.println("O usuário cadastrado foi: ".concat(nome));
			System.out.println("Email: ".concat(email));
		} else {
			System.out.println("A tentativa cadastrado foi: ".concat(nome));
			System.out.println("Preço: ".concat(email));
			req.setAttribute("mensagem1", "!!!Os dados já estão cadastrados cadastrado!!!");
		}

		req.getRequestDispatcher("cadastro.jsp").forward(req, resp);

	}

}


