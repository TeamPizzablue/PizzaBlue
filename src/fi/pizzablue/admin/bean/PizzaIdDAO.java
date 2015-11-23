package fi.pizzablue.admin.bean;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import fi.pizzablue.dao.DAOPoikkeus;

/**
 * Servlet implementation class PizzaIdDAO
 */
@WebServlet("/PizzaIdDAO")
public class PizzaIdDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public int haeId(Connection yhteys) throws DAOPoikkeus{		
		
		int id = 0;
		
		try {
			//suoritetaan haku
			String sql = "SELECT MAX(numero) FROM pizza";
			Statement haku = yhteys.createStatement();
			ResultSet tulokset = haku.executeQuery(sql);
			
			//käydään hakutulokset läpi
			while (tulokset.next()) {
				id = tulokset.getInt("MAX(numero)");
			}
			
		} catch(Exception e) {
			// virheitä tapahtui
			throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
		}
		return id;
	}

}
