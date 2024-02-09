
package dat109.hvl.no;

public class Adresse {

	private String gateadresse;
	private int postnummer;
	private String poststed;

	public Adresse(String gateadresse, int postnummer, String poststed) {
		super();
		this.gateadresse = gateadresse;
		this.postnummer = postnummer;
		this.poststed = poststed;
	}

	public String getGateadresse() {
		return gateadresse;
	}

	public void setGateadresse(String gateadresse) {
		this.gateadresse = gateadresse;
	}

	public int getPostnummer() {
		return postnummer;
	}

	public void setPostnummer(int postnummer) {
		this.postnummer = postnummer;
	}

	public String getPoststed() {
		return poststed;
	}

	public void setPoststed(String poststed) {
		this.poststed = poststed;
	}

	@Override
	public String toString() {
		return "Adresse [gateadresse=" + gateadresse + ", postnummer=" + postnummer + ", poststed=" + poststed + "]";
	}
	
	

}
