import java.util.ArrayList;
import java.util.List;

public class Simulator{
	
	public static void main(String[] args) {
		
		Keyboard keyboardInput = new Keyboard();
		Console display = new Console();
		List<Fighter> fighterList = new ArrayList<Fighter>();
		List<Capacity> capacityList = new ArrayList<Capacity>();
		Simulator software = new Simulator(keyboardInput, display, fighterList, capacityList);
		software.start();
	}
	private Keyboard keyboardInput;
	private List<Fighter> fighterList;
	private Console display;
	private List<Capacity> capacityList;
	
	public static final String WARRIOR_TYPE = "WARRIOR";
	public static final String ATHLETE_TYPE = "ATHLETE";
	public static final String MAGE_TYPE = "MAGE";
	public static final String SWORD_CAPACITY = "SWORD";
	public static final String OFFENSIVE_SPELL_CAPACITY = "OFFENSIVESPELL";
	public static final String DEFENSIVE_SPELL_CAPACITY = "DEFENSIVESPELL";
	public static final String REMEDY_CAPACITY = "REMEDY";
	public static final String SHIELD_CAPACITY = "SHIELD";
	public static final String HEALING_SPELL_CAPACITY = "HEALINGSPELL";
	public static final String NEW_FIGHTER = "CREATE A NEW FIGHTER";
	public static final String PROVOKE = "PROVOKE";
	public static final String NEW_CAPACITY = "CREATE A NEW CAPACITY";
	public static final String YES = "YES";
	public static final String NO = "NO";
	
	private void createFighter(String fighterType, String fighterStr, String fighterDex, String fighterInt, String fighterCon, List<Capacity> capacityList) {
		
		FighterFabric myFabric = new FighterFabric();
		FighterFabric.FighterType type1 = FighterFabric.FighterType.valueOf(fighterType);
		int strength = Integer.parseInt(fighterStr);
		int dexterity = Integer.parseInt(fighterDex);
		int intelligence = Integer.parseInt(fighterInt);
		int concentration = Integer.parseInt(fighterCon);
		fighterList.add(myFabric.createFighter(type1, myFabric.createStats(strength, dexterity, intelligence, concentration), capacityList));
		
	}
	private Capacity createCapacity(String type, String capacityStrength) {
		
		CapacityFabric myFabric = new CapacityFabric();
		CapacityFabric.CapacityType type1 = CapacityFabric.CapacityType.valueOf(type);
		int capacityStr = Integer.parseInt(capacityStrength);
		Capacity capacityToAdd = myFabric.createCapacity(type1, capacityStr);
		return capacityToAdd;
	}
	
	public Simulator(Keyboard keyboardInput, Console display, List<Fighter> fighterList, List<Capacity> capacityList) {
		
		this.capacityList = capacityList;
		this.display = display;
		this.keyboardInput = keyboardInput;
		this.fighterList = fighterList;
		
	}
	private void start() {
		
		if (this.fighterList.isEmpty()) {
			this.display.writeLine("You must create a fighter in order to continue");
			createFighter();
		}
		recursiveSoftware();
	}
	
