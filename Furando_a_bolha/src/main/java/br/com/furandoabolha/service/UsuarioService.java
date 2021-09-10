package br.com.furandoabolha.service;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.furandoabolha.Repository.UsuarioRepository;
import br.com.furandoabolha.model.Usuario;
import br.com.furandoabolha.model.UsuarioLogin;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	public String encoder(String senha) {

		return encoder.encode(senha);
	}

	public List<Usuario> listarUsuarios() {

		return usuarioRepository.findAll();
	}

	public Optional<Usuario> buscarUsuarioId(long id) {

		return usuarioRepository.findById(id);
	}

	public Optional<Usuario> cadastrarUsuario(Usuario usuario) {

		if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent())
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Usuário já existe!,null");

		int idade = Period.between(usuario.getDataNascimento(), LocalDate.now()).getYears();

		if (idade < 18)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Usuário é menos de idade!", null);

		usuario.setSenha(encoder(usuario.getSenha()));

		return Optional.of(usuarioRepository.save(usuario));
	}

	public Optional<Usuario> atualizarUsuario(Usuario usuario) {

		for (Usuario user : this.listarUsuarios()) {
			if (user.getEmail().equals(usuario.getEmail())) {
				throw new ResponseStatusException(HttpStatus.CONFLICT, "Ja existe um usuario com esse nome", null);
			}
		}

		if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {

			int idade = Period.between(usuario.getDataNascimento(), LocalDate.now()).getYears();
			if (idade < 18)
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Usuário é menor de idade", null);
			usuario.setSenha(encoder(usuario.getSenha()));

			return Optional.of(usuarioRepository.save(usuario));
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado!", null);
		}
	}

	public Optional<UsuarioLogin> loginUsuario(Optional<UsuarioLogin> usuarioLogin) {

		Optional<Usuario> usuario = usuarioRepository.findByEmail(usuarioLogin.get().getEmail());

		if (usuario.isPresent()) {

			if (encoder.matches(usuarioLogin.get().getSenha(), usuario.get().getSenha())) {

				String auth = usuarioLogin.get().getEmail() + ":" + usuarioLogin.get().getSenha();
				byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodeAuth);

				usuarioLogin.get().setId(usuario.get().getId());
				usuarioLogin.get().setNome(usuario.get().getNome());
				usuarioLogin.get().setSenha(usuario.get().getSenha());
				usuarioLogin.get().setToken(authHeader);

				return usuarioLogin;
			}
		}
		throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "O Usuário ou Senha Inválidos!", null);
	}
}
