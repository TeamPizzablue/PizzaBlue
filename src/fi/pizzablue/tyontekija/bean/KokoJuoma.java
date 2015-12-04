package fi.pizzablue.tyontekija.bean;

import fi.pizzablue.bean.Juoma;

public class KokoJuoma {
	
	private int tilausId;
	private Juoma juoma;
	
	public KokoJuoma(int tilausId, Juoma juoma) {
		this.tilausId = tilausId;
		this.juoma = juoma;
	}
	
	public KokoJuoma() {
		
	}
	
	public int getTilausId() {
		return tilausId;
	}
	public void setTilausId(int tilausId) {
		this.tilausId = tilausId;
	}
	public Juoma getJuoma() {
		return juoma;
	}
	public void setJuoma(Juoma juoma) {
		this.juoma = juoma;
	}
	@Override
	public String toString() {
		return "KokoJuoma [tilausId=" + tilausId + ", juoma=" + juoma + "]";
	}
}
