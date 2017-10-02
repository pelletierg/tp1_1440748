import org.junit.Test;

public class MageTest {
	
	private static final int OK_DEX = 5;
	private static final int OK_INT = 30;
	private static final int OK_CON = 30;
	private static final int OK_STR = 5;
	private static final int CON_TOO_LOW = OK_DEX + OK_STR + Mage.INT_CON_CONDITION - 1;
	private static final int INT_TOO_LOW = OK_DEX + OK_STR + Mage.INT_CON_CONDITION - 1;
	
	@Test (expected = IllegalConcentrationTooLowAtCreationException.class)
	public void WHEN_concentrationTooLowIsSet_THEN_shouldRaiseIllegalConcentrationTooLowAtCreationException() {
		new Mage(new FighterStats(OK_STR, OK_DEX, OK_INT, CON_TOO_LOW));
	}
	
	@Test (expected = IllegalIntelligenceTooLowAtCreationException.class)
	public void WHEN_intelligenceTooLowIsSet_THEN_shouldRaiseIllegalIntelligenceTooLowAtCreationException() {
		new Mage(new FighterStats(OK_STR, OK_DEX, INT_TOO_LOW, OK_CON));
	}
	
	
}
