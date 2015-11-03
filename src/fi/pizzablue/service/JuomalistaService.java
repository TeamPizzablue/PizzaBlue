package fi.pizzablue.service;

import java.sql.Connection;
import java.util.List;

import fi.pizzablue.bean.Juoma;
import fi.pizzablue.bean.Pizza;
import fi.pizzablue.dao.DAOPoikkeus;
import fi.pizzablue.dao.JuomaDAO;
import fi.pizzablue.dao.Yhteys;

public class JuomalistaService {

	JuomaDAO jDAO = new JuomaDAO();
	
	public List<Juoma> haeJuomalista() throws DAOPoikkeus {

		Connection yhteys = Yhteys.avaaYhteys();
		
		List<Juoma> juomat = jDAO.haeJuomat(yhteys);
		
		Yhteys.suljeYhteys(yhteys);
		return juomat;
		
	}
	
	public Juoma haeJuoma(int id) throws DAOPoikkeus {

		Connection yhteys = Yhteys.avaaYhteys();
		
		Juoma j = jDAO.haeYksiJuoma(id, yhteys);
		
		Yhteys.suljeYhteys(yhteys);
		return j;
		
	}

}