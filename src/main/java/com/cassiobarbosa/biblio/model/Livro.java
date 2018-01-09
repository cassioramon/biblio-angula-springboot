package com.cassiobarbosa.biblio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name = "LIVRO")
public class Livro {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "TITULO")
	@NotNull
	private String titulo;

	@Column(name = "AUTOR")
	@NotNull
	private String autor;

	@Column(name = "ANO_PUBLICACAO")
	private Integer anoPublicacao;

	@Column(name = "CATEGORIA")
	private Integer categoria;

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(Integer anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public Integer getCategoria() {
		return categoria;
	}

	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", anoPublicacao=" + anoPublicacao
				+ ", categoria=" + categoria + "]";
	}
	
}
