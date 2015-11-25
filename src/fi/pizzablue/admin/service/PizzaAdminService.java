package fi.pizzablue.admin.service;

import java.sql.Connection;
import fi.pizzablue.admin.dao.PizzaNumeroDAO;
import fi.pizzablue.bean.Pizza;
import fi.pizzablue.dao.DAOPoikkeus;
import fi.pizzablue.dao.PizzaDAO;
import fi.pizzablue.dao.Yhteys;

public class PizzaAdminService {
	
	PizzaDAO pDAO = new PizzaDAO();
	PizzaNumeroDAO pnroDAO = new PizzaNumeroDAO();
	
	public void lisaaPizza(Pizza p) throws DAOPoikkeus {
	
		Connection yhteys = Yhteys.avaaYhteys();
		pDAO.lisaa(p, yhteys);
		Yhteys.suljeYhteys(yhteys);	
	}
	public void poistaPizza(Pizza p) throws DAOPoikkeus {
		
		Connection yhteys = Yhteys.avaaYhteys();
		pDAO.poista(p, yhteys);
		Yhteys.suljeYhteys(yhteys);	
	}
	public int haePizzaNumero() throws DAOPoikkeus {
		
		Connection yhteys = Yhteys.avaaYhteys();
		int numero = pnroDAO.haeNumero(yhteys);
		Yhteys.suljeYhteys(yhteys);
		return numero;
	}
	

}
