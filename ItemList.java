public class ItemList {
    // instance variable
    private Item[] items;
    private int currentIndex;
    private int maxSize = 100;

    // method
    public ItemList() {
        items = new Item[maxSize];
        currentIndex = 0;
    }

    // method 
    public void addItem(Item newItem) {
        items[currentIndex] = newItem;
        currentIndex ++;
    }

    public int itemCount() {
        return currentIndex;
    }

    public String toString() {
        String value = "[";

        if(currentIndex == 0) {
            return "[EMPTY]";
        }    

        for(int i = 0; i < currentIndex -1; i++) {
            value += items[i].toString() + ", ";
        }
        
        value += items[currentIndex-1].toString() + "]";
        return value;
    }
}
