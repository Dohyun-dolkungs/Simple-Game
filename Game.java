public class Game {
    // instance variable
    private int currentLocation;
    private Location[] map;

    // constructor
    public Game(int mapSize){
        map = new Location[mapSize];
        for(int i=0; i < mapSize; i++){
            map[i] = new Location(i);
        }

        currentLocation = 0;
    }
    
    // method
    public void startGame() {
        System.out.println("Starting new game with " + map.length + " Locations");
    }

    public void endGame() {
        System.out.println("--- The End ---");
    }

    public void incrementLocation() {
        currentLocation++;
    }

    public void enterLocation() {
        System.out.println("-------------------------");
        System.out.println("You see the " + map[currentLocation].toString() + " up ahead");
        
        int input = GameController.waitForInput("Do you enter? (Enter 1 for yes, 2 for no)", 2);
       
        if(input ==1) {
            System.out.println("You enter the " + map[currentLocation].toString());
        }else if(input ==2) {
            System.out.println("You pass by the " + map[currentLocation].toString());
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