	private void recursiveSoftware() {
		
		String value = "";
		int value1;
		
		this.display.writeLine("You must choose an action between the following ones: Create a new Fighter, Provoke, Create a new Capacity, Create an new infirmary, Admnistrate heals:");
		value = this.keyboardInput.read();
		value = switchToUpperCase(value);
		switch (value) {
		case NEW_FIGHTER:
			createFighter();
			break;
		case NEW_CAPACITY:
			Capacity capacityToAdd = chooseCapacity();
			this.display.writeLine("Which fighter do you want to add a new capacity(*Answer with the number assigned to the fighter)?:");
			displayFighters(this.fighterList);
			value = this.keyboardInput.read();
			value1 = validateNumberForList(value);
			fighterList.get(value1 - 1).addCapacity(capacityToAdd);
			break;
		case PROVOKE:
			this.display.writeLine("With which fighter do you want to provoke(*Answer with the number assigned to the fighter)?:");
			displayFighters(this.fighterList);
			value = this.keyboardInput.read();
			value1 = validateNumberForList(value);
			Fighter aggressor = fighterList.get(value1);
			this.display.writeLine("With which ability do you want to provoke(*Answer with the number assigned to the ability, must be an Attack ability:");
			displayAttackCapacities(aggressor.getCapacityList());
			value = this.keyboardInput.read();
			value1 = validateNumberForList(value);
			AttackCapacity acapacity = (AttackCapacity) aggressor.getCapacityList().get(value1);
			this.display.writeLine("Which fighter do you want to provoke(*Answer with the number assigned to the fighter)?");
			value = this.keyboardInput.read();
			value1 = validateNumberForList(value);
			if (aggressor.equals(fighterList.get(value1))) {
				throw new IllegalFighterCannotFightHimselfException();
			}
			Fighter defender = fighterList.get(value1);
			this.display.writeLine("Enter 'fight' or 'flee' depending on the defender's will to fight or flee:");
			value = this.keyboardInput.read();
			value = switchToUpperCase(value);
			switch (value) {
			case YES:
				this.display.writeLine("Select a combat ability to answer the duel(*Answer with the number assigned to the fighter):");
				displayCombatCapacities(defender.getCapacityList());
				value = this.keyboardInput.read();
				value1 = validateNumberForList(value);
				CombatCapacity dcapacity = (CombatCapacity) defender.getCapacityList().get(value1);
				aggressor.Fight(aggressor, acapacity, defender, dcapacity);
				break;
			case NO: 
				this.display.writeLine("The defender as chosen not to fight. The aggressor Automatically wins");
				aggressor.Flee(aggressor, defender);
				break;
			default: 
				throw new IllegalNotAValidCommandException();
			}
		}
		recursiveSoftware();
	}
	private void displayCombatCapacities(List<Capacity> capacityList2) {

		for (int i= 0; i < capacityList.size(); i++) {
			if (capacityList.get(i) instanceof CombatCapacity) {
				this.display.writeLine("Capacity number " + i + " " + capacityList.get(i));
			}
		}
	}
	private void displayAttackCapacities(List<Capacity> capacityList) {
		for (int i= 0; i < capacityList.size(); i++) {
			if (capacityList.get(i) instanceof AttackCapacity) {
				this.display.writeLine("Capacity number " + i + " " + capacityList.get(i));
			}
		}
		
	}
	private int validateNumberForList(String value) {
		int value1;
		validateIfANumberIsEntered(value);
		value1 = Integer.parseInt(value);
		if (value1 >= this.fighterList.size()) {
			throw new IllegalNumberOfFighterNotValidException();
		}
		return value1;
	}
	private void displayFighters(List<Fighter> fighterList) {
		for (int i= 0; i < fighterList.size(); i++) {
			this.display.writeLine("Fighter number " + i + " " + fighterList.get(i));
		}
		
	}
	private Capacity chooseCapacity() {
		
		String value;
		String firstCapacity;
		String firstCapacityStr;
		this.display.writeLine("Capacity type:");
		value = this.keyboardInput.read();
		value = switchToUpperCase(value);
		validateCapacityType(value);
		firstCapacity = value;
		this.display.writeLine("Capacity Strength level(*Remember, your capacity level must not be under 20 and not over 100:");
		value = this.keyboardInput.read();
		validateIfANumberIsEntered(value);
		firstCapacityStr = value;
		return createCapacity(firstCapacity, firstCapacityStr);
	}
	
