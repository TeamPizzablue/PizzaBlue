package fi.pizzablue.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fi.pizzablue.bean.Pizza;
import fi.pizzablue.bean.Tayte;
import fi.pizzablue.dao.DAOPoikkeus;

public class TayteDAO {

	public List<Tayte> haeTaytteetPizzalle(Pizza p, Connection yhteys) throws DAOPoikkeus {
		
		ArrayList<Tayte> taytteet = new ArrayList<Tayte>();
	
		try {
			//suoritetaan haku
			String sql = "select t.id, t.nimi from tayte t, pizzantayte pt where t.id = pt.tayte_id and pt.pizza_id = ?";
			PreparedStatement haku = yhteys.prepareStatement(sql);
			haku.setInt(1, p.getId());
			ResultSet tulokset = haku.executeQuery();
					
			//käydään hakutulokset läpi
			while(tulokset.next()) {
				String nimi = tulokset.getString("nimi");
				int id = tulokset.getInt("id");
				
				//lisätään pizza listaan
				Tayte t = new Tayte(id, nimi);
				taytteet.add(t);
			}
			
		} catch(Exception e) {
			// virheitä tapahtui
			throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
		}
		
		System.out.println("HAETTIIN TIETOKANNASTA PIZZAT: " + taytteet.toString());
		
		return taytteet;
	}

}
