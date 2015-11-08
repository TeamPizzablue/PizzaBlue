package fi.pizzablue.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TilausIdDAO {
	public int haeId(int id, Connection yhteys) throws DAOPoikkeus{		
		
		try {
			
			//suoritetaan haku
			String sql = "SELECT LAST_INSERT_ID();";
			Statement haku = yhteys.createStatement();
			ResultSet tulokset = haku.executeQuery(sql);
			
			//käydään hakutulokset läpi
				id = tulokset.getInt("id");
			
		} catch(Exception e) {
			// virheitä tapahtui
			throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
		}
		return id;
	}
}
