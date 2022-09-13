package br.edu.ifgoiano.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.ifgoiano.servico.LivroService;
import br.edu.ifgoiano.servico.LivroServiceImpl;

@Controller //controlador entre back e front
public class LivroController {
	
    private final LivroService livroServiceImpl;

    public LivroController(LivroServiceImpl livroServiceImpl) {
        this.livroServiceImpl = livroServiceImpl;
    }

    @GetMapping("/livros") //url
    public String listarLivros(Model model) {
        model.addAttribute("livros", livroServiceImpl.listarLivros()); //chama o método da classe de serviço
        return "listar-livros"; //devolve para a view
    }        
}
