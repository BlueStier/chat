package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Archive {
	private BDD _bdd;
	private String _str;
	private String _pseudo;

	public Archive(String str) {
		_str = str;
	}



	public String get_message(String pse) throws SQLException {
		_pseudo = pse;
		ArrayList<ArrayList<String>> liste = new ArrayList<ArrayList<String>>();
		String refresh = "";
		_bdd = new BDD();
		Connection connect = _bdd.getInstance();
		Statement stm = connect.createStatement();
		String requete = "select pseudo,message,dateHeure,public,prive,destinataire from " + _str;
		ResultSet result;
		result = stm.executeQuery(requete);
		while (result.next()) {
			ArrayList<String> ajout = new ArrayList<String>();
			ajout.add(result.getString("pseudo"));
			ajout.add(result.getString("message"));
			ajout.add(result.getString("dateHeure"));
			ajout.add(result.getString("public"));
			ajout.add(result.getString("prive"));
			ajout.add(result.getString("destinataire"));
			liste.add(ajout);
		}
		result.close();
		if (liste.size() == 0) {
			refresh = "pas de message encore enregistré";
		} else {
			for (int i = 0; i < liste.size(); i++) {
				if (Integer.parseInt(liste.get(i).get(3)) == 1) {
					if (liste.get(i).get(0).equals(_pseudo)) {
						refresh += "<div class='pseudopublic'><strong> Pseudo : " + liste.get(i).get(0)
								+ "   </strong>Date du message : " + liste.get(i).get(2)
								+ "   Type du message : Public<br><em>Message : </em>" + liste.get(i).get(1)
								+ "<br><div>";
					} else {
						refresh += "<strong> Pseudo : " + liste.get(i).get(0) + "   </strong>Date du message :"
								+ liste.get(i).get(2) + "   Type du message : Public<br><em>Message : </em>"
								+ liste.get(i).get(1) + "<br><div>";
					}

					if (Integer.parseInt(liste.get(i).get(4)) == 1) {
						if (liste.get(i).get(5).equals(_pseudo)) {
							refresh += "<div class='privé'><strong> Pseudo : " + liste.get(i).get(0)
									+ "   </strong>Date du message :" + liste.get(i).get(2)
									+ "   Type du message : Privé<br><em>Message : </em>" + liste.get(i).get(1)
									+ "<br><div>";
						}
						if (liste.get(i).get(0).equals(_pseudo)) {
							refresh += "<div class='pseudoprive'><strong> Pseudo : " + liste.get(i).get(0)
									+ "   </strong>Date du message :" + liste.get(i).get(2)
									+ "   Type du message : Privé<br><em>Message : </em>" + liste.get(i).get(1)
									+ "<br><div>";
						}
					}
				}
			}
		}
		return refresh;
	}
}
