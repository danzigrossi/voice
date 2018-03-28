/**
 * 
 */
package br.com.jarbas.factory.dao;

import java.util.List;

import br.com.jarbas.model.entity.Acao;

/**
 * @author <a
 * 1 de jun de 2017
 */
public interface AcaoDao {
	List<Acao> findByCod(String codAcao);
	
	/**
	 * 
	 * @param acao
	 */
	void persist(Acao acao);
	/**
	 * 
	 * @param acao
	 * @return
	 */
	Acao merge(Acao acao);
	
	/**
	 * 
	 * @return
	 */
	List<Acao> findListAcaoByPai (Long idPai);
}
