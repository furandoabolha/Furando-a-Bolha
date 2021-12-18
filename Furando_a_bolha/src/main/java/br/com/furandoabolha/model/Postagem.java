package br.com.furandoabolha.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;

//import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.furandoabolha.configure.AlteracaoDataPostagem;

@Entity
@Table(name = "tb_postagem")
public class Postagem extends AlteracaoDataPostagem implements Serializable {

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull(message = "O atributo título é Obrigatório!")
	@Size(min = 5, max = 100, message = "O atributo título deve conter no mínimo 05 e no máximo 100 caracteres")
	private String titulo;

	@NotNull(message = "O atributo texto é Obrigatório!")
	@Size(min = 1, max = 1000, message = "O atributo texto deve conter no mínimo 01 e no máximo 1000 caracteres")
	private String texto;

	@CreationTimestamp
	@Column(name = "dt_criacao", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());

	// Verfifcar na task9
	// Alteração de data X data fixa de postagem

	/*
	 * @UpdateTimestamp
	 * 
	 * @Temporal(TemporalType.TIMESTAMP)
	 * 
	 * @Column(name = "dt_alteracao")
	 * 
	 * @JsonFormat(pattern="yyyy-MM-dd  HH:mm") private Date alteracaoData = new
	 * java.sql.Date(System.currentTimeMillis());
	 */

	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;

	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;

	@Column(columnDefinition = "integer default 0")
	private int curtidas;
	
	@Column(columnDefinition = "integer default 0")
	private int descurtidas;

	// ------------- GETTERS & SETTERS -------------

	
	
	
	


	public int getDescurtidas() {
		return descurtidas;
	}

	public void setDescurtidas(int descurtidas) {
		this.descurtidas = descurtidas;
	}

	public int getCurtidas() {
		return this.curtidas;
	}
	
	
	public void setCurtidas(int curtidas) {
		this.curtidas = curtidas;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	/*
	 * public Date getAlteracaoData() { return alteracaoData; }
	 * 
	 * public void setAlteracaoData(Date alteracaoData) { this.alteracaoData =
	 * alteracaoData; }
	 */

}
