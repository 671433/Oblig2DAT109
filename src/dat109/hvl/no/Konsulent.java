package dat109.hvl.no;

public class Konsulent {

	private Person konsulent;

	private Utleiekontor utleiekontor;

	public Konsulent(Person konsulent, Utleiekontor utleiekontor) {
		super();
		this.konsulent = konsulent;
		this.utleiekontor = utleiekontor;
	}

	public Person getKunsulent() {
		return konsulent;
	}

	public void setKunsulent(Person kunsulent) {
		this.konsulent = kunsulent;
	}

	public Utleiekontor getUtleiekontor() {
		return utleiekontor;
	}

	public void setUtleiekontor(Utleiekontor utleiekontor) {
		this.utleiekontor = utleiekontor;
	}

	@Override
	public String toString() {
		return "Konsulent [konsulent=" + super.toString() +"]";
	}
	
	

}
