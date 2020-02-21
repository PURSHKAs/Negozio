package negozio;

public class Utente {
	
	private String IDUtente;
	private String Nome;
	private String Cognome;
	private String Cellulare;
	private boolean Status;
	private String Username;
	private String Password;
	
	
	UtenteDAO UDAO;
	Control TheController;
	
	
	public Utente() {
		
	}
	

	public Utente(String iDUtente, String nome, String cognome, String cellulare, boolean status, String username, String password) {
		super();
		setIDUtente(iDUtente);
		setNome(nome);
		setCognome(cognome);
		setCellulare(cellulare);
		setStatus(status);
		setUsername(username);
		setPassword(password);
		
	}
	
	
	
	
	public Utente Login(String username, String password) {
		Utente Logg = new Utente();
		Logg = UDAO.LoginDAO(username, password);
		if(Logg!=null) {
			return Logg;
		}else {
			return null;
		}
	}
	
	
	
	public String getIDUtente() {
		return IDUtente;
	}
	public void setIDUtente(String iDUtente) {
		IDUtente = iDUtente;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getCognome() {
		return Cognome;
	}
	public void setCognome(String cognome) {
		Cognome = cognome;
	}
	public String getCellulare() {
		return Cellulare;
	}
	public void setCellulare(String cellulare) {
		Cellulare = cellulare;
	}
	public boolean getStatus() {
		return Status;
	}
	public void setStatus(boolean status) {
		Status = status;
	}
	
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		this.Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	@Override
	public String toString() {
		return "Utente [IDUtente=" + IDUtente + ", Nome=" + Nome + ", Cognome=" + Cognome + ", Cellulare=" + Cellulare
				+ ", Status=" + Status + "]";
	}

}
