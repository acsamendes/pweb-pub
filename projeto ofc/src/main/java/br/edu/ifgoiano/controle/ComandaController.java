package br.edu.ifgoiano.controle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ComandaController {
	
	@GetMapping("/comandas")
	public String login() {
		return "login";
	}
	
	@GetMapping ("/comandas/garcom")
	public String abrirGarcom() {
		return "garcom";
	}
	
	@GetMapping ("/comandas/cozinha")
	public String abrirCozinha() {
		return "cozinha";
	}
	
	@GetMapping ("/comandas/caixa")
	public String abrirCaixa() {
		return "caixa";
	}

}
