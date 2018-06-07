package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Utilisateurs {
	private BDD _bdd;

	public Utilisateurs() {

	}

	public String get_users(String base) throws SQLException {
		String refresh = "";
		_bdd = new BDD();
		Connection connect = _bdd.getInstance();
		Statement stm = connect.createStatement();
		String requete = "select pseudo from " + base;
		ResultSet result;
		result = stm.executeQuery(requete);
		while (result.next()) {			
				refresh += "<form  action='choix' method='post'><input class='utilisateurs' type='submit' value='"
						+ result.getString("pseudo") + "' name='user'></input><br><br><br></form>";

			
		}
		result.close();
		stm.close();
		connect.close();
		return refresh;
	}
}
