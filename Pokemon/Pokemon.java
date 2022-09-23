public class Pokemon{

    private String name;
    private final int maxHp;
    private int currentHp;
    private int ep;
    private final String type;
    Skill currentSkill;

    public Pokemon(String name, int maxHp, String type){    //Pokemon constructor
        this.name = name;
        this.maxHp = maxHp;
        this.type = type;

        this.currentHp = maxHp;
        this.ep = 100;

    }

    public void learnSkill(String name, int ap, int ep){    //Pokemon learns a skill
        currentSkill = new Skill(name, ap, ep);
    }

    public void forgetSkill(){  //Pokemon forgets skill
        currentSkill = null;
    }

    public void takeDamage(int damage){
        if ((this.currentHp-damage) < 0) {
            this.currentHp = 0;
        }

        else{
            this.currentHp -= damage;
        }

    }

    public void rest(){
        int restHeal = 20;

        if ((this.currentHp + restHeal) > this.maxHp) {this.currentHp = this.maxHp;}

        else if(this.currentHp > 0 && (this.currentHp + restHeal) <= this.maxHp){this.currentHp += restHeal;}

    }

    public void recoverEp(){
        if(currentHp != 0){
            int ammountEpRecovered = 25;
            this.ep = ammountEpRecovered;
        }
    }

    public void spendEp(int epSpent){
        if((this.ep - epSpent) => 0) {
            this.ep -= epSpent;
        }
    }

    public String toString(){   //Makes it so you can print the information in a Pokemon object
        String returnString;

        if(currentSkill == null){
            returnString = this.name + " (" + this.type + ")";
            return returnString;
        }

        else{
            returnString = this.name + " (" + this.type + "). Knows " + currentSkill.getName() + " - AP: " + currentSkill.getAp() + " EP: " + currentSkill.getEc();
            return returnString;
        }

    }

}