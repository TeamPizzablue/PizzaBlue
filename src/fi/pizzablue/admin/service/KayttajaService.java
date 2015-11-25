package fi.pizzablue.admin.service;

import java.sql.Connection;

import fi.pizzablue.admin.bean.Kayttaja;
import fi.pizzablue.admin.dao.KayttajaDAO;
import fi.pizzablue.dao.DAOPoikkeus;
import fi.pizzablue.dao.Yhteys;

public class KayttajaService {
	
	KayttajaDAO kDAO = new KayttajaDAO();
	
	public void lisaaKayttaja(Kayttaja k) throws DAOPoikkeus {
	
		Connection yhteys = Yhteys.avaaYhteys();
		kDAO.lisaa(k, yhteys);
		Yhteys.suljeYhteys(yhteys);	
	}
	public Kayttaja haeKayttaja(String kayttajatunnus) throws DAOPoikkeus {
		
		Connection yhteys = Yhteys.avaaYhteys();
		Kayttaja k = kDAO.hae(kayttajatunnus, yhteys);
		Yhteys.suljeYhteys(yhteys);
		
		return k;
	}

}
