
public class Articolo {
	private String IDArticolo;
	private String Nome ;
	private String Taglia;
	private String Colore;
	private int Scorte;
	private double Prezzo;
	
	public Articolo(String iDarticolo, String nome, String taglia, String colore, int scorte, double prezzo) {
		setIDArticolo(iDarticolo);
		setNome(nome);
		setTaglia(taglia);
		setColore(colore);
		setScorte(scorte);
		setPrezzo(prezzo);
	}
	


	public Articolo() {
		// TODO Auto-generated constructor stub
	}




	public String getIDArticolo() {
		return IDArticolo;
	}

	public void setIDArticolo(String iDarticolo) {
		IDArticolo = iDarticolo;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getTaglia() {
		return Taglia;
	}

	public void setTaglia(String taglia) {
		Taglia = taglia;
	}

	public String getColore() {
		return Colore;
	}

	public void setColore(String colore) {
		Colore = colore;
	}

	public int getScorte() {
		return Scorte;
	}

	public void setScorte(int scorte) {
		Scorte = scorte;
	}

	public double getPrezzo() {
		return Prezzo;
	}

	public void setPrezzo(double prezzo) {
		Prezzo = prezzo;
	}

	
	@Override
	public String toString() {
		String s = IDArticolo + " " +Nome+ " " +Taglia+ " " +Colore+ " " +Scorte+ " " +Prezzo;
		return s;
	}
	
}
