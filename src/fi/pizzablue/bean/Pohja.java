package fi.pizzablue.bean;

public class Pohja { 
	
	private int id;
	private String nimi;
	
	public Pohja(int id, String nimi) {
		this.id = id;
		this.nimi = nimi;
	}

	public Pohja(String nimi) {
		this.nimi = nimi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	@Override
	public String toString() {
		return "Pohja [id=" + id + ", nimi=" + nimi + "]";
	}

}
