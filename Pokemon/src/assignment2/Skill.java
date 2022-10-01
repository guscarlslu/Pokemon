package assignment2;
public class Skill {

    private final String name;
    private final int ap;
    private final int ec;

    public Skill(String name, int ap, int ec){
        this.name = name;
        this.ap = ap;
        this.ec = ec;
    }

    public String getName(){
        return this.name;
    }

    public int getAp(){
        return this.ap;
    }

    public int getEc(){
        return this.ec;
    }
    
    public boolean equals(Object anotherObject){

        // Checks if I (this) am equal to myself (also this)
        if(anotherObject == this) {return true;} 
        
        else if(anotherObject == null){ return false;}
        
        else if( anotherObject instanceof Skill ) { 

            Skill otherSkill = (Skill) anotherObject;

            boolean sameName = this.name.equals(otherSkill.name);
            boolean sameAp = this.ap == otherSkill.ap;
            boolean sameEc = this.ec == otherSkill.ec;
            return sameName && sameAp && sameEc;
        } 
        
        else {return false;}
    }
}
