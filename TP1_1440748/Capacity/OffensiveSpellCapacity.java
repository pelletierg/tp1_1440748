
public class OffensiveSpellCapacity extends AttackCapacity{

	public OffensiveSpellCapacity(int capacityStrength) {
		super(capacityStrength);
	}

	public int getCapacityPower(Fighter fighter) {
		return (fighter.getIntelligence()*this.getCapacityStrength()/100)*3;
	}
}
