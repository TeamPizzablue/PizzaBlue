package fi.pizzablue.tyontekija.service;

import java.sql.Connection;
import java.util.List;

import fi.pizzablue.dao.DAOPoikkeus;
import fi.pizzablue.dao.Yhteys;
import fi.pizzablue.tyontekija.bean.KokoJuoma;
import fi.pizzablue.tyontekija.bean.KokoPizza;
import fi.pizzablue.tyontekija.bean.KokoTilaus;
import fi.pizzablue.tyontekija.dao.HaeTilausDAO;

public class KokoTilausService {
	
	KokoTilaus kokotilaus = new KokoTilaus();

	HaeTilausDAO hDAO = new HaeTilausDAO();

	public List<KokoTilaus> haeTilaukset() throws DAOPoikkeus {

		Connection yhteys = Yhteys.avaaYhteys();	
		List<KokoTilaus> tilaus = hDAO.haeTilaukset(yhteys);
		
		for (KokoTilaus kokotilaus : tilaus) {
			int id = kokotilaus.getId();
			List<KokoPizza> kpLista = hDAO.haeKokotilauksenPizzat(id, yhteys);
			kokotilaus.setPizzat(kpLista);
			List<KokoJuoma> kjLista = hDAO.haeKokotilauksenJuomat(id, yhteys);
			kokotilaus.setJuomat(kjLista);	
		}
		
		Yhteys.suljeYhteys(yhteys);
		
		return tilaus;
		
	}
}

