package br.edu.ifgoiano.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table(name = "livro") //cria a tabela automaticamente
public class Livro {
	
	@Id //adiciona as colunas no bd
	@GeneratedValue (strategy = GenerationType.IDENTITY) //torna a coluna com valores auto gerados 
	private Long id;
	
	@Column //se não colocar o name, ele utiliza o do atributo
	private String isbn;
	
	@Column
	private String nome;
	
	@Column 
	private String autor;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
}
