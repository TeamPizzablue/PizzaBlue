package fi.pizzablue.bean;

public class Juomarivi extends Tilausrivi {
	
	private Juoma juoma;
	
	public Juomarivi(Juoma juoma) {
		this.juoma = juoma;
	}

	public Juomarivi(int id, int maara, double hinta, Juoma juoma) {
		super(id, maara, hinta);
		this.juoma = juoma;
	}

	public Juoma getJuoma() {
		return juoma;
	}

	public void setJuoma(Juoma juoma) {
		this.juoma = juoma;
	}

	@Override
	public String toString() {
		return "Juomarivi [juoma=" + juoma + ", id=" + id + ", maara=" + maara
				+ ", hinta=" + hinta + "]";
	}

}
