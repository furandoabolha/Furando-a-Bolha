package br.com.furandoabolha.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.furandoabolha.model.Usuario;



public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;
	
	private String userEmail;
	
	private String password;

	

	public UserDetailsImpl(Usuario usuario) {
		this.userEmail = usuario.getEmail();
		this.password = usuario.getSenha();
	}
	
	public UserDetailsImpl() {   } 
	
	
	

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return null;
	}

	@Override
	public String getUsername() {
		
		return userEmail;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}

	

	
}
