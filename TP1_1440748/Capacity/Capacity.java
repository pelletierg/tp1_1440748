

public abstract class Capacity{

	public final int MAX = 100;
	public final int MIN = 20;
	private int capacityStrength;
	
	public Capacity(int capacityStrength) {
		validateCapacityStrength(capacityStrength);
		this.capacityStrength = capacityStrength;
	}
	
	private void validateCapacityStrength(int capacityStrength) {
		if (capacityStrength < 20) {
			throw new IllegalCapacityStrengthTooLowException();
		}
		if (capacityStrength > 100) {
			throw new IllegalCapacityStrengthTooHighException();
		}
	}
	
	public int getCapacityStrength() {
		return capacityStrength;
	}
	
	public abstract int getCapacityPower(Fighter fighter);
}
