package fi.pizzablue.admin.bean;

public class InvalidKayttajaPoikkeus extends Exception{
	
	private static final long serialVersionUID = 1L;

	public InvalidKayttajaPoikkeus(String viesti) {
		super(viesti);
	}

}
