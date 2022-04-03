public class Player {
    // variable
    private String name;
    private int hitPoints;
    private int locationsReached;
    private int locationsEntered;
    private ItemList inventory;

    // constructor
    public Player() {
        name = GameData.getRandomName();
        hitPoints = 10;
        locationsReached = 0;
        locationsEntered = 0;
        inventory = new ItemList();
    }

    public Player(String newName, int newHitPoints) {
        name = newName;
        hitPoints = newHitPoints;
    }

    // method
    public String toString() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void loglocation(boolean wasEntered) {
        locationsReached ++;

        if(wasEntered) {
            locationsEntered ++;
        }
    }

    public String playerStatus() {
        return "The player " + name + " has " + hitPoints + " Hit Points and entered " + locationsEntered + " of " + locationsReached + " locations" 
                +  "\n" + "They also colleted the following loot : [" + inventory.toString() + "]";
    }

    public String getInventory() {
        return inventory.toString();
    }

    public void addItem(Item newItem) {
        inventory.addItem(newItem);
    }

    public int itemCount() {
        return inventory.itemCount();
    }

    public void takeDamage(int damage) {
        hitPoints -= damage;
    }
}
