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
        items[currentIndex++] = newItem;
    }

    public int itemCount() {
        return currentIndex;
    }

    public String toString() {
        String value = "[";

        if(currentIndex > 1){
            for(int i=0; i < items.length; i++){
                value += items[i].toString();
                
                if(i != items.length-1){
                    value += ",";
                }
            }
        }else{
            value = "There is no Item in the list";
        }
        return value;
    }
}
