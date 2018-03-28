/**
 * 
 */
package br.com.jarbas.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 * @author <a
 * 1 de jun de 2017
 */
@Entity
public class Acao {
	
	@Id
	@GeneratedValue(generator = "AcaoSeq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "AcaoSeq", sequenceName = "SEQ_ACAO", allocationSize = 1)
	private Long idAcao;
	
	private String codAcao;
	
	@ManyToOne
	private Acao acaoPai;
	
	private String nomeAcao;

	public Long getIdAcao() {
		return idAcao;
	}

	public void setIdAcao(Long idAcao) {
		this.idAcao = idAcao;
	}

	public String getCodAcao() {
		return codAcao;
	}

	public void setCodAcao(String codAcao) {
		this.codAcao = codAcao;
	}

	public Acao getAcaoPai() {
		return acaoPai;
	}

	public void setAcaoPai(Acao acaoPai) {
		this.acaoPai = acaoPai;
	}

	public String getNomeAcao() {
		return nomeAcao;
	}

	public void setNomeAcao(String nomeAcao) {
		this.nomeAcao = nomeAcao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAcao == null) ? 0 : idAcao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Acao other = (Acao) obj;
		if (idAcao == null) {
			if (other.idAcao != null)
				return false;
		} else if (!idAcao.equals(other.idAcao))
			return false;
		return true;
	}
}
