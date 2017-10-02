public class Warrior extends Fighter{
	
	public static int STR_DEX_CONDITION = 10;

	public Warrior(FighterStats data) {
		super(data);
		validate(data);
	}
	
	private void validate(FighterStats data) {
		if ((getStrength() - STR_DEX_CONDITION) < getDexterity()) {
			throw new IllegalStrengthTooLowAtCreationException();
		}
		
		if ((getDexterity() - STR_DEX_CONDITION) < getIntelligence()) {
			throw new IllegalDexterityTooLowAtCreationException();
		}
		
		if (getIntelligence() < getConcentration()) {
			throw new IllegalIntelligenceTooLowAtCreationException();
		}
	}
}
