public abstract class Combatant {
    private String Species;
    private String Name;
    private int Toughness;
    private int Wounds;
    private String Weapon;


    public Combatant(String Name, int Toughness,int Wounds,String Weapon, String Species) {
        this.Species = Species;
        this.Name = Name;
        this.Toughness = Toughness;
        this.Wounds = Wounds;
        this.Weapon = Weapon;
    }

    public String getName() {return Name;}
    public int getToughness() {return Toughness;}
    public int getWounds() {return Wounds;}
    public String getWeapon() {return Weapon;}
    public String getSpecies() {return Species;}



    public String toString() {
        return "Name: " + Name + " Toughness: " + Toughness + " Wounds: " + Wounds + " Weapon: " + Weapon + " Species: " + Species;
    }
}