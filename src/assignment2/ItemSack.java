public class ItemSack {
    //The bag should provide: the current number of items stored, the current weight of the bag, and its maximum weight
    static int storedItems;
    static int maxWeight;
    static double currentWeight;

     ItemSack(int maxWeight, int storedItems, double currentWeight){
        this.maxWeight = maxWeight;
        this.storedItems = ItemManager.Items.size();
        this.currentWeight = currentWeight;
       // currentWeight =

    }

//    public int getStoredItems() {return storedItems;}

    public static int getMaxWeight() {
        return maxWeight;
    }

    public static double getCurrentWeight() {
        return currentWeight;
    }
}
