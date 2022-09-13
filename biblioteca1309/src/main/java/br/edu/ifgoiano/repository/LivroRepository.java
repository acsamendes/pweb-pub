package br.edu.ifgoiano.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifgoiano.entidade.Livro;

//<entidade, tipo de dado>
public interface LivroRepository extends JpaRepository<Livro, Long> {
	
	
	
}
