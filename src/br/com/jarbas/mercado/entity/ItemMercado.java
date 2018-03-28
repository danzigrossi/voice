/**
 * 
 */
package br.com.jarbas.mercado.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/**
 * @author "<a href=\'mailto:dzigrossi@ciandt.com\'>Danilo Rafael F. de C. Zigrossi(CIT)</a>"
 * 3 de jun de 2017
 */
public class ItemMercado {
	@Id
	@GeneratedValue(generator = "ItemMercadoSeq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "ItemMercadoSeq", sequenceName = "SEQ_ITEMMERCADO", allocationSize = 1)
	private Long idItemMercado;
	
	@OneToOne
	private Item item;
	
	@ManyToOne
	private Mercado mercado;
	
	private Boolean comprado;
	
	private Boolean listado;
	
	private Date incluido;

	public Long getIdItemMercado() {
		return idItemMercado;
	}

	public void setIdItemMercado(Long idItemMercado) {
		this.idItemMercado = idItemMercado;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Boolean getComprado() {
		return comprado;
	}

	public void setComprado(Boolean comprado) {
		this.comprado = comprado;
	}

	public Boolean getListado() {
		return listado;
	}

	public void setListado(Boolean listado) {
		this.listado = listado;
	}

	public Date getIncluido() {
		return incluido;
	}

	public void setIncluido(Date incluido) {
		this.incluido = incluido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idItemMercado == null) ? 0 : idItemMercado.hashCode());
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
		ItemMercado other = (ItemMercado) obj;
		if (idItemMercado == null) {
			if (other.idItemMercado != null)
				return false;
		} else if (!idItemMercado.equals(other.idItemMercado))
			return false;
		return true;
	}

}
