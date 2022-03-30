public class Location {
    // instance variable
    private String name;
    private int difficulty;

    // constructor
    public Location(int newDifficulty) {
        difficulty = newDifficulty;
        name = GameData.getRandomLocationName();
    }

    // toString 
    public String toString() {
        return name;
    }

    public String toStringLong() {
        return  name + difficulty;
    }
}
