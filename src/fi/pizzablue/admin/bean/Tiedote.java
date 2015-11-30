package fi.pizzablue.admin.bean;

public class Tiedote {
	private int id;
	private String otsikko;
	private String sisalto;
	
	public Tiedote(int id, String otsikko, String sisalto) {
		this.id = id;
		this.otsikko = otsikko;
		this.sisalto = sisalto;
	}
	public Tiedote (String otsikko, String sisalto) {
		this.otsikko = otsikko;
		this.sisalto = sisalto;
	}
	public Tiedote (int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOtsikko() {
		return otsikko;
	}
	public void setOtsikko(String otsikko) {
		this.otsikko = otsikko;
	}
	public String getSisalto() {
		return sisalto;
	}

	public void setSisalto(String sisalto) {
		this.sisalto = sisalto;
	}
	@Override
	public String toString() {
		return "Tiedote [id=" + id + ", otsikko=" + otsikko + ", sisalto="
				+ sisalto + "]";
	}

	
	

}
