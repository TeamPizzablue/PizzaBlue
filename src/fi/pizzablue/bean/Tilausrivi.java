package fi.pizzablue.bean;

public abstract class Tilausrivi {
	protected int id;
	protected int maara;
	protected double hinta;
	
	public Tilausrivi() {
	}
	
	public Tilausrivi(int id, int maara, double hinta) {
		this.id = id;
		this.maara = maara;
		this.hinta = hinta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getHinta() {
		return hinta;
	}

	public void setHinta(double hinta) {
		this.hinta = hinta;
	}

	public int getMaara() {
		return maara;
	}

	public void setMaara(int maara) {
		this.maara = maara;
	}

	@Override
	public String toString() {
		return "Tilausrivi [id=" + id + ", maara=" + maara + ", hinta=" + hinta
				+ "]";
	}
	
}
