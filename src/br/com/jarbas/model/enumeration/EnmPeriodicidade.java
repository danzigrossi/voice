package br.com.jarbas.model.enumeration;

/**
 * 
 * @author "<a href=\'mailto:dzigrossi@ciandt.com\'>Danilo Rafael F. de C. Zigrossi(CIT)</a>"
 * 31 de mai de 2017
 */
public enum EnmPeriodicidade {

	DIARIO("D","periodo.dia"),
	SEMANAL("S","periodo.semmana"),
	MENSAL("M","periodo.mensal"),
	UNICO("S","periodo.inico"),
	ANUAL("A","periodo.anual");
	
	private String value;
	private String label;
	
	/**
	 * 
	 * @param value
	 * @param label
	 */
	private EnmPeriodicidade(String value, String label) {
		this.value = value;
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String getLabel() {
		return label;
	}
	
	/**
	 * 
	 * @param label
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
