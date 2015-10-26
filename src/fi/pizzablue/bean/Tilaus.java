package fi.pizzablue.bean;
import java.util.Date;

public class Tilaus {
	
	private int id;
	private double hinta;
	private Date aikaleima;
	private boolean toimitustapa;
	private String nimi;
	private String puhelinnumero;
	private String sahkoposti;
	private String toimitusosoite;
	private String lisatiedot;
	private Tila tila;
	
	public Tilaus(int id, double hinta, Date aikaleima, boolean toimitustapa, String nimi, String puhelinnumero, String sahkoposti, String toimitusosoite, String lisatiedot, Tila tila) {
		this.id = id;
		this.hinta = hinta;
		this.aikaleima = aikaleima;
		this.toimitustapa = toimitustapa;
		this.nimi = nimi;
		this.puhelinnumero = puhelinnumero;
		this.sahkoposti = sahkoposti;
		this.toimitusosoite = toimitusosoite;
		this.lisatiedot = lisatiedot;
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

	public boolean getToimitustapa() {
		return toimitustapa;
	}

	public void setToimitustapa(boolean toimitustapa) {
		this.toimitustapa = toimitustapa;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
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

	public String getToimitusosoite() {
		return toimitusosoite;
	}

	public void setToimitusosoite(String toimitusosoite) {
		this.toimitusosoite = toimitusosoite;
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
	
	
}
