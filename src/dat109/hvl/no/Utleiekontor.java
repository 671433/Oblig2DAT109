package dat109.hvl.no;

public class Utleiekontor {
	
	private String kontornavn;
	private String telefonnummer;
	private Adresse firmaadresse;
	
	private Bilutleieselskap hk;
	
	
	public Utleiekontor(String kontornavn, String telefonnummer, Adresse firmaadresse) {
		super();
		this.kontornavn = kontornavn;
		this.telefonnummer = telefonnummer;
		this.firmaadresse = firmaadresse;
		
	}

	void leieUtBil(Bil bil){
		
	}
	
	void taIMotBil() {
		
		
		
	}

	@Override
	public String toString() {
		return "Utleiekontor [kontornavn=" + kontornavn + ", telefonnummer=" + telefonnummer + ", firmaadresse="
				+ firmaadresse + "]";
	}
	
	
	
}
