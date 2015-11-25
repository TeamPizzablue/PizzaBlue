package fi.pizzablue.admin.service;

import java.sql.Connection;

import fi.pizzablue.admin.dao.JuomaNumeroDAO;
import fi.pizzablue.bean.Juoma;
import fi.pizzablue.bean.Pizza;
import fi.pizzablue.dao.DAOPoikkeus;
import fi.pizzablue.dao.JuomaDAO;
import fi.pizzablue.dao.PizzaDAO;
import fi.pizzablue.dao.Yhteys;

public class JuomaAdminService {
	
	JuomaDAO jDAO = new JuomaDAO();
	JuomaNumeroDAO jnroDAO = new JuomaNumeroDAO();
	
	public void lisaaJuoma(Juoma j) throws DAOPoikkeus {
	
		Connection yhteys = Yhteys.avaaYhteys();
		jDAO.lisaa(j, yhteys);
		Yhteys.suljeYhteys(yhteys);	
	}
	public void poistaJuoma(Juoma j) throws DAOPoikkeus {
		
		Connection yhteys = Yhteys.avaaYhteys();
		jDAO.poista(j, yhteys);
		Yhteys.suljeYhteys(yhteys);	
	}
	public int haeJuomaNumero() throws DAOPoikkeus {
		
		Connection yhteys = Yhteys.avaaYhteys();
		int numero = jnroDAO.haeNumero(yhteys);
		Yhteys.suljeYhteys(yhteys);
		return numero;
	}
	

}
