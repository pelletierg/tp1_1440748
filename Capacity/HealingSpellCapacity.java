
public class HealingSpellCapacity extends HealCapacity{

	public HealingSpellCapacity(int capacityStrength) {
		super(capacityStrength);
	}

	public int getCapacityPower(Fighter fighter) {
		return fighter.getIntelligence()*this.getCapacityStrength()/100;
	}
}
