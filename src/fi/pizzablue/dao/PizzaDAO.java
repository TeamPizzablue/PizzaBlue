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
	}
