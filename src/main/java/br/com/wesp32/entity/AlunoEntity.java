package br.com.wesp32.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "aluno")
public class AlunoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_alu")
	private Integer id_alu;

	@Column(name = "nome_alu")
	private String nome_alu;

	@Column(name = "senha_alu")
	private String senha_alu;

	@Column(name = "usuario_alu")
	private String usuario_alu;

	@Column(name = "idade_alu")
	private Integer idade_alu;

	public Integer getId_alu() {
		return id_alu;
	}

	public void setId_alu(Integer id_alu) {
		this.id_alu = id_alu;
	}

	public String getNome_alu() {
		return nome_alu;
	}

	public void setNome_alu(String nome_alu) {
		this.nome_alu = nome_alu;
	}

	public String getSenha_alu() {
		return senha_alu;
	}

	public void setSenha_alu(String senha_alu) {
		this.senha_alu = senha_alu;
	}

	public String getUsuario_alu() {
		return usuario_alu;
	}

	public void setUsuario_alu(String usuario_alu) {
		this.usuario_alu = usuario_alu;
	}

	public Integer getIdade_alu() {
		return idade_alu;
	}

	public void setIdade_alu(Integer idade_alu) {
		this.idade_alu = idade_alu;
	}
	
	

}
