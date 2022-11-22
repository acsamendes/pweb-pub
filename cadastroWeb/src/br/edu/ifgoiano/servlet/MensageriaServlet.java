package br.edu.ifgoiano.servlet;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifgoiano.entidade.Usuario;

@WebServlet("/mensageria")
public class MensageriaServlet extends HttpServlet {

	private static final long serialVersionUID = 3828466400074158832L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Usuario> listaDeEmail = new ArrayList<Usuario>();
		
		for (int i = 0; i < 5; i++) {
			Usuario usuario = new Usuario();
			usuario.setEmail("teste" + i + "@gmail.com");
			
			listaDeEmail.add(usuario);
		}
		
		req.setAttribute("listaDeEmail", listaDeEmail);
		
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String titulo = req.getParameter("titulo");
		String texto = req.getParameter("texto");
		String cmpFormal = req.getParameter("cmpFormal");
		String cmpHorario = req.getParameter("cmpHorario");
		String emailA = req.getParameter("emailAuto");
		int hour = LocalTime.now().getHour();
		
		System.out.println("E-mail enviado com sucesso!\n");
		System.out.println("E-mail enviado para: " + email + "\n");
		System.out.println(titulo + "\n");
		if (cmpFormal!=null && !cmpFormal.isEmpty()) {
			System.out.println("Prezada(o)");
		} else if (cmpHorario!=null && !cmpHorario.equals(null)) {
			if (hour >= 5 && hour <=11) {
				System.out.println("Bom dia,");
			} else if (hour >= 12 && hour <=18) {
				System.out.println("Boa tarde,");
			} else {
				System.out.println("Boa noite,");
			}
		}
		System.out.println(texto + "\n");
		if (emailA!=null && !emailA.equals(null)) {
			System.out.println("Atenção: esse é um e-mail automático e não deve ser respondido.");
		}
		
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
