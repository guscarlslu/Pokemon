package assignment2;
import java.util.ArrayList;
import java.util.Scanner;

public class Utility {
    

    public static void menu(Scanner input){         //Main menu of the Pokemon game
        int menuoption = 0;
        Pokemon[] pokemon = new Pokemon[0];

        while(menuoption != 6){

            System.out.println("----------------------------------");
            System.out.println("1. Create a Pokemon");
            System.out.println("2. View Pokemon");
            System.out.println("3. Battle");
            System.out.println("4. Manage items");
            System.out.println("6. Exit");

            menuoption = input.nextInt();
            input.nextLine();

            if(menuoption == 1){pokemon = createPokemon(pokemon, input);}

            else if(menuoption == 2){editPokemon(pokemon, input);}

            else if(menuoption == 3){}

            else if(menuoption == 4){
                ItemManager.itemMenu(input);
            }

            else if(menuoption == 6){System.out.println("Thank you for playing Pokemon!");}

            else{System.out.println("Error - Type a number from 1 to 4");}
        }



    }


    public static Pokemon[] createPokemon(Pokemon[] pokemon, Scanner input){       //Creates a pokemon with user input, with creating a skill being optional
        String pokemonName;
        int pokemonMaxHp;
        String pokemonType = null;
        int pokemonTypeInt = -1;
        int skillOption;

        System.out.println("----------------------------------");
        System.out.println("Type in the name of the pokemon:");
        pokemonName = input.nextLine();

        System.out.println("----------------------------------");
        System.out.println("Type in the max hp of the pokemon:");
        pokemonMaxHp = input.nextInt();
        input.nextLine();

        while(pokemonTypeInt < 0 || pokemonTypeInt > 4){
            System.out.println("----------------------------------");
            System.out.println("What type do you want your pokemon to be?");
            System.out.println("1. Fire");
            System.out.println("2. Water");
            System.out.println("3. Grass");
            System.out.println("4. Normal");
            pokemonTypeInt = input.nextInt();
            input.nextLine();
            if(pokemonTypeInt == 1){pokemonType = "fire";}
            else if(pokemonTypeInt == 2){pokemonType = "water";}
            else if(pokemonTypeInt == 3){pokemonType = "grass";}
            else if(pokemonTypeInt == 4){pokemonType = "normal";}
            else{System.out.println("Error - Invalid input");}
        }

        pokemon = arrayAdd(pokemon, new Pokemon(pokemonName, pokemonMaxHp, pokemonType));

        System.out.println("----------------------------------");
        System.out.println("Do you want your pokemon to know a skill?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        skillOption = input.nextInt();
        input.nextLine();

        if(skillOption == 1){
            teachPokemonSkill(pokemon[(pokemon.length-1)], input);
        }

        return pokemon;
    }


    public static void editPokemon(Pokemon[] pokemon, Scanner input){      //Displays all created Pokemon and allow you to edit the skills
        int option;
        int optionSubMenu;

        System.out.println("----------------------------------");
        System.out.println("0. Back");
        for(int i = 0; i < pokemon.length; i++){
            System.out.println((i+1) + ". " + pokemon[i]);
        }

        option = input.nextInt();
        input.nextLine();

        if(option <= pokemon.length && option > 0){
            System.out.println("----------------------------------");
            System.out.println(pokemon[(option-1)]);

            System.out.println("----------------------------------");
            System.out.println("0. Exit to menu");
            
            if(pokemon[option-1].assertSkillNull()){System.out.println("1. Learn skill");}

            else{System.out.println("1. Forget skill");}

            optionSubMenu = input.nextInt();
            input.nextLine();

            if(optionSubMenu == 1 && pokemon[option-1].assertSkillNull()){
                teachPokemonSkill(pokemon[option-1], input);
            }
            
            else if(optionSubMenu == 1 && !pokemon[option-1].assertSkillNull()){
                pokemon[option-1].forgetSkill();
            }
         }


    }

    
    public static void teachPokemonSkill(Pokemon pokemon, Scanner input){     //Takes user input to create a skill
        String skillName;
        int ap;
        int ec;

        System.out.println("----------------------------------");
        System.out.println("Type the name of your skill:");
        skillName = input.nextLine();

        System.out.println("----------------------------------");
        System.out.println("Type in the attack power of your skill:");
        ap = input.nextInt();
        input.nextLine();

        System.out.println("----------------------------------");
        System.out.println("Type in the energy cost of your skill:");
        ec = input.nextInt();
        input.nextLine();

        pokemon.learnSkill(skillName, ap, ec);


    }

    public static Pokemon[] arrayAdd(Pokemon[] pokemon, Pokemon pokemonToAdd){      //Makes it so you can add another element to an array, but that array must start at length 0
        Pokemon[] pokemonTemp = new Pokemon[(pokemon.length+1)];

        for(int i = 0; i < pokemonTemp.length; i++){

            if(i < pokemon.length){pokemonTemp[i] = pokemon[i];}

            else{pokemonTemp[i] = pokemonToAdd;}
        }

        pokemon = pokemonTemp;
        return pokemon;


    }




    public static void createSack(Scanner input) {  //allows user to create ItemSack
        ArrayList<Item> Items = new ArrayList<>();

        String itemName;
        int healPower;
        double itemWeight;

        int itemMenu = 1;
        while (itemMenu != 0) {


            System.out.println("----------------------------------");
            System.out.println("Type the name of the item");
            itemName = input.nextLine();

            System.out.println("----------------------------------");
            System.out.println("How much should the item heal?");
            healPower = input.nextInt();
            input.nextLine();

            System.out.println("----------------------------------");
            System.out.println("Type the weight of the item");
            itemWeight = input.nextDouble();


            Items.add(new Item(itemName, healPower, itemWeight));

            System.out.println("Press 1 to create a new item \n Press 0 to continue");
            itemMenu = input.nextInt();
            input.nextLine();


            System.out.println("----------------------------------");

        }


    }
    
    public static int damageCalc(Pokemon attacker, Pokemon attacked) {
    	int unmodifiedDamage = attacker.getCurrentSkillAp();
    	int finalDamage = unmodifiedDamage;
    	
    	if(attacker.getType() == "Normal" || attacked.getType() == "Normal") {finalDamage = unmodifiedDamage;}
    	
    	else if(attacker.getType() == "Fire") {
    		if(attacked.getType() == "Fire") {finalDamage = (int)(unmodifiedDamage*(TypeOfPokemon.Fire.fire()));}
    		else if(attacked.getType() == "Water") {finalDamage = (int)(unmodifiedDamage*(TypeOfPokemon.Fire.water()));}
    		else if(attacked.getType() == "Grass") {finalDamage = (int)(unmodifiedDamage*(TypeOfPokemon.Fire.grass()));}
    	}
    	
    	else if(attacker.getType() == "Water") {
    		if(attacked.getType() == "Fire") {finalDamage = (int)(unmodifiedDamage*(TypeOfPokemon.Water.fire()));}
    		else if(attacked.getType() == "Water") {finalDamage = (int)(unmodifiedDamage*(TypeOfPokemon.Water.water()));}
    		else if(attacked.getType() == "Grass") {finalDamage = (int)(unmodifiedDamage*(TypeOfPokemon.Water.grass()));}
    	}
    	
    	else if(attacker.getType() == "Grass") {
    		if(attacked.getType() == "Fire") {finalDamage = (int)(unmodifiedDamage*(TypeOfPokemon.Grass.fire()));}
    		else if(attacked.getType() == "Water") {finalDamage = (int)(unmodifiedDamage*(TypeOfPokemon.Grass.water()));}
    		else if(attacked.getType() == "Grass") {finalDamage = (int)(unmodifiedDamage*(TypeOfPokemon.Grass.grass()));}
    	}
    	
    	return finalDamage;
    	
    }


    
}
