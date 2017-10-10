import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class AthleteTest {

	
	private static final int OK_DEX = 20;
	private static final int OK_INT = 20;
	private static final int OK_CON = 20;
	private static final int OK_STR = 20;
	private static final int DEX_TOO_LOW = Athlete.STATS_CONDITION - 1;
	private static final int INT_TOO_LOW = Athlete.STATS_CONDITION - 1;
	private static final int STR_TOO_LOW = Athlete.STATS_CONDITION - 1;
	public static List<Capacity> capacity = new ArrayList<Capacity>();
	
	@Test (expected = IllegalStrengthTooLowAtCreationException.class)
	public void WHEN_strengthTooLowIsSet_THEN_shouldRaiseIllegalStrengthTooLowAtCreationException() {
		new Athlete(new FighterStats(STR_TOO_LOW, OK_DEX, OK_INT, OK_CON), capacity);
	}
	
	@Test (expected = IllegalDexterityTooLowAtCreationException.class)
	public void WHEN_dexterityTooLowIsSet_THEN_shouldRaiseIllegalDexterityTooLowAtCreationException() {
		new Athlete(new FighterStats(OK_STR, DEX_TOO_LOW, OK_INT, OK_CON), capacity);
	}
	
	@Test (expected = IllegalIntelligenceTooLowAtCreationException.class)
	public void WHEN_intelligenceTooLowIsSet_THEN_shouldRaiseIllegalIntelligenceTooLowAtCreationException() {
		new Athlete(new FighterStats(OK_STR, OK_DEX, INT_TOO_LOW, OK_CON), capacity);
	}
	
}

