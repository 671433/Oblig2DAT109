package dat109.hvl.no;

import java.util.Arrays;

public class Bil {
	private String regnr;
	private String merke;
	private String farge;
	private String model;
	private int kilometerstand;

	private Utleiekontor Utleiekontor;

	private Utleiegrupper bilGruppe;

	private Utleiestatus[] dayCal = new Utleiestatus[366];
	
	private Kunde leidAvKund;

	/**
	 * Bil constructor med Utleiestatus blir satt til ledig som default
	 * 
	 * @param regnr
	 * @param merke
	 * @param farge
	 * @param model
	 * @param utleiekontor
	 * @param bilGruppe    Enum gruppe
	 * @param leidAvKunde
	 */

	public Bil(String regnr, String merke, String farge, String model, Utleiekontor utleiekontor,
			Utleiegrupper bilGruppe, Kunde leidAvKunde) {
		super();
		for (Utleiestatus d : dayCal) {
			d = new Utleiestatus();
		}

		this.regnr = regnr;
		this.merke = merke;
		this.farge = farge;
		this.model = model;
		Utleiekontor = utleiekontor;
		this.bilGruppe = bilGruppe;
		kilometerstand = 200000;
		this.leidAvKund = leidAvKunde;

	}

	public Bil(String regnr, String merke, String farge, String model, Utleiegrupper bilGruppe) {
		super();
		this.regnr = regnr;
		this.merke = merke;
		this.farge = farge;
		this.model = model;
		this.bilGruppe = bilGruppe;
		kilometerstand = 200000;

		for (Utleiestatus d : dayCal) {
			d = new Utleiestatus();
		}
	}

	/**
	 * Sjekk Utleie status for dato gitt i dagsnr pr år
	 * 
	 * @param dag
	 * @return boolean true om ledig dag
	 */

	public boolean sjekkUtleieStatusForDato(int dag) {

		return dayCal[dag].sjekkUtleieStatus();
	}

	/**
	 * Reserverer bil for gitt rekke med dager fra stasrt til slutt
	 * 
	 * sjekker utleiestatus via sjekkUtleieStatus() før input
	 * 
	 * @param kunde
	 * @param start    startdag gitt i dagsnr i påstasrtet år
	 * @param sluttdag gitt i dagsnr i påstasrtet år
	 * @return true om registrering gikk som forventet
	 */

	
	
	
	
	public Kunde hentKundeReservasjon(int start) {
		return dayCal[start].getKunde();
		
	}

	public boolean Reserver(Kunde kunde, int start, int sluttdag) {

		for (int i = start; i <= sluttdag; i++) {

			if (dayCal[i].sjekkUtleieStatus() == false) {

				return false;
			}
		}

		for (int i = start; i <= sluttdag; i++) {

			dayCal[i].Reserver(kunde);

		}
		return true;

	}

	/**
	 * Reserverer bil i antall dager sat med dagsnr i gitt år
	 * 
	 * @param kunde
	 * @param start
	 * @param antallDager
	 * @return
	 */

	public boolean ReserverAntallDager(Kunde kunde, int start, int antallDager) {

		for (int i = start; i <= start + antallDager; i++) {

			if (dayCal[i].sjekkUtleieStatus() == false) {

				return false;
			}
		}

		for (int i = start; i <= start + antallDager; i++) {

			dayCal[i].Reserver(kunde);

		}
		return true;

	}

	 int[] hentAntallDagerReservert(Kunde kunde) {
		int[] startOgAntallDager = new int[2];

		for (int i = 0; i < 366; i++) {

			if (dayCal[i].getKunde() == kunde) {
				startOgAntallDager[0] = i;

				while (dayCal[i].getKunde() == kunde) {

					startOgAntallDager[1] += 1;

				}

			}
		}
		return startOgAntallDager;

	}

	/**
	 * /** Lever ut bil Bil er gitt til kunde og er faktisk i bruk og ikke bare
	 * reservert
	 * 
	 * @param kunde
	 * @param dag
	 * @return boolean for suksessfull utleie av bil
	 */
	public boolean utleverBil(Kunde kunde, int dag) {

		return dayCal[dag].LeiUt(kunde);
	}

	/**
	 * BIl inlevert
	 * 
	 * @param kunde
	 * @param dag
	 * @return suksessfull innlevering gir boolean true
	 */

	public Kunde hentKundeSalg(int dag) {

		return dayCal[dag].getKunde();

	}

	public boolean LeverInnBil(Kunde kunde, int dag) {

		return dayCal[dag].LeverInn(kunde);

		// lagFaktura();
	}

	public String getMerke() {
		return merke;
	}

	public void setMerke(String merke) {
		this.merke = merke;
	}

	public String getFarge() {
		return farge;
	}

	public void setFarge(String farge) {
		this.farge = farge;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Utleiekontor getUtleiekontor() {
		return Utleiekontor;
	}

	public void setUtleiekontor(Utleiekontor utleiekontor) {
		Utleiekontor = utleiekontor;
	}

	public String getRegnr() {
		return regnr;
	}

	public void setRegnr(String regnr) {
		this.regnr = regnr;
	}

	public Utleiegrupper getBilGruppe() {
		return bilGruppe;
	}

	public void setBilGruppe(Utleiegrupper bilGruppe) {
		this.bilGruppe = bilGruppe;
	}

	public int getKilometerstand() {
		return kilometerstand;
	}

	public void setKilometerstand(int kilometerstand) {
		this.kilometerstand = kilometerstand;
	}

	public Utleiestatus[] getDayCal() {
		return dayCal;
	}

	public void setDayCal(Utleiestatus[] dayCal) {
		this.dayCal = dayCal;
	}

	public Kunde getLeidAvKund() {
		return leidAvKund;
	}

	public void setLeidAvKund(Kunde leidAvKund) {
		this.leidAvKund = leidAvKund;
	}

	@Override
	public String toString() {
		return "Bil [regnr=" + regnr + ", merke=" + merke + ", farge=" + farge + ", model=" + model
				+ ", kilometerstand=" + kilometerstand + ", Utleiekontor=" + Utleiekontor + ", bilGruppe=" + bilGruppe
				+  "]";
	}
	
	
	

}
