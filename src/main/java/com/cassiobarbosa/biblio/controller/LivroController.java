package com.cassiobarbosa.biblio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cassiobarbosa.biblio.model.Livro;
import com.cassiobarbosa.biblio.repository.LivroRepository;

@Controller
public class LivroController {

	@Autowired
	private LivroRepository livroRepository;

	@RequestMapping(value = "/salvarlivro", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Livro> saveBook(@RequestBody Livro livro)
			throws Exception {

		
		if(livroRepository.exists(livro.getId())) {
			livro.setId(livro.getId());
		}

		livro.setAutor(livro.getAutor());
		livro.setAnoPublicacao(livro.getAnoPublicacao());
		livro.setTitulo(livro.getTitulo());
		livro.setCategoria(livro.getCategoria());

		livro = livroRepository.save(livro);

		return new ResponseEntity<Livro>(livro, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/buscarTodosLivros", method = RequestMethod.GET)
	public ResponseEntity<List<Livro>> listAllBooks() throws Exception {
		List<Livro> livros = (List<Livro>)livroRepository.findAll();
		return new ResponseEntity<List<Livro>>(livros, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/buscarPorId", method = RequestMethod.GET)
	public ResponseEntity<Livro> findBookById(@RequestParam("id") Long id) throws Exception {
		
		Livro livro = null;
		
		try {
			livro = livroRepository.findOne(id);
		} catch (Exception e) {
			
			return new ResponseEntity<Livro>(livro, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Livro>(livro, HttpStatus.OK);

	}
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Livro> delete(@PathVariable("id") Long id) throws Exception {
		
		try {
			livroRepository.delete(id);
		} catch (Exception e) {
			return new ResponseEntity<Livro>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Livro>(HttpStatus.OK);
	}

}
