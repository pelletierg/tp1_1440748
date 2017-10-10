import static org.junit.Assert.*;

import org.junit.Test;

public class CapacityFabricTest {

	CapacityFabric myFabric = new CapacityFabric();
	public static final String type1 = "SWORD";
	public static final int capacityStrength = 40;
	
	@Test
	public void WHEN_askedToCreateCapacity_THEN_shouldCreateCapacityWithPowerLevelSpecified() {
		
		CapacityFabric.CapacityType type = CapacityFabric.CapacityType.valueOf(type1);
		Capacity actual = myFabric.createCapacity(type, capacityStrength);
		Capacity expected = new SwordCapacity(capacityStrength);
		assertEquals(expected.getCapacityStrength(), actual.getCapacityStrength());
		
	}
	
	@Test
	public void GIVEN_aCapacityFabric_WHEN_askedToAddCapacity_THEN_shouldAddCapacityToList() {
		Capacity capacityToAdd = new SwordCapacity(capacityStrength);
		myFabric.addCapacityToList(capacityToAdd);
		assertEquals(capacityToAdd, myFabric.getCapacity(0));
	}
}
