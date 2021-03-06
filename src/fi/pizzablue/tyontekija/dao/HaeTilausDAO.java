package fi.pizzablue.tyontekija.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import fi.pizzablue.bean.Juoma;
import fi.pizzablue.bean.Pizza;
import fi.pizzablue.dao.DAOPoikkeus;
import fi.pizzablue.tyontekija.bean.KokoJuoma;
import fi.pizzablue.tyontekija.bean.KokoPizza;
import fi.pizzablue.tyontekija.bean.KokoTilaus;

	public class HaeTilausDAO {
		
		public List<KokoTilaus> haeTilaukset(Connection yhteys) throws DAOPoikkeus {

			List<KokoTilaus> ktilaus = new ArrayList<KokoTilaus>();
			
			try {
				String sql = "SELECT t.id, t.aikaleima, t.kotiinkuljetus, t.hinta, t.etunimi, t.sukunimi, t.puhelinnumero, t.sahkoposti, t.katuosoite, t.postinro, t.postitmp, t.lisatiedot, ti.id FROM tilaus t JOIN tila ti ON t.tila_id = ti.id ORDER BY t.id DESC;";
				Statement haku = yhteys.createStatement();
				ResultSet tulokset = haku.executeQuery(sql);
				
				//käydään hakutulokset läpi
				while(tulokset.next()) {
					int tilausId = tulokset.getInt("t.id");
					Timestamp aikaleima = tulokset.getTimestamp("t.aikaleima");
					boolean kotiinkuljetus = tulokset.getBoolean("t.kotiinkuljetus");
					double hinta = tulokset.getDouble("t.hinta");
					String etunimi = tulokset.getString("t.etunimi");
					String sukunimi = tulokset.getString("t.sukunimi");
					String puhelinnumero = tulokset.getString("t.puhelinnumero");
					String sahkoposti = tulokset.getString("t.sahkoposti");
					String katuosoite = tulokset.getString("t.katuosoite");
					String postinumero = tulokset.getString("t.postinro");
					String postitmp = tulokset.getString("t.postitmp");
					String lisatiedot = tulokset.getString("t.lisatiedot");
					int tilaId = tulokset.getInt("ti.id");
					
					KokoTilaus kokotilaus = new KokoTilaus();
					
			//lisätään tilaus listaan
					kokotilaus.setId(tilausId);
					kokotilaus.setAikaleima(aikaleima);
					kokotilaus.setKotiinkuljetus(kotiinkuljetus);
					kokotilaus.setHinta(hinta);
					kokotilaus.setEtunimi(etunimi);
					kokotilaus.setSukunimi(sukunimi);
					kokotilaus.setPuhelinnumero(puhelinnumero);
					kokotilaus.setSahkoposti(sahkoposti);
					kokotilaus.setKatuosoite(katuosoite);
					kokotilaus.setPostinumero(postinumero);
					kokotilaus.setPostitoimipaikka(postitmp);
					kokotilaus.setLisatiedot(lisatiedot);
					kokotilaus.setTila(tilaId);
					
					ktilaus.add(kokotilaus);
				}
			} catch(Exception e) {
				throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
			} 	
			//System.out.println("Haettiin tilaukset: " + kokotilaus.toString());
			return ktilaus;		
		}
		
		public List<KokoPizza> haeKokotilauksenPizzat(int kokotilausid, Connection yhteys) throws DAOPoikkeus {
			
			List<KokoPizza> kpLista = new ArrayList<>();
			
			try {
				String sql = "SELECT pr.pizza_id, p.numero, p.nimi, poh.nimi, pr.oregano, pr.valkosipuli FROM tilaus t JOIN pizzarivi pr ON t.id = pr.tilaus_id JOIN pohja poh ON poh.id = pr.pohja_id JOIN pizza p ON p.id = pr.pizza_id WHERE t.id = ?;";
				PreparedStatement haku = yhteys.prepareStatement(sql);
				haku.setInt(1, kokotilausid);
				ResultSet tulokset = haku.executeQuery();
				
				//käydään hakutulokset läpi
				while(tulokset.next()) {
					int pizzaid = tulokset.getInt("pr.pizza_id");
					int pizzanNumero = tulokset.getInt("p.numero");
					String pizzanNimi = tulokset.getString("p.nimi");
					String pohja = tulokset.getString("poh.nimi");
					boolean oregano = tulokset.getBoolean("pr.oregano");
					boolean valkosipuli = tulokset.getBoolean("pr.valkosipuli");
					
					KokoPizza kp = new KokoPizza();
					Pizza p = new Pizza(); 
					
			//lisätään tiedot olioihin
					p.setId(pizzaid);
					kp.setOregano(oregano);
					kp.setValkosipuli(valkosipuli);
					kp.setPohja(pohja);
					kp.setNumero(pizzanNumero);
					kp.setNimi(pizzanNimi);
					
					kpLista.add(kp);
					
				}
			} catch(Exception e) {
				throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
			} 	
			//System.out.println("Haettiin tilauksen pizzat: " + kokotilaus.getPizzat().toString());	
			return kpLista;
		}
		
		public List<KokoJuoma> haeKokotilauksenJuomat(int kokotilausid, Connection yhteys) throws DAOPoikkeus {
			
			List<KokoJuoma> jLista = new ArrayList<>();
			
			try {
				String sql = "SELECT jr.juoma_id, j.numero, j.nimi FROM tilaus t JOIN juomarivi jr ON t.id = jr.tilaus_id JOIN juoma j ON j.id = jr.juoma_id WHERE t.id = ?;";
				PreparedStatement haku = yhteys.prepareStatement(sql);
				haku.setInt(1, kokotilausid);
				ResultSet tulokset = haku.executeQuery();
				
				//käydään hakutulokset läpi
				while(tulokset.next()) {
					int juomaid = tulokset.getInt("jr.juoma_id");
					int juomaNumero = tulokset.getInt("j.numero");
					String juomaNimi = tulokset.getString("j.nimi");
					
					Juoma j = new Juoma(juomaid);
					KokoJuoma kj = new KokoJuoma();
			
			//lisätään attribuutit olioille
					j.setId(juomaid);
					kj.setNumero(juomaNumero);
					kj.setNimi(juomaNimi);

					jLista.add(kj);
				}
			} catch(Exception e) {
				throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
			} 
			//System.out.println("Haettiin tilauksen juomat: " + kokotilaus.getJuomat().toString());
			return jLista;
		}
	} 
