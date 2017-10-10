import org.junit.Test;

public class FighterStatsTest {
	
	private final int TOO_HIGH_STATS = 30;
	
	@Test (expected = IllegalStatsTooHighAtCreationException.class)
	public void WHEN_tooHighSumStats_THEN_shouldRaiseIllegalStatsTooHighAtCreationException() {
		new FighterStats(TOO_HIGH_STATS, TOO_HIGH_STATS, TOO_HIGH_STATS, TOO_HIGH_STATS);
	}
	
}
