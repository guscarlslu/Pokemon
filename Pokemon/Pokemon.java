public class Pokemon{

    private String name;
    private final int maxHp;
    private int currentHp;
    private int ep;
    private final String type;
    Skill currentSkill;

    public Pokemon(String name, int maxHp, String type){
        this.name = name;
        this.maxHp = maxHp;
        this.type = type;

        this.currentHp = maxHp;
        this.ep = 100;

    }

    public void learnSkill(String name, int ap, int ep){
        currentSkill = new Skill(name, ap, ep);
    }

    public void forgetSkill(){
        currentSkill = null;
    }

    public String toString(){
        
        if(currentSkill == null){
            String returnString = "No skills learned: " + this.name + " (" + this.type + ")";
            return returnString;
        }

        else{
            return "";
        }

    }

}