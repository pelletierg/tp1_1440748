import java.util.ArrayList;
import java.util.List;

public class CapacityFabric {
	
	private List<Capacity> capacityList;
	
	public CapacityFabric() {
		this.capacityList = new ArrayList<Capacity>();
	}
	public static enum CapacityType {
		SWORD, OFFENSIVESPELL, DEFENSIVESPELL, REMEDY, SHIELD, HEALINGSPELL;
	}
	
	public Capacity createCapacity(CapacityType type, int capacityStrength) {
		Capacity capacity = null;
		switch (type) {
			case SWORD: 
				capacity = new SwordCapacity(capacityStrength);
				addCapacityToList(capacity);
				break;
			case OFFENSIVESPELL: 
				capacity = new OffensiveSpellCapacity(capacityStrength);
				addCapacityToList(capacity);
				break;
			case DEFENSIVESPELL:
				capacity = new DefensiveSpellCapacity(capacityStrength);
				addCapacityToList(capacity);
				break;
			case REMEDY:
				capacity = new RemedyCapacity(capacityStrength);
				addCapacityToList(capacity);
				break;
			case SHIELD:
				capacity = new ShieldCapacity(capacityStrength);
				addCapacityToList(capacity);
				break;
			case HEALINGSPELL:
				capacity = new HealingSpellCapacity(capacityStrength);
				addCapacityToList(capacity);
				break;
			default: throw new IllegalNotAValidTypeException();
		}
		return capacity;
	}
	
	public void addCapacityToList(Capacity capacity) {
		this.capacityList.add(capacity);
	}
	
	public List<Capacity> getCapacityList() {
		return this.capacityList;
	}
	
	public int getCapacityListSize() {
		return getCapacityList().size();
	}
	
	public Capacity getCapacity(int index) {
		return getCapacityList().get(index);
	}

	public void emptyCapacityList() {
		getCapacityList().clear();
		
	}
}
                               