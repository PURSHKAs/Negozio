	import java.sql.*;
	import java.util.ArrayList;

	public class ArticoloDAO {
		
		private Connection con;
		
		public ArticoloDAO(Connection c) {
			con = c;
		}
		
		public ArrayList<Articolo> getArticoloByNome(String Nome) {
			
			ResultSet result;
			Articolo A;
			ArrayList<Articolo> ap = new ArrayList<Articolo>();
			
			String query = "select * from articolo where nome=?";
			
			try {
				PreparedStatement pst = con.prepareStatement(query);
				pst.setString(1,Nome);
				result = pst.executeQuery();
				
					while(result.next()) {
						A = new Articolo();
						A.setIDArticolo(result.getString(1));
						A.setNome(result.getString(2));
						A.setTaglia(result.getString(3));
						A.setColore(result.getString(4));
						A.setScorte(result.getInt(5));
						A.setPrezzo(result.getDouble(6));
						ap.add(A);
					}
					return ap;
				
			} catch (SQLException e) {e.printStackTrace(); return null;}

		}
		
public ArrayList<Articolo> getArticoloByID(String id) {
			
			ResultSet result;
			Articolo A;
			ArrayList<Articolo> ap = new ArrayList<Articolo>();
			
			String query = "select * from articolo where id=?";
			
			try {
				PreparedStatement pst = con.prepareStatement(query);
				pst.setString(1,id);
				result = pst.executeQuery();
				
					while(result.next()) {
						A = new Articolo();
						A.setIDArticolo(result.getString(1));
						A.setNome(result.getString(2));
						A.setTaglia(result.getString(3));
						A.setColore(result.getString(4));
						A.setScorte(result.getInt(5));
						A.setPrezzo(result.getDouble(6));
						ap.add(A);
					}
					return ap;
				
			} catch (SQLException e) {e.printStackTrace(); return null;}

		}
		
		public void AggiungiArticolo(String nome, String taglia, String colore, int scorte, double prezzo){
			
			ResultSet result;
			String query = "INSERT INTO articolo (Nome,Cognome,Fisso,Cellulare) VALUES (?,?,?,?)";
			
			try {
				PreparedStatement pst = con.prepareStatement(query);
				pst.setString(1, nome);
				pst.setString(2, taglia);
				pst.setString(3, colore);
				pst.setInt(4, scorte);
				pst.setDouble(4, prezzo);
				result = pst.executeQuery();
			}catch(SQLException e) {e.printStackTrace();}
		}
		
		public void RimuoviArticolo(int ID) {
			ResultSet result;
			String query = "delete from articolo where id = ?";
			try {
				PreparedStatement pst = con.prepareStatement(query);
				pst.setInt(1, ID);
				result = pst.executeQuery();
			}catch (SQLException e) {e.printStackTrace();}
		}
		
		
		public void ModificaArticolo(String nome, String taglia, String colore, int scorte, double prezzo) {
			ResultSet result;
			String query = "UPDATE articolo SET nome=?, Cognome=?, Fisso=?, Cellulare=? WHERE id=?";
			try {
				PreparedStatement pst = con.prepareStatement(query);
				pst.setString(1, nome);
				pst.setString(2, taglia);
				pst.setString(3, colore);
				pst.setInt(4, scorte);
				pst.setDouble(4, prezzo);
				result = pst.executeQuery();
			}catch(SQLException e) {e.printStackTrace();}
		}
	}


