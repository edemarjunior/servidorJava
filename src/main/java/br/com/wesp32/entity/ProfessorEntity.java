package br.com.wesp32.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "professor")
public class ProfessorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pro")
	private Integer id_pro;

	@Column(name = "nome_pro")
	private String nome_pro;

	@Column(name = "senha_pro")
	private String senha_pro;

	@Column(name = "usuario_pro")
	private String usuario_pro;

	public Integer getId_pro() {
		return id_pro;
	}

	public void setId_pro(Integer id_pro) {
		this.id_pro = id_pro;
	}

	public String getNome_pro() {
		return nome_pro;
	}

	public void setNome_pro(String nome_pro) {
		this.nome_pro = nome_pro;
	}

	public String getSenha_pro() {
		return senha_pro;
	}

	public void setSenha_pro(String senha_pro) {
		this.senha_pro = senha_pro;
	}

	public String getUsuario_pro() {
		return usuario_pro;
	}

	public void setUsuario_pro(String usuario_pro) {
		this.usuario_pro = usuario_pro;
	}

}
