package fi.pizzablue.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import fi.pizzablue.bean.Juomarivi;
import fi.pizzablue.bean.Pizzarivi;
import fi.pizzablue.bean.Tilaus;
import fi.pizzablue.bean.Tilausrivi;
import fi.pizzablue.service.TilausIdService;


public class TilausrivitDAO {
				
	public void lisaaTilausrivit(Tilaus tilaus, Connection yhteys) throws DAOPoikkeus {
				
		TilausIdService tidService = new TilausIdService();
						
		List<Tilausrivi> tilausrivit = tilaus.getTilausrivit();
				
		int tilausID = tidService.haeTilausId();
				
		try {

			for (int i = 0; i < tilaus.getTilausrivit().size(); i++) {
					
				if (tilaus.getTilausrivit().get(i) instanceof Pizzarivi) {
					Pizzarivi privi = (Pizzarivi)tilausrivit.get(i);
					String sqlp = "INSERT INTO pizzarivi (maara, hinta, oregano, valkosipuli, pohja_id, pizza_id, tilaus_id) VALUES (?,?,?,?,?,?,?)";
					PreparedStatement lausep = yhteys.prepareStatement(sqlp);
					lausep.setInt(1, 1);
					lausep.setDouble(2, privi.getPizza().getHinta());
					lausep.setBoolean(3, privi.isOregano());
					lausep.setBoolean(4, privi.isValkosipuli());
					lausep.setInt(5, privi.getPohja().getId());
					lausep.setInt(6, privi.getPizza().getId());
					lausep.setInt(7, tilausID);
							
					lausep.executeUpdate();
							
					System.out.println(privi.toString());
							
				} else if (tilaus.getTilausrivit().get(i) instanceof Juomarivi) {
					//syötetään juomariville tilaustiedot
					Juomarivi jrivi = (Juomarivi)tilausrivit.get(i);
					String sqlj = "INSERT INTO juomarivi (maara, hinta, juoma_id, tilaus_id) VALUES (?,?,?,?)";
					PreparedStatement lausej = yhteys.prepareStatement(sqlj);
					lausej.setInt(1, 1);
					lausej.setDouble(2, jrivi.getJuoma().getHinta());
					lausej.setInt(3, jrivi.getJuoma().getId());
					lausej.setInt(4, tilausID);
							
					lausej.executeUpdate();
							
					System.out.println(jrivi.toString());
				}
			}
					
		} catch(Exception e) {
			//JOTAIN VIRHETTÄ TAPAHTUI
			throw new DAOPoikkeus("Tilauksen lisäys kantaan aiheutti virheen: ", e);
		} 									
	}		
}