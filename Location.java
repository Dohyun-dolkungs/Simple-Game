public class Location {
    // instance variable
    private String name;
    private int difficulty;
    private Item storedItem;
    private Creature guardian;

    // constructor
    public Location(int newDifficulty) {
        difficulty = newDifficulty;
        name = GameData.getRandomLocationName();
        storedItem = new Item();
        guardian = new Creature(difficulty);
    }

    // method
    public String toString() {
        return name;
    }

    public String toStringLong() {
        return  name + difficulty + storedItem.toString();
    }

    public Item removeItem() {
        Item temp = storedItem;
        storedItem = null;
        return temp;
    }

    public Creature getGuardian() {
        return guardian;
    }
}
