import java.util.ArrayList;
import java.util.List;

public class FighterFabric {
	
	
	private List<Fighter> fighterList;

	public FighterFabric() {
		this.fighterList = new ArrayList<Fighter>();
	}
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
				addFighterToList(aFighter);
				break;
			case ATHLETE:
				aFighter = new Athlete(stats, initialCapacity);
				addFighterToList(aFighter);
				break;
			case MAGE:
				aFighter = new Mage(stats, initialCapacity);
				addFighterToList(aFighter);
				break;
			default: throw new IllegalNotAValidFighterTypeException();
		}
		return aFighter;
	}
	
	public List<Fighter> getFighterList(){
		return this.fighterList;
	}
	
	public void addFighterToList(Fighter fighter) {
		fighterList.add(fighter);
	}
	
	public Fighter getFighter(int index) {
		return this.fighterList.get(index);
	}
	
	public boolean getEmptyList() {
		if (getFighterList().isEmpty()) {
			return true;
		}
		return false;
	}
}
