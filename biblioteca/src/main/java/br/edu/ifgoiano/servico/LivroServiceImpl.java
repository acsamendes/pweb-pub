package br.edu.ifgoiano.servico;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifgoiano.entidade.Livro;

@Service 
public class LivroServiceImpl implements LivroService {

	static List<Livro> livros = new ArrayList<Livro>();
	
	public LivroServiceImpl() {
		Livro livro1 = new Livro();
		livro1.setIsbn("8550804606");
		livro1.setNome("Arquitetura Limpa");
		livro1.setAutor("Robert Martin");
		
		livros.add(livro1);
		
		Livro livro2 = new Livro();
		livro2.setIsbn("8543024978");
		livro2.setNome("Engenharia de Software");
		livro2.setAutor("Ian Sommerville");
		
		livros.add(livro2);
	}
	
    public List<Livro> listarLivros() {
        return livros;
    }

}
