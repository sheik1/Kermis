package Kermis;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Kermis {
	
	public double[] prijzen = {2.50, 2.25, 2.75, 3.20, 2.90, 5.00};
	
	public Map<AttractieNaam, Double> AttractiesMetPrijs = new HashMap<AttractieNaam, Double>();
	
	public Map<AttractieNaam, Integer> AttractieAantalKerenBezocht = new HashMap<AttractieNaam, Integer>();
	
	
	public void GenereerLijstMetAttractiesEnPrijs() {
		int prijslijst =0; 

			for(AttractieNaam attractieNaam : AttractieNaam.values()) {
				
				AttractiesMetPrijs.put(attractieNaam, prijzen[prijslijst]);	
				AttractieAantalKerenBezocht.put(attractieNaam, 0);
				prijslijst++;
			}
	}
	
	public void WelkomstTextEnInformatie() {
		
		System.out.println("welkom bij de kermis. Het bestaat uit de volgende attracties met de bijbehorende prijzen");
		
		ToonAttractiesMetEntreePrijzen();
		ToonOptiesVoorGebruiker();
	}
	
	public void ToonAttractiesMetEntreePrijzen() {
		
		for(Entry<AttractieNaam, Double> data : AttractiesMetPrijs.entrySet() ) {
			
			System.out.println("de entree voor het " + data.getKey() + " = € " + data.getValue());
		}
	}
	
	public void ToonOptiesVoorGebruiker() {
		
		for(AttractieNaam attracies : AttractieNaam.values() ) {
			
			System.out.println((char)attracies.Positie +" = " + attracies);
		}
	}
	
}
