package com.livro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livro.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

	
	

}