/**
 * 
 */
package br.com.jarbas.mercado.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * @author "<a href=\'mailto:dzigrossi@ciandt.com\'>Danilo Rafael F. de C. Zigrossi(CIT)</a>"
 * 3 de jun de 2017
 */
@Entity
public class Mercado {
	
	@Id
	@GeneratedValue(generator = "MercadoSeq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "MercadoSeq", sequenceName = "SEQ_MERCADO", allocationSize = 1)
	private Long idMercado;
	
	private String nomeLista;
	
	private Date dataCriacao;
	
	private Date dataCompra;
	
	private Date valorCompra;

	public Long getIdMercado() {
		return idMercado;
	}

	public void setIdMercado(Long idMercado) {
		this.idMercado = idMercado;
	}

	public String getNomeLista() {
		return nomeLista;
	}

	public void setNomeLista(String nomeLista) {
		this.nomeLista = nomeLista;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public Date getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(Date valorCompra) {
		this.valorCompra = valorCompra;
	}
	
}
