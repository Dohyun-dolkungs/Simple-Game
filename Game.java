public class Game {
    // instance variable
    private int currentLocation;
    private Location[] map;
    private Player currentPlayer;

    // constructor
    public Game(int mapSize){
        map = new Location[mapSize];
        for(int i=0; i < mapSize; i++){
            map[i] = new Location(i);
        }

        currentLocation = 0;
        currentPlayer = new Player();
    }
    
    // method
    public void startGame() {
        System.out.println("Our hero " + currentPlayer.toString() + " begins a campain that contains " + map.length + " Locations");
    }

    public void endGame() {
        System.out.println("At the end of the campain " + currentPlayer.playerStatus());
        System.out.println("--- The End ---");
    }

    public void incrementLocation() {
        currentLocation++;
    }

    public void enterLocation() {
        System.out.println("-------------------------");
        System.out.println("You see the " + map[currentLocation].toString() + " up ahead. A " + map[currentLocation].getGuardian().toString() + " can be seen inside.");
        
        int input = GameController.waitForInput("Do you enter? (Enter 1 for yes, 2 for no)", 2);
        
        String playerName = currentPlayer.toString();
        String creatureName = map[currentLocation].getGuardian().toString();
        String locationName = map[currentLocation].toString();

        if(input ==1) {
            System.out.println(playerName + " enter the " + locationName);
            currentPlayer.loglocation(true);
        
            if(battleCreature(map[currentLocation].getGuardian())) {
                System.out.println(playerName + " battles the " + creatureName + " and wins!");
                Item newItem = map[currentLocation].removeItem();
                currentPlayer.addItem(newItem);
                System.out.println(playerName + " collected a new Item. The " + newItem.toString());
            }else{
                System.out.println(playerName + " battles the " + creatureName + " and loses!");
                System.out.println(playerName + " takes " + map[currentLocation].getGuardian().getDifficulty() + " damage and has " + currentPlayer.getHitPoints());
                if(currentPlayer.getHitPoints() < 1){
                    System.out.println(playerName + " has been slained by " + creatureName + "\n\nGameOver\n");
                }
            }
            
        }else if(input ==2) {
            currentPlayer.loglocation(false);
            System.out.println(playerName + " pass by the " + locationName + " and avoided the " +creatureName);
        }
    }

    public boolean isLocationValid() {
        if(currentLocation < map.length){
            return true;
        }
        
        return false;
    }

    // toString
    public String toString() {
        if(map.length != 0){
            String value ="[";
            for(int i=0; i<map.length; i++){
                value += map[i].toString();
                if(i != map.length - 1)
                value += ",";
            }
            return value + "]";
        }
        else{
            return "mapLength is less than 1";
        }
    }

    public boolean isPlayerAlive() {
        if(currentPlayer.getHitPoints() > 0) {
            return true;
        }else{
            return false;
        }
    }

    public boolean battleCreature(Creature newCreature) {
        if((GameData.randomRoll(0, 3) + currentPlayer.itemCount()) > newCreature.getDifficulty()) {
            return true;
        }else{
            currentPlayer.takeDamage(newCreature.getDifficulty());
            return false;
        }
        
    }
}

