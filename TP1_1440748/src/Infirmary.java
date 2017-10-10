
public class Infirmary {
	
	public Infirmary() {
	}
	public void heal(Fighter aFighter, HealCapacity capacity) {
		aFighter.updateHealth(capacity.getCapacityPower(aFighter));
		aFighter.removeCapacity(capacity);
	}
}
