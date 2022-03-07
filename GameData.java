// Game Data 
// 2019 Dylan Fries
// Returns a Random Location Name
// and contains the basic random number generator
public class GameData{
	 
	// ======== Source Words ========
	// Phase 0 - a random list of words to generate a random location 
	private static String[] locationAdjectives = {"Cold","Damp","Soggy","Hot","Dangerous","Dark","Bright","Cavernous"};
	private static String[] locationNouns = {"Cave","Hallway","Diner","Room"};

	// Phase 1 - a random list of words to generate a random name 
	private static String[] randomNames = {"Dylan","Maxim","Thomas","Mehidi","Rayhan","Huayi","Zihan","Tasnimul","Elroy","Toluwani","Ravi","Nikita","Sheila","Yash","Nhan","Deep","Zilkumar","Saif","Moadil","Shivam","Ravdeep","Vishavbir","Seyed","Yongying","Nguyen","Shaun","Minh","Xunqing","Guohao","Zhijie","Sabid","Temiloluwa","Tai","Taeho","Oghenekome","Wynona","Jawad","Rafia","Zahirul","Petro","Zhuobin","Vikas","Binh","Nhat","Maisha","Chibuike","Nneka","Hinalben","Shrey","Muhammad","Mahdis","Abu","Sarabjit","Abdullah","Ayon","Daivum","Leonardo","Adrian","Wenqing","Huimin"};

	//Phase 2
	// Generate a random item name
	private static String[] itemAdjectives = {"Magic","Antique","Smelly","Rusted","Broken","Fragile","Glowing","Strange","Flaming"};
	private static String[] itemNouns = {"Hammer","Shield","Helmet","Shoes","Sword"};

	// Phase 3
	// this list is sorted by difficulty
	private static String[] creatureDifficulty = {"Insignificant","Trivial","Tiny","Small","Weak","Rumpled","Sulking","Zombie","Mutant","Angry","Venomous","Fierce","Giant","Tremendous","Elemental","Monsterous","Omnipotent","Exceptional"};
	private static String[] creatureNames = {"Mouse","Lizard","Rabbit","Skunk","Fish","Monkey","Crab","Blob","Goblin","Dinosaur","Orc","Dragon","Bandit","Werewolf"};
	// ======== Name Generators ========

	// Phase 3
	// This method returns names of monsters. 
	// The type of monster is determined by the difficulty of the location
	// we can use the difficulty as an index to get a monster from the list
	// Difficulty is locked from 0 to 6. total 18 difficulty names
	// This is a little loose, there are probably better ways to map this but I am dealing with 
	// uncertainty by contraining both the input and selected (calculated) indexes manually. 
	public static String getMonsterNameByDifficulty(int difficulty){
		String returnMonster = "Default Monster";
		// Lock in bounds. This should never be < 0 but might be higher then 6
		if( difficulty < 0)
			difficulty = 0;
		if( difficulty > 6)
			difficulty = 6;

		// Add some random noise. The difficulty should be 'close' to where it actually will be but might be higher
		int tilt = randomRoll(-1,4);
		int adjustedDifficulty = difficulty * 3 + tilt;

		// boundary check again because I am adding some random values to the index
		if(adjustedDifficulty < 0)
			adjustedDifficulty = 0; // zero difficulty
		if( adjustedDifficulty >= creatureDifficulty.length )
			adjustedDifficulty = creatureDifficulty.length -1; // max difficulty

		// Select a name by combining difficulty and type
		returnMonster = creatureDifficulty[adjustedDifficulty];
		int typeIndex = randomRoll(0, creatureNames.length);
		returnMonster += " " + creatureNames[typeIndex];

		// Return the new generated monster name
		return returnMonster;
	}

	// Phase 2
	public static String getRandomItemName(){
		int indexAdjective = randomRoll(0,itemAdjectives.length);
		int indexNoun = randomRoll(0,itemNouns.length);
		String returnName = itemAdjectives[indexAdjective] + " " + itemNouns[indexNoun];
		return returnName;
	}

	// Phase 1
	// Generate a random persons name from the list supplied above
	public static String getRandomName(){
		int index = randomRoll(0,randomNames.length);
		String name = randomNames[index];
		return name;
	}

	// Generates a random two word name for the Location and returns it. 
	// Sample names could include: "Cold Cave", "Damp Hallway", "Soggy Room" etc.
	public static String getRandomLocationName(){
		// randomly roll to get the adjective. 
		int indexAdjective = randomRoll(0, locationAdjectives.length);
		// randomly roll to get the noun. 
		int indexNoun = randomRoll(0, locationNouns.length);
		String returnName = locationAdjectives[indexAdjective] + " " + locationNouns[indexNoun];
		return returnName;
	}

	// ======== Utility Functions ========
	// Roll a random int between min (inclusive) and max (exclusive)
	public static int randomRoll(int min, int max){
		int randomNum = 0;
		// Get the random number between [0..1)]
		double random = Math.random();
		// convert to an int range from [0..length-1]
		int range = max - min;
		randomNum = min + (int)(random * range);

		return randomNum;
	}
}