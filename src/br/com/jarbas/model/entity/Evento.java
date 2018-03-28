package br.com.jarbas.model.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.jarbas.model.enumeration.EnmPeriodicidade;

@Entity
public class Evento {

	@Id
	@GeneratedValue(generator = "EventoSeq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "EventoSeq", sequenceName = "SEQ_EVENTO", allocationSize = 1)
	public Long idEvento;
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date dtaInicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date dtaFim;
	
	public String nome;
	
	public String descricao;
	
	public EnmPeriodicidade periodo;

	public Long getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}

	public Date getDtaInicio() {
		return dtaInicio;
	}

	public void setDtaInicio(Date dtaInicio) {
		this.dtaInicio = dtaInicio;
	}

	public Date getDtaFim() {
		return dtaFim;
	}

	public void setDtaFim(Date dtaFim) {
		this.dtaFim = dtaFim;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public EnmPeriodicidade getPeriodo() {
		return periodo;
	}

	public void setPeriodo(EnmPeriodicidade periodo) {
		this.periodo = periodo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEvento == null) ? 0 : idEvento.hashCode());
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
		Evento other = (Evento) obj;
		if (idEvento == null) {
			if (other.idEvento != null)
				return false;
		} else if (!idEvento.equals(other.idEvento))
			return false;
		return true;
	}

}
