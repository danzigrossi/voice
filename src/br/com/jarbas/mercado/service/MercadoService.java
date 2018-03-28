/**
 * 
 */
package br.com.jarbas.mercado.service;

import org.springframework.stereotype.Service;

import br.com.jarbas.mercado.entity.Item;

/**
 * @author "<a href=\'mailto:dzigrossi@ciandt.com\'>Danilo Rafael F. de C. Zigrossi(CIT)</a>"
 * 3 de jun de 2017
 */
@Service
public interface MercadoService {
	
	int makeDecision(String word);
	
	void addItemList(Item item, Double amount);
	
	void removeItemList(Item item);
	
	void removeAmountItemList(Item item);
	

}
