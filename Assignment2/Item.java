public class Item {
    //Each item has a name, a healing power value (integer) and a weight (double)
    final String itemName;
    final int healPower;
    final double itemWeight;

    public Item (String itemName, int healPower, double itemWeight){
        this.itemName = itemName;
        this.healPower = healPower;
        this.itemWeight = itemWeight;
    }

    public String getItemName() {return this.itemName;}

    public int getHealPower() {
        return this.healPower;
    }

    public double getItemWeight(){
        return itemWeight;
    }

    public String fullItem(){
        String fullItem = this.itemName + this.healPower + this.itemWeight;
        return fullItem;
    }
}
