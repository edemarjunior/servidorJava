package br.com.wesp32.http;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Aluno {

	private Integer codigo;
	private String nome;
	private String senha;
	private String usuario;
	private Integer idade;

	public Aluno() {
	}

	public Aluno(Integer codigo, String nome, String senha, String usuario, Integer idade) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.senha = senha;
		this.usuario = usuario;
		this.idade = idade;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

}
