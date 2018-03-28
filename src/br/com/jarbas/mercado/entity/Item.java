/**
 * 
 */
package br.com.jarbas.mercado.entity;

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
public class Item {
	@Id
	@GeneratedValue(generator = "ItemSeq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "ItemSeq", sequenceName = "SEQ_ITEM", allocationSize = 1)
	private Long idItem; 
	
	private String nome;
	
	private String tipo;

	public Long getIdItem() {
		return idItem;
	}

	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idItem == null) ? 0 : idItem.hashCode());
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
		Item other = (Item) obj;
		if (idItem == null) {
			if (other.idItem != null)
				return false;
		} else if (!idItem.equals(other.idItem))
			return false;
		return true;
	}

}
