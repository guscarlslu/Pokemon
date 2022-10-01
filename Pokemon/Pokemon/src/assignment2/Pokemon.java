package assignment2;
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

    public void takeDamage(int damage){     //Lowers the pokemons hp by the value of damage, if the damage exceeds the currentHp then currentHp is set to 0
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

    public void recoverEp(){    //Recovers ep at the ammount of the variable ammountEpRecovered
        if(currentHp != 0){
            int ammountEpRecovered = 25;
            this.ep = ammountEpRecovered;
        }
    }

    public void spendEp(int epSpent){   //Spending ep
        if((this.ep - epSpent) >= 0) {
            this.ep -= epSpent;
        }
    }
    
    public void attack(Pokemon attackedPokemon) {
    	int damage = Utility.damageCalc(Pokemon.this, attackedPokemon);
    	
    	
    }
    
    public int getEnergy(){return this.ep;}

    public int getCurrentHP(){return this.currentHp;}

    public String getName(){return this.name;}

    public String getType(){return this.type;}

    public int getMAX_HP(){return this.maxHp;}

    public boolean knowsSkill() {
    	if (this.currentSkill == null) {
    		return false;
    	}
    	
    	else {
    		return true;
    	}
    }

    public Skill getCurrentSkill() {return currentSkill;}
    
    public String getCurrentSkillName(){
        return currentSkill.getName();
    }

    public int getCurrentSkillAp(){
        return currentSkill.getAp();
    }

    public int getCurrentSkillEc(){
        return currentSkill.getEc();
    }

    public boolean assertSkillNull(){
        if (this.currentSkill == null){
            return true;
        }

        else{
            return false;
        }
    }

    public String toString(){   //Makes it so you can print the information in a Pokemon object
        String returnString;

        if(currentSkill == null){
            returnString = this.name + " (" + this.type + ")";
            return returnString;
        }

        else{
            returnString = this.name + " (" + this.type + "). Knows " + currentSkill.getName() + " - AP: " + currentSkill.getAp() + " EC: " + currentSkill.getEc();
            return returnString;
        }

    }
    
    public boolean equals(Object anotherObject){
    	boolean sameSkill;
    	
        // Checks if I (this) am equal to myself (also this)
        if(anotherObject == this) {return true;} 
        
        else if(anotherObject == null){ return false;}
        
        else if( anotherObject instanceof Pokemon ) { 

            Pokemon otherPokemon = (Pokemon) anotherObject;

            boolean sameName = this.name.equals(otherPokemon.getName());
            boolean sameType = this.type.equals(otherPokemon.getType());
            
            if(this.currentSkill == null && otherPokemon.getCurrentSkill() == null) {
            	sameSkill = true;
            }
            
            else if(this.currentSkill != null ) {
            	sameSkill = this.currentSkill.equals(otherPokemon.getCurrentSkill());
            }
            
            else {return false;}
            
            boolean sameMaxHp = this.maxHp == otherPokemon.getMAX_HP();
            boolean sameEp = this.ep == otherPokemon.getEnergy();
            return sameName && sameType && sameSkill && sameMaxHp && sameEp && sameEp;
        } 
        
        else {return false;}
    }
<<<<<<< HEAD:src/assignment2/Pokemon.java
    
=======
>>>>>>> origin/HEAD:Pokemon/src/assignment2/Pokemon.java

}