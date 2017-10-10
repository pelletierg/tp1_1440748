import org.junit.Test;

public class WarriorTest {
	
	public static final int OK_DEX = 15;
	public static final int OK_INT = 5;
	public static final int OK_CON = 2;
	public static final int OK_STR = 30;
	public static final int DEX_TOO_LOW = OK_INT + Warrior.STR_DEX_CONDITION - 1;
	public static final int INT_TOO_LOW = OK_CON - 1;
	public static final int STR_TOO_LOW = OK_DEX + Warrior.STR_DEX_CONDITION - 1;
	
	@Test (expected = IllegalStrengthTooLowAtCreationException.class)
	public void WHEN_strengthTooLowIsSet_THEN_shouldRaiseIllegalStrengthTooLowAtCreationException() {
		new Warrior(new FighterStats(STR_TOO_LOW, OK_DEX, OK_INT, OK_CON), AthleteTest.capacity);
	}
	
	@Test (expected = IllegalDexterityTooLowAtCreationException.class)
	public void WHEN_dexterityTooLowIsSet_THEN_shouldRaiseIllegalDexterityTooLowAtCreationException() {
		new Warrior(new FighterStats(OK_STR, DEX_TOO_LOW, OK_INT, OK_CON), AthleteTest.capacity);
	}
	
	@Test (expected = IllegalIntelligenceTooLowAtCreationException.class)
	public void WHEN_intelligenceTooLowIsSet_THEN_shouldRaiseIllegalIntelligenceTooLowAtCreationException() {
		new Warrior(new FighterStats(OK_STR, OK_DEX, INT_TOO_LOW, OK_CON), AthleteTest.capacity);
	}
	
}
