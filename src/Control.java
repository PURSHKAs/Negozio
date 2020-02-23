package negozio;
import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class Control {
	
	
	/**
	 * MAIN.
	 */
	public static void main(String[] args) {
		Control c = new Control();
		
	}
	
	ArticoloDAO ADAO;
	ListaArticoliDAO LADAO;
	MainFrame mainFrame;
	StoreFrame SF;
	UtenteFrame UF;
	UtenteDAO UDAO;
	ListaUtentiDAO LUDAO;
	LoginFrame LF;
	Utente U;
	
	/**
	 * Costruttore.
	 */
	
	public Control() {
		Connection con = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/purshka?useSSL=false","root","123stella");
			
			
		} catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
		
		
		
		LF = new LoginFrame(this);
		ADAO = new ArticoloDAO(con);
		LADAO = new ListaArticoliDAO(con);
		LUDAO = new ListaUtentiDAO(con);
		UDAO = new UtenteDAO(con);
		mainFrame = new MainFrame(this);
		UF = new UtenteFrame(this);
		SF = new StoreFrame(this);
		LF.setVisible(true);
		
		}
	
	
	public void UtenteFrame() {
		
		UF.setVisible(true);
		MostraUtenti();
	}
	public void StoreButton() {
		SF.setVisible(true);
		MostraArticoli();
	}

	
	/**
	 * Funzione di login.
	 */
	public void LoginButton(String username, String password) {
		Utente UN;
		UN =  UDAO.LoginDAO(username, password);
		if(UN!=null) {
			MainframeAccess(UN);
		}else {
			JOptionPane.showMessageDialog(null,"Errore, credenziali invalide!!!");
		}
	}
	
	
	public void MainframeAccess(Utente U) {
		mainFrame.setVisible(true);
		LF.setVisible(false);
	}
	
	public void ErroreLogin() {
		LF.ErroreLogIn();
	}
	

	/**
	 * Funzioni per l'articolo.
	 */
	public void RicercaArticolobyNome(String Nome) {
		ArrayList<Articolo> ap = ADAO.getArticoloByNome(Nome);
		if(ap.isEmpty())
			System.out.println("Articolo non trovato");
		else
			for(Articolo a: ap) {
				System.out.println(a.toString());
			}
	}
	
	public void AggiungiArticoliaLista(String nome, String taglia, String colore, String scorte, String prezzo) {
		int scorte1 = Integer.parseInt(scorte);
		double prezzo1 = Double.parseDouble(prezzo);
		ADAO.AggiungiArticolo(nome, taglia, colore, scorte1, prezzo1);
	}
	
	
	public void RicercaArticolibyID(String IDArticolo) {
		ArrayList<Articolo> ap = ADAO.getArticoloByID(IDArticolo);
		if(ap.isEmpty())
			System.out.println("Articolo non trovato");
		else
			MostraArticoli();
	}
	
	
	public void MostraArticoli() {
		ArrayList<Articolo> ListaArticoli = LADAO.ListaArticoli();
		DefaultTableModel model = (DefaultTableModel)SF.getTable().getModel();
		Object[] row = new Object[7];
		for(int i=0; i<ListaArticoli.size(); i++) {
			row[0]=ListaArticoli.get(i).getIDArticolo();
			row[1]=ListaArticoli.get(i).getNome();
			row[2]=ListaArticoli.get(i).getTaglia();
			row[3]=ListaArticoli.get(i).getColore();
			row[4]=ListaArticoli.get(i).getScorte();
			row[5]=ListaArticoli.get(i).getPrezzo();
			model.addRow(row);
		}	
	}
	
	
	
	public void MostraArticoliByNome(String Nome) {
		ArrayList<Articolo> ListaArticoli = LADAO.ListaArticolibyNome(Nome);
		DefaultTableModel model = (DefaultTableModel)SF.getTable().getModel();
		Object[] row = new Object[6];
		for(int i=0; i<ListaArticoli.size(); i++) {
			row[0]=ListaArticoli.get(i).getIDArticolo();
			row[1]=ListaArticoli.get(i).getNome();
			row[2]=ListaArticoli.get(i).getTaglia();
			row[3]=ListaArticoli.get(i).getColore();
			row[4]=ListaArticoli.get(i).getScorte();
			row[5]=ListaArticoli.get(i).getPrezzo();
			model.addRow(row);
		}	
	}
	
	
	
	public void MostraArticoliByID(String IDArticolo) {
		ArrayList<Articolo> ListaArticoli = LADAO.ListaArticolibyID(IDArticolo);
		DefaultTableModel model = (DefaultTableModel)SF.getTable().getModel();
		Object[] row = new Object[6];
		for(int i=0; i<ListaArticoli.size(); i++) {
			row[0]=ListaArticoli.get(i).getIDArticolo();
			row[1]=ListaArticoli.get(i).getNome();
			row[2]=ListaArticoli.get(i).getTaglia();
			row[3]=ListaArticoli.get(i).getColore();
			row[4]=ListaArticoli.get(i).getScorte();
			row[5]=ListaArticoli.get(i).getPrezzo();
			model.addRow(row);
		}	
	}
	
	public void RimuoviArticolo(String IDArticolo) {
		ADAO.RimuoviArticolo(IDArticolo);
	}
	
	public void ModificaArticolo(String nome, String taglia, String colore, String scorte, String prezzo, String ID) {
		int scorte1 = Integer.parseInt(scorte);
		double prezzo1 = Double.parseDouble(prezzo);
		ADAO.ModificaArticolo(nome, taglia, colore, scorte1, prezzo1, ID );
	}
	public void VendiArticolo(String nome, String taglia, String colore, int scorte, String prezzo, String ID, int vendita) {
		scorte-=vendita;
		double prezzo1 = Double.parseDouble(prezzo);
		ADAO.ModificaArticolo(nome, taglia, colore, scorte, prezzo1, ID );
	}
	
	/**
	 * Funzioni per l'utente.
	 */
	
	public void RicercaUtentebyNome(String Nome) {
		ArrayList<Utente> af = UDAO.getUtenteByNome(Nome);
		if(af.isEmpty())
			System.out.println("Utente non trovato");
		else
			for(Utente f: af) {
				System.out.println(f.toString());
			}
	}
	
	
	public void AggiungiUtentiLista(String nome, String Cognome, String Cellulare, String username, String password) {
		UDAO.AggiungiUtente(nome, Cognome, Cellulare, username, password);
	}
	
	
	public void MostraUtenti() {
		ArrayList<Utente> ListaUtenti;
		ListaUtenti = LUDAO.ListaUtenti();
		DefaultTableModel model = (DefaultTableModel)UF.getTable().getModel();
		Object[] row = new Object[7];
		for(int i=0; i<ListaUtenti.size(); i++) {
			row[0]=ListaUtenti.get(i).getIDUtente();
			row[1]=ListaUtenti.get(i).getNome();
			row[2]=ListaUtenti.get(i).getCognome();
			row[3]=ListaUtenti.get(i).getCellulare();
			row[4]=ListaUtenti.get(i).getUsername();
			row[5]=ListaUtenti.get(i).getPassword();
			model.addRow(row);
		}	
	}
	
	public void MostraUtentiByNome(String Nome) {
		ArrayList<Utente> ListaUtenti = LUDAO.ListaUtentibyNome(Nome);
		DefaultTableModel model = (DefaultTableModel)UF.getTable().getModel();
		Object[] row = new Object[7];
		for(int i=0; i<ListaUtenti.size(); i++) {
			row[0]=ListaUtenti.get(i).getIDUtente();
			row[1]=ListaUtenti.get(i).getNome();
			row[2]=ListaUtenti.get(i).getCognome();
			row[3]=ListaUtenti.get(i).getCellulare();
			row[4]=ListaUtenti.get(i).getUsername();
			row[5]=ListaUtenti.get(i).getPassword();
			model.addRow(row);
		}	
	}
	
	public void MostraUtentiByID(String IDUtente) {
		ArrayList<Utente> ListaUtenti = LUDAO.ListaUtentibyID(IDUtente);
		DefaultTableModel model = (DefaultTableModel)UF.getTable().getModel();
		Object[] row = new Object[7];
		for(int i=0; i<ListaUtenti.size(); i++) {
			row[0]=ListaUtenti.get(i).getIDUtente();
			row[1]=ListaUtenti.get(i).getNome();
			row[2]=ListaUtenti.get(i).getCognome();
			row[3]=ListaUtenti.get(i).getCellulare();
			row[4]=ListaUtenti.get(i).getUsername();
			row[5]=ListaUtenti.get(i).getPassword();
			model.addRow(row);
		}	
	}
	
	public void RimuoviUtente(String IDUtente) {
		UDAO.RimuoviUtente(IDUtente);
	}
	
	public void ModificaUtente(String nome, String Cognome, String Cellulare, String Username, String password) {
		UDAO.ModificaUtente(nome, Cognome, Cellulare, Username, password);
	}


	public void MainframeAccess() {
		// TODO Auto-generated method stub
		
	}


	
}

