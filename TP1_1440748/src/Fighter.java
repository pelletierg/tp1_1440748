public abstract class Fighter {
	
	private FighterStats data;
	private int health;


	public Fighter (FighterStats stats) {
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
}
