package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertMessage {
	private BDD _bdd;
	private String _base;
	private String _pseudo;
	private String _mess;
	private String _des;
	private int _priv;
	private int _pub;
	
	public InsertMessage(){
		
	}
	
	public void go(String b, String p, String m,int priv,int pub,String des) throws SQLException{
		_base = b;
		_pseudo = p;
		_mess=m;
		_priv=priv;
		_pub=pub;
		_des=des;
		_bdd = new BDD();
		Connection connect = _bdd.getInstance();
		Statement stm = connect.createStatement();
		String requete = "insert into " + _base+" values(null,'"+_pseudo+"','"+_mess+"',NOW(),"+_priv+","+_pub+",'"+_des+"')";
		stm.executeUpdate(requete);
		
		stm.close();
		connect.close();
	}
}
