package dat109.hvl.no;

public class Faktura {
	
	
	
//	private Salg salg;
	
	
private	Kunde kunde;
private	Bil bil;
	
	private int startDagUtlevert,sluttDagInnlevert,antallDager,pris;
	
	/**
	 * Laget faktura 
	 * 
	 * 
	 * 
	 * @param kunde
	 * @param bil
	 * @param startDagUtlevert
	 * @param sluttDagInnlevert
	 * @param antallDager
	 * @param pris
	 */
	
 public Faktura(
		 Kunde kunde, 
		 Bil bil, 
		 int startDagUtlevert, 
		 int  sluttDagInnlevert,
		 int antallDager,
		 int pris) {
	 
	 
	this.kunde=kunde;
	this.bil=bil;
	this.startDagUtlevert=startDagUtlevert;
	this.sluttDagInnlevert=sluttDagInnlevert;
	this.antallDager=antallDager;
	this.pris=pris;
	
 }
 
	
 
	
	
	 
	 
	 
	 
	 
	 
	 

}
