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
    }
    
    // method
    public void startGame() {
        System.out.println("Starting new game with " + map.length + " Locations");
    }

    public void endGame() {
        System.out.println("The End");
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

