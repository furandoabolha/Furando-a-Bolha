package br.com.furandoabolha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.furandoabolha.Repository.PostagemRepository;
import br.com.furandoabolha.model.Postagem;


@Service
public class PostagemService {

	@Autowired
	private PostagemRepository postagemRepository;

	/**
	 * Método Curtir -> Soma 1 ao atributo curtidos
	 */

	public Postagem curtir(Long id) {

		Postagem postagem = buscarPostagemPeloId(id);

		postagem.setCurtidas(postagem.getCurtidas() + 1);

		return postagemRepository.save(postagem);

	}

	/**
	 * Método Descurtir -> Soma 1 do atributo descurtidos enquanto
	 */
	
	
	public Postagem descurtir(Long id) {

		Postagem postagem = buscarPostagemPeloId(id);

		postagem.setDescurtidas(postagem.getDescurtidas() + 1);

		return postagemRepository.save(postagem);

	}


	private Postagem buscarPostagemPeloId(Long id) {

		Postagem postagemSalvo = postagemRepository.findById(id).orElse(null);

		if (postagemSalvo == null) {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Postagem não encontrada!", null);
		}

		return postagemSalvo;
	}

}