	private void validateCapacityType(String value) {
		
		switch (value) {
		case SWORD_CAPACITY: 
			break;
		case OFFENSIVE_SPELL_CAPACITY:
			break;
		case DEFENSIVE_SPELL_CAPACITY:
			break;
		case REMEDY_CAPACITY:
			break;
		case SHIELD_CAPACITY:
			break;
		case HEALING_SPELL_CAPACITY:
			break;
		default:
			throw new IllegalCapacityNotValidException();
		}
	}
	private void validateIfANumberIsEntered(String value) {
		
		for (int i = 0; i <value.length();++i){
	        char c = value.charAt(i);
	        if(!Character.isDigit(c) && c !='-') {
	        	throw new IllegalNoNumberHaveBeenEnteredException();
	        }
	    }
	}
	private String switchToUpperCase(String value) {
		return value.toUpperCase();
	}
	private void createFighter() {

		String value = "";
		String fighterType = "";
		String fighterStr = "";
		String fighterDex = "";
		String fighterInt = "";
		String fighterCon = "";
		this.display.writeLine("Choose a fighter type: Warrior, Athlete, Mage:");
		value = this.keyboardInput.read();
		value = switchToUpperCase(value);
		switch (value) {
		case WARRIOR_TYPE: 
			fighterType = WARRIOR_TYPE;
			this.display.writeLine("You must now choose your Warrior's Stats level(*The sum of your Stats must not be higher than 100).");
			this.display.writeLine("First, you must choose your Concentration Level:");
			value = this.keyboardInput.read();
			validateIfANumberIsEntered(value);
			fighterCon = value;
			this.display.writeLine("Now, you must choose your Intelligence Level(*Remember, the Intelligence must be higher than the Concentration):");
			value = this.keyboardInput.read();
			validateIfANumberIsEntered(value);
			fighterInt = value;
			this.display.writeLine("Now, you must choose your Dexterity Level(*Remember, the Dexterity must be higher than the Intelligence + 10):");
			value = this.keyboardInput.read();
			validateIfANumberIsEntered(value);
			fighterDex = value;
			this.display.writeLine("Finally, you must choose your Strength Level(*Remember, the Strength must be higher thant the Dexterity + 10):");
			value = this.keyboardInput.read();
			validateIfANumberIsEntered(value);
			fighterStr = value;
			this.display.writeLine("You must create two capacities for your new Warrior:");
			this.display.writeLine("First one:");
			this.capacityList.add(chooseCapacity());
			this.display.writeLine("Second one:");
			this.capacityList.add(chooseCapacity());
			createFighter(fighterType, fighterStr, fighterDex, fighterInt, fighterCon, this.capacityList);
			break;
		case ATHLETE_TYPE:
			fighterType = ATHLETE_TYPE;
			this.display.writeLine("You must now choose your Athlete's Stats level(*The sum of your Stats must not be higher than 100 and all of your stats must be higher than 20).");
			this.display.writeLine("First, you must choose your Concentration Level:");
			value = this.keyboardInput.read();
			validateIfANumberIsEntered(value);
			fighterCon = value;
			this.display.writeLine("Now, you must choose your Intelligence Level:");
			value = this.keyboardInput.read();
			validateIfANumberIsEntered(value);
			fighterInt = value;
			this.display.writeLine("Now, you must choose your Dexterity Level:");
			value = this.keyboardInput.read();
			validateIfANumberIsEntered(value);
			fighterDex = value;
			this.display.writeLine("Finally, you must choose your Strength Level:");
			value = this.keyboardInput.read();
			validateIfANumberIsEntered(value);
			fighterStr = value;
			this.display.writeLine("You must create two capacities for your new Athlete:");
			this.display.writeLine("First one:");
			this.capacityList.add(chooseCapacity());
			this.display.writeLine("Second one:");
			this.capacityList.add(chooseCapacity());
			createFighter(fighterType, fighterStr, fighterDex, fighterInt, fighterCon, this.capacityList);
			break;
		case MAGE_TYPE:
			fighterType = MAGE_TYPE;
			this.display.writeLine("You must now choose your Mage's Stats level(*The sum of your Stats must not be higher than 100).");
			this.display.writeLine("First, you must choose your Strength Level:");
			value = this.keyboardInput.read();
			validateIfANumberIsEntered(value);
			fighterStr = value;
			this.display.writeLine("Now you must choose your Dexterity Level:");
			value = this.keyboardInput.read();
			validateIfANumberIsEntered(value);
			fighterDex = value;
			this.display.writeLine("Now, you must choose your Concentration Level(*Remember, you Concentration must be higher thant the sum of your Dexterity and Strength + 15):");
			value = this.keyboardInput.read();
			validateIfANumberIsEntered(value);
			fighterCon = value;
			this.display.writeLine("Finally, you must choose your Intelligence Level(*(*Remember, you Concentration must be higher thant the sum of your Dexterity and Strength + 15)):");
			value = this.keyboardInput.read();
			validateIfANumberIsEntered(value);
			fighterInt = value;
			this.display.writeLine("You must create two capacities for your new Mage:");
			this.display.writeLine("First one:");
			this.capacityList.add(chooseCapacity());
			this.display.writeLine("Second one:");
			this.capacityList.add(chooseCapacity());
			createFighter(fighterType, fighterStr, fighterDex, fighterInt, fighterCon, this.capacityList);
			break;
		default:
			throw new IllegalWrongFighterTypeException();
		}
	}
}
