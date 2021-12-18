package br.com.furandoabolha.model;
import java.time.LocalDate;






public class UsuarioLogin {

	private long id;
	
	private String email;
	
	private String senha;
	
	private  String tipoUsuario;
	
	private String nome;
	
	private String token;
	
	private String foto;

	private LocalDate dataNascimento;
	
	//------------- GETTERS & SETTERS -------------
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	public LocalDate getDataNascimento() {
	return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
	this.dataNascimento = dataNascimento;
}
	
	
}
