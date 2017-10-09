
public class DefensiveSpellCapacity extends ParryCapacity{

	public DefensiveSpellCapacity(int capacityStrength) {
		super(capacityStrength);
	}

	public int getCapacityPower(Fighter fighter) {
		return (fighter.getIntelligence()*this.getCapacityStrength()/100)*3;
	}
}
