package br.com.furandoabolha.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (name = "db_usuario")
public class Usuario{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
@NotNull(message = "O atributo e-mail é Obrigatório!") 
@Size(min = 5, max = 100, message = "O atributo e-mail deve conter no mínimo 05 e no máximo 100 caracteres")
private String email;
@NotNull(message = "O atributo senha é Obrigatório!") 
@Size(min = 8, max = 8, message = "O atributo senha deve conter no mínimo 08 e no máximo 8 caracteres, contendo letras e números")
private String senha;




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
	
}
