public class CapacityFabric {
	
	public static enum CapacityType {
		SWORD, OFFENSIVESPELL, DEFENSIVESPELL, REMEDY, SHIELD, HEALINGSPELL;
	}
	
	public Capacity createCapacity(CapacityType type, int capacityStrength) {
		Capacity capacity = null;
		switch (type) {
			case SWORD: 
				capacity = new SwordCapacity(capacityStrength);
				break;
			case OFFENSIVESPELL: 
				capacity = new OffensiveSpellCapacity(capacityStrength);
				break;
			case DEFENSIVESPELL:
				capacity = new DefensiveSpellCapacity(capacityStrength);
				break;
			case REMEDY:
				capacity = new RemedyCapacity(capacityStrength);
				break;
			case SHIELD:
				capacity = new ShieldCapacity(capacityStrength);
				break;
			case HEALINGSPELL:
				capacity = new HealingSpellCapacity(capacityStrength);
				break;
			default: throw new IllegalNotAValidTypeException();
		}
		return capacity;
	}
}
                               