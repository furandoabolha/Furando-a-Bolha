package br.com.furandoabolha.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.furandoabolha.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Long> {

	public Optional<Usuario> findByEmail(String email);
	
	public List<Usuario>findAllByNomeContainingIgnoreCase(String nome);
	
	public Usuario findByNome(String nome);


}
