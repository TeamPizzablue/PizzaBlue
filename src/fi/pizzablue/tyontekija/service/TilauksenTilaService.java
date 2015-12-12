package fi.pizzablue.tyontekija.service;

import java.sql.Connection;

import fi.pizzablue.dao.DAOPoikkeus;
import fi.pizzablue.dao.Yhteys;
import fi.pizzablue.tyontekija.dao.VaihdaTilauksenTilaDAO;

public class TilauksenTilaService {
	
	public void muutaTilaValmistetuksi(int tilausId) throws DAOPoikkeus {
		
		VaihdaTilauksenTilaDAO vDAO = new VaihdaTilauksenTilaDAO();

		Connection yhteys = Yhteys.avaaYhteys();	
		vDAO.paivitaTilauksenTilaValmistetuksi(tilausId, yhteys);
		Yhteys.suljeYhteys(yhteys);
	
	}
	public void muutaTilauksenTilaMaksetuksi(int tilausId) throws DAOPoikkeus {
		
		VaihdaTilauksenTilaDAO vDAO = new VaihdaTilauksenTilaDAO();

		Connection yhteys = Yhteys.avaaYhteys();	
		vDAO.paivitaTilauksenTilaMaksetuksi(tilausId, yhteys);
		Yhteys.suljeYhteys(yhteys);
	
	}
}