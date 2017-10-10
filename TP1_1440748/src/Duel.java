
public class Duel {

	public Fighter Fight(Fighter aggressor, AttackCapacity attack, Fighter defender, CombatCapacity defense) {
		
		Fighter winner;
		int aggressorAttack = attack.getCapacityPower(aggressor);
		int defenderDefense = defense.getCapacityPower(defender);
		if (aggressorAttack > defenderDefense) {
			defender.updateHealth(defenderDefense-aggressorAttack);
			defender.updateLosingStats();
			aggressor.updateWinningStats();
			winner = aggressor;
		}
		if (aggressorAttack < defenderDefense) {
			aggressor.updateHealth(aggressorAttack-defenderDefense);
			defender.updateWinningStats();
			aggressor.updateLosingStats();
			winner = defender;
		}
		else {
			defender.updateLosingStats();
			aggressor.updateWinningStats();
			winner = aggressor;
		}
		return winner;
	}
	
	public void Flee(Fighter aggressor, Fighter defender) {
		defender.updateWinningStats();
		defender.updateLosingStats();
	}
}
