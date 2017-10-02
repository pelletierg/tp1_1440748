public class Athlete extends Fighter {
	
	public static int STATS_CONDITION = 20;
	
	public Athlete (FighterStats data) {
		super(data);
		validate(data);
		
	}

	private void validate(FighterStats data) {
		if (getStrength() < STATS_CONDITION) {
			throw new IllegalStrengthTooLowAtCreationException();
		}
		if (getDexterity() < STATS_CONDITION) {
			throw new IllegalDexterityTooLowAtCreationException();
		}
		if (getIntelligence() < STATS_CONDITION) {
			throw new IllegalIntelligenceTooLowAtCreationException();
		}
		if (getConcentration() < STATS_CONDITION) {
			throw new IllegalConcentrationTooLowAtCreationException();
		}
	}
}
