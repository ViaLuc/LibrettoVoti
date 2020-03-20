package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class TestLibretto {
	
	Libretto lib ;
	
	private void run() {
		this.lib = new Libretto() ; // crea libretto vuoto
		
		
		//1. inserire alcuni voti
		Voto v1 = new Voto("Tecniche di programmazione", 30, LocalDate.of(2020, 06, 15)) ;
		Voto v2 = new Voto("Analisi II", 28, LocalDate.of(2020, 06, 28)) ;

		lib.add(v1);
		lib.add(v2);
		if(lib.add(new Voto("Economia", 24, LocalDate.of(2020, 02, 14))) == false)
			System.out.println("Errore nell'inserimento di Economia");
		
		System.out.println(this.lib) ;
		
		//2. Stampa tutti i voi uguali a 28
		System.out.println(this.lib.stampaVotiUguali(28)) ;
		
		System.out.println(this.lib.estraiVotiUguali(28)) ;
		
		//3. cerca un esame superato sapendo il corso
		
		String nomeCorso = "Analisi II";
		
		Voto votoAnalisi = lib.cercaNomeCorso(nomeCorso);
		System.out.println("il voto di "+nomeCorso+" é "+votoAnalisi.getVoto());
		
		Voto votoMancante = lib.cercaNomeCorso("Fisica I");
		System.out.println("il voto di Fisica I è "+votoMancante);
		
		//4. 5. Verifica voti dublicati o voti in conflitto
		
		Voto economia2 = new Voto("Economia",24, LocalDate.now());
		Voto economia3 = new Voto("Economia",21, LocalDate.now());
		System.out.println("Economia con 24 è duplicato: "+lib.isDuplicato(economia2)+"\n conflitto: "+ lib.isConflitto(economia2));
		System.out.println("Economia con 24 è duplicato: "+lib.isDuplicato(economia3)+"\n conflitto: "+ lib.isConflitto(economia3));
		
		//7. Migliora libretto
		
		Libretto migliorato = lib.creaLibrettoMigliorato();
		System.out.println("Libretto migliorato\n");
		System.out.println(lib);
		System.out.println(migliorato);
		
		//8. Stampa in ordine alfabetico
		Libretto alfabetico = new Libretto (lib);
		alfabetico.ordinaPerCorso();
		System.out.println(alfabetico);
		
		//8. Stampa in ordine di voto
		Libretto votidecrescenti = new Libretto (lib);
		votidecrescenti.ordinaPerVoto();
		System.out.println(votidecrescenti);
		
		//9. Elimina voti bassi
		lib.add(new Voto("Chimica", 19, LocalDate.now()));
		lib.ordinaPerCorso();
		System.out.println(lib);
		lib.cancellaVotiScarsi();
		System.out.println(lib);
		
	}

	public static void main(String[] args) {
		TestLibretto test = new TestLibretto() ;
		test.run();
	}

}
