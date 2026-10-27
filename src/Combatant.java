import java.util.Random;

public abstract class Combatant {
    private String Species;
    private String Name;
    private int Toughness;
    private int Wounds;
    private String Weapon;
    private int WeaponStrength;


    public Combatant(String Name, int Toughness, int Wounds, String Weapon, int WeaponStrength, String Species) {
        this.Species = Species;
        this.Name = Name;
        this.Toughness = Toughness;
        this.Wounds = Wounds;
        this.Weapon = Weapon;
        this.WeaponStrength = WeaponStrength;

    }

    public String getName() {return Name;}
    public int getToughness() {return Toughness;}
    public int getWounds() {return Wounds;}
    public String getWeapon() {return Weapon;}
    public int getWeaponStrength() {return  WeaponStrength;}
    public String getSpecies() {return Species;}

    public abstract void Attack(Combatant Target);


    public String toString() {
        return "Name: " + Name + " Toughness: " + Toughness + " Wounds: " + Wounds + " Weapon: " + Weapon +  " Weapon Strength: " + WeaponStrength + " Species: " + Species;
    }


}

