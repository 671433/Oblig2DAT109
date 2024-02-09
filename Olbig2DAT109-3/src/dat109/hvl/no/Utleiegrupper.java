package dat109.hvl.no;

public enum Utleiegrupper {
	
	LitenBil(1000), 
	MellemBil(2000),
	Storbil(3000),
	Stasjonvogen(2500);
	
	private int pris;
	
	private Utleiegrupper(int pris) {
		this.pris= pris;
	}
	
	public int getPris() {
		return pris;
	}

}
