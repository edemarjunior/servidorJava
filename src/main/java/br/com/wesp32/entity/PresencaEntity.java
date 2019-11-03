package br.com.wesp32.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "presenca")
public class PresencaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pre")
	private int id_pre;

	@Column(name = "data_pre")
	private Date data_pre;

	@Column(name = "aluno_pre")
	private String aluno_pre;

	@Column(name = "endmac_pre")
	private String endmac_pre;

	@Column(name = "nmesp_pre")
	private String nmesp_pre;

	@Column(name = "sala_pre")
	private String sala_pre;

	public String getData_pre() {
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String Calibragemveiculo = formatador.format(data_pre);
		
		return Calibragemveiculo;
	}

	public void setData_pre(Date data_pre) {
		this.data_pre = data_pre;
	}

	public String getAluno_pre() {
		return aluno_pre;
	}

	public void setAluno_pre(String aluno_pre) {
		this.aluno_pre = aluno_pre;
	}

	public String getEndmac_pre() {
		return endmac_pre;
	}

	public void setEndmac_pre(String endmac_pre) {
		this.endmac_pre = endmac_pre;
	}

	public int getId_pre() {
		return id_pre;
	}

	public void setId_pre(int id_pre) {
		this.id_pre = id_pre;
	}

	public String getNmesp_pre() {
		return nmesp_pre;
	}

	public void setNmesp_pre(String nmesp_pre) {
		this.nmesp_pre = nmesp_pre;
	}

	public String getSala_pre() {
		return sala_pre;
	}

	public void setSala_pre(String sala_pre) {
		this.sala_pre = sala_pre;
	}

}
