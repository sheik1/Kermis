package Kermis;
import java.util.Date;
import java.util.Map.Entry;
import java.util.Scanner;

import org.omg.IOP.ExceptionDetailMessage;

public class Attractie extends Kermis implements Administratie {
	
	Scanner inlezen = new Scanner(System.in);
		
	public void Startpunt() {
		
		
		System.out.println("Voor welke attractie wilt u een kaartje kopen (1 t/m " + AttractieNaam.values().length +") ? s = stoppen, o = omzet, k = kaartjes i = toon info  ");
		
		char GeefData = inlezen.next().charAt(0);
		char geefData = Character.toLowerCase(GeefData);
		
		for(int i=0; i<=AttractieNaam.values().length; i++) {
			char getal = Integer.toString(i).charAt(0);
			if(geefData == getal ) {
				Boekhouden(geefData);
				Startpunt();
			}
		}
		
		if(GeefData == ' ') {
			System.out.println("u heeft geen letter ingevuld");
			Startpunt();
		}
		
		switch (GeefData) {
		case 'i':
			WelkomstTextEnInformatie();
			Startpunt();
			break;
		case 's':
			Einde();
			break;
			
		case 'o':
			
			System.out.println("van welke attractie wilt u het omzet willen zien (1 t/m "+ AttractieNaam.values().length + ") t = totaal");
			char input = inlezen.next().charAt(0);
			Kosten(input);
			Startpunt();
			
		case 'k':
			
			System.out.println("van welke attractie wilt u het aantal verkochte kaartjes zien (1 t/m "+ AttractieNaam.values().length + ") t = totaal");
			char input2 = inlezen.next().charAt(0);
			
			if(input2 != ' ') {
				Kaarten(input2);
			}else {
				Startpunt();
			}
		default:
			geefData = ' '; 
			Startpunt();
		}
	}
	
	public void Einde() {
		System.out.println("Bedankt voor uw bezoek aan de kermis ");
	};
		
	@Override
	public void Boekhouden(char geefdata) {
		
		for(AttractieNaam attracties: AttractieNaam.values() ) {
			
			if(attracties.Positie == geefdata) {
					
					if(AttractieAantalKerenBezocht.containsKey(attracties)){
						AttractieAantalKerenBezocht.put(attracties, AttractieAantalKerenBezocht.get(attracties)+1);
						
						System.out.println("de attractie draait");
						System.out.println("veel plezier bij de " + attracties );
					}
			}
		}	
	}
	
	@Override
	public void Kaarten(char input) {
		
		int totaal_aantal_verkochte_kaarten = 0;
		
		if(input == 't') {
				
			for(Entry<AttractieNaam, Integer> data : AttractieAantalKerenBezocht.entrySet() ) {
				
				totaal_aantal_verkochte_kaarten = totaal_aantal_verkochte_kaarten + data.getValue();
			}
			
			System.out.println("het totaal aantal verkochte kaarten op "+ new Date().toString().substring(0, 10)+ " zijn "  + totaal_aantal_verkochte_kaarten);
			
		}else {
			
			char geefData = Character.toLowerCase(input);
			
			for(AttractieNaam attracties: AttractieNaam.values() ) {
				
				if(geefData == (char)attracties.Positie) {
					for(Entry<AttractieNaam, Integer> data : AttractieAantalKerenBezocht.entrySet() ) {
					
						if(attracties == data.getKey()) {
						
							System.out.println(data.getKey() + " is " + data.getValue() + " keren bezocht " );
						}
					}
				}
			}
		}
	}
	
	@Override
	public void Kosten(char input) {
		
		int aantal_bezoekers = 0;
		double kosten = 0.0f;
		double totale_kosten = 0.0f;
		AttractieNaam attractienaam = null;
		
		char geefData = Character.toLowerCase(input);
		
		if(geefData != 't') {
			
		Bereken_individuele_kosten(geefData,aantal_bezoekers,kosten, totale_kosten, attractienaam);
		
		}else {
			
		Bereken_totale_kosten(geefData,aantal_bezoekers,kosten, totale_kosten, attractienaam);
		
		}
	}

	@Override
	public void Bereken_totale_kosten(char input, int aantal_bezoekers, double kosten, double totale_kosten,
			AttractieNaam attractienaam) {
		
		double tel_alle_attracties_bij_elkaar_op = 0.0f;
		
		for(int i=0; i<AttractieNaam.values().length; i++) {
			char getal = Integer.toString(i).charAt(0);
			
			for(AttractieNaam attracties: AttractieNaam.values()) {
				if(getal == (char)attracties.Positie) {
					
					for(Entry<AttractieNaam, Integer> bezoekers : AttractieAantalKerenBezocht.entrySet() ) {
					
						if(attracties == bezoekers.getKey()) {
							attractienaam = bezoekers.getKey();
							aantal_bezoekers = bezoekers.getValue();
						}
					}
				
					for(Entry<AttractieNaam, Double> prijzen : AttractiesMetPrijs.entrySet()) {

						if(attracties == prijzen.getKey()) {
							kosten = prijzen.getValue();
						}
					}
				}		
			}// for
			totale_kosten = aantal_bezoekers * kosten;
			
			tel_alle_attracties_bij_elkaar_op = tel_alle_attracties_bij_elkaar_op + totale_kosten;
	
			totale_kosten = 0.0f;
		}// for
		System.out.println("De totale omzet voor de kermis is € "+ tel_alle_attracties_bij_elkaar_op);
	}

	@Override
	public void Bereken_individuele_kosten(char input, int aantal_bezoekers, double kosten, double totale_kosten,
			AttractieNaam attractienaam) {
		
		
		for(AttractieNaam attracties: AttractieNaam.values()) {
			if(input == (char)attracties.Positie) {
				
				for(Entry<AttractieNaam, Integer> bezoekers : AttractieAantalKerenBezocht.entrySet() ) {
				
					if(attracties == bezoekers.getKey()) {
						attractienaam = bezoekers.getKey();
						aantal_bezoekers = bezoekers.getValue();
					}
				}
			
				for(Entry<AttractieNaam, Double> prijzen : AttractiesMetPrijs.entrySet()) {

					if(attracties == prijzen.getKey()) {
						kosten = prijzen.getValue();
					}
				}
			}
		}
		totale_kosten = aantal_bezoekers * kosten;
		
		System.out.println("De " + attractienaam.name().toString() + "heeft € " + totale_kosten + " gedraaid" );
	}

}
