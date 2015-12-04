package fi.pizzablue.tyontekija.service;

import java.sql.Connection;
import java.util.List;

import fi.pizzablue.dao.DAOPoikkeus;
import fi.pizzablue.dao.Yhteys;
import fi.pizzablue.tyontekija.bean.KokoTilaus;
import fi.pizzablue.tyontekija.dao.HaeTilausDAO;

public class KokoTilausService {
	
	KokoTilaus kokotilaus = new KokoTilaus();

	HaeTilausDAO hDAO = new HaeTilausDAO();

	public List<KokoTilaus> haeTilaukset() throws DAOPoikkeus {

		Connection yhteys = Yhteys.avaaYhteys();	
		List<KokoTilaus> tilaus = hDAO.haeTilaukset(yhteys);
		Yhteys.suljeYhteys(yhteys);
		
		return tilaus;
		
	}
//kesken
	public void haeTilauksenPizzat() throws DAOPoikkeus {

		Connection yhteys = Yhteys.avaaYhteys();
		hDAO.haeKokotilauksenPizzat(kokotilaus, yhteys);
		Yhteys.suljeYhteys(yhteys);	
	}
//kesken
	public void haeTilauksenJuomat() throws DAOPoikkeus {

		Connection yhteys = Yhteys.avaaYhteys();
		hDAO.haeKokotilauksenJuomat(kokotilaus, yhteys);
		Yhteys.suljeYhteys(yhteys);
	}

}

