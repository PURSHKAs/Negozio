package negozio;
import java.util.*;
import java.sql.*;

public class ListaUtentiDAO extends ListaUtenti{
	
	private Connection con;
	
	public ListaUtentiDAO(Connection c) {
		con = c;
	}
	
	
	/**
	 * Fuzioni per la ricerca e la manipolazione della lista utenti.
	 */
	public ArrayList<Utente> ListaUtenti(){
		
			ResultSet result;
			Utente A;
			ArrayList<Utente> ap = new ArrayList<Utente>();
			
			String query = "select * from utente ";
			
		try {
			
			PreparedStatement pst = con.prepareStatement(query);
			result = pst.executeQuery();
			
			while(result.next())
			{
				A = new Utente(result.getString("idutente"), result.getString("nome"), result.getString("cognome"), result.getString("cellulare"), result.getBoolean("status"), result.getString("username"), result.getString("password"));
				ap.add(A);
			}
		} catch (SQLException e ) {e.printStackTrace();}
		return ap;
	}
	
	public ArrayList<Utente> ListaUtentibyNome(String Nome){
		
		ResultSet result;
		Utente A;
		ArrayList<Utente> ap = new ArrayList<Utente>();
		String query = null;
		
			query = "select * from utente where nome=?";
		
	try {
		
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1,Nome);
		result = pst.executeQuery();
		
		while(result.next())
		{
			A = new Utente(result.getString("idutente"), result.getString("nome"), result.getString("cognome"), result.getString("cellulare"), result.getBoolean("status"), result.getString("username"), result.getString("password"));
			ap.add(A);
		}
	} catch (SQLException e ) {e.printStackTrace();}
	return ap;
}
	
public ArrayList<Utente> ListaUtentibyID(String ID){
		
		ResultSet result;
		Utente A;
		ArrayList<Utente> ap = new ArrayList<Utente>();
		String query = null;
		
			query = "select * from utente where idutente=?";
		
	try {
		
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1,ID);
		result = pst.executeQuery();
		
		while(result.next())
		{
			A = new Utente(result.getString("idutente"), result.getString("nome"), result.getString("cognome"), result.getString("cellulare"), result.getBoolean("status"), result.getString("username"), result.getString("password"));
			ap.add(A);
		}
	} catch (SQLException e ) {e.printStackTrace();}
	return ap;
}
}
