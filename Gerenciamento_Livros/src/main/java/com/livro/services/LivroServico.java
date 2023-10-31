package com.livro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livro.entities.Livro;
import com.livro.repository.LivroRepository;

@Service
public class LivroServico {
	
	private final LivroRepository livroRepository;
	
	@Autowired
	public LivroServico (LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}
	public List<Livro> buscaTodosLivros(){
		return livroRepository.findAll();
	}
	public Livro buscaLivroId(Long id) {
		Optional <Livro> Livro = livroRepository.findById(id);
		return Livro.orElse(null);
	}
	public Livro alterarLivro (Long id, Livro alterarLivro) {
		Optional <Livro> existeLivro = livroRepository.findById(id);
		if(existeLivro.isPresent()) {
			alterarLivro.setId(id);
			return livroRepository.save(alterarLivro);
		}
		return null;
	}
	public boolean apagarLivro(Long id) {
		Optional <Livro> existeLivro = livroRepository.findById(id);
		if(existeLivro.isPresent()) {
		livroRepository.deleteById(id);
		return true;
	}
	return false;
	}
	public Livro salvaLivro(Livro livro) {
		return livroRepository.save(livro);
	}
}
