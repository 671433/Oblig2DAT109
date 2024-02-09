package dat109.hvl.no;

public class Main {

	public static void main(String[] args) {
		
		
		Bilutleieselskap selskap = new Bilutleieselskap(new Adresse("Haviz", 2054, "Asker"),12341234);
		
//		Utleiekontor utleiekontor0 = new Utleiekontor("Hoved kontor", "999888", new Adresse("Tigerstaden", 9898, "Løva"));
//		Utleiekontor utleiekontor1 = (new Utleiekontor("Stavanger", "43433333", new Adresse("Tigerstaden", 9898, "Løva")));
//		Utleiekontor utleiekontor2 = (new Utleiekontor("Oslo", "9494999", new Adresse("Nansensplass", 8787, "Frøya")));
//		Utleiekontor utleiekontor3 = (new Utleiekontor("Bergen", "98989898", new Adresse("Askøy", 3421, "Sotra")));
//		
//		
//		Person selger1 = new Person("Nils", "Pils", "54345434",new Adresse("Nilsgaten 9", 3454,"Andeby"));
//		Person selger2 = new Person ("Anja", "Nilsen", "84858384", new Adresse("Anjarud 9", 9898,"Åseby"));
//		Person selger3 = new Person("Niko", "Niksen", "34343443", new Adresse("London", 3888,"Sveits"));
//		Konsulent konsulent1 = new Konsulent(selger1,utleiekontor1);
//		Konsulent konsulent2 = new Konsulent(selger1,utleiekontor2);
		
		
		
		selskap.leggTilBil(new Bil ("AA00000", "MG", "2", "Rød",Utleiegrupper.Storbil));
		selskap.leggTilBil(new Bil ("BB11111", "WV", "Toran", "Blå", Utleiegrupper.MellemBil));
		selskap.leggTilBil(new Bil ("CC22222", "Tesla", "S2", "Hvit", Utleiegrupper.Stasjonvogen));
		selskap.leggTilBil(new Bil ("EN32420", "Volvo", "Penta", "Sølv", Utleiegrupper.Storbil));
		selskap.leggTilBil(new Bil ("UEASDFG", "Nissan", "Leaf", "Grå", Utleiegrupper.MellemBil));
		selskap.leggTilBil(new Bil ("FG74837", "Ford", "Escort", "Blå", Utleiegrupper.Storbil));
		selskap.leggTilBil(new Bil ("FV49853", "Citroen", "DS", "Sort", Utleiegrupper.MellemBil));
		selskap.leggTilBil(new Bil ("GM49495", "Skoda", "Superba", "Grønn", Utleiegrupper.Storbil));
		selskap.leggTilBil(new Bil ("OP94949", "Fiat", "Ritmo", "Hvit", Utleiegrupper.MellemBil));
		
		System.out.println("");
		selskap.logginn();
		
		//utleiekontor.logginn();
	}

}
