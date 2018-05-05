package Kermis;

public interface Administratie {
	
	public void Kaarten(char input);
	public void Kosten(char input);
	public void Bereken_totale_kosten(char input,int aantal_bezoekers, double kosten, double totale_kosten, AttractieNaam attractienaam);
	public void Bereken_individuele_kosten(char input,int aantal_bezoekers, double kosten, double totale_kosten, AttractieNaam attractienaam);
	public void Boekhouden(char geefdata);
	
}
