package fi.pizzablue.bean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tilaus {
	
	private int id;
	private double hinta;
	private Date aikaleima;
	private boolean kotiinkuljetus;
	private String etunimi;
	private String sukunimi;
	private String puhelinnumero;
	private String sahkoposti;
	private String katuosoite;
	private String lisatiedot;
	private Posti posti;
	private Tila tila;
	private List<Tilausrivi> tilausrivit;

	public Tilaus() {
		this.tilausrivit = new ArrayList<Tilausrivi>();
	}
	
	public Tilaus(int id, double hinta, Date aikaleima, boolean kotiinkuljetus, String etunimi, String sukunimi, String puhelinnumero, String sahkoposti, String katuosoite, String lisatiedot, Posti posti, Tila tila) {
		this.id = id;
		this.hinta = hinta;
		this.aikaleima = aikaleima;
		this.kotiinkuljetus = kotiinkuljetus;
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.puhelinnumero = puhelinnumero;
		this.sahkoposti = sahkoposti;
		this.katuosoite = katuosoite;
		this.lisatiedot = lisatiedot;
		this.posti = posti;
		this.tila = tila;
		this.tilausrivit = new ArrayList<Tilausrivi>();
	}

	public List<Tilausrivi> getTilausrivit() {
		return tilausrivit;
	}

	public void setTilausrivit(List<Tilausrivi> tilausrivit) {
		this.tilausrivit = tilausrivit;
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

	public Date getAikaleima() {
		return aikaleima;
	}

	public void setAikaleima(Date aikaleima) {
		this.aikaleima = aikaleima;
	}

	public boolean getKotiinkuljetus() {
		return kotiinkuljetus;
	}

	public void setKotiinkuljetus(boolean kotiinkuljetus) {
		this.kotiinkuljetus = kotiinkuljetus;
	}

	public String getEtunimi() {
		return etunimi;
	}

	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}
	
	public String getSukunimi() {
		return sukunimi;
	}
	
	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}

	public String getPuhelinnumero() {
		return puhelinnumero;
	}

	public void setPuhelinnumero(String puhelinnumero) {
		this.puhelinnumero = puhelinnumero;
	}

	public String getSahkoposti() {
		return sahkoposti;
	}

	public void setSahkoposti(String sahkoposti) {
		this.sahkoposti = sahkoposti;
	}

	public String getKatuosoite() {
		return katuosoite;
	}

	public void setKatuosoite(String katuosoite) {
		this.katuosoite = katuosoite;
	}

	public String getLisatiedot() {
		return lisatiedot;
	}

	public void setLisatiedot(String lisatiedot) {
		this.lisatiedot = lisatiedot;
	}

	public Tila getTila() {
		return tila;
	}

	public void setTila(Tila tila) {
		this.tila = tila;
	}

	public Posti getPosti() {
		return posti;
	}

	public void setPosti(Posti posti) {
		this.posti = posti;
	}
	
	@Override
	public String toString() {
		return "Tilaus [id=" + id + ", hinta=" + hinta + ", aikaleima="
				+ aikaleima + ", kotiinkuljetus=" + kotiinkuljetus
				+ ", etunimi=" + etunimi + ", sukunimi=" + sukunimi
				+ ", puhelinnumero=" + puhelinnumero + ", sahkoposti="
				+ sahkoposti + ", katuosoite=" + katuosoite + ", lisatiedot="
				+ lisatiedot + ", posti=" + posti + ", tila=" + tila
				+ ", tilausrivit=" + tilausrivit + "]";
	}
	
}
