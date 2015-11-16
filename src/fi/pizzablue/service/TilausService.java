package fi.pizzablue.service;

import java.sql.Connection;

import fi.pizzablue.bean.Tilaus;
import fi.pizzablue.dao.DAOPoikkeus;
import fi.pizzablue.dao.TilausDAO;
import fi.pizzablue.dao.Yhteys;

public class TilausService {
	
	TilausDAO tDAO = new TilausDAO();
	
	
	public void lisaaTilaus(Tilaus tilaus) throws DAOPoikkeus {

			Connection yhteys = Yhteys.avaaYhteys();
			
			tDAO.lisaaTilaus(tilaus, yhteys);
			
			Yhteys.suljeYhteys(yhteys);	
			
		}

}
