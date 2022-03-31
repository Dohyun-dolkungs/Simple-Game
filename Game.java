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
        System.out.println("You see the " + map[currentLocation].toString() + " up ahead");
        
        int input = GameController.waitForInput("Do you enter? (Enter 1 for yes, 2 for no)", 2);
        String playerName = currentPlayer.toString();
        if(input ==1) {
            currentPlayer.loglocation(true);
            System.out.println(playerName + " enter the " + map[currentLocation].toString());
        }else if(input ==2) {
            currentPlayer.loglocation(false);
            System.out.println(playerName + " pass by the " + map[currentLocation].toString());
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
}

