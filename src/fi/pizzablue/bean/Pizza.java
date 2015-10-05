package fi.pizzablue.bean;

public class Pizza {
	
	private int id;
	private int numero;
	private String nimi;
	private double hinta;
	private int energia;
	private double proteiini;
	private double hiilihydraatti;
	private double rasva;
	
	public Pizza (int id, int numero, String nimi, double hinta) {
		this.id = id;
		this.numero = numero;
		this.nimi = nimi;
		this.hinta = hinta;
	}
	
	public Pizza (int id, int numero, String nimi, double hinta, int energia, double proteiini, double hiilihydraatti, double rasva) {
		this.id = id;
		this.numero = numero;
		this.nimi = nimi;
		this.hinta = hinta;
		this.energia = energia;
		this.proteiini = proteiini;
		this.hiilihydraatti = hiilihydraatti;
		this.rasva = rasva;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public double getHinta() {
		return hinta;
	}

	public void setHinta(double hinta) {
		this.hinta = hinta;
	}

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}

	public double getProteiini() {
		return proteiini;
	}

	public void setProteiini(double proteiini) {
		this.proteiini = proteiini;
	}

	public double getHiilihydraatti() {
		return hiilihydraatti;
	}

	public void setHiilihydraatti(double hiilihydraatti) {
		this.hiilihydraatti = hiilihydraatti;
	}

	public double getRasva() {
		return rasva;
	}

	public void setRasva(double rasva) {
		this.rasva = rasva;
	}

	@Override
	public String toString() {
		return "Pizza [id=" + id + ", numero=" + numero + ", nimi=" + nimi
				+ ", hinta=" + hinta + ", energia=" + energia + ", proteiini="
				+ proteiini + ", hiilihydraatti=" + hiilihydraatti + ", rasva="
				+ rasva + "]";
	}
	

}
