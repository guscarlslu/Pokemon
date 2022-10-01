package assignment2;
public enum TypeOfPokemon{

    Fire(0.5, 0.5, 2, 1),
    Water(2, 0.5, 0.5, 1),      // Stores the value of the damage moddifier for Type attacking type, i.e. Attacker(attacked)
    Grass(0.5, 2, 0.5, 1),
    Normal(1, 1, 1, 1);

    private final double fire;
    private final double water;
    private final double grass;
    private final double normal;

    TypeOfPokemon(double fire, double water, double grass, double normal){
        this.fire = fire;
        this.water = water;
        this.grass = grass;
        this.normal = normal;
    }

    public double fire(){
        return fire;
    }

    public double water(){
        return water;
    }

    public double grass(){
        return grass;
    }

    public double normal(){
        return normal;
    }

}