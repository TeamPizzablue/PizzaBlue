package fi.pizzablue.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fi.pizzablue.bean.Pizza;
import fi.pizzablue.bean.Tayte;
import fi.pizzablue.dao.DBConnectionProperties;
import fi.pizzablue.dao.DAOPoikkeus;

public class TayteDAO {
	
	/*
	//Hakee pizzat kannasta 
	public List<Tayte> haeKaikki() throws DAOPoikkeus{		
		
		ArrayList<Tayte> taytteet = new ArrayList<Tayte>();
		
		//avataan yhteys
		Connection yhteys = avaaYhteys();
		
		try {
			
			//suoritetaan haku
			String sql = "select p.numero, group_concat(t.nimi SEPARATOR ', ') as taytteet from pizza p, tayte t, pizzantayte pt where t.id = pt.tayte_id and pt.pizza_id = p.id GROUP BY p.id;";
			Statement haku = yhteys.createStatement();
			ResultSet tulokset = haku.executeQuery(sql);
					
			//käydään hakutulokset läpi
			while(tulokset.next()) {
				String tayte = tulokset.getString("taytteet");
				int id = tulokset.getInt("p.numero");
				
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
*/
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
