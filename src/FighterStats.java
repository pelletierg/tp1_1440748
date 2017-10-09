
public class FighterStats {
	
	private int strength;
	private int dexterity;
	private int intelligence;
	private int concentration;

	public FighterStats(int strength, int dexterity, int intelligence, int concentration) {
		validate(strength, dexterity, intelligence, concentration);
		this.strength = strength;
		this.dexterity = dexterity;
		this.intelligence = intelligence;
		this.concentration = concentration;
	}
	private void validate (int strength, int dexterity, int intelligence, int concentration) {
		/*if (strength < 0 || dexterity < 0 || intelligence < 0 || concentration < 0) {
			throw new IllegalStatsCanNotBeNegativeException();
		}*/
		if (strength + dexterity + intelligence + concentration > 100) {
			throw new IllegalStatsTooHighAtCreationException();
		}
	}
	
	public int getStrength() {
		return this.strength;
	}
	
	public int getDexterity() {
		return this.dexterity;
	}
	
	public int getIntelligence() {
		return this.intelligence;
	}
	
	public int getConcentration() {
		return this.concentration;
	}
	
	public void updateWinningStats() {
		this.strength = this.strength + 1;
		this.dexterity = this.dexterity + 1;
		this.intelligence = this.intelligence + 1;
		this.concentration = this.concentration + 1;
	}
	
	public void updateLosingStats() {
		this.strength = this.strength - 1;
		this.dexterity = this.dexterity - 1;
		this.intelligence = this.intelligence - 1;
		this.concentration = this.concentration - 1;
	}
}