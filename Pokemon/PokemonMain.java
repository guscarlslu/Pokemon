public class PokemonMain{

    public static void main(String[] args){

        System.out.println("Hello pokemonGuyMan! I like Pokemon");
        
        Pokemon Hej = new Pokemon("Charmander", 100, "Fire");
        Hej.learnSkill("Fireball", 10, 10);

        System.out.println(Hej);

    }
}
