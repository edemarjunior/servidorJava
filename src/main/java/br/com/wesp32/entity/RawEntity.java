package br.com.wesp32.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "infrared")
public class RawEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_inf")
	private Integer id_inf;

	@Column(name = "sala_inf")
	private String sala_inf;

	@Column(name = "esp_inf")
	private String esp_inf;

	@Column(name = "raw_inf")
	private String raw_inf;
	
	@Column(name = "tipo_inf")
	private int tipo_inf;

	public Integer getId_inf() {
		return id_inf;
	}

	public void setId_inf(Integer id_inf) {
		this.id_inf = id_inf;
	}

	public String getSala_inf() {
		return sala_inf;
	}

	public void setSala_inf(String sala_inf) {
		this.sala_inf = sala_inf;
	}

	public String getEsp_inf() {
		return esp_inf;
	}

	public void setEsp_inf(String esp_inf) {
		this.esp_inf = esp_inf;
	}

	public String getRaw_inf() {
		return raw_inf;
	}

	public void setRaw_inf(String raw_inf) {
		this.raw_inf = raw_inf;
	}

	public int getTipo_inf() {
		return tipo_inf;
	}

	public void setTipo_inf(int tipo_inf) {
		this.tipo_inf = tipo_inf;
	}
	
	

}
