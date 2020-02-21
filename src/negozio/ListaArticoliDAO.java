package negozio;
import java.util.*;
import java.sql.*;

public class ListaArticoliDAO extends ListaArticoli{
	
	private Connection con;
	
	public ListaArticoliDAO(Connection c) {
		con = c;
	}
	
	public ArrayList<Articolo> ListaArticoli(){
		
			ResultSet result;
			Articolo A;
			ArrayList<Articolo> ap = new ArrayList<Articolo>();
			
			String query = "select * from articolo ";
			
		try {
			
			PreparedStatement pst = con.prepareStatement(query);
			result = pst.executeQuery();
			
			while(result.next())
			{
				A = new Articolo(result.getString("idarticolo"), result.getString("nome"), result.getString("taglia"), result.getString("colore"), result.getInt("scorta"), result.getDouble("prezzo"));
				ap.add(A);
			}
		} catch (SQLException e ) {e.printStackTrace();}
		return ap;
	}
	
	public ArrayList<Articolo> ListaArticolibyNome(String Nome){
		
		ResultSet result;
		Articolo A;
		ArrayList<Articolo> ap = new ArrayList<Articolo>();
		String query = null;
		
			query = "select * from articolo where nome=?";
		
	try {
		
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1,Nome);
		result = pst.executeQuery();
		
		while(result.next())
		{
			A = new Articolo(result.getString("idarticolo"), result.getString("nome"), result.getString("taglia"), result.getString("colore"), result.getInt("scorta"), result.getDouble("prezzo"));
			ap.add(A);
		}
	} catch (SQLException e ) {e.printStackTrace();}
	return ap;
}
	
	public ArrayList<Articolo> ListaArticolibyID(String ID){
		
		ResultSet result;
		Articolo A;
		ArrayList<Articolo> ap = new ArrayList<Articolo>();
		String query = null;
		
			query = "select * from articolo where idarticolo=?";
		
	try {
		
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1,ID);
		result = pst.executeQuery();
		
		while(result.next())
		{
			A = new Articolo(result.getString("idarticolo"), result.getString("nome"), result.getString("taglia"), result.getString("colore"), result.getInt("scorta"), result.getDouble("prezzo"));
			ap.add(A);
		}
	} catch (SQLException e ) {e.printStackTrace();}
	return ap;
}
}
