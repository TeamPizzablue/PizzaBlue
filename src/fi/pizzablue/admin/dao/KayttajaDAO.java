package fi.pizzablue.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fi.pizzablue.admin.bean.Kayttaja;
import fi.pizzablue.dao.DAOPoikkeus;

public class KayttajaDAO {


	/**
	 * Lisää uuden webuserin tietokantaan
	 * 
	 * @param kayttaja
	 *            uuden webuserin tiedot
	 * @throws UsernameVarattuPoikkeus
	 *             Mikäli tietokannasta löytyy jo käyttäjä samalla usernamella
	 * @throws DAOPoikkeus
	 *             Mikäli tietokantahaussa tapahtuu virhe
	 */
	public void lisaa(Kayttaja kayttaja, Connection yhteys) throws DAOPoikkeus {

		try {

			// tarkistetaan, että usernamella ei jo löydy käyttäjää
			PreparedStatement usernameHaku = yhteys.prepareStatement("select id from kayttaja where username = ?");
			usernameHaku.setString(1, kayttaja.getUsername());
			ResultSet rs = usernameHaku.executeQuery();
			if (rs.next()) {
				System.out.println("Käyttäjä on jo");
				throw new DAOPoikkeus();
			}

			// suoritetaan lisäys
			PreparedStatement insertLause = yhteys.prepareStatement("insert into kayttaja(username, password_hash, salt) values(?,?,?)");
			insertLause.setString(1, kayttaja.getUsername());
			insertLause.setString(2, kayttaja.getPasswordHash());
			insertLause.setString(3, kayttaja.getSalt());

			insertLause.executeUpdate();

		} catch (SQLException e) {
			// JOTAIN VIRHETTÄ TAPAHTUI
			throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
		}

	}

	public Kayttaja hae(String username, Connection yhteys) throws DAOPoikkeus {
		Kayttaja kayttaja;

		try {

			// tarkistetaan, että usernamella ei jo löydy käyttäjää
			PreparedStatement usernameHaku = yhteys.prepareStatement("select id, username, salt, password_hash from kayttaja where username = ?");
			usernameHaku.setString(1, username);
			ResultSet rs = usernameHaku.executeQuery();
			if (rs.next()) {
				// LÖYTYI
				kayttaja = new Kayttaja(rs.getInt("id"),
						rs.getString("username"), rs.getString("salt"),
						rs.getString("password_hash"));
			} else {
				// EI LÖYTYNYT
				// generoidaan kuitenkin tyhjä user, jotta 
				// login tarkistus kestää aina yhtä kauan
				kayttaja = new Kayttaja(-1, "-", "-", "-");
			}

		} catch (SQLException e) {
			// JOTAIN VIRHETTÄ TAPAHTUI
			throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
		}
		return kayttaja;
	}

}
