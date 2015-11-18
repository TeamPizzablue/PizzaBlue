package fi.pizzablue.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TilausIdDAO {
	
	public int haeId(Connection yhteys) throws DAOPoikkeus{		
		
		int id = 0;
		
		try {
			//suoritetaan haku
			String sql = "SELECT MAX(id) from tilaus;";
			Statement haku = yhteys.createStatement();
			ResultSet tulokset = haku.executeQuery(sql);
			
			//käydään hakutulokset läpi
			while (tulokset.next()) {
				id = tulokset.getInt("MAX(id)");
			}
			
		} catch(Exception e) {
			// virheitä tapahtui
			throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
		}
		return id;
	}
}
