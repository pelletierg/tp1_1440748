
public abstract class Duel {

	public void Fight(Fighter aggressor, AttackCapacity attack, Fighter defender, CombatCapacity defense) {
		
		int aggressorAttack = attack.getCapacityPower(aggressor);
		int defenderDefense = defense.getCapacityPower(defender);
		if (aggressorAttack > defenderDefense) {
			defender.updateHealth(defenderDefense-aggressorAttack);
			defender.updateLosingStats();
			aggressor.updateWinningStats();
		}
		if (aggressorAttack < defenderDefense) {
			aggressor.updateHealth(aggressorAttack-defenderDefense);
			defender.updateWinningStats();
			aggressor.updateLosingStats();
		}
		else {
			defender.updateLosingStats();
			aggressor.updateWinningStats();
		}
	}
	
	public void Flee(Fighter aggressor, Fighter defender) {
		defender.updateWinningStats();
		defender.updateLosingStats();
	}
}
