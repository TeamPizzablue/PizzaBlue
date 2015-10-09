package fi.pizzablue.service;

import java.sql.Connection;
import java.util.List;

import fi.pizzablue.bean.Pizza;
import fi.pizzablue.bean.Tayte;
import fi.pizzablue.dao.DAOPoikkeus;
import fi.pizzablue.dao.PizzaDAO;
import fi.pizzablue.dao.TayteDAO;
import fi.pizzablue.dao.Yhteys;

public class PizzalistaService {
	
	PizzaDAO pDAO = new PizzaDAO();
	TayteDAO tDAO = new TayteDAO();
	
	
	public List<Pizza> haePizzalista() throws DAOPoikkeus {

		Connection yhteys = Yhteys.avaaYhteys();
		
		List<Pizza> pizzat = pDAO.haeKaikki(yhteys);
		
		for(Pizza p : pizzat) {
			List<Tayte> taytteet = tDAO.haeTaytteetPizzalle(p, yhteys);
			p.setTaytteet(taytteet);
		}
		
		Yhteys.suljeYhteys(yhteys);
		return pizzat;
		
	}

}
