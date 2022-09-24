import java.util.Scanner;

public class Utility {
    

    public static void menu(Scanner input){         //Main menu of the Pokemon game
        int menuoption = 0;
        Pokemon[] pokemon = new Pokemon[0];

        while(menuoption != 4){

            System.out.println("1. Create a Pokemon");
            System.out.println("2. View Pokemon");
            System.out.println("3. Battle");
            System.out.println("4. Exit");

            menuoption = input.nextInt();
            input.nextLine();

            if(menuoption == 1){pokemon = createPokemon(pokemon, input);}

            else if(menuoption == 2){viewPokemon(pokemon);}

            else if(menuoption == 3){}

            else if(menuoption == 4){System.out.println("Thank you for playing Pokemon!");}

            else{System.out.println("Error - Type a number from 1 to 4");}
        }



    }


    public static Pokemon[] createPokemon(Pokemon[] pokemon, Scanner input){       //Creates a pokemon with user input, with creating a skill being optional
        String pokemonName;
        int pokemonMaxHp;
        String pokemonType = null;
        int pokemonTypeInt = -1;
        int skillOption;

        System.out.println("Type in the name of the pokemon:");
        pokemonName = input.nextLine();

        System.out.println("Type in the max hp of the pokemon:");
        pokemonMaxHp = input.nextInt();
        input.nextLine();

        while(pokemonTypeInt < 0 || pokemonTypeInt > 4){
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


    public static void viewPokemon(Pokemon[] pokemon){      //Displays all created Pokemon
        for(int i = 0; i < pokemon.length; i++){
            System.out.println(pokemon[i]);
        }
    }

    
    public static void teachPokemonSkill(Pokemon pokemon, Scanner input){     //Takes user input to create a skill
        String skillName;
        int ap;
        int ec;

        System.out.println("Type the name of your skill:");
        skillName = input.nextLine();

        System.out.println("Type in the attack power of your skill:");
        ap = input.nextInt();
        input.nextLine();

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

}
