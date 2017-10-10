import java.util.List;

public class Mage extends Fighter	{
	
	public static int INT_CON_CONDITION = 15;
	public Mage(FighterStats data, List<Capacity> capacityList) {
		super(data, capacityList);
		validate(data);
	}
	
	private void validate(FighterStats data) {
		
		if(getIntelligence() - INT_CON_CONDITION < getStrength() + getDexterity()) {
			throw new IllegalIntelligenceTooLowAtCreationException();
		}
		
		if (getConcentration() - INT_CON_CONDITION < getStrength() + getDexterity()) {
			throw new IllegalConcentrationTooLowAtCreationException();
		}
	}
}
