import static org.junit.Assert.*;

import org.junit.Test;

public class CapacityTest {

	public static final int TOO_LOW_STR = 19;
	public static final int TOO_HIGH_STR = 101;
	public static final int STR = 40;
	
	@Test (expected = IllegalCapacityStrengthTooLowException.class)
	public void WHEN_createACapacityWithTooLowStrength_THEN_shouldThrowException() {
		new CapacityMock(TOO_LOW_STR);
	}
	
	@Test (expected = IllegalCapacityStrengthTooHighException.class)
	public void WHEN_createACapacityWithTooHighStrength_THEN_shouldThrowException() {
		new CapacityMock(TOO_HIGH_STR);
	}
	
	@Test 
	public void WHEN_createACapacity_THEN_shouldCreateCapacityWithStrengthValue() {
		int actual = new CapacityMock(STR).getCapacityStrength();
		assertEquals(STR, actual);
	}
}
