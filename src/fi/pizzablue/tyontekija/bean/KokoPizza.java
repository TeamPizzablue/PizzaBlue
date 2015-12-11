package fi.pizzablue.tyontekija.bean;


public class KokoPizza {
	
	private int tilausId;
	private int numero;
	private String nimi;
	private boolean oregano;
	private boolean valkosipuli;
	private String pohja;
	
	public KokoPizza(int tilausId, int numero, String nimi, boolean oregano, boolean valkosipuli, String pohja) {
		this.tilausId = tilausId;
		this.numero = numero;
		this.nimi = nimi;
		this.oregano = oregano;
		this.valkosipuli = valkosipuli;
		this.pohja = pohja;	
	}
	

	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getNimi() {
		return nimi;
	}


	public void setNimi(String nimi) {
		this.nimi = nimi;
	}


	public KokoPizza() {
		
	}
	
	public int getTilausId() {
		return tilausId;
	}
	
	public void setTilausId(int tilausId) {
		this.tilausId = tilausId;
	}

	public boolean isOregano() {
		return oregano;
	}

	public void setOregano(boolean oregano) {
		this.oregano = oregano;
	}

	public boolean isValkosipuli() {
		return valkosipuli;
	}

	public void setValkosipuli(boolean valkosipuli) {
		this.valkosipuli = valkosipuli;
	}

	public String getPohja() {
		return pohja;
	}

	public void setPohja(String pohja) {
		this.pohja = pohja;
	}


	@Override
	public String toString() {
		return "KokoPizza [tilausId=" + tilausId + ", numero=" + numero
				+ ", nimi=" + nimi + ", oregano=" + oregano + ", valkosipuli="
				+ valkosipuli + ", pohja=" + pohja + "]";
	}

}
