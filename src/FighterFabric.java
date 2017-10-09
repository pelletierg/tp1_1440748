import java.util.List;

public class FighterFabric {
	
	public static enum FighterType {
		WARRIOR, ATHLETE, MAGE;
	}

	public FighterStats createStats(int strength, int dexterity, int intelligence, int concentration) {
		return new FighterStats(strength, dexterity, intelligence, concentration);
	}
	public Fighter createFighter(FighterType type, FighterStats stats, List<Capacity> initialCapacity) {
		
		Fighter aFighter;
		switch(type) {
			case WARRIOR: 
				aFighter = new Warrior(stats, initialCapacity);
				break;
			case ATHLETE:
				aFighter = new Athlete(stats, initialCapacity);
				break;
			case MAGE:
				aFighter = new Mage(stats, initialCapacity);
				break;
			default: throw new IllegalNotAValidFighterTypeException();
		}
		return aFighter;
	}
}
