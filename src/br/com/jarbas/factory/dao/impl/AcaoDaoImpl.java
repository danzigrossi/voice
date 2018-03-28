/**
 * 
 */
package br.com.jarbas.factory.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import br.com.jarbas.factory.dao.AcaoDao;
import br.com.jarbas.factory.dao.BasicDao;
import br.com.jarbas.model.entity.Acao;

/**
 * @author 
 * 1 de jun de 2017
 */
@Repository
public class AcaoDaoImpl extends BasicDao<Acao> implements AcaoDao {

	/* (non-Javadoc)
	 * @see br.com.jarbas.factory.dao.AcaoDao#findByCod(java.lang.String)
	 */
	@Override
	public List<Acao> findByCod(String codAcao) {
		
		Query query = em
		        .createQuery("select t from Tarefa as t "+
		          "where t.finalizado = :paramFinalizado");
		    query.setParameter("paramFinalizado", true);
		return null;
	}
	
	/* (non-Javadoc)
	 * @see br.com.jarbas.factory.dao.AcaoDao#persist(br.com.jarbas.model.entity.Acao)
	 */
	@Override
	public void persist(Acao obj) {
		super.pesist(obj);
		System.out.println("Passou no DAO");
	}
	
	/* (non-Javadoc)
	 * @see br.com.jarbas.factory.dao.BasicDao#merge(java.lang.Object)
	 */
	@Override
	public Acao merge(Acao obj) {
		return super.merge(obj);
	}

	/* (non-Javadoc)
	 * @see br.com.jarbas.factory.dao.AcaoDao#findListAcaoByPai()
	 */
	@Override
	public List<Acao> findListAcaoByPai(Long idPai) {
		Query query = em
		        .createQuery("select a from Acao a "+
		          "where a.acaoPai.idAcao = :idPai");
		    query.setParameter("idPai", idPai);
		return null;
	}
	

}
