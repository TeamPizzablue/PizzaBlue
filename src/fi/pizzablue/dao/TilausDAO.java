package fi.pizzablue.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import fi.pizzablue.bean.Juomarivi;
import fi.pizzablue.bean.Pizzarivi;
import fi.pizzablue.bean.Tilaus;
import fi.pizzablue.bean.Tilausrivi;

	


	public class TilausDAO {
		
		public void lisaaTilaus(Tilaus tilaus, Connection yhteys) throws DAOPoikkeus {

			try {
				String sql = "INSERT INTO tilaus (hinta, kotiinkuljetus, etunimi, sukunimi, puhelinnumero, sahkoposti, katuosoite, postinro, postitmp, lisatiedot, tila_id) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement lause = yhteys.prepareStatement(sql);
				lause.setDouble(1, tilaus.getHinta());
				lause.setBoolean(2, tilaus.getKotiinkuljetus());
				lause.setString(3, tilaus.getEtunimi());
				lause.setString(4, tilaus.getSukunimi());
				lause.setString(5, tilaus.getPuhelinnumero());
				lause.setString(6, tilaus.getSahkoposti());
				lause.setString(7, tilaus.getKatuosoite());
				lause.setString(8, tilaus.getPostinro());
				lause.setString(9, tilaus.getPostitmp());
				lause.setString(10, tilaus.getLisatiedot());
				lause.setInt(11, 1);
				
				//suoritetaan lause
				lause.executeUpdate();
				
				System.out.println("Lisättiin tietokantaan tilaus: " + tilaus.toString());
				
				List<Tilausrivi> tilausrivit = tilaus.getTilausrivit();

				for (int i = 0; i < tilaus.getTilausrivit().size(); i++) {
					
					if (tilaus.getTilausrivit().get(i) instanceof Pizzarivi) {
						Pizzarivi privi = (Pizzarivi)tilausrivit.get(i);
						String sqlp = "INSERT INTO pizzarivi (maara, hinta, oregano, valkosipuli, pohja_id, pizza_id, tilaus_id) VALUES (?,?,?,?,?,?,?)";
						PreparedStatement lausep = yhteys.prepareStatement(sqlp);
						lausep.setInt(1, 1);
						lausep.setDouble(2, privi.getHinta());
						lausep.setBoolean(3, privi.isOregano());
						lausep.setBoolean(4, privi.isValkosipuli());
						lausep.setInt(5, privi.getPohja().getId());
						lausep.setInt(6, privi.getPizza().getId());
						lausep.setInt(7, tilaus.getId());
						
						lausep.executeUpdate();
						
						System.out.println(privi.toString());
						
					} else if (tilaus.getTilausrivit().get(i) instanceof Juomarivi) {
						//syötetään juomariville tilaustiedot
						Juomarivi jrivi = (Juomarivi)tilausrivit.get(i);
						String sqlj = "INSERT INTO juomarivi (maara, hinta, juoma_id, tilaus_id) VALUES (?,?,?,?)";
						PreparedStatement lausej = yhteys.prepareStatement(sqlj);
						lausej.setInt(1, 1);
						lausej.setDouble(2, jrivi.getHinta());
						lausej.setInt(3, jrivi.getId());
						lausej.setInt(4, tilaus.getId());
						
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
