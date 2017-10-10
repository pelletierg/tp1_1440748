
public class RemedyCapacity extends HealCapacity{

	public RemedyCapacity(int capacityStrength) {
		super(capacityStrength);
	}

	public int getCapacityPower(Fighter fighter) {
		return fighter.getDexterity()*this.getCapacityStrength()/100;
	}
}
