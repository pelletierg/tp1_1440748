import java.util.ArrayList;
import java.util.List;

public class Simulator{
	
	public static void main(String[] args) {
		
		Keyboard keyboardInput = new Keyboard();
		List<Infirmary> infirmaryList = new ArrayList<Infirmary>();
		Console display = new Console();
		FighterFabric myFabric = new FighterFabric();
		CapacityFabric myCFabric = new CapacityFabric();
		Simulator software = new Simulator(keyboardInput, display, infirmaryList, myFabric, myCFabric);
		software.recursiveSoftware();
	}
	private Keyboard keyboardInput;
	private Console display;
	private List<Infirmary> infirmaryList;
	private FighterFabric myFabric;
	private CapacityFabric myCFabric;
	
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
	public static final String HEAL = "ADMINISTRATE HEAL";
	public static final String INFIRMARY = "CREATE AN INFIRMARY";
	public static final String YES = "YES";
	public static final String NO = "NO";
	
	private void createFighter(String fighterType, String fighterStr, String fighterDex, String fighterInt, String fighterCon, List<Capacity> capacityList) {
		
		FighterFabric.FighterType type1 = FighterFabric.FighterType.valueOf(fighterType);
		int strength = Integer.parseInt(fighterStr);
		int dexterity = Integer.parseInt(fighterDex);
		int intelligence = Integer.parseInt(fighterInt);
		int concentration = Integer.parseInt(fighterCon);
		myFabric.createFighter(type1, myFabric.createStats(strength, dexterity, intelligence, concentration), capacityList);
		
	}
	private Capacity createCapacity(String type, String capacityStrength) {
		
		CapacityFabric.CapacityType type1 = CapacityFabric.CapacityType.valueOf(type);
		int capacityStr = Integer.parseInt(capacityStrength);
		Capacity capacityToAdd = myCFabric.createCapacity(type1, capacityStr);
		return capacityToAdd;
	}
	
	public Simulator(Keyboard keyboardInput, Console display, List<Infirmary> infirmaryList, FighterFabric myFabric, CapacityFabric myCFabric) {
		
		this.display = display;
		this.keyboardInput = keyboardInput;
		this.infirmaryList = infirmaryList;
		this.myFabric = myFabric;
		this.myCFabric = myCFabric;
		
	}
	
