package br.edu.ifgoiano.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifgoiano.entidade.Livro;
import br.edu.ifgoiano.repository.LivroRepository;

@Service
public class LivroServiceImpl implements LivroService {
	
	@Autowired
	private LivroRepository livroRepository;

	public List<Livro> listarLivros() {
		return livroRepository.findAll();
	}

	@Override
	public Livro obterLivro(Long id) {
		return this.livroRepository.getReferenceById(id);
	}

	@Override
	public void alterarLivro(Livro livro) {
		this.livroRepository.save(livro);
	}

	@Override
	public void excluirLivro(Long id) {
		this.livroRepository.deleteById(id);
	}
}