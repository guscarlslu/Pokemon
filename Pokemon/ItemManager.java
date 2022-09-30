import java.util.ArrayList;
import java.util.Scanner;

public class ItemManager {

    static ArrayList<Item> Items = new ArrayList<>();

    public static void itemMenu(Scanner input) {         //
        int itemMenu = 0;

        while (itemMenu != 6) {

            System.out.println("----------------------------------");
            System.out.println("Item Menu");
            System.out.println("1. Create a Item");
            System.out.println("2. Create a bag");
            System.out.println("6. Exit");

            itemMenu = input.nextInt();
            input.nextLine();

            if (itemMenu == 1 && ItemSack.getMaxWeight() == 0) {
                System.out.println("You need to create a bag first");
                createItemSack(input);
            } else if (itemMenu == 1) {
                createItem(input);
            } else if (itemMenu == 2) {
                createItemSack(input);
            } else if (itemMenu == 6) {
                System.out.println("Returning to menu...");
            } else {
                System.out.println("Error - Type a number from 1 to 6");
            }

        }
    }

    public static void createItem(Scanner input) {  //allows user to create one or multiple items stored in an arraylist


        String itemName;
        int healPower;
        double itemWeight = 0;
        double currentWeight = 0;
        double tempWeight;
        double toHeavy = 0;

        int itemMenu = 1;
        while (itemMenu != 0) {

            checkCurrentWeight();
            if (ItemSack.getCurrentWeight() > ItemSack.getMaxWeight()) { //Checks if ItemSack is full
                System.out.println("No more space in bag for new items");
                itemMenu = 0;
            } else {


                System.out.println("----------------------------------");
                System.out.println("Type the name of the item");
                itemName = input.nextLine();

                System.out.println("----------------------------------");
                System.out.println("How much should the item heal?");
                healPower = input.nextInt();
                input.nextLine();

                System.out.println("----------------------------------");
                System.out.println("Type the weight of the item");
                tempWeight = input.nextDouble();

                while (ItemSack.getCurrentWeight() + tempWeight > ItemSack.getMaxWeight()) {
                    toHeavy = ItemSack.getMaxWeight() - ItemSack.getCurrentWeight();
                    System.out.println("Item can weigh at most " + toHeavy);
                    System.out.println("----------------------------------");
                    System.out.println("Type the weight of the item");
                    tempWeight = input.nextDouble();
                }
                if (ItemSack.getCurrentWeight() + tempWeight < ItemSack.getMaxWeight()) {
                    itemWeight = tempWeight;
                    System.out.println("Successfully created item ");
                }


            Items.add(new Item(itemName, healPower, itemWeight));

            System.out.println("Press 1 to create a new item \nPress 0 to continue");
            itemMenu = input.nextInt();
            input.nextLine();


        }
    }
    }




    public static void createItemSack(Scanner input) {
        int maxWeight;

        if (ItemSack.getMaxWeight() == 0) {
            int healPower = 0;
            double currentWeight = 0;


            System.out.println("----------------------------------");
            System.out.println("Enter max weight");
            maxWeight = input.nextInt();
            input.nextLine();
            System.out.println("Bag created");
            ItemSack ItemSack = new ItemSack(maxWeight, healPower, currentWeight);

        } else {
            System.out.println("You have already created a bag");
        }


    }
    public void sortItems(){
        double tempWeight;
        for (int i = 0; i < Items.size() -1 ; i++)
        {
            for (int j = 0; i <Items.size() +1; j++){
                if (Items.get(i).getItemWeight() > Items.get(j).getItemWeight()){
                    tempWeight = Items.get(j).getItemWeight();
                    //Items.get(i).itemWeight.set(i, Item()) ;
                    Items.add(i, Items.get(j));
                    Items.add(j, Items.get(j));


                }
            }

        }

    }

    public static double checkCurrentWeight() {
        for (int i = 0; i < Items.size(); i++) {
            ItemSack.currentWeight += Items.get(i).getItemWeight();

        }
        return ItemSack.currentWeight;
    }
}