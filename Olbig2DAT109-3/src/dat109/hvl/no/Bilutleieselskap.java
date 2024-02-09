package dat109.hvl.no;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bilutleieselskap {

	private Adresse bilUtleieSelskapAdresse;

	private int telefonnr;

	private List<Konsulent> konsulentListe;

	private List<Kunde> kundeListe;

	private List<Utleiekontor> utleiekontor;

	private List<Bil> bilListe;
	
	private Utleiestatus utleiestatus;

	public Bilutleieselskap(Adresse adresse,int telefonnr) {
		super();
		this.bilUtleieSelskapAdresse = adresse;
		this.telefonnr=telefonnr;

		konsulentListe = new ArrayList<Konsulent>();
		kundeListe = new ArrayList<Kunde>();
		utleiekontor = new ArrayList<Utleiekontor>();
		bilListe = new ArrayList<Bil>();

	}
	
	
	
	public void logginn() {
		
		valgKontorOgKonsulent();
		Scanner scanner = new Scanner(System.in);
		
		
		
		while( true) {
			System.out.println("Skriv 1 for å logge inn \n"
					+ "Skriv 2 for å registrere bruker \n"
					+ "Skriv 3 for å avslutte programet");
			int valg = scanner.nextInt();
			
			if (valg == 1 || valg == 2 ) {
				if (valg == 1) {
					System.out.println("Skriv inn telefonnummer for å logge inn.");
					String telefonNr= scanner.nextLine();
					if(kundeListe.stream().
							filter(k->k.getPerson().getTelefonnummer().equals(telefonNr))
							.findFirst().isPresent()) {
						innlogget(kundeListe.stream().
								filter(k->k.getPerson().getTelefonnummer().equals(telefonNr))
								.findFirst().get(), scanner);
						
					}

				}
				
			if(valg == 2 ) {
				Kunde kunde = registreKunde(scanner);
				if (kunde != null) {
					innlogget(kunde, scanner);
				}
			}else {
				System.out.println("Skriv inn riktig nummer!");

			}
			}
			
		}
	}
	
	
	private Kunde registreKunde(Scanner scanner) {
		System.out.println("Skriv inn fornavn:");
		String fornavn = scanner.next();
		
		System.out.println("Skriv inn etternavn:");
		String ettternavn = scanner.next();
		
		System.out.println("Skriv inn telefonnummer: ");
		String telefonnummer = scanner.next();
		
		System.out.println("Skriv inn gateadresse: ");
		String gateadresse = scanner.next();
		
		System.out.println("Skriv inn postnummer: ");
		String stringpostnummer = scanner.next();
		   int postnummer = 0;
	        try {
	            postnummer = Integer.parseInt(stringpostnummer);
	        } catch (NumberFormatException e) {
	            System.out.println("Ugyldig postnummer. Vennligst skriv inn et heltall.");
	        }
		
		System.out.println("Skriv inn poststed: ");
		String poststed = scanner.next();
		
		Adresse adresse = new Adresse(gateadresse, postnummer, poststed);
		
		Person person = new Person(fornavn, ettternavn, telefonnummer, adresse);
		
		Kunde kunde = new Kunde(person);
		kundeListe.add(kunde);
		
		System.out.println("Din konto er registrert");
		return kunde;
	}


	private void innlogget(Kunde kunde, Scanner scanner) {
		int valg = 0;
		while( valg != 4) {
			System.out.println("Skriv 1 for å leie bil.");
			System.out.println("Skriv 2 for å se ledige biler");
			System.out.println("Skriv 3 for å levere fra seg en bil");
			System.out.println("Skriv 4 for å logge av");
			valg = scanner.nextInt();
			
			switch(valg) {
			case 1: {
				System.out.println("Skriv regNr på bilen du ønsker å leie.");
				String regNr = scanner.next();
			//	if(utleiestatus.isLedig()&& !utleiestatus.isReservert()) {
					leieUtBil(kunde, regNr);
			//	}
				
				System.out.println("Takk for at du valgte å leie hos oss ");
				break;
			}
			
			case 2: {
				System.out.println("");
				skrivUtLedigBil();
				break;
			}
			
			case 3: {
				System.out.println("Skriv regNr på bilen du ånsker å levere fra deg: ");
				String regNr = scanner.next();
				leverBil(regNr, kunde);
				System.out.println("Bilen er levert");
			
				break;
			}
			case 4: {
				valg = 4;
				break;
			}
			default:{
				valg = 4;
			}
				
			
			}
		}
		
	}


	private void skrivUtLedigBil() {
		bilListe.stream().filter(k->k.getLeidAvKund()==null).
		forEach(System.out::println);
		
	}



	private Boolean leieUtBil(Kunde kunde, String regNr) {
		Bil bil = finnBil(regNr);
		if (bil != null ) {
			bil.setLeidAvKund(kunde);
			return true;
		}else {
            System.out.println("Feil med leie av bil");
            return false;		
        }
	}
		
		
	



	private Bil finnBil(String regNr) {
		for(Bil bil : bilListe) {
			if(regNr.equals(bil.getRegnr()))
				return bil;
		}
		return null;
	}



	public void valgKontorOgKonsulent() {

		System.out.println("Velcommen til våre appen. Valg utleiekontor og konsulent:"
				+ "\nSkriv 1 for Hoved kontor, konsulent Nils Pils" + "\nSkriv 2 for Stavanger, konsulent Nils Pils"
				+ "\nSkriv 3 for Oslo konsulent Anja Nilsen" + "\nSkriv 4 for Bergen konsulent Niko Niksen");

		int valg = 0;
		Scanner scanner = new Scanner(System.in);
		valg = scanner.nextInt();
		
		Person selger1 = new Person("Nils", "Pils", "54345434",new Adresse("Nilsgaten 9", 3454,"Andeby"));

		switch (valg) {

		case 1: {
			Utleiekontor utleiekontor0 = new Utleiekontor("Hoved kontor", "999888", new Adresse("Tigerstaden", 9898, "Løva"));

			utleiekontor.add(utleiekontor0);
		//	Person selger1 = new Person("Nils", "Pils", "54345434",new Adresse("Nilsgaten 9", 3454,"Andeby"));
			Konsulent konsulent1 = new Konsulent(selger1,utleiekontor0);
			konsulentListe.add(konsulent1);
			System.out.println("Du har valget : " + utleiekontor0.toString()  );
		//	System.out.println(konsulent1.toString());

			break;
		}
		case 2: {
			Utleiekontor utleiekontor2 = (new Utleiekontor("Stavanger", "43433333", new Adresse("Tigerstaden", 9898, "Løva")));
			utleiekontor.add(utleiekontor2);
			Konsulent konsulent2 = new Konsulent(selger1,utleiekontor2);
			konsulentListe.add(konsulent2);
			System.out.println("Du har valget : " + utleiekontor2.toString());
			//System.out.println(konsulent2.toString());
			
			break;
		}
		case 3: {
			Utleiekontor utleiekontor3 = (new Utleiekontor("Oslo", "9494999", new Adresse("Nansensplass", 8787, "Frøya")));
			utleiekontor.add(utleiekontor3);
			Person selger2 = new Person ("Anja", "Nilsen", "84858384", new Adresse("Anjarud 9", 9898,"Åseby"));
			Konsulent konsulent3 = new Konsulent(selger2,utleiekontor3);
			konsulentListe.add(konsulent3);
			System.out.println("Du har valget : " + utleiekontor3.toString() );
			//System.out.println(konsulent3.toString());


			
			break;
		}
		case 4: {
			Utleiekontor utleiekontor4 = (new Utleiekontor("Bergen", "98989898", new Adresse("Askøy", 3421, "Sotra")));
			utleiekontor.add(utleiekontor4);
			Person selger4 = new Person("Niko", "Niksen", "34343443", new Adresse("London", 3888,"Sveits"));
			Konsulent konsulent4 = new Konsulent(selger4,utleiekontor4);
			konsulentListe.add(konsulent4);
			System.out.println("Du har valget : " + utleiekontor4.toString() );
			//System.out.println(konsulent4.toString());

			
			break;
		}

		}

	}
	
	private void leverBil(String regNr, Kunde kunde) {
		Bil bil = finnBil(regNr);
		if(bil != null) {
			if (kunde==bil.getLeidAvKund()) {
				bil.setLeidAvKund(null);
				System.out.println(
						"Bilen: " + bil.toString() 
						+ " er nå levert og prisen ble: " 
								+ bil.getBilGruppe().getPris());
						
			}else {
				System.err.println("Finner ikke bil registrert til deg med dette registererings nummeret.");
			}
		}else {
			System.err.println("Finner ikke bil med dette registerings nummeret.");
		}
		
	}
	
	
	
	

	public void LeggTilKonsulent(Konsulent k) {
		konsulentListe.add(k);
	}

	public void LeggTilKunde(Kunde k) {
		kundeListe.add(k);
	}

	public void LeggTilKontor(Utleiekontor k) {
		utleiekontor.add(k);
	}

	public void leggTilBil(Bil k) {
		bilListe.add(k);
	}

}
