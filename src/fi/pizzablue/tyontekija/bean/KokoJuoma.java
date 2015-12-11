package fi.pizzablue.tyontekija.bean;

public class KokoJuoma {
	
	private int tilausId;
	private int numero;
	private String nimi;
	
	public KokoJuoma(int tilausId, int numero, String nimi) {
		this.tilausId = tilausId;
		this.numero = numero;
		this.nimi = nimi;
	}
	
	public KokoJuoma() {
		
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

	public int getTilausId() {
		return tilausId;
	}
	public void setTilausId(int tilausId) {
		this.tilausId = tilausId;
	}

	@Override
	public String toString() {
		return "KokoJuoma [tilausId=" + tilausId + ", numero=" + numero
				+ ", nimi=" + nimi + "]";
	}

}
