package dat109.hvl.no;

public class Person {

	private String fornavn;
	private String etternavn;
	private String telefonnummer;

	private Adresse adresse;

	public Person(String fornavn, String etternavn, String telefonnummer, Adresse adresse) {
		super();
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.telefonnummer = telefonnummer;
		this.adresse = adresse;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getTelefonnummer() {
		return telefonnummer;
	}

	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Person [fornavn=" + fornavn + ", etternavn=" + etternavn + ", telefonnummer=" + telefonnummer
				+ ", adresse=" + adresse + "]";
	}

	
}
