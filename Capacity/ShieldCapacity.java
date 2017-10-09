
public class ShieldCapacity extends ParryCapacity{

	public ShieldCapacity(int capacityStrength) {
		super(capacityStrength);
	}
	
	public int getCapacityPower(Fighter fighter) {
		return fighter.getStrength() * this.getCapacityStrength()/100;
	}
}
