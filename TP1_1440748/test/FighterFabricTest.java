import static org.junit.Assert.*;

import org.junit.Test;

public class FighterFabricTest {

	FighterFabric myFabric = new  FighterFabric();
	FighterStats myDefaultStats = myFabric.createStats(FighterTest.NORM_STR, FighterTest.NORM_STR, FighterTest.NORM_STR, FighterTest.NORM_STR);
	FighterFabric.FighterType WARRIOR;
	
	@Test
	public void WHEN_askedToCreateFighterStats_THEN_shouldReturnFighterStats() {
		FighterStats myStats = myFabric.createStats(FighterTest.NORM_STR, FighterTest.NORM_STR, FighterTest.NORM_STR, FighterTest.NORM_STR);
		assertEquals(myDefaultStats.getStrength(), myStats.getStrength());
		assertEquals(myDefaultStats.getDexterity(), myStats.getDexterity());
		assertEquals(myDefaultStats.getIntelligence(), myStats.getIntelligence());
		assertEquals(myDefaultStats.getConcentration(), myStats.getConcentration());
	}
	
	@Test
	public void WHEN_askedToAddFighterToList_THEN_shouldAddFighterToList() {
		Fighter aFighter = new Athlete(myDefaultStats, AthleteTest.capacity);
		myFabric.addFighterToList(aFighter);
		assertEquals(aFighter, myFabric.getFighter(0));
	}
	
	@Test
	public void GIVEN_aEmptyFighterList_WHEN_askedToCheckIfEmpty_THEN_shouldReturnTrue() {
		myFabric.getFighterList().clear();
		assertEquals(true, myFabric.getEmptyList());
	}
}
