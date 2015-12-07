package fi.pizzablue.dao;
	
	import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

	import fi.pizzablue.bean.Pizza;
import fi.pizzablue.dao.DAOPoikkeus;

	public class PizzaDAO {
		

		
		//Hakee pizzat kannasta 
		public List<Pizza> haeKaikki(Connection yhteys) throws DAOPoikkeus{		
			
			ArrayList<Pizza> pizzat = new ArrayList<Pizza>();
			
			try {
				
				//suoritetaan haku
				String sql = "select p.id, p.numero, p.nimi, p.hinta, p.energia, p.proteiini, p.hiilihydraatti, p.rasva from pizza p;";
				Statement haku = yhteys.createStatement();
				ResultSet tulokset = haku.executeQuery(sql);
				
				//käydään hakutulokset läpi
				while(tulokset.next()) {
					int id = tulokset.getInt("p.id");
					int numero = tulokset.getInt("p.numero");
					String nimi = tulokset.getString("p.nimi");
					double hinta = tulokset.getDouble("p.hinta");
					int energia = tulokset.getInt("p.energia");
					double proteiini = tulokset.getDouble("p.proteiini");
					double hiilihydraatti = tulokset.getDouble("p.hiilihydraatti");
					double rasva = tulokset.getDouble("p.rasva");
					
					
					//lisätään pizza listaan
					Pizza p = new Pizza(id, numero, nimi, hinta, energia, proteiini, hiilihydraatti, rasva);
					pizzat.add(p);
				}
				
			} catch(Exception e) {
				// virheitä tapahtui
				throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
			}
			
			System.out.println("HAETTIIN TIETOKANNASTA PIZZAT: " + pizzat.toString());
			
			return pizzat;
		}
		
		public Pizza haeYksiPizza(int id, Connection yhteys) throws DAOPoikkeus {
			Pizza p = null;
			
			try {
				
				//suoritetaan haku
				String sql = "select p.id, p.numero, p.nimi, p.hinta, p.energia, p.proteiini, p.hiilihydraatti, p.rasva from pizza p where p.id = ?;";
				PreparedStatement haku = yhteys.prepareStatement(sql);
				haku.setInt(1, id);
				ResultSet tulokset = haku.executeQuery();
				
				//käydään hakutulokset läpi
				if(tulokset.next()) {
					int numero = tulokset.getInt("p.numero");
					String nimi = tulokset.getString("p.nimi");
					double hinta = tulokset.getDouble("p.hinta");
					int energia = tulokset.getInt("p.energia");
					double proteiini = tulokset.getDouble("p.proteiini");
					double hiilihydraatti = tulokset.getDouble("p.hiilihydraatti");
					double rasva = tulokset.getDouble("p.rasva");
					
					p = new Pizza(id, numero, nimi, hinta, energia, proteiini, hiilihydraatti, rasva);
				}
				
			} catch(Exception e) {
				// virheitä tapahtui
				throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
			}
			
			System.out.println("HAETTIIN TIETOKANNASTA PIZZA: " + p.toString());
			
			return p;
		}
		public void lisaa(Pizza p, Connection yhteys) throws DAOPoikkeus{
			
			try {
				//suoritetaan haku
				
				//alustetaan sql-lause. HUOM! values kohdassa tulee olla (?,?) muuten sovellus on haavoittuvainen, sillä sqllää voi syöttää syötekenttiin
				//älä ikinä katenoi käyttäjien syöttämiä tietoja sql komentoihin!
				String sql = "insert into pizza(numero, nimi, hinta, energia, proteiini, hiilihydraatti, rasva) values(?,?,?,?,?,?,?)";
				PreparedStatement lause = yhteys.prepareStatement(sql);
				
				//täytetään puuttuvat tiedot
				lause.setInt(1, p.getNumero());
				lause.setString(2, p.getNimi());
				lause.setDouble(3, p.getHinta());
				lause.setDouble(4, p.getEnergia());
				lause.setDouble(5, p.getProteiini());
				lause.setDouble(6, p.getHiilihydraatti());
				lause.setDouble(7, p.getRasva());
				
				//suoritetaan lause
				lause.executeUpdate();
				System.out.println("Lisättiin tietokantaan pizza: "+ p);
			} catch(Exception e) {
				//JOTAIN VIRHETTÄ TAPAHTUI
				throw new DAOPoikkeus("Pizzan lisäämisyritys aiheutti virheen", e);
			} 
			

		}
		public void poista(Pizza p, Connection yhteys) throws DAOPoikkeus{
	
			try {
				
				//suoritetaan haku
				
				//alustetaan sql-lause, huom pitää olla ? ja seuraavassa kohtaa täydennetään tiedot
				String sql = "delete from pizza where id = ?;";
				PreparedStatement lause = yhteys.prepareStatement(sql);
				
				//täytetään puuttuvat tiedot
				lause.setInt(1, p.getId());
				
				//suoritetaan lause
				lause.executeUpdate();
				System.out.println("Poistettiin tietokannasta pizza: "+ p);
			} catch(Exception e) {
				//JOTAIN VIRHETTÄ TAPAHTUI
				throw new DAOPoikkeus("Pizzan lisäämisyritys aiheutti virheen", e);
			} 
		}
		
		public void poistaTaytteet(Pizza p, Connection yhteys) throws DAOPoikkeus{
			
			try {
				
				//suoritetaan haku
				
				//alustetaan sql-lause, huom pitää olla ? ja seuraavassa kohtaa täydennetään tiedot
				String sql = "delete from pizzantayte where pizza_id = ?;";
				PreparedStatement lause = yhteys.prepareStatement(sql);
				
				//täytetään puuttuvat tiedot
				lause.setInt(1, p.getId());
				
				//suoritetaan lause
				lause.executeUpdate();
				System.out.println("Poistettiin tietokannasta taytteet: "+ p);
			} catch(Exception e) {
				//JOTAIN VIRHETTÄ TAPAHTUI
				throw new DAOPoikkeus("Pizzan lisäämisyritys aiheutti virheen", e);
			} 
		}
		
		
		
		public int haeTayteId(String taytenimi, Connection yhteys) throws DAOPoikkeus {
			
			int id = 0;
			
			try {
				//suoritetaan haku
				
				//alustetaan sql-lause. HUOM! values kohdassa tulee olla (?,?) muuten sovellus on haavoittuvainen, sillä sqllää voi syöttää syötekenttiin
				//älä ikinä katenoi käyttäjien syöttämiä tietoja sql komentoihin!
				String sql = "select id from tayte where nimi = ?;";
				PreparedStatement haku = yhteys.prepareStatement(sql);
				haku.setString(1, taytenimi);
				ResultSet tulokset = haku.executeQuery();
				
				while(tulokset.next()) {
					id = tulokset.getInt("id");
				}
				
			} catch(Exception e) {
				//JOTAIN VIRHETTÄ TAPAHTUI
				throw new DAOPoikkeus("Pizzan lisäämisyritys aiheutti virheen", e);
			}
			
			return id;
		}
		
		public void lisaaPizzanTayte(int pizzaId, int tayteId, Connection yhteys) throws DAOPoikkeus{
			
			try {
				//suoritetaan haku
				
				//alustetaan sql-lause. HUOM! values kohdassa tulee olla (?,?) muuten sovellus on haavoittuvainen, sillä sqllää voi syöttää syötekenttiin
				//älä ikinä katenoi käyttäjien syöttämiä tietoja sql komentoihin!
				String sql = "insert into pizzantayte(pizza_id, tayte_id) values(?,?)";
				PreparedStatement lause = yhteys.prepareStatement(sql);
				
				//täytetään puuttuvat tiedot
				lause.setInt(1, pizzaId);
				lause.setInt(2, tayteId);
				
				//suoritetaan lause
				lause.executeUpdate();
				System.out.println("Lisättiin tietokantaan pizzantayte: "+ pizzaId + ", " + tayteId);
			} catch(Exception e) {
				//JOTAIN VIRHETTÄ TAPAHTUI
				throw new DAOPoikkeus("Täytteen lisäämisyritys aiheutti virheen", e);
			} 
			

		}
		
		public int haePizzaId(Pizza p, Connection yhteys) throws DAOPoikkeus {
			
			int id = 0;
			
			try {
				//suoritetaan haku
				
				//alustetaan sql-lause. HUOM! values kohdassa tulee olla (?,?) muuten sovellus on haavoittuvainen, sillä sqllää voi syöttää syötekenttiin
				//älä ikinä katenoi käyttäjien syöttämiä tietoja sql komentoihin!
				String sql = "select id from pizza where numero = ?;";
				PreparedStatement haku = yhteys.prepareStatement(sql);
				haku.setInt(1, p.getNumero());
				ResultSet tulokset = haku.executeQuery();
				
				while(tulokset.next()) {
					id = tulokset.getInt("id");
				}
				
			} catch(Exception e) {
				//JOTAIN VIRHETTÄ TAPAHTUI
				throw new DAOPoikkeus("Pizzan lisäämisyritys aiheutti virheen", e);
			}
			
			return id;
		}
		
	}
