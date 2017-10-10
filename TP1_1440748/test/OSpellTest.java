import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OSpellTest {
	FighterFabric myFabric = new  FighterFabric();
	FighterStats myDefaultStats = myFabric.createStats(FighterTest.NORM_STR, FighterTest.NORM_STR, FighterTest.NORM_STR, FighterTest.NORM_STR);
	
	@Test
	public void WHEN_askedToCalculateCapacityPower_THEN_shouldReturnCapacityPower() {
		Fighter aFighter = new Athlete(myDefaultStats, AthleteTest.capacity);
		aFighter.addCapacity(new OffensiveSpellCapacity(40));
		int actual = aFighter.getCapacity(0).getCapacityPower(aFighter);
		int expected = FighterTest.NORM_STR *40 /100 *3;
		assertEquals(expected, actual);
	}
}
