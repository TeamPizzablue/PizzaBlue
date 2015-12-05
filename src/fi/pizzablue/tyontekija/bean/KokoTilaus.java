package fi.pizzablue.tyontekija.bean;

import java.util.Date;
import java.util.List;

public class KokoTilaus {
	
	private int id;
	private double hinta;
	private Date aikaleima;
	private boolean kotiinkuljetus;
	private String etunimi;
	private String sukunimi;
	private String puhelinnumero;
	private String sahkoposti;
	private String katuosoite;
	private String postinumero;
	private String postitoimipaikka;
	private String lisatiedot;
	private List<KokoPizza> pizzat;
	private int pizzojenMaara;
	private List<KokoJuoma> juomat;
	private int juomienMaara;
	private int tila;
	
	public KokoTilaus() {
		
	}
	
	public KokoTilaus(int id, double hinta, Date aikaleima,
			boolean kotiinkuljetus, String etunimi, String sukunimi,
			String puhelinnumero, String sahkoposti, String katuosoite,
			String postinumero, String postitoimipaikka, String lisatiedot,
			List<KokoPizza> pizzat, int pizzojenMaara, List<KokoJuoma> juomat, int juomienMaara, int tila) {
		this.id = id;
		this.hinta = hinta;
		this.aikaleima = aikaleima;
		this.kotiinkuljetus = kotiinkuljetus;
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.puhelinnumero = puhelinnumero;
		this.sahkoposti = sahkoposti;
		this.katuosoite = katuosoite;
		this.postinumero = postinumero;
		this.postitoimipaikka = postitoimipaikka;
		this.lisatiedot = lisatiedot;
		this.pizzat = pizzat;
		this.pizzojenMaara = pizzojenMaara;
		this.juomat = juomat;
		this.juomienMaara = juomienMaara;
		this.tila = tila;
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

	public boolean isKotiinkuljetus() {
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

	public String getPostinumero() {
		return postinumero;
	}

	public void setPostinumero(String postinumero) {
		this.postinumero = postinumero;
	}

	public String getPostitoimipaikka() {
		return postitoimipaikka;
	}

	public void setPostitoimipaikka(String postitoimipaikka) {
		this.postitoimipaikka = postitoimipaikka;
	}

	public String getLisatiedot() {
		return lisatiedot;
	}

	public void setLisatiedot(String lisatiedot) {
		this.lisatiedot = lisatiedot;
	}

	public List<KokoPizza> getPizzat() {
		return pizzat;
	}

	public void setPizzat(List<KokoPizza> pizzat) {
		this.pizzat = pizzat;
	}

	public List<KokoJuoma> getJuomat() {
		return juomat;
	}

	public void setJuomat(List<KokoJuoma> juomat) {
		this.juomat = juomat;
	}

	public int getTila() {
		return tila;
	}

	public void setTila(int tila) {
		this.tila = tila;
	}

	public int getPizzojenMaara() {
		return pizzojenMaara;
	}

	public void setPizzojenMaara(int pizzojenMaara) {
		this.pizzojenMaara = pizzojenMaara;
	}

	public int getJuomienMaara() {
		return juomienMaara;
	}

	public void setJuomienMaara(int juomienMaara) {
		this.juomienMaara = juomienMaara;
	}

	@Override
	public String toString() {
		return "KokoTilaus [id=" + id + ", hinta=" + hinta + ", aikaleima="
				+ aikaleima + ", kotiinkuljetus=" + kotiinkuljetus
				+ ", etunimi=" + etunimi + ", sukunimi=" + sukunimi
				+ ", puhelinnumero=" + puhelinnumero + ", sahkoposti="
				+ sahkoposti + ", katuosoite=" + katuosoite + ", postinumero="
				+ postinumero + ", postitoimipaikka=" + postitoimipaikka
				+ ", lisatiedot=" + lisatiedot + ", pizzat=" + pizzat
				+ ", pizzojenMaara=" + pizzojenMaara + ", juomat=" + juomat
				+ ", juomienMaara=" + juomienMaara + ", tila=" + tila + "]";
	}

}
