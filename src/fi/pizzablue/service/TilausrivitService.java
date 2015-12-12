package fi.pizzablue.service;

import java.sql.Connection;

import fi.pizzablue.bean.Tilaus;
import fi.pizzablue.dao.DAOPoikkeus;
import fi.pizzablue.dao.TilausrivitDAO;
import fi.pizzablue.dao.Yhteys;

public class TilausrivitService {
	
TilausrivitDAO trDAO = new TilausrivitDAO();
	
	
	public void lisaaTilausrivit(Tilaus tilaus) throws DAOPoikkeus {

			Connection yhteys = Yhteys.avaaYhteys();
			trDAO.lisaaTilausrivit(tilaus, yhteys);
			Yhteys.suljeYhteys(yhteys);		
		}
}
