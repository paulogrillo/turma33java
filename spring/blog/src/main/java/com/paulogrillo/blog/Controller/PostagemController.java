package com.paulogrillo.blog.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paulogrillo.blog.Repository.PostagemRepository;
import com.paulogrillo.blog.model.Postagens;
import com.paulogrillo.blog.model.Tema;

@RestController
@RequestMapping("/feed")
@CrossOrigin(origins = "*",allowedHeaders = "*" )
public class PostagemController {
	
	@Autowired
	private PostagemRepository repository;
	
	//Busca todas postagens
	@GetMapping
	public ResponseEntity<List<Postagens>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Postagens> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagens>> GetByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	@PostMapping
	public ResponseEntity<Postagens> post (@RequestBody Postagens postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
	}
	
	@PutMapping
	public ResponseEntity<Postagens> put (@RequestBody Postagens postagem){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}	
	
}
