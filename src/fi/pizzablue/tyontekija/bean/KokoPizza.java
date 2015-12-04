package fi.pizzablue.tyontekija.bean;

import fi.pizzablue.bean.Pizza;

public class KokoPizza {
	
	private int tilausId;
	private boolean oregano;
	private boolean valkosipuli;
	private String pohja;
	private Pizza pizza;
	
	public KokoPizza(int tilausId, boolean oregano, boolean valkosipuli, String pohja, Pizza pizza) {
		this.tilausId = tilausId;
		this.oregano = oregano;
		this.valkosipuli = valkosipuli;
		this.pohja = pohja;
		this.pizza = pizza;
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

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public String toString() {
		return "KokoPizza [oregano=" + oregano + ", valkosipuli=" + valkosipuli
				+ ", pohja=" + pohja + ", pizza=" + pizza + "]";
	}
	
	

}
