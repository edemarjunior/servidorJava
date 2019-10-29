package br.com.wesp32.http;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Presenca {

	private Integer id_pre;
	private Date data_pre;
	private String aluno_pre;
	private String endmac_pre;
	private String nmesp_pre;
	private String sala_pre;
	
	public Presenca() {
	}

	public Presenca(Date data_pre, String aluno_pre, String endmac_pre, String nmesp_pre,
			String sala_pre) {
		super();
		this.data_pre = data_pre;
		this.aluno_pre = aluno_pre;
		this.endmac_pre = endmac_pre;
		this.nmesp_pre = nmesp_pre;
		this.sala_pre = sala_pre;
	}

	public Integer getId_pre() {
		return id_pre;
	}

	public void setId_pre(Integer id_pre) {
		this.id_pre = id_pre;
	}

	public Date getData_pre() {
		return data_pre;
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
