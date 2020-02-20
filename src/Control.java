package negozio;
import java.sql.*;
import java.util.*;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class Control {

	public static void main(String[] args) {
		Control c = new Control();
		
	}
	
	ArticoloDAO ADAO;
	ListaArticoliDAO LADAO;
	MainFrame mainFrame;
	StoreFrame SF;
	FornitoreFrame FF;
	FornitoreDAO FDAO;
	ListaFornitoriDAO LFDAO;
	Utente U;
	
	public Control() {
		Connection con = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/purshka?useSSL=false","root","123stella");
			
			
		} catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
		
		ADAO = new ArticoloDAO(con);
		LADAO = new ListaArticoliDAO(con);
		mainFrame = new MainFrame(this);
		FF = new FornitoreFrame(this);
		SF = new StoreFrame(this);
		mainFrame.setVisible(true);
		
	}
	
	public void FornitoreButton() {
		FF.setVisible(true);
		MostraFornitori();
	}
	public void StoreButton() {
		SF.setVisible(true);
		MostraArticoli();
	}
	
	public boolean LoginButton(String username, String password) {
		if(U.Login(username, password)==true) {
			return true;
		}else {
			return false;
		}
		
	}
	
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
	
	public void RimuoviArticolo(int IDArticolo) {
		ADAO.RimuoviArticolo(IDArticolo);
	}
	
	public void ModificaArticolo(String nome, String taglia, String colore, String scorte, String prezzo) {
		int scorte1 = Integer.parseInt(scorte);
		double prezzo1 = Double.parseDouble(prezzo);
		ADAO.ModificaArticolo(nome, taglia, colore, scorte1, prezzo1 );
	}
	
	public void RicercaFornitorebyNome(String Nome) {
		ArrayList<Fornitore> af = FDAO.getFornitoreByNome(Nome);
		if(af.isEmpty())
			System.out.println("Fornitore non trovato");
		else
			for(Fornitore f: af) {
				System.out.println(f.toString());
			}
	}
	
	public void AggiungiFornitoriaLista(String nome, String pi, String sede) {
		FDAO.AggiungiFornitore(nome, pi, sede);
	}
	
	public void RicercaFornitoribyID(String IDFornitore) {
		ArrayList<Fornitore> af = FDAO.getFornitoreByID(IDFornitore);
		if(af.isEmpty())
			System.out.println("Fornitore non trovato");
		else
			MostraFornitori();
	}
	
	public void MostraFornitori() {
		ArrayList<Fornitore> ListaFornitori;
		ListaFornitori = LFDAO.ListaFornitori();
		DefaultTableModel model = (DefaultTableModel)FF.getTable().getModel();
		Object[] row = new Object[5];
		for(int i=0; i<ListaFornitori.size(); i++) {
			row[0]=ListaFornitori.get(i).getIDFornitore();
			row[1]=ListaFornitori.get(i).getNome();
			row[2]=ListaFornitori.get(i).getPI();
			row[3]=ListaFornitori.get(i).getSede();
			model.addRow(row);
		}	
	}
	
	public void MostraFornitoriByNome(String Nome) {
		ArrayList<Fornitore> ListaFornitori = LFDAO.ListaFornitoribyNome(Nome);
		DefaultTableModel model = (DefaultTableModel)FF.getTable().getModel();
		Object[] row = new Object[6];
		for(int i=0; i<ListaFornitori.size(); i++) {
			row[0]=ListaFornitori.get(i).getIDFornitore();
			row[1]=ListaFornitori.get(i).getNome();
			row[2]=ListaFornitori.get(i).getPI();
			row[3]=ListaFornitori.get(i).getSede();
			model.addRow(row);
		}	
	}
	
	public void MostraFornitoriByID(String IDFornitore) {
		ArrayList<Fornitore> ListaFornitori = LFDAO.ListaFornitoribyID(IDFornitore);
		DefaultTableModel model = (DefaultTableModel)FF.getTable().getModel();
		Object[] row = new Object[6];
		for(int i=0; i<ListaFornitori.size(); i++) {
			row[0]=ListaFornitori.get(i).getIDFornitore();
			row[1]=ListaFornitori.get(i).getNome();
			row[2]=ListaFornitori.get(i).getPI();
			row[3]=ListaFornitori.get(i).getSede();
			model.addRow(row);
		}	
	}
	
	public void RimuoviFornitore(int IDFornitore) {
		FDAO.RimuoviFornitore(IDFornitore);
	}
	
	public void ModificaFornitore(String nome, String pi, String sede) {
		FDAO.ModificaFornitore(nome, pi, sede);
	}
}

