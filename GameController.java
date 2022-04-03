import java.util.Scanner;

public class GameController{

	public static Scanner keyboard = new Scanner(System.in);

	public static boolean DEBUG_MODE = false;
	private static String debugFlag = "-d";

	// Phase 1
	public static void main(String[] args){

		if (args != null && args.length > 0){
			if( debugFlag.equals(args[0])){
				DEBUG_MODE = true;
			}
		}

		// Create a new game
		Game game = new Game(5);

		// execute game logic
		runGame(game);
		
		// close the input stream
		keyboard.close();
	}

	// This functionality is distinct from other functions in the main method
	// so I moved it to a private method. 
	private static void runGame(Game newGame){

		// Call start
		newGame.startGame();

		while(newGame.isLocationValid() && newGame.isPlayerAlive()) {
			newGame.enterLocation();
			newGame.incrementLocation();
		}
		
		// The End
		newGame.endGame();
	}
	
	// Asks the user to enter a number. No error checking is provided. 
	// Usage notes: Accepts 1-maxInput values. Will loop in place until this is entered. 
	public static int waitForInput(String message, int maxInput){
		// Print out the message informing the user of the input
		System.out.println(message);

		int num = 0;
		boolean valid = false;

		// Wait for input here
		// Should loop until we have a 1 or 2 entered.
		
		do{
			System.out.println("Please enter a number between 1-" + maxInput);
			num = keyboard.nextInt();

			if(num > 0 && num <= maxInput) {
				valid = true;
			}
		}while(!valid);

		return num;
	}

	// This is just one technique you can use for printing debug messages
	// It allows you to have lots of output without seeing it all the time
	// You also / instead might want to implement debugging at a class level (eg Location only)
	public static void debugOutput(String debugMessage){
		if( DEBUG_MODE )
			System.out.println("[Debug] " + debugMessage);
	}

}