	private void recursiveSoftware() {
		
		if (myFabric.getEmptyList() == true) {
			this.display.writeLine("You must create a fighter in order to continue");
			createFighter();
		}
		
		String value = "";
		
		this.display.writeLine("You must choose an action between the following ones: Create a new Fighter, Provoke, Create a new Capacity, Create an new infirmary, Admnistrate heals:");
		value = this.keyboardInput.read();
		value = switchToUpperCase(value);
		switch (value) {
		case NEW_FIGHTER:
			createFighter();
			recursiveSoftware();
			break;
		case NEW_CAPACITY:
			newCapacity();
			recursiveSoftware();
			break;
		case PROVOKE:
			provoke();
			recursiveSoftware();
			break;
		case INFIRMARY:
			createAnInfirmary();
			break;
		case HEAL:
			heal();
			break;
		default: 
			this.display.writeLine("The entry is not valid, please start again!");
			recursiveSoftware();
		}
	}
	private void heal() {
		String value;
		int value1;
		Infirmary anInfirmary;
		Fighter aFighter;
		HealCapacity aCapacity;
		if (this.infirmaryList.isEmpty()) {
			this.display.writeLine("You must create an infirmary in order to persue!");
			recursiveSoftware();
		}
		this.display.writeLine("Select which Fighter you wish to heal(*Answer with the number assigned to the fighter):");
		displayFighters(myFabric.getFighterList());
		value = this.keyboardInput.read();
		value1 = validateNumberForList(value);
		aFighter = myFabric.getFighter(value1);
		this.display.writeLine("Select a Healing Capacity to use on the Fighter(*Answer with the number assigned to the capacity):");
		displayHealCapacitites(aFighter.getCapacityList());
		value = this.keyboardInput.read();
		value1 = validateNumberForList(value);
		anInfirmary = this.infirmaryList.get(0);
		aCapacity = (HealCapacity) aFighter.getCapacityList().get(value1);
		anInfirmary.heal(aFighter, aCapacity);
		recursiveSoftware();
		
	}
	private void displayHealCapacitites(List<Capacity> capacityList2) {
		for (int i= 0; i < capacityList2.size(); i++) {
			if (capacityList2.get(i) instanceof HealCapacity) {
				this.display.writeLine("Capacity number " + i + " " + capacityList2.get(i));
			}
		}
		
	}
	private void createAnInfirmary() {
		Infirmary infirmary = new Infirmary();
		this.infirmaryList.add(infirmary);
		recursiveSoftware();
		
	}
	private void newCapacity() {
		String value;
		int value1;
		Capacity capacityToAdd = chooseCapacity();
		this.display.writeLine("Which fighter do you want to add a new capacity(*Answer with the number assigned to the fighter)?:");
		displayFighters(myFabric.getFighterList());
		value = this.keyboardInput.read();
		value1 = validateNumberForList(value);
		myFabric.getFighter(value1).addCapacity(capacityToAdd);
	}
	private void provoke() {
		String value;
		int value1;
		this.display.writeLine("With which fighter do you want to provoke(*Answer with the number assigned to the fighter)?:");
		displayFighters(myFabric.getFighterList());
		value = this.keyboardInput.read();
		value1 = validateNumberForList(value);
		Fighter aggressor = myFabric.getFighter(value1);
		this.display.writeLine("With which ability do you want to provoke(*Answer with the number assigned to the ability, must be an Attack ability:");
		displayAttackCapacities(aggressor.getCapacityList());
		value = this.keyboardInput.read();
		value1 = validateNumberForList(value);
		AttackCapacity acapacity = (AttackCapacity) aggressor.getCapacity(value1);
		this.display.writeLine("Which fighter do you want to provoke(*Answer with the number assigned to the fighter)?");
		value = this.keyboardInput.read();
		value1 = validateNumberForList(value);
		if (aggressor.equals(myFabric.getFighter(value1))) {
			throw new IllegalFighterCannotFightHimselfException();
		}
		Fighter defender = myFabric.getFighter(value1);
		this.display.writeLine("Enter 'fight' or 'flee' depending on the defender's will to fight or flee:");
		value = this.keyboardInput.read();
		value = switchToUpperCase(value);
		switch (value) {
		case YES:
			this.display.writeLine("Select a combat ability to answer the duel(*Answer with the number assigned to the fighter):");
			displayCombatCapacities(defender.getCapacityList());
			value = this.keyboardInput.read();
			value1 = validateNumberForList(value);
			CombatCapacity dcapacity = (CombatCapacity) defender.getCapacity(value1);
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
	private void displayCombatCapacities(List<Capacity> capacityList2) {

		for (int i= 0; i < capacityList2.size(); i++) {
			if (capacityList2.get(i) instanceof CombatCapacity) {
				this.display.writeLine("Capacity number " + i + " " + capacityList2.get(i));
			}
		}
	}
	private void displayAttackCapacities(List<Capacity> capacityList2) {
		for (int i= 0; i < capacityList2.size(); i++) {
			if (capacityList2.get(i) instanceof AttackCapacity) {
				this.display.writeLine("Capacity number " + i + " " + capacityList2.get(i));
			}
		}
		
	}
	private int validateNumberForList(String value) {
		int value1;
		validateIfANumberIsEntered(value);
		value1 = Integer.parseInt(value);
		if (value1 >= myFabric.getFighterList().size()) {
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
			chooseCapacity();
			this.display.writeLine("Second one:");
			chooseCapacity();
			createFighter(fighterType, fighterStr, fighterDex, fighterInt, fighterCon, myCFabric.getCapacityList());
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
			chooseCapacity();
			this.display.writeLine("Second one:");
			chooseCapacity();
			createFighter(fighterType, fighterStr, fighterDex, fighterInt, fighterCon, myCFabric.getCapacityList());
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
			chooseCapacity();
			this.display.writeLine("Second one:");
			chooseCapacity();
			createFighter(fighterType, fighterStr, fighterDex, fighterInt, fighterCon, myCFabric.getCapacityList());
			break;
		default:
			throw new IllegalWrongFighterTypeException();
		}
	}
}
