package fi.pizzablue.admin.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
			String sql = "INSERT INTO tiedote(otsikko, sisalto) values(?,?)";
			PreparedStatement lause = yhteys.prepareStatement(sql);
			
			//täytetään puuttuvat tiedot
			lause.setString(1, t.getOtsikko());
			lause.setString(2, t.getSisalto());
			
			//suoritetaan lause
			lause.executeUpdate();
			System.out.println("Lisättiin tietokantaan uusi tiedote: "+ t.toString());
			
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
			lause.setInt(1, t.getId());
			
			//suoritetaan lause
			lause.executeUpdate();
			
		} catch(Exception e) {
			// virheitä tapahtui
			throw new DAOPoikkeus("Tiedotteen poisto aiheutti virheen", e);
		}
	}
	public List<Tiedote> haeTiedotteet(Connection yhteys) throws DAOPoikkeus{	
		ArrayList<Tiedote> tiedotteet = new ArrayList<Tiedote>();
		
		try {
			//alustetaan sql-lause
			String sql = "SELECT id, otsikko, sisalto FROM tiedote ORDER BY id DESC;";
			Statement haku = yhteys.createStatement();
			ResultSet tulokset = haku.executeQuery(sql);
			
			//käydään hakutulokset läpi
			while(tulokset.next()) {
				int id = tulokset.getInt("id");
				String otsikko = tulokset.getString("otsikko");
				String sisalto = tulokset.getString("sisalto");
			
				//lisätään tiedote listaan
				Tiedote t = new Tiedote(id, otsikko, sisalto);
				tiedotteet.add(t);
			}
			
		} catch(Exception e) {
			// virheitä tapahtui
			throw new DAOPoikkeus("Tiedotteiden haku kannasta aiheutti virheen", e);
		}
		System.out.println("Haettiin kannasta tiedotteet: " + tiedotteet.toString());	
	
	return tiedotteet;

	}
}
