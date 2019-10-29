package br.com.wesp32.http;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Professor {

	private Integer id_pro;
	private String nome_pro;
	private String senha_pro;
	private String usuario_pro;

	public Professor(Integer id_pro, String nome_pro, String senha_pro, String usuario_pro) {
		super();
		this.id_pro = id_pro;
		this.nome_pro = nome_pro;
		this.senha_pro = senha_pro;
		this.usuario_pro = usuario_pro;
	}

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
