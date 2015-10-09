package fi.pizzablue.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fi.pizzablue.bean.Pizza;
import fi.pizzablue.bean.Tayte;
import fi.pizzablue.dao.DBConnectionProperties;
import fi.pizzablue.dao.DAOPoikkeus;

public class TayteDAO {
	
	//lataa tietokantayhteyden ajurin
	public TayteDAO() throws DAOPoikkeus {
		try {
			Class.forName(DBConnectionProperties.getInstance().getProperty("driver")).newInstance();
		} catch(Exception e) {
			throw new DAOPoikkeus("Tietokannan ajuria ei kyetty lataamaan.", e);
		}
	}
	
	//Avaa tietokantayhteyden
	private Connection avaaYhteys() throws DAOPoikkeus {
		
		try {
			return DriverManager.getConnection(
					DBConnectionProperties.getInstance().getProperty("url"), 
					DBConnectionProperties.getInstance().getProperty("username"),
					DBConnectionProperties.getInstance().getProperty("password"));
		} catch (Exception e) {
			throw new DAOPoikkeus("Tietokantayhteyden avaaminen epäonnistui", e);
		}
	}
	
	// Sulkee tietokantayhteyden
	private void suljeYhteys(Connection yhteys) throws DAOPoikkeus {
		try {
			if (yhteys != null && !yhteys.isClosed())
				yhteys.close();
		} catch(Exception e) {
			throw new DAOPoikkeus("Tietokantayhteys ei jostain syystä suostu menemään kiinni.", e);
		}
	}
	
	//Hakee pizzat kannasta 
	public List<Tayte> haeKaikki() throws DAOPoikkeus{		
		
		ArrayList<Tayte> taytteet = new ArrayList<Tayte>();
		
		//avataan yhteys
		Connection yhteys = avaaYhteys();
		
		try {
			
			//suoritetaan haku
			String sql = "select t.nimi, t.id from tayte t, pizzantayte pt where t.id = pt.tayte_id and pt.pizza_id = 1;";
			Statement haku = yhteys.createStatement();
			ResultSet tulokset = haku.executeQuery(sql);
					
			//käydään hakutulokset läpi
			while(tulokset.next()) {
				String tayte = tulokset.getString("t.nimi");
				int id = tulokset.getInt("t.id");
				
				//lisätään pizza listaan
				Tayte t = new Tayte(id, tayte);
				taytteet.add(t);
			}
			
		} catch(Exception e) {
			// virheitä tapahtui
			throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
		}finally {
			// lopuksi AINA suljetaan yhteys
			suljeYhteys(yhteys);
		}
		
		System.out.println("HAETTIIN TIETOKANNASTA PIZZAT: " + taytteet.toString());
		
		return taytteet;
	}

}
