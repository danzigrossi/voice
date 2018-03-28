/**
 * 
 */
package br.com.jarbas.app;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Main;

/** 
 * @author "<a href=\'mailto:dzigrossi@ciandt.com\'>Danilo Rafael F. de C. Zigrossi(CIT)</a>"
 * 2 de jun de 2017
 */
@Configuration
public class App {
	private static ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
			"/META-INF/spring-autoscan.xml");
	
	public static void main(String[] args) {
		App atd = new App(); 
		ctx.getAutowireCapableBeanFactory().autowireBeanProperties(atd, AutowireCapableBeanFactory.AUTOWIRE_BY_NAME,
			true);
		Main a = (Main)ctx.getBean("main");
	}
}
