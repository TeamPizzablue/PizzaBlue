package fi.pizzablue.admin.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import fi.pizzablue.admin.bean.Tiedote;
import fi.pizzablue.dao.DAOPoikkeus;

/**
 * Servlet implementation class PizzaIdDAO
 */
@WebServlet("/tiedoteDAO")
public class TiedoteDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void lisaa(Tiedote t, Connection yhteys) throws DAOPoikkeus{		
	
		try {
			//suoritetaan haku
			String sql = "INSERT INTO tiedote(sisalto) values(?)";
			PreparedStatement lause = yhteys.prepareStatement(sql);
			
			//täytetään puuttuvat tiedot
			lause.setString(1, t.getTiedote());
			
			//suoritetaan lause
			lause.executeUpdate();
			System.out.println("Lisättiin tietokantaan uusi tiedote: "+ t);
			
		} catch(Exception e) {
			// virheitä tapahtui
			throw new DAOPoikkeus("Tiedotteen lisäys aiheutti virheen", e);
		}
	}
public void poista(Tiedote t, Connection yhteys) throws DAOPoikkeus{		
		
		try {
			//alustetaan sql-lause
			String sql = "delete from tiedote where id = ?";
			PreparedStatement lause = yhteys.prepareStatement(sql);
			
			//täytetään puuttuvat tiedot
			lause.setString(1, t.getTiedote());
			
			//suoritetaan lause
			lause.executeUpdate();
			
		} catch(Exception e) {
			// virheitä tapahtui
			throw new DAOPoikkeus("Tiedotteen poisto aiheutti virheen", e);
		}
	}

}
