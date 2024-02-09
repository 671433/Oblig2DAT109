package dat109.hvl.no;

public class Salg {

	// ved utlevering
	private Kunde kunde;

	private Bil bil;

	private int startDagUtlevert, sluttDagInnlevert, startReservert, sluttReservert;

	int kilometerstandVedUtlaan, kilometerstandinnLevering;

	Faktura faktura;

	/**
	 * Registrer salg altsaa Utlevert bil
	 * kunde og start dag
	 * 
	 * pris blir satt ved inllevert bil i inllever og fakturer metoden
	 * 
	 * @param kunde
	 * @param startDagUtlevert
	 */
	public void registrerSalg(Kunde kunde, int startDagUtlevert) {

		kunde = bil.hentKundeSalg(startDagUtlevert);
		int[] hentAntallDagerReservert = bil.hentAntallDagerReservert(kunde);
		startReservert = hentAntallDagerReservert[0];
		sluttReservert = hentAntallDagerReservert[1];
		this.startDagUtlevert = startDagUtlevert;
		sluttDagInnlevert = 0;
		kilometerstandVedUtlaan = bil.getKilometerstand();
		kilometerstandinnLevering = 0;

	}

	/**
	 * Innlever og fakturer bil
	 * 
	 * pris blir her satt og faktura generert og lagt i kunde faktura listen
	 * 
	 * @param bil
	 */

	public void InnleverOgFakturer(Bil bil) {

		kilometerstandinnLevering = 100;

		bil.setKilometerstand(kilometerstandinnLevering);

		kilometerstandinnLevering = bil.getKilometerstand();

		int antallKilometer = kilometerstandinnLevering - kilometerstandVedUtlaan;

		int antallDager = sluttDagInnlevert - startDagUtlevert;

		int utleiegruppe = bil.getBilGruppe().getPris();
		int pris = antallDager * utleiegruppe;

		faktura = new Faktura(kunde, bil, startDagUtlevert, sluttDagInnlevert, antallDager, pris);

		kunde.setFakturaliste(faktura);

	}

}
