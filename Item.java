public class Item {
    // instance variable
    private String itemName;   

    // constructor
    public Item() {
        itemName = GameData.getRandomItemName();
    }

    public Item(String newName) {
        itemName = newName;
    }

    // method
    public String toString() {
        return itemName;
    }
}
