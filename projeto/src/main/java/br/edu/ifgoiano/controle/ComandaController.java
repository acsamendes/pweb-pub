package br.edu.ifgoiano.controle;

import org.springframework.web.bind.annotation.GetMapping;

public class ComandaController {
	
	@GetMapping("/comandas")
	public String listarLivros() {
		return "login";
	}

}
