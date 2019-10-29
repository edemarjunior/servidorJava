package br.com.wesp32.http;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Raw {

	private Integer codigo;
	private String sala;
	private String esp;
	private String raw;
	private int tipo;

	public Raw(String sala, String esp, String raw, int tipo) {
		super();
		this.sala = sala;
		this.esp = esp;
		this.raw = raw;
		this.tipo = tipo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getEsp() {
		return esp;
	}

	public void setEsp(String esp) {
		this.esp = esp;
	}

	public String getRaw() {
		return raw;
	}

	public void setRaw(String raw) {
		this.raw = raw;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	

}
