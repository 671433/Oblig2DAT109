package dat109.hvl.no;

import java.util.List;

public class Kunde {

	private Person person;

	private Konsulent selger;

	private Salg salg;

	List<Faktura> fakturaliste;
	

	public Kunde(String fornavn, String etternavn, String telefonnummer, Adresse adresse, Konsulent selger, Salg salg,
			Faktura fakturaliste) {

		this.person = new Person(fornavn, etternavn, telefonnummer, adresse);
		this.selger = selger;
		this.salg = salg;
		this.fakturaliste.add(fakturaliste);

	}

	public Kunde(Person person, Konsulent selger, Salg salg, Faktura fakturaliste) {
		super();
		this.person = person;
		this.selger = selger;
		this.salg = salg;
		this.fakturaliste.add(fakturaliste);
	}
	
	
	public Kunde (Person person ) {
		super();
		this.person = person ;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Konsulent getSelger() {
		return selger;
	}

	public void setSelger(Konsulent selger) {
		this.selger = selger;
	}

	public Salg getSalg() {
		return salg;
	}

	public void setSalg(Salg salg) {
		this.salg = salg;
	}

	public List<Faktura> getFakturaliste() {
		return fakturaliste;
	}

	public void setFakturaliste(Faktura fakturaliste) {
		this.fakturaliste.add(fakturaliste);
	}

}
