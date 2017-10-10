
public class CapacityMock extends Capacity{

	public CapacityMock(int capacityStrength) {
		super(capacityStrength);
	}

	@Override
	public int getCapacityPower(Fighter fighter) {
		return 0;
	}

}
