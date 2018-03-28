package br.com.jarbas.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Agenda {

	@Id
	@GeneratedValue(generator = "AgendaSeq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "AgendaSeq", sequenceName = "SEQ_AGENDA", allocationSize = 1)
	private Long idAgenda;
	
//	private List<Evento> eventos;
	
	//private Pessoa dono;
	
	public Long getIdAgenda() {
		return idAgenda;
	}
	public void setIdAgenda(Long idAgenda) {
		this.idAgenda = idAgenda;
	}
	
//	public List<Evento> getEventos() {
//		return eventos;
//	}
//	public void setEventos(List<Evento> eventos) {
//		this.eventos = eventos;
//	}
//	public Pessoa getDono() {
//		return dono;
//	}
//	public void setDono(Pessoa dono) {
//		this.dono = dono;
//	}
//	
	
}
