import static org.junit.Assert.*;
import org.junit.Test;

public class FighterTest {
	
	public static int NORM_STR = 20;
	public static int NORM_DEX = 20;
	public static int NORM_INT = 20;
	public static int NORM_CON = 20;
	
	Capacity aCapacity = new SwordCapacity(40);
	HealCapacity aHealingCapacity = new RemedyCapacity(50);
	FighterStats stats = new FighterStats(NORM_STR, NORM_DEX, NORM_INT, NORM_CON);
	Fighter aNewFighter = new FighterMock(stats, AthleteTest.capacity);
	
	@Test
	public void WHEN_aFighterIsCreated_THEN_setsCapacityListAndStatsToTheFighter() { 
		Fighter aFighter = new FighterMock (stats, AthleteTest.capacity);
		assertEquals(AthleteTest.capacity, aFighter.getCapacityList());
		assertEquals(stats, aFighter.getFighterStats());
	}
	
	@Test
	public void GIVEN_aFighter_WHEN_updateLosingStatsIsCalled_THEN_shouldReduceStatsByOne() {
		aNewFighter.updateLosingStats();
		assertEquals(NORM_STR - 1, aNewFighter.getStrength());
		assertEquals(NORM_STR - 1, aNewFighter.getDexterity());
		assertEquals(NORM_STR - 1, aNewFighter.getIntelligence());
		assertEquals(NORM_STR - 1, aNewFighter.getConcentration());
	}
	
	@Test 
	public void GIVEN_aFighter_WHEN_updateWiningStatsIsCalled_THEN_shouldIncreaseStatsByOne() {
		aNewFighter.updateWinningStats();
		assertEquals(NORM_STR + 1, aNewFighter.getStrength());
		assertEquals(NORM_STR + 1, aNewFighter.getDexterity());
		assertEquals(NORM_STR + 1, aNewFighter.getIntelligence());
		assertEquals(NORM_STR + 1, aNewFighter.getConcentration());
	}
	
	@Test 
	public void GIVEN_aFighter_WHEN_askedToAddCapacity_THEN_shouldAddCapacity() {
		aNewFighter.addCapacity(aCapacity);
		Capacity expectedCapacity = aNewFighter.getCapacityList().get(0);
		assertEquals(aCapacity, expectedCapacity);
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void GIVEN_aFighter_WHEN_askedToRemoveCapacity_THEN_shouldRemoveCapacity() {
		aNewFighter.addCapacity(aHealingCapacity);
		aNewFighter.removeCapacity(aHealingCapacity);
		aNewFighter.getCapacity(0);
	}
	
	@Test
	public void GIVEN_aFighter_WHEN_askedToUpdateHealth_THEN_shouldUpdateHealth() {
		int currentHealth = aNewFighter.getHealth();
		int healthVariation = 10;
		aNewFighter.updateHealth(healthVariation);
		assertEquals(currentHealth, aNewFighter.getHealth() - healthVariation);
	}
}
