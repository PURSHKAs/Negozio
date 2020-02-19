
public class Articolo {
	private String IDArticolo;
	private String Indumento ;
	private String Taglia;
	private String Colore;
	private int Scorte;
	private double Prezzo;
	
	public Articolo(String iDarticolo, String indumento, String taglia, String colore, int scorte, double prezzo) {
		setIDArticolo(iDarticolo);
		setIndumento(indumento);
		setTaglia(taglia);
		setColore(colore);
		setScorte(scorte);
		setPrezzo(prezzo);
	}
	
	
	public String getIDArticolo() {
		return IDArticolo;
	}

	public void setIDArticolo(String iDarticolo) {
		IDArticolo = iDarticolo;
	}

	public String getIndumento() {
		return Indumento;
	}

	public void setIndumento(String indumento) {
		Indumento = indumento;
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
		String s = IDArticolo + " " +Indumento+ " " +Taglia+ " " +Colore+ " " +Scorte+ " " +Prezzo;
		return s;
	}
	
}
