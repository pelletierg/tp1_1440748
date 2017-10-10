import static org.junit.Assert.*;

import org.junit.Test;

public class DuelTest {
	
	FighterFabric myFabric = new  FighterFabric();
	FighterStats myDefaultStats = myFabric.createStats(FighterTest.NORM_STR, FighterTest.NORM_STR, FighterTest.NORM_STR, FighterTest.NORM_STR);
	Fighter firstFighter = new Athlete(myDefaultStats, AthleteTest.capacity);
	Fighter secondFighter = new Athlete(myDefaultStats, AthleteTest.capacity);
	Capacity firstCapacity = new SwordCapacity(40);
	Capacity secondCapacity = new OffensiveSpellCapacity(40);
	

	@Test
	public void GIVEN_twoFightersAndTheirCapacity_WHEN_oneAttacksTheOtherOne_THEN_shouldReturnTheWinner() {
		Fighter winner = firstFighter.Fight(firstFighter, (AttackCapacity) firstCapacity, secondFighter, (CombatCapacity) secondCapacity);
		assertEquals(secondFighter, winner);
	}
	
	@Test
	public void GIVEN_twoFightersAndTheirCapacity_WHEN_oneFighterWins_THEN_shouldUpdateHisStats() {
		Fighter winner = firstFighter.Fight(firstFighter, (AttackCapacity) firstCapacity, secondFighter, (CombatCapacity) secondCapacity);
		assertEquals(secondFighter.getStrength(), winner.getStrength());
		assertEquals(secondFighter.getDexterity(), winner.getDexterity());
		assertEquals(secondFighter.getIntelligence(), winner.getIntelligence());
		assertEquals(secondFighter.getConcentration(), winner.getConcentration());
	}
}
