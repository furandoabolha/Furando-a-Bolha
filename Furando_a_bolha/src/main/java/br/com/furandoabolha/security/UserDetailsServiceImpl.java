package br.com.furandoabolha.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.furandoabolha.Repository.UsuarioRepository;
import br.com.furandoabolha.model.Usuario;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		
		Optional<Usuario> usuario = userRepository.findByEmail(userEmail);
		
		usuario.orElseThrow(() -> new UsernameNotFoundException(userEmail + " not found."));
		
		return usuario.map(UserDetailsImpl::new).get();
	}

}
