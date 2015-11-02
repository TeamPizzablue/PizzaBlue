package fi.pizzablue.bean;

public class Pizzarivi extends Tilausrivi {
	private boolean oregano;
	private boolean valkosipuli;
	private Pohja pohja;
	private Pizza pizza;
	
	
	public Pizzarivi(Pizza pizza) {
		this.pizza = pizza;
	}
	
	public Pizzarivi(int id, int maara, double hinta, boolean oregano, boolean valkosipuli, Pohja pohja, Pizza pizza) {
		super(id, maara, hinta);
		this.oregano = oregano;
		this.valkosipuli = valkosipuli;
		this.pohja = pohja;
		this.pizza = pizza;
		
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

	public Pohja getPohja() {
		return pohja;
	}

	public void setPohja(Pohja pohja) {
		this.pohja = pohja;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

}
