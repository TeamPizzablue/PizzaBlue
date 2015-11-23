package fi.pizzablue.service;

import java.sql.Connection;
import java.util.List;

import fi.pizzablue.bean.Pizza;
import fi.pizzablue.bean.Tayte;
import fi.pizzablue.dao.DAOPoikkeus;
import fi.pizzablue.dao.PizzaDAO;
import fi.pizzablue.dao.TayteDAO;
import fi.pizzablue.dao.Yhteys;

public class PizzaAdminService {
	
	PizzaDAO pDAO = new PizzaDAO();
	TayteDAO tDAO = new TayteDAO();
	
	
	public List<Pizza> lisaaPizza() throws DAOPoikkeus {

		Connection yhteys = Yhteys.avaaYhteys();
	
		
		Yhteys.suljeYhteys(yhteys);
		return "";
		
	}
	
	public Pizza poisaPizza(int id) throws DAOPoikkeus {

		Connection yhteys = Yhteys.avaaYhteys();
		
		Pizza p = pDAO.haeYksiPizza(id, yhteys);
		
		Yhteys.suljeYhteys(yhteys);
		return p;
		
	}
	

}
