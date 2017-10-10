import java.util.List;

public abstract class Fighter extends Duel{
	
	private FighterStats data;
	private int health;
	private List<Capacity> currentCapacity;


	public Fighter (FighterStats stats, List<Capacity> capacityList) {
		this.currentCapacity = capacityList;
		this.data = stats;
		this.health = 200 - (this.data.getStrength() + this.data.getDexterity() + this.data.getIntelligence() + this.data.getConcentration());
	}
	
	public int getStrength() {
		return this.data.getStrength();
	}
	
	public int getDexterity() {
		return this.data.getDexterity();
	}
	
	public int getIntelligence() {
		return this.data.getIntelligence();
	}
	
	public int getConcentration() {
		return this.data.getConcentration();
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public void updateHealth(int healthChange) {
		this.health = this.health + healthChange;
	}
	
	public void updateWinningStats() {
		this.data.updateWinningStats();
	}
	
	public void updateLosingStats() {
		this.data.updateLosingStats();
	}
	
	public void addCapacity(Capacity capacity) {
		this.currentCapacity.add(capacity);
	}

	public List<Capacity> getCapacityList() {
		return this.currentCapacity;
	}

	public void removeCapacity(HealCapacity capacity) {
		for (int i = 0; i < this.currentCapacity.size(); i++) {
			if (this.currentCapacity.get(i).equals(capacity)) {
				this.currentCapacity.remove(i);
				i--;
			}
		}
		
	}
	
	public Capacity getCapacity(int index) {
		return getCapacityList().get(index);
	}
	
	public FighterStats getFighterStats() {
		return this.data;
	}
}
