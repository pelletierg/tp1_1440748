import org.junit.Test;

public class WarriorTest {
	
	private static final int OK_DEX = 15;
	private static final int OK_INT = 5;
	private static final int OK_CON = 2;
	private static final int OK_STR = 30;
	private static final int DEX_TOO_LOW = OK_INT + Warrior.STR_DEX_CONDITION - 1;
	private static final int INT_TOO_LOW = OK_CON - 1;
	private static final int STR_TOO_LOW = OK_DEX + Warrior.STR_DEX_CONDITION - 1;
	
	/*@Test (expected = IllegalStrengthTooLowAtCreationException.class)
	public void WHEN_strengthTooLowIsSet_THEN_shouldRaiseIllegalStrengthTooLowAtCreationException() {
		new Warrior(new FighterStats(STR_TOO_LOW, OK_DEX, OK_INT, OK_CON));
	}
	
	@Test (expected = IllegalDexterityTooLowAtCreationException.class)
	public void WHEN_dexterityTooLowIsSet_THEN_shouldRaiseIllegalDexterityTooLowAtCreationException() {
		new Warrior(new FighterStats(OK_STR, DEX_TOO_LOW, OK_INT, OK_CON));
	}
	
	@Test (expected = IllegalIntelligenceTooLowAtCreationException.class)
	public void WHEN_intelligenceTooLowIsSet_THEN_shouldRaiseIllegalIntelligenceTooLowAtCreationException() {
		new Warrior(new FighterStats(OK_STR, OK_DEX, INT_TOO_LOW, OK_CON));
	}*/
	
}
