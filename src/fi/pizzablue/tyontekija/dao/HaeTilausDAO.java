package fi.pizzablue.tyontekija.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fi.pizzablue.bean.Juoma;
import fi.pizzablue.bean.Pizza;
import fi.pizzablue.dao.DAOPoikkeus;
import fi.pizzablue.tyontekija.bean.KokoPizza;
import fi.pizzablue.tyontekija.bean.KokoTilaus;

	


	public class HaeTilausDAO {
		
		public List<KokoTilaus> haeTilaukset(Connection yhteys) throws DAOPoikkeus {

			List<KokoTilaus> ktilaus = new ArrayList<KokoTilaus>();
			KokoTilaus kokotilaus = new KokoTilaus();
			
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
					
					ktilaus.add(kokotilaus);
				}
			} catch(Exception e) {
				throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
			} 
				
				System.out.println("Haettiin tilaukset: " + kokotilaus.toString());
				
				return ktilaus;
				
		}
		
		public void haeKokotilauksenPizzat(KokoTilaus kokotilaus, Connection yhteys) throws DAOPoikkeus {
			try {
				String sql = "SELECT t.id, pr.pizza_id, poh.nimi, pr.oregano, pr.valkosipuli FROM tilaus t JOIN pizzarivi pr ON t.id = pr.tilaus_id JOIN pohja poh ON poh.id = pr.pohja_id ORDER BY t.id;";
				Statement haku = yhteys.createStatement();
				ResultSet tulokset = haku.executeQuery(sql);
				
				//käydään hakutulokset läpi
				while(tulokset.next()) {
					int id = tulokset.getInt("pr.pizza_id");
					String pohja = tulokset.getString("poh.nimi");
					boolean oregano = tulokset.getBoolean("pr.oregano");
					boolean valkosipuli = tulokset.getBoolean("pr.valkosipuli");
					
					KokoPizza kp = new KokoPizza();
					Pizza p = new Pizza(id); 
					
			//lisätään tiedot olioihin
					p.setId(id);
					kp.setOregano(oregano);
					kp.setValkosipuli(valkosipuli);
					kp.setPohja(pohja);
					kp.setPizza(p);
					
					kokotilaus.getPizzat().add(kp);
					
				}
			} catch(Exception e) {
				throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
			} 
				
				System.out.println("Haettiin tilauksen pizzat: " + kokotilaus.getPizzat().toString());
			
		}
		public void haeKokotilauksenJuomat(KokoTilaus kokotilaus, Connection yhteys) throws DAOPoikkeus {
			try {
				String sql = "SELECT t.id, jr.juoma_id FROM tilaus t JOIN juomarivi jr ON t.id = jr.tilaus_id ORDER BY t.id;";
				Statement haku = yhteys.createStatement();
				ResultSet tulokset = haku.executeQuery(sql);
				
				//käydään hakutulokset läpi
				while(tulokset.next()) {
					int id = tulokset.getInt("jr.juoma_id");
					
					Juoma j = new Juoma(id);
			
			//lisätään tilaus listaan
					kokotilaus.getJuomat().add(j);
				}
			} catch(Exception e) {
				throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
			} 
				
				System.out.println("Haettiin tilauksen juomat: " + kokotilaus.getJuomat().toString());
			
		}
		
		

	} 
