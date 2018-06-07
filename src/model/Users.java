package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Users {
	private String _pseudo;
	private String _mdp;
	private BDD _bdd;
	
	public Users(String pse) {
		_pseudo=pse;
		
	}
	
	/*vérifie si l'utilisateur est dans la bdd*/
	public ArrayList<String> verif(String pse,String str) throws SQLException {
		ArrayList<String> liste = new ArrayList<String>();
		_bdd= new BDD();
		Connection connect=_bdd.getInstance();
		Statement stm = connect.createStatement();
		String requete="select pseudo from "+str+" where pseudo='"+pse+"'";
		ResultSet result;
		result = stm.executeQuery(requete);
		while (result.next()) {
			liste.add(result.getString("pseudo"));			
		}
		result.close();
		stm.close();
		connect.close();
		return liste;	
	}
	public ArrayList<String> verif_mdp(String pse,String str) throws SQLException {
		ArrayList<String> liste = new ArrayList<String>();
		_bdd= new BDD();
		Connection connect=_bdd.getInstance();
		Statement stm = connect.createStatement();
		String requete="select pseudo,mdp from "+str+" where pseudo='"+pse+"'";
		ResultSet result;
		result = stm.executeQuery(requete);
		while (result.next()) {
			liste.add(result.getString("pseudo"));
			liste.add(result.getString("mdp"));
		}
		result.close();
		stm.close();
		connect.close();
		return liste;	
	}
	
	public boolean creer(String pseudo,String mdp) throws SQLException {
		_pseudo=pseudo;
		_mdp= mdp;
		
		/*encodage md5 du password*/
		_mdp=Md5.encode(mdp);
		
		/*on vérifie si le compte existe dans la bdd*/
		ArrayList<String> verif = verif(_pseudo,"utilisateurs");
		
		if(verif.size()==0) {
			_bdd= new BDD();
			Connection connect=_bdd.getInstance();
			Statement stm = connect.createStatement();
			String requete="insert into utilisateurs values(NULL,'"+_pseudo+"','"+_mdp+"',NOW(),1)";
			stm.executeUpdate(requete);
			stm.close();
			connect.close();
			return true;			
		}
		else {
			return false;
		}
	}
	
	public void updateConnect(String pseudo,int i) throws SQLException{
		_bdd= new BDD();
		Connection connect=_bdd.getInstance();
		Statement stm = connect.createStatement();
		String requete="update utilisateurs set connect="+i+" where pseudo='"+pseudo+"'";
		stm.executeUpdate(requete);
		stm.close();
		connect.close();
	}
	
	public void insert_bddInstant(String pseudo,String str) throws SQLException{
		ArrayList<String> verif = verif(_pseudo,str);
		if(verif.size()==0) {
			_bdd= new BDD();
			Connection connect=_bdd.getInstance();
			Statement stm = connect.createStatement();
			String requete="insert into "+str+" values(NULL,'"+pseudo+"')";
			stm.executeUpdate(requete);
			stm.close();
			connect.close();
			}
	}
	
	public void delete_bddInstant(String pseudo,String str) throws SQLException{	
		
			_bdd= new BDD();
			Connection connect=_bdd.getInstance();
			Statement stm = connect.createStatement();
			String requete="delete from "+str+" where pseudo='"+pseudo+"'";
			stm.executeUpdate(requete);
			stm.close();
			connect.close();
	}
	
}
