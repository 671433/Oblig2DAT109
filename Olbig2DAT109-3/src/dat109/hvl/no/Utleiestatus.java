package dat109.hvl.no;

public class Utleiestatus {
	private Kunde kunde;

	private boolean reservert;
	private boolean utleid;
	private boolean ledig;
	private boolean fakturert;


	/**
	 * Dette er et kalenderobjeklt som representerer en dag i 365 kalenderen
	 * 
	 * Utleiestatus blir satt til ledig som default
	 * andre statuser er reservert, utleid og fakturert, alle boolean
	 * objektet blir knytt til kunde objekt
	 * 
	 */
	
	public Utleiestatus() {
		super();
		this.kunde = null;
		this.reservert = false;
		this.utleid = false;
		this.ledig = true;
		this.fakturert = false;
	}

	/**
	 * 
	 * Sjekk ut leie status for gitt dag
	 * 
	 * return true betyr ledig
	 */
	
	public boolean sjekkUtleieStatus() {

		if (this.reservert == false || this.utleid == false) {
			return true;
		}
		return false;

	}
	
	/**
	 * 
	 * Reserver for gitt dag om ikke reservert fra før av anen kunde  eller utleid
	 * 
	 * @param kunde
	 * @return true om siksessfull reservasjon
	 */

	boolean Reserver(Kunde kunde) {
		if (this.reservert == false || this.utleid == false) {
			this.kunde = kunde;
			this.reservert = true;
			this.utleid = false;
			this.ledig = true;
			this.fakturert = false;
			

			return true;
		} else {
			return false;
		}

	}
	/**
	 * 
	 * Leiu ut bil til kunde  på dag om bilen er tilgjengelig 
	 * 
	 * 
	 * 
	 * @param kunde
	 * @return true om suksess
	 */

	boolean LeiUt(Kunde kunde) {

		if (this.reservert == false) {

			this.kunde = kunde;
			this.reservert = false;
			this.utleid = true;
			this.ledig = false;
			this.fakturert = false;

			return true;

		}

		else if (this.reservert == true && this.kunde == kunde) {
			this.kunde = kunde;
			this.reservert = false;
			this.utleid = true;
			this.ledig = false;
			this.fakturert = false;

			return true;
		}

		else if (this.reservert == true && this.kunde != kunde || this.utleid == true) {

			return false;

		}
		return false;
	}

	/**
	 * Lever inn bil 
	
	 * @param kunde
	 * @return
	 */
	boolean LeverInn(Kunde kunde) {
		if (this.kunde == kunde) {
			this.kunde = kunde;
			this.reservert = false;
			this.utleid = false;
			this.ledig = true;
			this.fakturert = false;

			
			return true;
		} else {
			return false;
		}

	}

	public Kunde getKunde() {
		return kunde;
	}

	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}

	public boolean isReservert() {
		return reservert;
	}

	public void setReservert(boolean reservert) {
		this.reservert = reservert;
	}

	public boolean isUtleid() {
		return utleid;
	}

	public void setUtleid(boolean utleid) {
		this.utleid = utleid;
	}

	public boolean isLedig() {
		return ledig;
	}

	public void setLedig(boolean ledig) {
		this.ledig = ledig;
	}

	public boolean isFakturert() {
		return fakturert;
	}

	public void setFakturert(boolean fakturert) {
		this.fakturert = fakturert;
	}

	
	
}
