package fi.pizzablue.service;

import java.sql.Connection;

import fi.pizzablue.dao.DAOPoikkeus;
import fi.pizzablue.dao.TilausIdDAO;
import fi.pizzablue.dao.Yhteys;

public class TilausIdService {
	
	TilausIdDAO tidDAO = new TilausIdDAO();
		
		
	public int haeTilausId() throws DAOPoikkeus {

			Connection yhteys = Yhteys.avaaYhteys();
			int id = tidDAO.haeId(yhteys);
			Yhteys.suljeYhteys(yhteys);
			return id;	
		}	
}