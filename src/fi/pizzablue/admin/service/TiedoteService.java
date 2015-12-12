package fi.pizzablue.admin.service;

import java.sql.Connection;
import java.util.List;

import fi.pizzablue.admin.bean.Tiedote;
import fi.pizzablue.admin.dao.TiedoteDAO;
import fi.pizzablue.dao.DAOPoikkeus;
import fi.pizzablue.dao.Yhteys;

public class TiedoteService {
	
	TiedoteDAO tDAO = new TiedoteDAO();
	
	public void lisaaTiedote(Tiedote t) throws DAOPoikkeus {
	
		Connection yhteys = Yhteys.avaaYhteys();
		tDAO.lisaa(t, yhteys);
		Yhteys.suljeYhteys(yhteys);	
	}
	public void poistaTiedote(Tiedote t) throws DAOPoikkeus {
		
		Connection yhteys = Yhteys.avaaYhteys();
		tDAO.poista(t, yhteys);
		Yhteys.suljeYhteys(yhteys);	
	}
	public List<Tiedote> haeTiedotteet() throws DAOPoikkeus {
	
		Connection yhteys = Yhteys.avaaYhteys();
		List<Tiedote> tiedotteet = tDAO.haeTiedotteet(yhteys);
		Yhteys.suljeYhteys(yhteys);	
		return tiedotteet;
	}
}
