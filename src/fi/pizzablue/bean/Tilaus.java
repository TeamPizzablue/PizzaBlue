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
	private String postinro;
	private String postitmp;
	private String lisatiedot;
	private Tila tila;
	private List<Tilausrivi> tilausrivit;

	public Tilaus() {
		this.tilausrivit = new ArrayList<Tilausrivi>();
	}
	
	public Tilaus(int id, double hinta, Date aikaleima, boolean kotiinkuljetus, String etunimi, String sukunimi, String puhelinnumero, String sahkoposti, String katuosoite, String postinro, String postitmp, String lisatiedot, Tila tila) {
		this.id = id;
		this.hinta = hinta;
		this.aikaleima = aikaleima;
		this.kotiinkuljetus = kotiinkuljetus;
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.puhelinnumero = puhelinnumero;
		this.sahkoposti = sahkoposti;
		this.katuosoite = katuosoite;
		this.postinro = postinro;
		this.postitmp = postitmp;
		this.lisatiedot = lisatiedot;
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

	public String getPostinro() {
		return postinro;
	}

	public void setPostinro(String postinro) {
		this.postinro = postinro;
	}

	public String getPostitmp() {
		return postitmp;
	}

	public void setPostitmp(String postitmp) {
		this.postitmp = postitmp;
	}

	@Override
	public String toString() {
		return "Tilaus [id=" + id + ", hinta=" + hinta + ", aikaleima="
				+ aikaleima + ", kotiinkuljetus=" + kotiinkuljetus
				+ ", etunimi=" + etunimi + ", sukunimi=" + sukunimi
				+ ", puhelinnumero=" + puhelinnumero + ", sahkoposti="
				+ sahkoposti + ", katuosoite=" + katuosoite + ", postinro="
				+ postinro + ", postitmp=" + postitmp + ", lisatiedot="
				+ lisatiedot + ", tila=" + tila + ", tilausrivit="
				+ tilausrivit + "]";
	}
	
	
}
