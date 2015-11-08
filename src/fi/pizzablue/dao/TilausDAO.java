package fi.pizzablue.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import fi.pizzablue.bean.Tilaus;

	


	public class tilausDAO {
		
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

				/*for (int i = 0; i < tilaus.getTilausrivit().size(); i++) {
					
					if (tilaus.getTilausrivit().get(i) instanceof Pizzarivi) {
						String sqlp = "INSERT INTO pizzarivi (maara, hinta, oregano, valkosipuli, pohja_id, pizza_id, tilaus_id) VALUES (?,?,?,?,?,?,?)";
						PreparedStatement lausep = yhteys.prepareStatement(sql);
						//lause.setInt(1, tilaus );
						//lause.setBoolean(2, tilaus.getKotiinkuljetus());
						//lause.setString(3, tilaus.getEtunimi());
						//lause.setString(4, tilaus.getSukunimi());
						
					} else if (tilaus.getTilausrivit().get(i) instanceof Juomarivi) {
						//syötetään juomariville tilaustiedot
					}
				}*/
				
				} catch(Exception e) {
					//JOTAIN VIRHETTÄ TAPAHTUI
					throw new DAOPoikkeus("Tilauksen lisäys kantaan aiheutti virheen: ", e);
				} 
					
				
		}
		

	

	} 