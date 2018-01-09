package com.cassiobarbosa.biblio.repository;

import org.springframework.data.repository.CrudRepository;

import com.cassiobarbosa.biblio.model.Livro;

public interface LivroRepository extends CrudRepository<Livro, Long> {

}
