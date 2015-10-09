package fi.pizzablue.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Yhteys {
	
	static {
		try {
			Class.forName(DBConnectionProperties.getInstance().getProperty("driver")).newInstance();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Avaa tietokantayhteyden
	public static Connection avaaYhteys() throws DAOPoikkeus {
		
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
	public static void suljeYhteys(Connection yhteys) throws DAOPoikkeus {
		try {
			if (yhteys != null && !yhteys.isClosed())
				yhteys.close();
		} catch(Exception e) {
			throw new DAOPoikkeus("Tietokantayhteys ei jostain syystä suostu menemään kiinni.", e);
		}
	}
}
