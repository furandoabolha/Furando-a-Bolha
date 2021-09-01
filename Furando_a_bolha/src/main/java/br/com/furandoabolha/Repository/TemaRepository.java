package br.com.furandoabolha.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.furandoabolha.model.Tema;

public interface TemaRepository extends JpaRepository<Tema, Long>{

	public List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao);
	
}
