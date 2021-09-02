package br.com.furandoabolha.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.furandoabolha.model.Postagem;

@Repository
public interface PostagemRepository extends JpaRepository <Postagem, Long>{
 
	public List<Postagem> findByTituloContainingIgnoreCase(String titulo);
}