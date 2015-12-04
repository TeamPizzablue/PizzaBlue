package fi.pizzablue.tyontekija.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import fi.pizzablue.bean.Tilaus;
import fi.pizzablue.dao.DAOPoikkeus;
import fi.pizzablue.tyontekija.bean.KokoTilaus;

	


	public class HaeTilausDAO {
		
		public void haeTilaukset(KokoTilaus kokotilaus, Connection yhteys) throws DAOPoikkeus {

			try {
				String sql = "SELECT t.id, t.aikaleima, t.kotiinkuljetus, t.hinta, ti.id FROM tilaus t JOIN tila ti ON t.tila_id = ti.id;";
				Statement haku = yhteys.createStatement();
				ResultSet tulokset = haku.executeQuery(sql);
				
				//käydään hakutulokset läpi
				while(tulokset.next()) {
					int tilausId = tulokset.getInt("t.id");
					Date aikaleima = tulokset.getDate("t.aikaleima");
					boolean kotiinkuljetus = tulokset.getBoolean("t.kotiinkuljetus");
					double hinta = tulokset.getDouble("t.hinta");
					int tilaId = tulokset.getInt("ti.id");
					
			//lisätään tilaus listaan
					kokotilaus.setId(tilausId);
					kokotilaus.setAikaleima(aikaleima);
					kokotilaus.setKotiinkuljetus(kotiinkuljetus);
					kokotilaus.setHinta(hinta);
					kokotilaus.setTila(tilaId);
				}
			} catch(Exception e) {
				throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
			} 
				
				System.out.println("Haettiin tilaukset: " + kokotilaus.toString());
				
		}
		
		public void haeKokotilauksenPizzat(KokoTilaus kokotilaus, Connection yhteys) throws DAOPoikkeus {
			try {
				String sql = "SELECT t.id, pr.pizza_id, poh.nimi, pr.oregano, pr.valkosipuli FROM tilaus t JOIN pizzarivi pr ON t.id = pr.tilaus_id JOIN pohja poh ON poh.id = pr.pohja_id ORDER BY t.id;";
				Statement haku = yhteys.createStatement();
				ResultSet tulokset = haku.executeQuery(sql);
				
				//käydään hakutulokset läpi
				while(tulokset.next()) {
					int tilausId = tulokset.getInt("t.id");
					Date aikaleima = tulokset.getDate("t.aikaleima");
					boolean kotiinkuljetus = tulokset.getBoolean("t.kotiinkuljetus");
					double hinta = tulokset.getDouble("t.hinta");
					int tilaId = tulokset.getInt("ti.id");
					
			//lisätään tilaus listaan
					kokotilaus.setId(tilausId);
					kokotilaus.setAikaleima(aikaleima);
					kokotilaus.setKotiinkuljetus(kotiinkuljetus);
					kokotilaus.setHinta(hinta);
					kokotilaus.setTila(tilaId);
				}
			} catch(Exception e) {
				throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
			} 
				
				System.out.println("Haettiin tilaukset: " + kokotilaus.toString());
			
		}

	} 
