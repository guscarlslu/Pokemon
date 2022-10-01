package assignment2;
import java.util.Scanner;

import assignment2.Utility;

public class PokemonMain{

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        Utility.menu(input);

        input.close();
    }
}
