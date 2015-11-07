package fi.pizzablue.bean;

public class Posti {
	
	private String postinro;
	private String postitmp;
	
	public Posti(String postinro, String postitmp) {
		this.postinro = postinro;
		this.postitmp = postitmp;
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
		return "Posti [postinro=" + postinro + ", postitmp=" + postitmp + "]";
	}

}
