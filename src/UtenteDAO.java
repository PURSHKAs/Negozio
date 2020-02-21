package negozio;
	import java.sql.*;
	import java.util.ArrayList;

	public class UtenteDAO extends Utente{
		
		private Connection con;
		
		public UtenteDAO(Connection c) {
			con = c;
		}
		
		public ArrayList<Utente> getUtenteByNome(String Nome) {
			
			ResultSet result;
			Utente U;
			ArrayList<Utente> au = new ArrayList<Utente>();
			
			String query = "select * from utente where nome=?";
			
			try {
				PreparedStatement pst = con.prepareStatement(query);
				pst.setString(1,Nome);
				result = pst.executeQuery();
				
					while(result.next()) {
						U = new Utente();
						U.setIDUtente(result.getString(1));
						U.setNome(result.getString(2));
						U.setCognome(result.getString(3));
						U.setCellulare(result.getString(4));
						U.setStatus(result.getBoolean(5));
						U.setUsername(result.getString(6));
						U.setPassword(result.getString(7));
						au.add(U);
					}
					return au;
				
			} catch (SQLException e) {e.printStackTrace(); return null;}

		}
		

		
		public void AggiungiUtente(String nome, String cognome, String cellulare, boolean status, String username, String password){
			String query = "INSERT INTO utente(nome, cognome, cellulare, status, username, password) VALUES (?,?,?,?,?,?)";
			
			try {
				PreparedStatement pst = con.prepareStatement(query);
				pst.setString(1, nome);
				pst.setString(2, cognome);
				pst.setString(3, cellulare);
				pst.setBoolean(4, status);
				pst.setString(5, username);
				pst.setString(6, password);
				pst.executeUpdate();
			}catch(SQLException e) {e.printStackTrace();}
		}
		
		public void RimuoviUtente(int ID) {
			String query = "delete from utente where idutente = ?";
			try {
				PreparedStatement pst = con.prepareStatement(query);
				pst.setInt(1, ID);
				pst.executeUpdate();
			}catch (SQLException e) {e.printStackTrace();}
		}
		
		
		public void ModificaUtente(String nome, String cognome, String cellulare, boolean status, String username, String password) {
			String query = "UPDATE utente SET nome=?, cognome=?, cellulare=?, status=? , username=?, password=? WHERE cellulare=?";
			try {
				PreparedStatement pst = con.prepareStatement(query);
				pst.setString(1, nome);
				pst.setString(2, cognome);
				pst.setString(3, cellulare);
				pst.setBoolean(4, status);
				pst.setString(5, username);
				pst.setString(6, password);
				pst.setString(7, cellulare);
				pst.executeUpdate();
			}catch(SQLException e) {e.printStackTrace();}
		}
		
		public Utente LoginDAO(String username, String password) {
			ResultSet result;
			Utente U= new Utente();
			
			String query = "select * from utente where username=? and password=?";
			
			try {
				
				PreparedStatement pst = con.prepareStatement(query);
				pst.setString(1,username);
				pst.setString(2, password);
				result = pst.executeQuery();
				
					while(result.next()) {
						U.setIDUtente(result.getString(1));
						U.setNome(result.getString(2));
						U.setCognome(result.getString(3));
						U.setCellulare(result.getString(4));
						U.setStatus(result.getBoolean(5));
						U.setUsername(result.getString(6));
						U.setPassword(result.getString(7));
					}
					return U;
			} catch (SQLException e) {
				e.printStackTrace(); 
				
				return null;
				}
			
			

		}
	}
	
	


