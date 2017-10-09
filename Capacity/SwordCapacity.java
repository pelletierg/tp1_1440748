
public class SwordCapacity extends AttackCapacity{

	public SwordCapacity(int capacityStrength) {
		super(capacityStrength);
	}
	public int getCapacityPower(Fighter fighter) {
		return fighter.getStrength()*this.getCapacityStrength()/100;
	}
}
