package fi.pizzablue.admin.service;

import java.sql.Connection;
import java.util.List;

import fi.pizzablue.bean.Pizza;
import fi.pizzablue.bean.Tayte;
import fi.pizzablue.bean.Tilaus;
import fi.pizzablue.dao.DAOPoikkeus;
import fi.pizzablue.dao.PizzaDAO;
import fi.pizzablue.dao.TayteDAO;
import fi.pizzablue.dao.Yhteys;

public class PizzaAdminService {
	
	PizzaDAO pDAO = new PizzaDAO();
	
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
	

}
