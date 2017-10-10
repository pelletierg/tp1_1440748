import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ShieldTest {

	FighterFabric myFabric = new  FighterFabric();
	FighterStats myDefaultStats = myFabric.createStats(FighterTest.NORM_STR, FighterTest.NORM_STR, FighterTest.NORM_STR, FighterTest.NORM_STR);
	
	@Test
	public void WHEN_askedToCalculateCapacityPower_THEN_shouldReturnCapacityPower() {
		Fighter aFighter = new Athlete(myDefaultStats, AthleteTest.capacity);
		aFighter.addCapacity(new ShieldCapacity(40));
		int actual = aFighter.getCapacity(0).getCapacityPower(aFighter);
		int expected = FighterTest.NORM_STR *40 /100;
		assertEquals(expected, actual);
	}
}
