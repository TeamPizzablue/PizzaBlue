package fi.pizzablue.dao;
	
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;

	import fi.pizzablue.dao.DBConnectionProperties;
	import fi.pizzablue.bean.Pizza;
	import fi.pizzablue.dao.DAOPoikkeus;

	public class PizzaDAO {
		
		//lataa tietokantayhteyden ajurin
		public PizzaDAO() throws DAOPoikkeus {
			try {
				Class.forName(DBConnectionProperties.getInstance().getProperty("driver")).newInstance();
			} catch(Exception e) {
				throw new DAOPoikkeus("Tietokannan ajuria ei kyetty lataamaan.", e);
			}
		}
		
		//Avaa tietokantayhteyden
		private Connection avaaYhteys() throws DAOPoikkeus {
			
			try {
				return DriverManager.getConnection(
						DBConnectionProperties.getInstance().getProperty("url"), 
						DBConnectionProperties.getInstance().getProperty("username"),
						DBConnectionProperties.getInstance().getProperty("password"));
			} catch (Exception e) {
				throw new DAOPoikkeus("Tietokantayhteyden avaaminen epäonnistui", e);
			}
		}
		
		// Sulkee tietokantayhteyden
		private void suljeYhteys(Connection yhteys) throws DAOPoikkeus {
			try {
				if (yhteys != null && !yhteys.isClosed())
					yhteys.close();
			} catch(Exception e) {
				throw new DAOPoikkeus("Tietokantayhteys ei jostain syystä suostu menemään kiinni.", e);
			}
		}
		
		//Hakee pizzat kannasta 
		public List<Pizza> haeKaikki() throws DAOPoikkeus{		
			
			ArrayList<Pizza> pizzat = new ArrayList<Pizza>();
			
			//avataan yhteys
			Connection yhteys = avaaYhteys();
			
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
			}finally {
				// lopuksi AINA suljetaan yhteys
				suljeYhteys(yhteys);
			}
			
			System.out.println("HAETTIIN TIETOKANNASTA PIZZAT: " + pizzat.toString());
			
			return pizzat;
		}
	}
