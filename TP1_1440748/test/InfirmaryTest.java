import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class InfirmaryTest {

	Infirmary myInfirmary = new Infirmary();
	FighterFabric myFabric = new FighterFabric();
	public static final String type1 = "ATHLETE";
	
	@Test
	public void GIVEN_anInfirmary_WHEN_askedToHealAFighter_THEN_shouldHealTheFighter() {
		
		List<Capacity> capacityList = new ArrayList<Capacity>();
		capacityList.add(new RemedyCapacity(50));
		FighterStats myFighterStats = myFabric.createStats(FighterTest.NORM_STR, FighterTest.NORM_STR, FighterTest.NORM_STR, FighterTest.NORM_STR);
		Fighter aFighter = new Athlete(myFighterStats, capacityList);
		int expected = aFighter.getHealth();
		myInfirmary.heal(aFighter, (HealCapacity) capacityList.get(0)); 
		int actual = aFighter.getHealth() - aFighter.getDexterity() * 50 / 100;
		assertEquals(expected, actual);
		
	}
}
