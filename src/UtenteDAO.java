package negozioDAO;
	import java.sql.*;
	import java.util.ArrayList;

import negozio.Utente;

	public class UtenteDAO extends Utente{
		
		private Connection con;
		
		
		public UtenteDAO(Connection c) {
			con = c;
		}
		
		/**
		 * Fuzioni per la ricerca e la manipolazione dell'utente.
		 */
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
						U.setUsername(result.getString(5));
						U.setPassword(result.getString(6));
						au.add(U);
					}
					return au;
				
			} catch (SQLException e) {e.printStackTrace(); return null;}

		}
		

		public void AggiungiUtente(String nome, String cognome, String cellulare, String username, String password){
			String query = "INSERT INTO utente(nome, cognome, cellulare, username, password) VALUES (?,?,?,?,?)";
			
			try {
				PreparedStatement pst = con.prepareStatement(query);
				pst.setString(1, nome);
				pst.setString(2, cognome);
				pst.setString(3, cellulare);
				pst.setString(4, username);
				pst.setString(5, password);
				pst.executeUpdate();
			}catch(SQLException e) {e.printStackTrace();}
		}
		

		public void RimuoviUtente(String ID) {
			String query = "delete from utente where idutente = ?";
			try {
				PreparedStatement pst = con.prepareStatement(query);
				pst.setString(1, ID);
				pst.executeUpdate();
			}catch (SQLException e) {e.printStackTrace();}
		}

		public void ModificaUtente(String nome, String cognome, String cellulare, String username, String password) {
			String query = "UPDATE utente SET nome=?, cognome=?, cellulare=? , username=?, password=? WHERE cellulare=?";
			try {
				PreparedStatement pst = con.prepareStatement(query);
				pst.setString(2, nome);
				pst.setString(3, cognome);
				pst.setString(4, cellulare);
				pst.setString(5, username);
				pst.setString(6, password);
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
				if(result.next()) {
				
					while(result.next()) {
						U.setIDUtente(result.getString(1));
						U.setNome(result.getString(2));
						U.setCognome(result.getString(3));
						U.setCellulare(result.getString(4));
						U.setUsername(result.getString(5));
						U.setPassword(result.getString(6));
					}
					return U;
			}
					else return null;
			} catch (SQLException e) {
				e.printStackTrace(); 
				
				return null;
				}
			
			

		}
	}
	
	


