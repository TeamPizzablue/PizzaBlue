package fi.pizzablue.admin.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import fi.pizzablue.dao.DAOPoikkeus;

@WebServlet("/PizzaNumeroDAO")
public class PizzaNumeroDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public int haeNumero(Connection yhteys) throws DAOPoikkeus{		
		
		int numero = 0;
		try {
			//suoritetaan haku
			String sql = "SELECT MAX(numero) FROM juoma";
			Statement haku = yhteys.createStatement();
			ResultSet tulokset = haku.executeQuery(sql);
			
			//käydään hakutulokset läpi
			while (tulokset.next()) {
				numero = tulokset.getInt("MAX(numero)");
			}	
		} catch(Exception e) {
			// virheitä tapahtui
			throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
		}
		return numero;
	}
}
