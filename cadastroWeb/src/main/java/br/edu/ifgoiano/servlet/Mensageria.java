package br.edu.ifgoiano.servlet;

import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifgoiano.entidade.Usuario;
import br.edu.ifgoiano.repositorio.UsuRepositorio;

@WebServlet("/mensageria")
public class Mensageria extends HttpServlet{

	private static final long serialVersionUID = 4431416108198568308L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UsuRepositorio repositorio = new UsuRepositorio();
		List<Usuario> listaUsuarios = repositorio.listarUsuarios();
		
		req.setAttribute("listaUsuarios", listaUsuarios);
		req.getRequestDispatcher("mensageria.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String titulo = req.getParameter("titulo");
		String texto = req.getParameter("texto");
		String cumprimento = req.getParameter("envio");
		String automatico = req.getParameter("automatico");
		int hora = LocalTime.now().getHour();
		
		System.out.println();
		System.out.println();
		System.out.println("---------------SIMULAÇÃO---------------");
		System.out.println("Email enviado para: "+ email);
		System.out.println();
		System.out.println(titulo);
		System.out.println();
		
		if (cumprimento!=null && !cumprimento.equals(null)) {
			if (cumprimento.equals("formal") && cumprimento != null) {
			if (cumprimento!=null && !cumprimento.isEmpty()) {
				System.out.println("Prezada(o)");
			}
		} else if (cumprimento != null){
			if (hora >= 5 && hora <= 11.59) {
				System.out.println("Bom dia,");
			} else if (hora >= 12 && hora <= 18.59) {
				System.out.println("Boa tarde,");
			} else {
				System.out.println("Boa noite,");
			}
		}
		}
			
		System.out.println(texto);
		
		if (automatico!=null && !automatico.equals(null)) {
			System.out.println();
			System.out.println("Atenção: esse é um e-mail automático e não deve ser respondido.");
		}
		
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	
		
}
}
