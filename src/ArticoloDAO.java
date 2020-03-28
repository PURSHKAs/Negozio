package negozioDAO;
	import java.sql.*;
	import java.util.ArrayList;

import negozio.Articolo;

	public class ArticoloDAO extends Articolo{
		
		private Connection con;
		
		public ArticoloDAO(Connection c) {
			con = c;
		}
		
		/**
		 * Fuzioni per la ricerca e la manipolazione dell'articolo.
		 */
		
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
			
			String query = "select * from articolo where idarticolo=?";
			
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
			String query = "INSERT INTO articolo (nome, taglia, colore, scorta, prezzo) VALUES (?,?,?,?,?)";
			
			try {
				PreparedStatement pst = con.prepareStatement(query);
				pst.setString(1, nome);
				pst.setString(2, taglia);
				pst.setString(3, colore);
				pst.setInt(4, scorte);
				pst.setDouble(5, prezzo);
				pst.executeUpdate();
			}catch(SQLException e) {e.printStackTrace();}
		}
		
		public void RimuoviArticolo(String ID) {
			String query = "delete from articolo where idarticolo = ?";
			try {
				PreparedStatement pst = con.prepareStatement(query);
				pst.setString(1, ID);
				pst.executeUpdate();
			}catch (SQLException e) {e.printStackTrace();}
		}
		
		
		public void ModificaArticolo(String nome, String taglia, String colore, int scorte, double prezzo, String ID) {
			String query = "UPDATE articolo SET nome=?, taglia=?, colore=?, scorta=? , prezzo=? WHERE idarticolo=?";
			try {
				PreparedStatement pst = con.prepareStatement(query);
				pst.setString(1, nome);
				pst.setString(2, taglia);
				pst.setString(3, colore);
				pst.setInt(4, scorte);
				pst.setDouble(5, prezzo);
				pst.setString(6, ID);
				pst.executeUpdate();
			}catch(SQLException e) {e.printStackTrace();}
		}
		public void VendiArticolo( int scorte, String ID) {
			String query = "UPDATE articolo SET scorta=? WHERE idarticolo=?";
			try {
				PreparedStatement pst = con.prepareStatement(query);
				pst.setInt(1, scorte);
				pst.setString(2, ID);
				pst.executeUpdate();
			}catch(SQLException e) {e.printStackTrace();}
		}
	}


