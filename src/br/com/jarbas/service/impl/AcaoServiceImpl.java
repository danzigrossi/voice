/**
 * 
 */
package br.com.jarbas.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jarbas.factory.dao.AcaoDao;
import br.com.jarbas.model.entity.Acao;
import br.com.jarbas.service.AcaoService;

/**
 * @author "<a href=\'mailto:dzigrossi@ciandt.com\'>Danilo Rafael F. de C. Zigrossi(CIT)</a>"
 * 2 de jun de 2017
 */
@Service
@Transactional
public class AcaoServiceImpl implements AcaoService{

	@Autowired
	private AcaoDao acaoDao;
	
	@Override
	public void test(Acao acao) {
		acaoDao.persist(acao);
		System.out.println("Passou no serviço");
		
	}

}
