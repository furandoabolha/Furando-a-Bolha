package br.com.furandoabolha.controller;

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

import br.com.furandoabolha.Repository.PostagemRepository;
import br.com.furandoabolha.model.Postagem;
import br.com.furandoabolha.service.PostagemService;

@RestController
@RequestMapping ("/postagens")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class PostagemController {
	
	@Autowired
    private PostagemRepository postagemRepository;
	
	@Autowired
	private PostagemService postagemService;
	
	
	@GetMapping("/maiscurtidas")
	public ResponseEntity<List<Postagem>>getAllOrderByCurtida(){
		return ResponseEntity.ok(postagemRepository.findAllByOrderByCurtidasAsc());
	}
	
	@GetMapping("/all")
    public ResponseEntity<List<Postagem>>getAll(){
		return ResponseEntity.ok(postagemRepository.findAll());
		
	}
	@GetMapping("/{id}")
    public ResponseEntity<Postagem>getById(@PathVariable long id){
		return postagemRepository.findById(id)
				.map(Resp-> ResponseEntity.ok(Resp))
				.orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>>getByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(postagemRepository.findByTituloContainingIgnoreCase(titulo));
	}
	
	@PostMapping
	public ResponseEntity<Postagem>postPostagem(@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(postagemRepository.save(postagem));
		
	}
	@PutMapping
	public ResponseEntity<Postagem>putPostagem(@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.OK).body(postagemRepository.save(postagem));
		
	}
	@DeleteMapping("/{id}")
	public void deletePostagem(@PathVariable long id) {
		postagemRepository.deleteById(id);
	}
	
	
	//CURTIR R DESCURTIR
	
	@PutMapping("/curtir/{id}")
	public ResponseEntity<Postagem> putCurtirPostagemId (@PathVariable Long id){
		
		return ResponseEntity.status(HttpStatus.OK).body(postagemService.curtir(id));
	
	}

	@PutMapping("/descurtir/{id}")
	public ResponseEntity<Postagem> putDescurtirPostagemId (@PathVariable Long id){
		
		return ResponseEntity.status(HttpStatus.OK).body(postagemService.descurtir(id));
	
	}
	
	
}
	

