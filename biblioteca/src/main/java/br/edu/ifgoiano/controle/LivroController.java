package br.edu.ifgoiano.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifgoiano.entidade.Livro;
import br.edu.ifgoiano.repository.LivroRepository;
import br.edu.ifgoiano.servico.LivroService;
import br.edu.ifgoiano.servico.LivroServiceImpl;

@Controller
public class LivroController {

	private final LivroService livroServiceImpl;

	@Autowired
	private LivroRepository livroRepository;
	
	public LivroController(LivroServiceImpl livroServiceImpl) {
		this.livroServiceImpl = livroServiceImpl;
	}

	@GetMapping("/livros")
	public String listarLivros(Model model) {
		model.addAttribute("livros", livroServiceImpl.listarLivros());
		return "listar-livros";
	}
	
	@GetMapping ("/livros/novo")
	public String abrirNovoLivro(Model model) {
		Livro livro = new Livro();
		
		model.addAttribute("livro", livro);
		
		return "inserir-livro";
	}
	
	@PostMapping("/livros/inserir")
	public String inserirLivro(Livro livro) {
		//inserir o livro no BD
		livroRepository.save(livro);
		return "redirect:/livros";
	}
}