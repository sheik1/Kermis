package Kermis;

public enum AttractieNaam {
	Botsauto('1'),
	Spin('2'),
	Spiegelpaleis('3'),
	Spookhuis('4'),
	Hawaii('5'),
	Ladderklimmen('6');
	
	public int Positie;
	
	AttractieNaam(char Positie) {
		this.Positie = Positie;
	}

	public int GetNaam() {
		return Positie;
	}
};